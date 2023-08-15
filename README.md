# 项目环境配置说明

### 项目描述：



### 运行环境：

数据库：Mysql 8   

<br>

JDK:1.8

### 项目运行：

1、在数据库新建一个名为department的数据库，导入Sql语句
<br>
2、IDEA打开项目，在src/main/resources/application.yml中更改数据库配置

```yaml
spring:
  datasource:
    //用户名
    username: root
    //密码
    password: 123456
    //department是数据库名称，如果命名不同需要修改
    url: jdbc:mysql://localhost:3306/department?useUnicode=true&characterEncoding=utf8&serverTimezoneGMT%2B8&useSSL=true&rewriteBatchedStatements=true
    // 这个不要动，如果报错可以改成com.mysql.jdbc.Driver
    driver-class-name: com.mysql.cj.jdbc.Driver
server:
  // 运行端口号，自行修改
  port: 8088
```

后续本人有时间会给本系统添加SpringSecurity+JWT认证、Redis、RabbitMQ等相关内容，敬请期待！