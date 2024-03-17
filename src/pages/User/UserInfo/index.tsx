import {PageContainer, ProCard} from '@ant-design/pro-components';
import React, {useEffect, useState} from 'react';
import {Avatar, Descriptions, Divider} from "antd";
import {useModel} from "@umijs/max";
// @ts-ignore
import {listInterfaceInfoUsingGET1} from "@/services/api-backend/userInterfaceInfoController";
import QueueAnim from "rc-queue-anim";


const UserInfo: React.FC = () => {
  const {initialState} = useModel('@@initialState');
  const {loginUser} = initialState || {};
  const [data, setData] = useState<API.listInterfaceInfoUsingGET1Params[]>([]);

  useEffect(() => {
    try {
      // @ts-ignore
      listInterfaceInfoUsingGET1().then(res => {
        if (res.data) {
          // @ts-ignore
          setData(res.data);
        }
      })
    } catch (e: any) {

    }
    // 从远程获取数据
  }, [])

  const chartData = data
    .filter((item) => item.userId === loginUser?.id)
    .map(item => {
      return {
        totalnum: item.totalNum,
        id: item.interfaceInfoId,
        leftnum: item.leftNum,
      }
    })

  return (
    <PageContainer>
      <ProCard
        type="inner"
        bordered
        direction="column"
        boxShadow
      >
        <QueueAnim  className="queue-simple">
          {/*个人信息展示*/}
          <ProCard
            key="a"
            title={<strong>个人信息</strong>}
            type="inner"
            bordered
          >
            <Descriptions column={1}>
                <Descriptions.Item>{
                  <Avatar
                    size={{xs: 24, sm: 32, md: 80, lg: 100, xl: 120, xxl: 140}}
                    src={loginUser?.userAvatar}/>
                }</Descriptions.Item>
                <Descriptions.Item label="用户名">{loginUser?.userName}</Descriptions.Item>
                <Descriptions.Item label="性别">{loginUser?.gender ? '女' : '男'}</Descriptions.Item>
                <Descriptions.Item label="身份">{loginUser?.userRole ? '管理员' : '用户'}</Descriptions.Item>
            </Descriptions>
          </ProCard>
          <Divider key="b"/>
          {/*个人调用接口次数*/}
          <ProCard
            key="c"
            title={<strong>个人接口信息</strong>}
            type="inner"
            bordered
          >
            {/* 在这里使用 chartData 渲染数据 */}
            {chartData.map((item) => (
              <Descriptions key={item.id} column={3}>
                  <Descriptions.Item label="总次数">{item.totalnum}</Descriptions.Item>
                  <Descriptions.Item label="接口id">{item.id}</Descriptions.Item>
                  <Descriptions.Item label="剩余次数">{item.leftnum}</Descriptions.Item>
              </Descriptions>
            ))}
          </ProCard>
          <Divider key="b"/>
          {/*下载sdk*/}
          <ProCard
            key="c"
            title={<strong>个人接口信息</strong>}
            type="inner"
            bordered
          >
            {/* 在这里使用 chartData 渲染数据 */}
            {chartData.map((item) => (
              <Descriptions key={item.id} column={3}>
                <Descriptions.Item label="总次数">{item.totalnum}</Descriptions.Item>
                <Descriptions.Item label="接口id">{item.id}</Descriptions.Item>
                <Descriptions.Item label="剩余次数">{item.leftnum}</Descriptions.Item>
              </Descriptions>
            ))}
          </ProCard>
        </QueueAnim>
      </ProCard>
    </PageContainer>
  );
};
export default UserInfo;

