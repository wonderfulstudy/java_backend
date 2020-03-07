# Java语言高级特性

[TOC]

## 第一章：Java多线程编程

### 1.进程与线程

线程在进程的基础之上应用起来的。

### 2.Thread类实现多线程

继承Thread类就为线程主体类，必须覆写run方法，run为线程的主体方法。

多线程要执行的功能都应该在run方法中进行定义，但是run方法是不能直接被调用的，要想使用多线程必须使用start方法。

*为什么不直接使用run方法？*

使用start方法调用start0方法，使JVM调用系统对应的多线程底层函数执行相应的算法。

### 3.Runnable接口实现多线程

由于Java中存在单继承限制，提供Runnable接口。

### 4.Thread与Runnable关系

Thread类也是Runnable的子类。

### 5.Callable接口实现多线程

Runnable接口没有返回值，Callable接口就是为了解决这一缺点。

**面试题：**请解释Runnable与Callable的区别？

- Runnable是在JDK1.0的时候提出的多线程的实现接口，而Callable是在JDK1.5之后提出的
- java.lang.Runnable接口之中只提供一个run方法，并且没有返回值
- java.util.concurrent.Callable接口提供有call方法，可以有返回值

### 6.多线程运行状态



## 第二章：线程常用操作方法

### 1.线程的命名和取得

设置线程的名字：

- 构造方法：public Thread(Runnable target,String name);
- 设置名字：public final void setName(String name);
- 取得名字：public final String getName();

没有给线程命名时，由系统自动为线程分配序号。当每启动一个Java程序，系统就启动一个JVM进程。main线程进行程序步骤的控制，子线程进行耗时操作。

### 2.线程休眠

希望线程可以暂缓一些，使线程休眠。

- 休眠：public static void sleep(long millis) throws InterruptedException;
- 休眠：public static void sleep(long millis,int nanos) throws InterruptedException;

出现错误会产生InterruptedException异常，该异常是Exception的子类，因此必须强制处理。

### 3.线程中断

线程可以由另一个线程中断，所有正在执行的线程都是可以被中断的，中断线程必须进行异常处理。

### 4.线程强制运行

希望线程独占执行，可以使线程强制执行。

- 强制执行：public final void join() throws InterruptedException;

在进行线程强制执行的时候一定要获取强制执行线程对象之后才可以执行join()调用。

### 5.线程礼让

礼让指先将资源让出去。

- 礼让：public static yield();

礼让执行时调用yield方法，只执行一次。

### 6.线程优先级

理论上讲优先级越高越可能抢占到资源。

- 设置优先级：public final void setPriority(int newPriority)
- 获取优先级：public final int getPriority();

优先级通过int型数字来完成。

- 最高优先级：public static dinal int MAX_PRIORITY、10;
- 中等优先级：public static dinal int NORM_PRIORITY、5;
- 最低优先级：public static dinal int MIN_PRIORITY、1;

优先级有可能先执行，但并不一定先执行。

主线程属于中等优先级，默认创建的线程也是中等优先级。

## 第三章：线程的同步与死锁

### 1.同步问题的引出

多个线程同时操作同一内存空间。

### 2.线程同步处理

解决同步的问题是锁，在程序中实现锁的功能，使用synchronized关键字。

1. 利用同步代码块进行处理

```
sychronized(同步对象){
	同步代码操作;
}
```

加入同步处理之后程序的整体性能下降了，同步实际上会造成性能降低。

2. 利用同步方法解决：在方法的定义时加上synchronized关键字

### 3.线程死锁

死锁就是若干线程彼此等待的情况。若干个线程访问同一资源要使用同步处理，但过多的同步处理要造成死锁的出现。

## 第四章：多线程深入话题

### 1.优雅的停止线程

停止线程可以使用stop方法，但是从JDK1.2之后就不推荐使用stop方法。

- 停止多线程：public void stop();
- 销毁多线程：public void destory();
- 挂起线程：public final void suspend()、暂停执行；
- 恢复挂起的线程执行：public final void resume();

这些方法会导致死锁，因此JDK1.2之后不推荐使用。

**停止线程示例：**

```
package cn.mldn.demo;

public class ThreadDemo{
	public static boolean flag = ture;
	public static void main(String[] args){
		new Thread(() -> {
			long num = 0;
			while (flage){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "正在运行、num = " + num ++)
			}
		}, "执行线程").start();
		Thread.sleep(200); 	// 运行200毫秒
		flag = false;		// 停止线程
	}
}
```

### 2.后台守护线程

随主线程一直执行下去，并且运行在后台状态。

在Thread类里面提供有如下的守护线程的操作方法：

- 设置为守护线程：public final void setDaemon(boolean on);
- 判断是否为守护线程：public final boolean isDaemon();

所有的守护线程都是围绕在用户线程的周围，如果用户线程都结束了，守护线程也会结束。

### 3.volatile关键字

volatile关键字用在属性定义上，表示属性为直接操作，在一些书上将其错误的理解为同步属性。

在正常进行变量处理的时候往往会经历如下几个步骤：

- 获取变量原有的数据内容副本；
- 利用副本为变量进行数学计算；
- 将计算后的变量，保存到原始空间之中；

volatile是直接操作原始数据，不进行数据副本的操作。

**面试题：**请解释volatile与synchronized的区别？

- volatile主要在属性上使用，而synchronized是在代码块与方法上使用的；
- volatile无法描述同步处理，它只是一种直接内存的处理，避免了副本的操作

## 第五章：Java基础类库

### 1.StringBuffer类

StringBuffer类专门用来处理字符串内容需要更改的对象，StringBuffer类要像普通类对象一样实例化。

- 构造方法：public StringBuffer();
- 构造方法：public StringBuffer(String str)，接收初始化内容；
- 数据追加：public StringBuffer append(数据类型 变量)；

“+”在编译之后就变成了StringBuffer的append方法。

### 2.CharSequence接口

只要有字符串就能用CharSequence接口实例化。

### 3.AutoCloseable接口

AutoCloseable接口主要用于资源开发的处理上，以实现资源的自动关闭（释放）。

但类对象或接口光继承AutoCloseable无法起作用，还应该配套使用异常处理。

继承AutoCloseable实现自动关闭需要覆写close方法。

### 4.Runtime类

Runtime描述的是运行时的状态，整个JVM之中Runtime是唯一一个与JVM状态有关的类，并且都会默认提供有该类的实例化对象。

由于每一个JVM进程只允许提供一个Runtime类的对象，因此Runtime类的构造方法被私有化了。该类使用的是单例设计模式，并且会提供一个static方法获取本类实例。获取实例化对象使用getRuntime方法。

Runtime类中四个最重要的方法：

- 获取最大可用内存空间：public long maxMemory()，默认为本机系统内存的四分之一；
- 获取可用内存空间：public long totalMemory()，默认为本机内存的六十四分之一；
- 获取空闲内存空间：public long freeMemory()
- 手工进行GC处理：public void gc()

**面试题：**请问什么是GC？如何处理？

- GC（Garbage Collector）垃圾收集器，是可以由系统自动调用的垃圾释放功能，或者使用Runtime类中的gc()手工调用。

### 5.System类

重要处理方法：

- 数组拷贝：public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)


- 获取当前的日期时间数值：public static long currentTimeMillis()

- 进行垃圾回收：public static void gc()，是直接调用Runtime.gc()方法。

### 6.Cleaner类

### 7.对象克隆

## 第六章：数字操作类

### 1.Math数学计算类

math的构造方法为私有化，但不是单例，math的所有方法都是静态的。

### 2.Random随机数生成类

产生随机数的类。

### 3.大数字处理类

BigInteger、BigBigDecimal类继承自Number类。Math的处理性能高于大数字处理类。

## 第七章：日期操作类

### 1.Date日期处理

java.util.data，直接实例化就可以显示当前事件。

Date类只是对long数据的一种包装。

### 2.SimpleDateFormat日期处理类

Date类输出的时间格式不习惯。该类是DateFormat的子类。

String字符串可以向所有数据类型转换。

## 第八章：正则表达式

### 1.认识正则表达式

正则表达式主要用于字符串的验证处理。

### 2.常用正则标记

- 【数量：单个】字符匹配
	- 任意字符：表示由任意字符组成
	- \\\\：匹配“\”
	- \\n：匹配换行
	- \\t：匹配制表符
- 【数量：单个】匹配字符集（可以从里面任选一个字符）
	- [abc]：表示可能是字母a、b、c中的任意一个
	- [^abc]：表示不是由a、b、c中的任意一个字母组成
	- [a-zA-Z]：表示由任意一个字母组成，不区分大小写
	- [0-9]：表示由一位数字组成
- 【数量：单个】简化字符集
	- .：表示任意的一个字符
	- \\d：等价于“[0-9]”范围
	- \\D：等价于“[\^0-9]”范围
	- \\s：匹配任意的一位空格，可能是空格、换行、制表符
	- \\S：匹配任意的非空格数据
	- \\w：匹配字母、数字、下划线，等价于“[a-zA-z_0-9]”
	- \\W：匹配非字母、数字、下划线，等价于“[\^a-zA-z_0-9]”
- 边界匹配
	- ^：匹配边界开始
	- $：匹配边界结束
- 数量表示，默认情况下只有添加上了数量单位才可以匹配多位字符
	- 表达式？：该正则可以出现0次或1次
	- 表达式*：该正则可以出现0次、1次或多次
	- 表达式+：该正则可以出现1次多多次
	- 表达式{n}，：表达式的长度正好为n次
	- 表达式{n，}：表达式的长度为n次以上
	- 表达式{n，m}：表达式的长度在n~m次
- 逻辑表达式：可以连接多个正则
	- 表达式X表达式Y：X表达式之后紧跟上Y表达式
	- 表达式X|表达式Y：有一个表达式满足即可
	- (表达式)：为表达式设置一个整体描述，可以为整体设置数量单位

### 3.String类对正则的支持

### 4.java.util.regex包支持

如果只是匹配、替换、拆分更本用不到java.util.regex。

## 第九章：国际化程序实现

### 1.国际化程序实现原理

### 2.Locale类

### 3.ResourceBundle读取资源文件

### 4.实现国际化程序开发

### 5.格式化文本显示

## 第十章：开发支持类库

### 1.UUID类

### 2.Optional类

### 3.ThreadLocal类

### 4.定时调度

### 5.Base64加密与解密

## 第十一章：比较器

## 第十二章：文件操作

## 第十三章：字节流与字符流

## 第十四章：IO操作深入

## 第十五章：输入与输出支持







