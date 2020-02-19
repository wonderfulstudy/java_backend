# Linux安装配置maven

1.  下载并解压到/etc/profile

2.  设置环境变量

```
export MAVEN_HOME=/usr/local/apache-maven-3.3.1
export PATH=${PATH}:${MAVEN_HOME}/bin
```

3.  刷新环境变量

# VSCODE使用骨架创建MAVEN项目

1.  使用快捷键Ctrl+Shift+P，输入Maven，选择创建MAVEN项目并指定骨架

2.  接下来会在命令窗口叫你输入POM基本信息

![POM基本信息](/home/xiao_qi/Documents/Java后端/Maven/img/深度截图_选择区域_20200217164947.png)