
# 基于SpringBoot的API管理平台的设计与实现

旨在设计和实现一个面向API接口管理的综合平台，使用Spring Boot后台框架和React前端技术。该平台将支持接口的发布、下线、配置、统计分析以及用户的浏览、开通和调用接口。



## 作者 张郑晨


## 目录结构 📑


| 目录                                                     | 描述               |
|--------------------------------------------------------| ------------------ |
| **🏘️ api-backend**                                  | 后端核心服务模块 |
| **🏘️ api-common**                                   | 公共服务模块     |
| **🕸️ api-gateway**                                 | 网关模块           |
| **🔗 api-interface**                               | 接口模块           |
| **🛠 api-sdk**                                      | 开发者调用sdk      |

## 快速启动 🚀

### 前端

环境要求：Node.js >= 16

安装依赖：

```bash
yarn or npm install
```

启动：

```bash
yarn run dev or npm run start:dev
```

部署：

```bash
yarn build or npm run build
```

### 后端

执行sql目录下ddl.sql



## 功能介绍 📋

|                          **功能**                           | **普通用户** | **管理员** |
| ----------------------------------------------------- |-----|-----|
| **API-CLIENT-SDK**获取 | ✅ |     ✅      |
|                    切换主题、深色、暗色                      | ✅ | ✅ |
|                        在线调试接口                          | ✅ | ✅ |
|                 浏览接口                                     | ✅ | ✅ |
|                          更新头像                            | ✅ | ✅ |
|                    用户管理                      | ❌ | ✅ |
|                接口管理、接口发布、下架                  | ❌ | ✅ |
|                接口流量数据                  | ❌ | ✅ |




## 主要API 参考📑

#### 返回响应码

| 响应码	|参数名称|	参数描述|
| :-------- | :------- | :------------------------- |
|0	|SUCCESS |	ok|
|40000|	PARAMS_ERROR |	请求参数错误|
|40101|	NO_AUTH_ERROR 	|无权限|
|40300|	FORBIDDEN_ERROR 	|禁止访问|
|40400|	NOT_FOUND_ERROR |	请求数据不存在|
|50000|	SYSTEM_ERROR 	|系统内部异常
|50001|	OPERATION_ERROR 	|操作失败|

#### 添加用户

```http
  POST  /api/post/add
```

| 参数 | 类型     | 描述                |
| :-------- | :------- | :------------------------- |
| `UserAddRequest` | `application/json` | **必选**. UserAddRequest  |

#### 删除用户

```http
  POST  /api/user/delete
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `DeleteRequest `      | `application/json` | **必选**. DeleteRequest |

#### 根据ID获取用户

```http
  GET  /api/user/get
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `id `      | `integer(int32) ` |  |

#### 获取登录用户

```http
  GET  /api/user/get/login
```

#### 列出用户

```http
  GET  /api/user/list
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `createTime  `      | `string` | 非必选 |
| `current  `      | `integer` | 非必选 |
| `gender  `      | `integer` | 非必选 |
| `id `      | `integer` | 非必选 |
| `pageSize  `      | `integer` | 非必选 |
| `sortField  `      | `string` | 非必选 |
| `sortOrder `      | `string` | 非必选 |
| `updateTime  `      | `string` | 非必选 |
| `userAccount  `      | `string` | 非必选 |
| `userAvatar  `      | `string` | 非必选 |
| `userName  `      | `string` | 非必选 |
| `userRole  `      | `string` | 非必选 |

#### 按页面列出用户

```http
  GET  /api/user/list/page
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `createTime  `      | `string` | 非必选 |
| `current  `      | `integer` | 非必选 |
| `gender  `      | `integer` | 非必选 |
| `id `      | `integer` | 非必选 |
| `pageSize  `      | `integer` | 非必选 |
| `sortField  `      | `string` | 非必选 |
| `sortOrder `      | `string` | 非必选 |
| `updateTime  `      | `string` | 非必选 |
| `userAccount  `      | `string` | 非必选 |
| `userAvatar  `      | `string` | 非必选 |
| `userName  `      | `string` | 非必选 |
| `userRole  `      | `string` | 非必选 |

#### 用户登录

```http
  POST  /api/user/login
```

| 参数 | 类型     | 描述                |
| :-------- | :------- | :------------------------- |
| `userLoginRequest ` | `application/json` | **必选**. UserAddRequest  |

#### 用户退出

```http
  POST  /api/user/logout
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `无 `      | `无` | 无 |

#### 用户注册

```http
  POST  /api/user/register
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `UserRegisterRequest  `      | `无` | **必选**. UserRegisterRequest |

#### 更新用户

```http
  POST  /api/user/update
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `userUpdateRequest   `      | `application/json` | **必选**. userUpdateRequest |

#### 上传用户

```http
  POST  /api/user/upload
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `UserUploadRequest   `      | `application/json` | **必选**. UserUploadRequest |

#### 添加接口信息

```http
  POST  /api/interfaceInfo/add
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `InterfaceInfoAddRequest   `      | `application/json` | **必选**. InterfaceInfoAddRequest |

#### 删除接口信息

```http
  POST  /api/interfaceInfo/delete
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `DeleteRequest    `      | `application/json` | **必选**. DeleteRequest  |

#### 通过 ID 获取接口信息

```http
  GET  /api/interfaceInfo/get
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `id    `      | `integer` | 接口id  |

#### 调用接口信息

```http
  POST  /api/interfaceInfo/invoke
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `interfaceInfoInvokeRequest`      | `application/json` | **必选**. interfaceInfoInvokeRequest  |

#### 列出接口信息

```http
  GET  /api/interfaceInfo/list
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `current  `      | `integer` | 非必选 |
| `description   `      | `string ` | 非必选 |
| `id `      | `integer` | 非必选 |
| `method   `      | `string` | 非必选 |
| `name   `      | `string` | 非必选 |
| `pageSize  `      | `integer` | 非必选 |
| `requestHeader   `      | `string` | 非必选 |
| `responseHeader   `      | `string` | 非必选 |
| `sortField   `      | `string` | 非必选 |
| `sortOrder   `      | `string` | 非必选 |
| `status   `      | `integer` | 非必选 |
| `url   `      | `string` | 非必选 |
| `userId    `      | `integer` | 非必选 |

#### 按页列出界面信息

```http
  GET  /api/interfaceInfo/list/page
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `current  `      | `integer` | 非必选 |
| `description   `      | `string ` | 非必选 |
| `id `      | `integer` | 非必选 |
| `method   `      | `string` | 非必选 |
| `name   `      | `string` | 非必选 |
| `pageSize  `      | `integer` | 非必选 |
| `requestHeader   `      | `string` | 非必选 |
| `responseHeader   `      | `string` | 非必选 |
| `sortField   `      | `string` | 非必选 |
| `sortOrder   `      | `string` | 非必选 |
| `status   `      | `integer` | 非必选 |
| `url   `      | `string` | 非必选 |
| `userId    `      | `integer` | 非必选 |

####  下线接口信息

```http
  POST  /api/interfaceInfo/offline
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `IdRequest`      | `application/json` | **必选**. IdRequest   |

####  上线接口信息

```http
  POST  /api/interfaceInfo/online
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `IdRequest`      | `application/json` | **必选**. IdRequest   |

####  更新接口信息

```http
  POST  /api/interfaceInfo/update
```

| 参数 | 类型     | 描述                       |
| :-------- | :------- | :-------------------------------- |
| `InterfaceInfoUpdateRequest`      | `application/json` | **必选**. InterfaceInfoUpdateRequest   |


