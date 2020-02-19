# Maven基础

## 1.Maven介绍

### 1.1 Maven项目结构

![Maven项目结构](/home/xiao_qi/Documents/Java后端/Maven/img/深度截图_选择区域_20200219130715.png)

项目更目录a-maven-project是项目名。它有一个项目描述文件pom.xml。

src/main/java，存放Java源代码。

src/main/resource，存放资源文件。

src/test/resource，存放测试资源。

target，存放所有编译、打包生成的文件。

### 1.2 pom.xml

pom.xml基本内容

```
<project ...>
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.itranswarp.learnjava</groupId>
	<artifactId>hello</artifactId>
	<version>1.0</version>
	<packaging>jar</packaging>
	<properties>
        ...
	</properties>
	<dependencies>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>
	</dependencies>
</project>
```

groupId类似于Java包名，通常是公司或组织名称。

artifactId类似于Java类名，通常为项目名称。

version为版本号。

*一个Maven工程是由groupId、artifactId、versioon唯一标识。*

引入第三方库时也是通过这三个变量确定的。

使用`<dependency>`声明一个依赖，Maven就会自动下载这个依赖包并把它放到classpath中。

## 2.依赖管理

Maven的第一个作用就是解决依赖管理，我们声明自己项目需要abc，Maven会自动导入abc的jar包，再判断abc需要xyz，又自动导入xyz的jar包。

### 2.1 依赖关系

![Maven的几种依赖关系](/home/xiao_qi/Documents/Java后端/Maven/img/深度截图_选择区域_20200219133341.png)

### 2.2 Maven镜像

Maven可以从中央仓库下载还可以从Maven镜像仓库下载。

中国区用户可以使用阿里云提供的Maven镜像仓库，在.m2目录下创建一个settings.xml配置文件。

```
<settings>
    <mirrors>
        <mirror>
            <id>aliyun</id>
            <name>aliyun</name>
            <mirrorOf>central</mirrorOf>
            <!-- 国内推荐阿里云的Maven镜像 -->   						<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
        </mirror>
    </mirrors>
</settings>
```

### 2.3 搜索第三方组件

通过search.maven.org搜索关键字。

## 3.构建流程

Maven的生命周期有一系列阶段构成，以内置生命周期default为例，它包含一下phase：

-   validate
-   initialize
-   generate-sources
-   process-sources
-   generate-resources
-   process-resources
-   compile
-   process-classes
-   generate-test-sources
-   process-test-sources
-   generate-test-resources
-   process-test-resources
-   test-compile
-   process-test-classes
-   test
-   prepare-package
-   package
-   pre-integration-test
-   integration-test
-   post-integration-test
-   verify
-   install
-   deploy

Maven的另一个常用的生命周期是clean，它会执行3个phase：

-   pre-clean
-   clean （注意这个clean不是lifecycle而是phase）
-   post-clean

所以我们使用mvn命令时，后面的参数是phase，Maven自动根据生命周期运行到指定phase。

在实际开发过程中，经常使用的命令有：

mvn clean：清理所有生成的class和jar；

mvn clean compile：先清理，在执行到compile；

mvn clean test：先清理，再执行到test；

mvn clean package：先清理，再执行到package。

执行一个phase又会触发一个或多个goal。

-   lifecycle相当于Java的package，它包含一个或多个phase；
-   phase相当于Java的class，它包含一个或多个goal；
-   goal相当于class的method，它其实才是真正干活的。

## 4.使用插件

Maven将执行compile这个phase，这个phase会调用compile插件执行关联的compiler:compile这个goal。实际上执行每个phase都是通过某个插件plugin来执行的。

Maven内置的常用标准插件：

![Maven内置的标准插件](/home/xiao_qi/Documents/Java后端/Maven/img/深度截图_选择区域_20200219145921.png)

如果标准插件无法满足需求，还可以使用自定义插件，使用maven-shade-plugin可以创建一个可执行的jar，需要在pom.xml中声明：

```
<project>
    ...
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-shade-plugin</artifactId>
                <version>3.2.1</version>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>shade</goal>
						</goals>
						<configuration>
                            ...
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
</project>
```

自定义插件往往需要一些配置。

## 5.模块管理

## 6.使用mvnw



 