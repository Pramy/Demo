# mybatis-plus

继承mybatis的所有特性，而且添加一系列加强特性

- PerformanceInterceptor插件

  提供一个拦截器可以分析sql执行情况，但是生产环境最好不用

  ```java
  @Bean
  @Profile({"dev","test"})
  public PerformanceInterceptor performanceInterceptor() {
     PerformanceInterceptor per = new PerformanceInterceptor();
     per.setMaxTime(100);
     return per;
  }
  ```

  使用注解来标记为dev和test环境才用，在springboot配置文件中设置`spring.profiles.active=dev`

- Maven代码生成插件：

  ```xml
  <plugin>
     <groupId>com.baomidou</groupId>
     <artifactId>mybatisplus-maven-plugin</artifactId>
     <version>1.0</version>
  </plugin>
  ```

  值得注意的是maven项目生层的service的包路径有误所以必须加上

  ```xml
  <superServiceClass>com.baomidou.mybatisplus.service.IService</superServiceClass>             <superServiceImplClass>com.baomidou.mybatisplus.service.impl.ServiceImpl</superServiceImplClass>
                    
  ```

  详细配置请看[pom.xml](pom.xml)

- ActiveRecord模式

  所有的po类都会继承一个`model` 类，然后实现其中的方法，返回的是id，然后po类就可以直接使用dao的功能了

  - 如果字段和表中的字段有出入可以使用注解`@TableField` 来标识
  - 如果想使用id生成策略可以使用`@TableId(type = IdType.ID_WORKER)` 来实现，具体策略请看`IdType`

# log4j2

这个项目用了听说是日志之王的log4j2，实现了异步输出日志，集成springboot的方法如下

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter</artifactId>
  <!--因为spring boot内置的logback，所以要排除掉-->
          <exclusions>
              <exclusion>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-starter-logging</artifactId>
              </exclusion>
          </exclusions>
</dependency>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-log4j2</artifactId>
      </dependency>
      <!-- Log4j2 异步支持，需要实现异步一定要添加 -->
      <dependency>
          <groupId>com.lmax</groupId>
          <artifactId>disruptor</artifactId>
          <version>3.3.6</version>
      </dependency>
```

然后再resource下面建立log4j2.xml，然后用springboot指定配置文件

```java
logging.config=classpath:log4j2.xml
```

详细配置解释看[log4j2.xml](src/main/resources/log4j2.xml)