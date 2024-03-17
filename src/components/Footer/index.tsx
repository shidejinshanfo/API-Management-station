import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import '@umijs/max';
import React from 'react';
const Footer: React.FC = () => {
  const defaultMessage = 'API管理平台';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'API Management Platform',
          title: 'API Management Platform',
          href: '',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <GithubOutlined />,
          href: 'https://github.com/shidejinshanfo?tab=repositories',
          blankTarget: true,
        },
        {
          key: 'shidejinshanfo',
          title: 'shidejinshanfo',
          href: 'https://github.com/shidejinshanfo?tab=repositories',
          blankTarget: true,
        },
      ]}
    />
  );
};
export default Footer;
