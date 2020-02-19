# Java Swing概述

## 一、Swing概述

Swing没有完全取代AWT，而是基于AWT架构上，Swing仅仅提供了更加强大的用户界面组件。

## 二、Swing构建

### 1.创建架构

Java中顶层窗口被称为框架（frame)，AWT库中有一个称为Frame的类，用于描述顶层窗口，这个类的Swing版本名为JFrame。

JFrame类的常用构造方法：

```
JFrame();//构造一个初始时不可见的新窗体
JFrame(String title);//创建一个具有title指定标题的不可见窗体
```

当创建一个JFrame类的实例化对象后，其他组件并不能够直接放到容器上面，需要将组件添加至内容窗格，而不是直接添加至JFrame对象。

```
frame.getContenPane().add(b);
```

使用JFrame类创建GUI界面时，其组件的布局组织示意图如图：

![JFrame窗口组件组织](/home/xiao_qi/Documents/Java后端/Swing/img/深度截图_选择区域_20200212104253.png)

### 2.窗体组件类结构

![窗体组件类结构](/home/xiao_qi/Documents/Java后端/Swing/img/深度截图_选择区域_20200217113843.png)

### 3.Swing常用组件

![Swing常用组件](/home/xiao_qi/Documents/Java后端/Swing/img/深度截图_选择区域_20200217114043.png)

![Swing常用组件](/home/xiao_qi/Documents/Java后端/Swing/img/深度截图_选择区域_20200217114358.png)

![Swing常用组件](/home/xiao_qi/Documents/Java后端/Swing/img/深度截图_选择区域_20200217114646.png)

#### 3.1 窗体JFrame

