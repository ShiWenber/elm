# elm

- [ ] controller 日志
- [ ] controller 分页查询
- [ ] controller 条件组合查询
- [ ] controller 文档
- [ ] 抽象基类
- [ ] DBHelper适配

项目配置

springboot 2.7.3
maven 3.8.4

## spring配置

### IOC

IoC控制反转

### DI依赖注入

如何进行依赖注入
1. 定义组件 通过@Component， @Service，@Bean等定义一个IoC容器管理的类(组件)
2. 装配组件 通过@Autowired(将淘汰)，@Resource等将一个组件注入到另一个组件中,一般称为字段或者属性注入(spring2版本)
    - 另一种注入方式，构造函数注入(spring3版本提倡，但是仍然支持)
    - 在3.0中建议使用构造函数完成依赖注入而不是使用字段注入
3. 静态属性注入不一定报错，但是不推荐使用

将DBHelper更换为实例，不再使用静态内容

### 数据持久化

#### 数据库访问方式

1. 直接在java代码中使用sql语言访问数据库
2. DBHelper，使用代码级的封装，实现了重用
3. DAO
4. spring data/jpa(java persistence api java持久层接口)

#### jpa

或者使用mybatis作为数据访问层

- 目前java持久层的标准

在物理数据库已经完成的情况下不建议开启jpa的generate-ddl: true，因为会导致数据库的表结构被修改

#### 日志

log4j

用途：在控制台，日志文件，数据库中记录

对于大量的日志内容，使用print会导致性能下降，因此使用日志系统

#### 文档

使用springdoc代替javadoc可以使用更加现代的UI界面查看文档

springdoc注解
- @Scheme 字段
- @Tag 

swagger文档
swagger只定义了文档的信息标准，带有一个swagger-ui能显示文档
或者使用knife4j-ui显示文档

api文档：
- http://localhost:xxxx/swagger-ui/index.html
- http://localhost:xxxx/doc.html

swagger和knife4j都基于oas3标准

标注使用openapi3

#### controller 和 service

controller 和 service 分离

controller 可以作为前后端交互的接口(对外接口)， service作为功能逻辑的实际实现

controller 不包含业务代码，而是调用service

业务代码简单的时候 controller 常常是作为 service 的传递者，controller 调用 service

controller 和 web 上下文有关，而 service 则和 web 无关

controller 是一种用在特定平台的技术，而 service 应该是可以剥离开 controller 后再跨平台重用的

## service

一个service只针对某一类型的数据库表进行擦做

抽象化 service 和 controller

AbstractTypedController 使用泛型将 controller 类型化

命名统一：/menus/page 或者 /menus/{id} 不要使用 /menus/menus_page

![image-20221031192300600](README.assets/image-20221031192300600.png)

**标准化url**

## 身份认证

### https 

安全证书可以使用免费开源的，苹果不认可这种免费的证书

### session & token

一旦登陆，就会获得sessionid，只要你的请求中带有sessionid，就认证成功，存入到cookie中

session模式和token模式的区别：
token不再使用sessionid而换用token
token是自描述的，服务器内部不存储token内容，而session模式需要服务器内存存储，session模式一般适用于单机部署，对于多机分布式部署，token模式更加适用

目前主要用token

对于 jsp 使用session会更简单

使用postman来获得session或者token(表单认证时用postman发送post表单)

自定义用户名和密码

```yaml
spring:
   security:
      user:
         name: admin
         password:
```

```sql
DROP TABLE IF EXISTS Business;
CREATE TABLE Business(
                         id INT NOT NULL AUTO_INCREMENT  COMMENT '商家编号' ,
                         `password` VARCHAR(20) NOT NULL   COMMENT '密码' ,
                         `name` VARCHAR(40) NOT NULL   COMMENT '商家名称' ,
                         `address` VARCHAR(50)    COMMENT '商家地址' ,
                         `explain` VARCHAR(40)    COMMENT '商家介绍' ,
                         img MEDIUMTEXT NOT NULL   COMMENT '图片' ,
                         orderTypeId INT NOT NULL   COMMENT '' ,
                         startPrice DECIMAL(5,2)   DEFAULT 0.00 COMMENT '起送费' ,
                         deliveryPrice DECIMAL(5,2)   DEFAULT 0.00 COMMENT '配送费' ,
                         remarks VARCHAR(40)    COMMENT '' ,
                         PRIMARY KEY (id)
)  COMMENT = '商家表';

DROP TABLE IF EXISTS Food;
CREATE TABLE Food(
                     id INT NOT NULL AUTO_INCREMENT  COMMENT '食品编号' ,
                     `name` VARCHAR(30) NOT NULL   COMMENT '食物名称' ,
                     `explain` VARCHAR(30) NOT NULL   COMMENT '食品简介' ,
                     `img` MEDIUMTEXT NOT NULL   COMMENT '图片' ,
                     price DECIMAL(5,2) NOT NULL   COMMENT '食品价格' ,
                     business$id INT NOT NULL   COMMENT '所属商家编号' ,
                     remarks VARCHAR(40)    COMMENT '' ,
                     PRIMARY KEY (id)
)  COMMENT = '食品表';

DROP TABLE IF EXISTS Admin;
CREATE TABLE Admin(
                      aid INT NOT NULL AUTO_INCREMENT  COMMENT '管理员编号' ,
                      `name` VARCHAR(20) NOT NULL   COMMENT '管理员名称' ,
                      `password` VARCHAR(20)    COMMENT '管理员密码' ,
                      PRIMARY KEY (aid)
)  COMMENT = '管理员表';

DROP TABLE IF EXISTS Cart;
CREATE TABLE Cart(
                     id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
                     food$id INT NOT NULL   COMMENT '食物id' ,
                     business$id INT NOT NULL   COMMENT '商家id' ,
                     user$id VARCHAR(20) NOT NULL   COMMENT '用户id' ,
                     quantity INT NOT NULL   COMMENT '数量id' ,
                     PRIMARY KEY (id)
)  COMMENT = '购物车表';

DROP TABLE IF EXISTS DeliveryAddress;
CREATE TABLE DeliveryAddress(
                                id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
                                contactName VARCHAR(20) NOT NULL   COMMENT '' ,
                                contactSex INT NOT NULL   COMMENT '' ,
                                contactTel VARCHAR(20) NOT NULL   COMMENT '' ,
                                address VARCHAR(100) NOT NULL   COMMENT '更新人' ,
                                user$id VARCHAR(20) NOT NULL   COMMENT '' ,
                                PRIMARY KEY (id)
)  COMMENT = '送货地址表';

DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order`(
                      id INT NOT NULL AUTO_INCREMENT  COMMENT '' ,
                      user$id VARCHAR(32) NOT NULL   COMMENT '' ,
                      business$id INT NOT NULL   COMMENT '' ,
    date VARCHAR(20) NOT NULL   COMMENT '' ,
    total DECIMAL(7,2) NOT NULL  DEFAULT 0.00 COMMENT '' ,
    deliveryAddress$id INT NOT NULL   COMMENT '' ,
    orderState INT NOT NULL  DEFAULT 0 COMMENT '' ,
    PRIMARY KEY (id)
    )  COMMENT = '订单表';

DROP TABLE IF EXISTS OrderDetailet;
CREATE TABLE OrderDetailet(
                              id INT NOT NULL AUTO_INCREMENT  COMMENT '' ,
                              order$id INT NOT NULL   COMMENT '' ,
                              food$id INT NOT NULL   COMMENT '' ,
                              quantity INT NOT NULL   COMMENT '' ,
                              PRIMARY KEY (id)
)  COMMENT = '订单明细表';

DROP TABLE IF EXISTS User;
CREATE TABLE User(
                     id VARCHAR(20) NOT NULL   COMMENT 'id' ,
                     `password` VARCHAR(20) NOT NULL   COMMENT '' ,
                     `name` VARCHAR(20) NOT NULL   COMMENT '' ,
                     sex INT NOT NULL  DEFAULT 1 COMMENT '1为男，0为女' ,
                     img MEDIUMTEXT    COMMENT '' ,
                     delTag INT NOT NULL  DEFAULT 1 COMMENT '' ,
                     PRIMARY KEY (id)
)  COMMENT = '用户表';
```

数据库没有使用check检查唯一，这会影响性能，交给后端程序来检查唯一性

多表连接操作在service层进行，不在controller层进行

设计数据库sql之类的操作则在dao层进行

jpa实体中必须指定主键生成策略，否则创建时会出错

没有物理外键，使用逻辑外键关联表，未建索引，未建视图，所有连接操作都由程序来完成

在代码级如何比较方便的保证一致性（级联删除级联更新）

## security

swagger只在测试阶段使用，当项目上线后，swagger会暴露接口，不安全

需要开发的url: 登陆

### 认证码模式

session
token

现在前后端分离项目一般使用token，如果使用后端生成页面的方式：session

现在用的比较多的是jwt(json web token)

### 用户自定义

userdetailservice 从数据库中获取用户信息以使用security

## 关于jpa和lombok联合使用问题

jpa buddy插件检查了实体上的lombok注解

Using @Data for JPA entities is not recommended. It can cause severe performance and memory consumption issues.

多对多的死递归 -- https://blog.csdn.net/a499477783/article/details/79969750

使用JPA和Lombok时，请记住以下规则：
使用JPA实体时避免使用lombok的@EqualsAndHashCode和@Data;
使用@ToString时始终排除惰性lazy属性;
别忘了用@Builder和@AllArgsConstructor将@NoArgsConstructor添加到实体。

-- https://www.jdon.com/56148

1. dto模式:先取得物理的数据再转换为dto，一个逻辑对象，其数据不存入数据库
2. 直接关联entity

userdetail是自动注入的，当有类实现了userdetail接口，就会自动注入，不需要再做额外的配置