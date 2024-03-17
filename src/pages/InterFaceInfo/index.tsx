import {PageContainer} from '@ant-design/pro-components';
import React, {useEffect, useState} from 'react';
import {useParams} from "react-router";
import {Button, Card, Checkbox, Descriptions, Divider, Form, message} from "antd";
import {
  getInterfaceInfoByIdUsingGET,
  invokeInterfaceInfoUsingPOST
} from "@/services/api-backend/interfaceInfoController";
import TextArea from "antd/lib/input/TextArea";


const Index: React.FC = () => {

  //使用useState和泛型来定义组件内的状态
  //加载状态
  const [loading, setLoading] = useState(false);
  //列表数据
  const [data, setData] = useState<API.InterfaceInfo>();
  //存储结果变量
  const [invokeRes, setInvokeRes] = useState<any>();
  //调用加载状态变量，默认为false
  const [invokeLoading, setInvokeLoading] = useState(false);
  const params = useParams();

  //定义异步加载数据的函数
  const loadData = async () => {
    if (!params.id) {
      message.error('参数不存在');
      return;
    }
    setLoading(true);
    try {
      const res = await getInterfaceInfoByIdUsingGET({
        id: Number(params.id),
      });
      setData(res.data);
    } catch (error: any) {
      message.error('请求失败，' + error.message);
    }
    setLoading(false);
  };

  useEffect(() => {
    //页面加载完成后调用加载数据的函数
    loadData();
  }, []);

  const onFinish = async (values: any) => {
    //检查是否存在接口id
    if (!params.id) {
      message.error('接口不存在');
      return;
    }
    //再开始调用接口之前，将invokeLoading设置为true表示正在加载
    setInvokeLoading(true);
    try {
      //发起接口调用请求，传入一个对象作为参数，这个对象包含了id和values的属性
      //其中，id是从params中获取的，而values是函数的参数
      const res = await invokeInterfaceInfoUsingPOST({
        id: params.id,
        ...values,
      });
      //将接口调用的结果(res.data)更新到invokeRes状态变量中
      setInvokeRes(res.data);
      message.success('请求成功');
    } catch (error: any) {
      message.error('操作失败' + error.message)
    }
    //无论成功或失败，最后将invokeLoading设置为false表示加载完成
    setInvokeLoading(false);
  };

  return (
    //使用antd的PageContainer组件作为页面容器
    <PageContainer title='查看接口文档'>
      <Card>
        {data ? (
          <Descriptions title={data.name} column={1}>
            <Descriptions.Item label="接口id">{data.id}</Descriptions.Item>
            <Descriptions.Item label="接口状态">{data.status ? '开启' : '关闭'}</Descriptions.Item>
            <Descriptions.Item label="描述">{data.description}</Descriptions.Item>
            <Descriptions.Item label="请求地址">{data.url}</Descriptions.Item>
            <Descriptions.Item label="请求方法">{data.method}</Descriptions.Item>
            <Descriptions.Item label="请求参数">{data.requestParams}</Descriptions.Item>
            <Descriptions.Item label="请求头">{data.requestHeader}</Descriptions.Item>
            <Descriptions.Item label="响应头">{data.responseHeader}</Descriptions.Item>
            <Descriptions.Item label="创建时间">{data.createTime}</Descriptions.Item>
            <Descriptions.Item label="更新时间">{data.updateTime}</Descriptions.Item>
          </Descriptions>
        ) : (
          <>接口不存在</>
        )}
      </Card>
      <Divider/>
      <Card title="在线测试">
        {/*创建一个表单，表单名称为"invoke",布局方式为垂直布局，当表单提交时调用onFinish方法*/}
        <Form
          name="invoke"
          layout="vertical"
          onFinish={onFinish}
        >
          {/*创建一个表单项，用于输入请求参数，表单项名称为"userRequestParams"*/}
          <Form.Item
            label="请求参数"
            name="userRequestParams"
          >
            <TextArea/>
          </Form.Item>
          {/*创建一个包裹项，设置其宽度占据16个栅格列*/}
          <Form.Item wrapperCol={{span: 16}}>
            {/*创建调用按钮*/}
            <Button type="primary" htmlType="submit">
              调用
            </Button>
          </Form.Item>
        </Form>
      </Card>
      <Divider/>
      <Card title="返回结果" loading={invokeLoading}>
        {invokeRes}
      </Card>
    </PageContainer>
  );
};

export default Index;
