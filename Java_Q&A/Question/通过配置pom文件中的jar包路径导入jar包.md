# 通过配置pom文件中的jar包路径导入jar包

在pom文件中添加对应jar包以下内容：

```xml
<dependency>
	<groupId>com.huizhi</groupId>
	<artifactId>huizhi.utils</artifactId>
	<scope>system</scope>
	<systemPath>${project.basedir}/lib/huizhi.utils-0.0.1.jar</systemPath>
	<version>0.0.1</version>
</dependency>
```