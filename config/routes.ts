export default [
  { name:'接口调用',path: '/', icon: 'smile', component: './Index' },
  { name:'接口信息表',path: '/interface_info/:id', icon: 'smile', component: './InterFaceInfo', hideInMenu: true },
  { name:'登录',path: '/user', layout: false, routes: [{ path: '/user/login', component: './User/Login' }] },
  { name:'注册',path: '/user', layout: false, routes: [{ path: '/user/register', component: './User/Register' }] },
  {
    name:'管理员页',
    path: '/admin',
    icon: 'crown',
    access: 'canAdmin',
    routes: [
      { icon: 'table', name:'接口管理表',path: '/admin/interface_info', component: './Admin/InterfaceInfo' },
      {
        icon: 'analysis',
        name:'数据展示',
        path: '/admin/interface_analysis',
        component: './Admin/InterfaceAnalysis',
      },
      {
        name: '用户管理',
        icon: 'TeamOutlined',
        path: '/admin/user/list',
        component: './Admin/UserList',
      },
    ],
  },
  {
    path: '/account/center',
    name: '个人中心',
    component: './User/UserInfo',
    hideInMenu: true,
  },
  {
    path: '/account/settings',
    name: '个人设置',
    component: './User/UserInfoSetting',
    hideInMenu: true,
  },
  { name:'欢迎页',path: '*', layout: false, component: './404' },
];
