## mybatis-plus思维导图，让mybatis-plus不再难懂
- https://www.jianshu.com/p/df543044e8e2
- https://mp.baomidou.com/guide/


## 特性
   - 无侵入：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
   - 损耗小：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
   - 强大的 CRUD 操作：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求
   - 支持 Lambda 形式调用：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错
   - 支持主键自动生成：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题
   - 支持 ActiveRecord 模式：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作
   - 支持自定义全局通用操作：支持全局通用方法注入（ Write once, use anywhere ）
   - 内置代码生成器：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用
   - 内置分页插件：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询
   - 分页插件支持多种数据库：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer2005、SQLServer 等多种数据库
   - 内置性能分析插件：可输出 Sql 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
   - 内置全局拦截插件：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作

## 添加依赖
- 引入 Spring Boot Starter 父工程：
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.6.RELEASE</version>
        <relativePath/>
    </parent>
- 引入 spring-boot-starter、spring-boot-starter-test、mybatis-plus-boot-starter、lombok、h2 依赖：
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.1.2</version>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
    
## 配置
- 在 application.yml 配置文件中添加 H2 数据库的相关配置：
    # DataSource Config
    spring:
      datasource:
        driver-class-name: org.h2.Driver
        schema: classpath:db/schema-h2.sql
        data: classpath:db/data-h2.sql
        url: jdbc:h2:mem:test
        username: root
        password: test
- 在 Spring Boot 启动类中添加 @MapperScan 注解，扫描 Mapper 文件夹：
    @SpringBootApplication
    @MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
    public class Application {
    
        public static void main(String[] args) {
            SpringApplication.run(QuickStartApplication.class, args);
        }
    }
## 编码
- 编写实体类 User.java（此处使用了 Lombok 简化代码）
  @Data
  public class User {
      private Long id;
      private String name;
      private Integer age;
      private String email;
  }
- 编写Mapper类 UserMapper.java
  public interface UserMapper extends BaseMapper<User> {
  
  }
  
## 注解
  @TableName
  描述：表名注解
  属性	             类型	必须指定	默认值	描述
  value	            String	   否	  ""	表名
  resultMap	        String	   否	  ""	xml 中 resultMap 的 id
  schema	        String	   否	  ""	schema(@since 3.1.1)
  keepGlobalPrefix	boolean    否	false	是否保持使用全局的 tablePrefix 的值(如果设置了全局 tablePrefix 且自行设置了 value 的值)(@since 3.1.1)
  #@TableId
  描述：主键注解
  属性	 类型	必须指定	 默认值	         描述
  value	 String	   否	  ""	        主键字段名
  type	 Enum	   否	  IdType.NONE	主键类型
  #IdType
  值	描述
  AUTO	数据库自增
  INPUT	自行输入
  ID_WORKER	分布式全局唯一ID 长整型类型
  UUID	32位UUID字符串
  NONE	无状态
  ID_WORKER_STR	分布式全局唯一ID 字符串类型
  #@TableField
  描述：字段注解(非主键)
  属性	类型	必须指定	默认值	描述
  value	String	否	""	字段名
  el	String	否	""	映射为原生 #{ ... } 逻辑,相当于写在 xml 里的 #{ ... } 部分
  exist	boolean	否	true	是否为数据库表字段
  condition	String	否	""	字段 where 实体查询比较条件,有值设置则按设置的值为准,没有则为默认全局的 %s=#{%s},参考
  update	String	否	""	字段 update set 部分注入, 例如：update="%s+1"：表示更新时会set version=version+1(该属性优先级高于 el 属性)
  strategy	Enum	否	FieldStrategy.DEFAULT	字段验证策略
  fill	Enum	否	FieldFill.DEFAULT	字段自动填充策略
  select	boolean	否	true	是否进行 select 查询
  keepGlobalFormat	boolean	否	false	是否保持使用全局的 format 进行处理(@since 3.1.1)
  #FieldStrategy
  值	描述
  IGNORED	忽略判断
  NOT_NULL	非NULL判断
  NOT_EMPTY	非空判断(只对字符串类型字段,其他类型字段依然为非NULL判断)
  DEFAULT	追随全局配置
  #FieldFill
  值	描述
  DEFAULT	默认不处理
  INSERT	插入时填充字段
  UPDATE	更新时填充字段
  INSERT_UPDATE	插入和更新时填充字段
  #@Version
  描述：乐观锁注解、标记 @Verison 在字段上
  #@EnumValue
  描述：通枚举类注解(注解在枚举字段上)
  #@TableLogic
  描述：表字段逻辑处理注解（逻辑删除）
  属性	类型	必须指定	默认值	描述
  value	String	否	""	逻辑未删除值
  delval	String	否	""	逻辑删除值
  #@SqlParser
  描述：租户注解 目前只支持注解在 mapper 的方法上(3.1.1开始支持注解在mapper上)
  属性	类型	必须指定	默认值	描述
  filter	boolean	否	false	true: 表示过滤SQL解析，即不会进入ISqlParser解析链，否则会进解析链并追加例如tenant_id等条件
  #@KeySequence
  描述：序列主键策略 oracle
  属性：value、resultMap
  属性	类型	必须指定	默认值	描述
  value	String	否	""	序列名
  clazz	Class	否	Long.class	id的类型, 可以指定String.class，这样返回的Sequence值是字符串"1"
  
 



## 操作教程
- Lambda
- 官方表示，3.x支持Lambda表达式，那应该怎么使用呢？我们来看个例子：
  ServiceScheme ServiceScheme = ServiceSchemeMapper.selectOne(
                  new QueryWrapper<ServiceScheme>().lambda()
                          .eq(ServiceScheme::getCompanyId, 11)
                          .eq(ServiceScheme::getCompanyInfoId, 11)
                          .eq(ServiceScheme::getMainAccount, "Hello")
  );
          
- 分页查询
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }