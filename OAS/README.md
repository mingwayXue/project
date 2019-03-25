# OAS
基于ssh框架架构的oa系统..

1、在eclipse中maven项目与web项目发布的区别：
    tomcat(需发布项目新模块)中的maven项目最保险的是先移除后，再发布...(避免tomcat项目残留)

2、使用maven架构项目的好处：
    1）只需在pom中添加jar包依赖即可；
    2）maven项目可以通过maven package来将项目成war文件(可以直接在tomcat上运行)；
    3）

3、Hibernate的懒加载：
    延迟加载，也叫懒加载，它是Hibernate为提高程序执行效率而提供的一种机制，即只有真正使用该对象的数据时才会创建。
    1）hibernate中默认采用懒加载的几种情况：
	a.加载一个实体时；
	b.加载实体时，会对实体中的集合；
	c.加载实体时，会对实体中的实体对象；
    2）关闭懒加载：
        a.加载单个实体，如果不需要延迟加载，就可以使用session的get()方法。
	b.可以在映射文件中这个集合的配置元素（set bag list）添加属性lazy=false；
	c.可以在映射文件中针对这个单端关联的配置元素（<one-to-one><many-to-one>）添加lazy=false；
	d(常用方法).使用OpenSessionInView模式，user.department.xxx或user.roles.xxx得出数据；

4、SSH框架中遇见常见的多表添加数据时：
    1）在view页面中添加department.did,则action中可以通过模型驱动(this.getModel())获取；
    2）在view页面中添加did，则action的模型驱动获取不到，需要另行处理；

5、解决hibernate传入数据库数据出现乱码：
    在数据库配置中的url后面添加：（?useUnicode=true&amp;characterEncoding=UTF-8）

6、练习项目中的user_role.js:(2到3遍)
