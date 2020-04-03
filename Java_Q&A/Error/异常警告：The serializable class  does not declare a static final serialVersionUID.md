# 异常警告：The serializable class * does not declare a static final serialVersionUID

## 一、提示信息：

The serializable class XXX does not declare a static final serialVersionUID field of type long

## 二、出现原因

当你一个类实现了Serializable接口，如果没有定义serialVersionUID，会提供这个提示功能告诉你去定义。

## 三、serialVersionUID作用

序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。

## 四、serialVersionUID生成方式

### 1.一个是默认的1L，比如：private static final long serialVersionUID = 1L;

## 2.一个是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段，比如：private static final long serialVersionUID = -8940196742313994740L;之类的。