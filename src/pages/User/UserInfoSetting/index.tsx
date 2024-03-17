import React, {useState} from 'react';
import {PageContainer, ProCard, ProForm, ProFormRadio, ProFormText} from '@ant-design/pro-components';
import {Avatar, Upload, Button, Divider, message} from 'antd';
import {UploadOutlined} from '@ant-design/icons/lib';
import {useModel} from '@umijs/max';
import {uploadUserUsingPOST} from "@/services/api-backend/userController";
import {UploadProps} from "antd/lib/upload/interface";
import {uploadFileUsingPOST} from "@/services/api-backend/fileController";
import QueueAnim from 'rc-queue-anim';


const UserInfoSetting: React.FC = () => {
  const COS_HOST = "https://api-1321025141.cos.ap-shanghai.myqcloud.com";
  const [value, setValue] = useState<string>();

  const {initialState} = useModel('@@initialState');
  const {loginUser} = initialState || {};

  const [avatarString, setAvatarString] = useState<string>('');

  const props: UploadProps = {
    name: 'file',
    multiple: false,
    maxCount: 1,
    // beforeUpload: (file: File) => {
    //   return new Promise((resolve, reject) => {
    //     const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
    //     if (!isJpgOrPng) {
    //       message.error('只能上传 JPG/PNG 格式的图片！');
    //       reject(false);
    //       return;
    //     }
    //
    //     const isLt2M = file.size / 1024 / 1024 < 2;
    //     if (!isLt2M) {
    //       message.error('图片大小必须小于 2MB！');
    //       reject(false);
    //       return;
    //     }
    //
    //   });
    // },
    customRequest: async (fileObj: any) => {
      try {
        const biz = "user_avatar";
        const formData = new FormData();
        formData.append('file', fileObj.file);
        const res = await uploadFileUsingPOST({biz}, {}, fileObj.file);
        fileObj.onSuccess(res.data);
        setValue(res.data);
      } catch (e: any) {
        message.error('上传失败', +e.message);
        fileObj.onError(e);
      }
    },
    onRemove() {
      setValue(undefined);
    },
  };

  const updateUser = async () => {
    try {
      await uploadUserUsingPOST({
        id: loginUser?.id,
        userAccount: form.getFieldValue('userAccount'),
        userName: form.getFieldValue('userName'),
        userPassword: form.getFieldValue('userPassword'),
        gender: form.getFieldValue('gender'),
      });
      message.success('用户信息更新成功');
    } catch (error) {
      message.error('更新用户信息失败，请重试');
    }
  };

  const [form] = ProForm.useForm();

  // @ts-ignore
  // @ts-ignore
  return (
    <PageContainer>
      <QueueAnim  className="queue-simple">
        <ProCard key="a" type="inner" bordered direction="column" boxShadow>
          <QueueAnim  className="queue-simple">
            <ProCard
              key="a"
              title={<strong>基本设置</strong>}
              type="inner"
              bordered
            >
              <QueueAnim  className="queue-simple">
                <div key="a" style={{display: 'flex', alignItems: 'flex-start'}}>
                  <div style={{flex: 1, marginRight: '16px'}}>
                    <ProForm
                      layout="vertical"
                      onFinish={async (values) => {
                        await updateUser();
                        await form.resetFields();
                      }}
                      form={form}
                    >
                      <ProFormText
                        width="md"
                        name="account"
                        label="账户"
                        tooltip="最长为 24 位"
                        placeholder={loginUser?.userAccount}

                      />
                      <ProFormText
                        width="md"
                        name="password"
                        label="密码"
                        placeholder="请输入密码"
                      />
                      <ProFormText
                        name="username"
                        width="md"
                        label="用户名"
                        placeholder={loginUser?.userName}
                      />

                      <ProFormRadio.Group
                        name="gender"
                        label="性别"
                        options={[
                          {label: '男', value: 0},
                          {label: '女', value: 1},
                        ]}
                        initialValue={loginUser?.gender}
                      />
                    </ProForm>
                  </div>
                  <div style={{display: 'flex', flexDirection: 'column', alignItems: 'center'}}>
                    <Avatar
                      size={{xs: 24, sm: 32, md: 80, lg: 100, xl: 120, xxl: 140}}
                      src={loginUser?.userAvatar}
                    />
                    <Divider/>
                    <Upload {...props}>
                      <Button icon={<UploadOutlined/>}>Click to Upload</Button>
                    </Upload>
                  </div>
                </div>
              </QueueAnim>
            </ProCard>
          </QueueAnim>
        </ProCard>
      </QueueAnim>
    </PageContainer>
  );
};

export default UserInfoSetting;
