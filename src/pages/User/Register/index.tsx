import Footer from '@/components/Footer';
import {userRegisterUsingPOST} from '@/services/api-backend/userController';
import {
  AlipayCircleOutlined,
  LockOutlined,
  TaobaoCircleOutlined,
  UserOutlined,
  WeiboCircleOutlined,
} from '@ant-design/icons';
import {LoginForm, ProFormText,} from '@ant-design/pro-components';
import {useEmotionCss} from '@ant-design/use-emotion-css';
import { Helmet, history, } from '@umijs/max';
import {Alert, message, Tabs} from 'antd';
import Settings from '../../../../config/defaultSettings';
import React, {useState} from 'react';
import {string} from "prop-types";
import {useParams} from "@@/exports";


const ActionIcons = () => {
  const langClassName = useEmotionCss(({token}) => {
    return {
      marginLeft: '8px',
      color: 'rgba(0, 0, 0, 0.2)',
      fontSize: '24px',
      verticalAlign: 'middle',
      cursor: 'pointer',
      transition: 'color 0.3s',
      '&:hover': {
        color: token.colorPrimaryActive,
      },
    };
  });

  return (
    <>
      <AlipayCircleOutlined key="AlipayCircleOutlined" className={langClassName}/>
      <TaobaoCircleOutlined key="TaobaoCircleOutlined" className={langClassName}/>
      <WeiboCircleOutlined key="WeiboCircleOutlined" className={langClassName}/>
    </>
  );
};



const LoginMessage: React.FC<{
  content: string;
}> = ({content}) => {
  return (
    <Alert
      style={{
        marginBottom: 24,
      }}
      message={content}
      type="error"
      showIcon
    />
  );
};

const Register: React.FC = () => {
  const [userLoginState] = useState<API.LoginResult>({});
  const [type, setType] = useState<string>('account');
  const params = useParams();

  const containerClassName = useEmotionCss(() => {
    return {
      display: 'flex',
      flexDirection: 'column',
      height: '100vh',
      overflow: 'auto',
      backgroundImage:
        "url('https://mdn.alipayobjects.com/yuyan_qk0oxh/afts/img/V-_oS6r-i7wAAAAAAAAAAAAAFl94AQBr')",
      backgroundSize: '100% 100%',
    };
  });



  //表单提交
  const handleSubmit = async (values: API.UserRegisterRequest) => {
    const {userPassword,checkPassword} = values;
    //校验
    if (userPassword !== checkPassword){
      message.error('两次输入的密码不一致');
      return;
    }
    try {
      // 注冊
      const userAccount = await userRegisterUsingPOST({
        userAccount: String(params.userAccount),
      });
      if (userAccount != null) {
        message.success('注冊成功！');
        history.push('/user/login');
        return;
      }
    } catch (error) {
      // @ts-ignore
      message.error('操作失败' + error.message)
    }
  };
  const {status, type: loginType} = userLoginState;

  return (
    <div className={containerClassName}>
      <Helmet>
        <title>
          {'注册'}- {Settings.title}
        </title>
      </Helmet>
      <div
        style={{
          flex: '1',
          padding: '32px 0',
        }}
      >
        <LoginForm
          submitter={{
            searchConfig:{
              submitText:'注册'
            }
          }}
          contentStyle={{
            minWidth: 280,
            maxWidth: '75vw',
          }}
          logo={<img alt="logo" src="/logo.svg" />}
          title="API管理平台"
          subTitle={'致力于提供稳定、安全、高效的接口调用服务'}
          initialValues={{
            autoLogin: true,
          }}
          onFinish={async (values) => {
            await handleSubmit(values as API.UserRegisterRequest);
          }}
        >
          <Tabs
            activeKey={type}
            onChange={setType}
            centered
            items={[
              {
                key: 'account',
                label: '账户密码注册',
              },
            ]}
          />

          {status === 'error' && loginType === 'account' && (
            <LoginMessage
              content='账户或密码错误'
            />
          )}
          {type === 'account' && (
            <>
              <ProFormText
                name="userAccount"
                fieldProps={{
                  size: 'large',
                  prefix: <UserOutlined/>,
                }}
                placeholder='请输入账户'
                rules={[
                  {
                    required: true,
                    message: "请输入账户!",
                  },
                ]}
              />
              <ProFormText.Password
                name="userPassword"
                fieldProps={{
                  size: 'large',
                  prefix: <LockOutlined/>,
                }}
                placeholder='请输入密码'
                rules={[
                  {
                    required: true,
                    message: "请输入密码！",
                  },
                  {
                    min: 8,
                    type: 'string',
                    message: "密码至少为8位",
                  },
                ]}
              />
              <ProFormText.Password
                name="checkPassword"
                fieldProps={{
                  size: 'large',
                  prefix: <LockOutlined/>,
                }}
                placeholder='请确认密码'
                rules={[
                  {
                    required: true,
                    message: "请确认密码！",
                  },
                  {
                    min: 8,
                    type: 'string',
                    message: "密码至少为8位",
                  },
                ]}
              />
            </>
          )}
        </LoginForm>
      </div>
      <Footer/>
    </div>
  );
};

export default Register;
