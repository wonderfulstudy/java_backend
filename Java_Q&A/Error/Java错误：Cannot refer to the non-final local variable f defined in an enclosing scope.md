# Java错误：Cannot refer to the non-final local variable f defined in an enclosing scope

**问题描述：**在使用Java局部内部类或者内部类时，若该类调用了所在方法的局部变量，则该局部变量必须使用final关键字修饰，否则会报：Cannot refer to the non-final local variable f defined in an enclosing scope的编译错误。

**问题原因：**在方法中定义非变量是局部变量，当方法返回时，局部变量对应的栈就被回收了，当方法内部类去访问局部变量时就会发生错误。当在变量前加上final时，变量就不在是真的变量了，成了常量，这样在编译器进行编译时(即编译阶段)就会用变量的值来代替变量，这样就不会出现变量清除后，再访问变量的错误。