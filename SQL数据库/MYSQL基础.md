## 第一章：SQL语言概述

SQL语法：

1.  SQL语句可以在单行或多行书写，以分号结尾
2.  可以使用空格和缩进来增强语句的可读性
3.  MYSQL不区分大小写，建议使用大写

SQL语句分类：

1.  DDL（Data Definition Language）：数据定义语言，用来定义数据库对象：库、表、列等；
2.  DML（Data Manipulation Language）：数据操作语言，用来定义数据库记录（数据）；
3.  DCL（Data Control Language）：数据控制语言，用来定义访问权限和安全级别；
4.  DQL（Data Query Language）：数据查询语言，用来查询记录（数据）

## 第二章：DDL（数据定义语言）

### 1.数据类型介绍

-   字符类型

| 类型         | 大小                                     | 范围（有符号）                                               | 范围（无符号）                                               | 用途            |
| :----------- | :--------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :-------------- |
| TINYINT      | 1 字节                                   | (-128，127)                                                  | (0，255)                                                     | 小整数值        |
| SMALLINT     | 2 字节                                   | (-32 768，32 767)                                            | (0，65 535)                                                  | 大整数值        |
| MEDIUMINT    | 3 字节                                   | (-8 388 608，8 388 607)                                      | (0，16 777 215)                                              | 大整数值        |
| INT或INTEGER | 4 字节                                   | (-2 147 483 648，2 147 483 647)                              | (0，4 294 967 295)                                           | 大整数值        |
| BIGINT       | 8 字节                                   | (-9,223,372,036,854,775,808，9 223 372 036 854 775 807)      | (0，18 446 744 073 709 551 615)                              | 极大整数值      |
| FLOAT        | 4 字节                                   | (-3.402 823 466 E+38，-1.175 494 351 E-38)，0，(1.175 494 351 E-38，3.402 823 466 351 E+38) | 0，(1.175 494 351 E-38，3.402 823 466 E+38)                  | 单精度 浮点数值 |
| DOUBLE       | 8 字节                                   | (-1.797 693 134 862 315 7 E+308，-2.225 073 858 507 201 4 E-308)，0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 双精度 浮点数值 |
| DECIMAL      | 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2 | 依赖于M和D的值                                               | 依赖于M和D的值                                               | 小数值          |

-   字符串类型

| 类型       | 大小                | 用途                            |
| :--------- | :------------------ | :------------------------------ |
| CHAR       | 0-255字节           | 定长字符串                      |
| VARCHAR    | 0-65535 字节        | 变长字符串                      |
| TINYBLOB   | 0-255字节           | 不超过 255 个字符的二进制字符串 |
| TINYTEXT   | 0-255字节           | 短文本字符串                    |
| BLOB       | 0-65 535字节        | 二进制形式的长文本数据          |
| TEXT       | 0-65 535字节        | 长文本数据                      |
| MEDIUMBLOB | 0-16 777 215字节    | 二进制形式的中等长度文本数据    |
| MEDIUMTEXT | 0-16 777 215字节    | 中等长度文本数据                |
| LONGBLOB   | 0-4 294 967 295字节 | 二进制形式的极大文本数据        |
| LONGTEXT   | 0-4 294 967 295字节 | 极大文本数据                    |

-   时间和日期类型

| 类型      | 大小 (字节) | 范围                                                         | 格式                | 用途                     |
| :-------- | :---------- | :----------------------------------------------------------- | :------------------ | :----------------------- |
| DATE      | 3           | 1000-01-01/9999-12-31                                        | YYYY-MM-DD          | 日期值                   |
| TIME      | 3           | '-838:59:59'/'838:59:59'                                     | HH:MM:SS            | 时间值或持续时间         |
| YEAR      | 1           | 1901/2155                                                    | YYYY                | 年份值                   |
| DATETIME  | 8           | 1000-01-01 00:00:00/9999-12-31 23:59:59                      | YYYY-MM-DD HH:MM:SS | 混合日期和时间值         |
| TIMESTAMP | 4           | 1970-01-01 00:00:00/2038结束时间是第 **2147483647** 秒，北京时间 **2038-1-19 11:14:07**，格林尼治时间 2038年1月19日 凌晨 03:14:07 | YYYYMMDD HHMMSS     | 混合日期和时间值，时间戳 |

-   几个非常重要的数据类型

    -   int：整型
    -   double：浮点型，例如double(5,2)表示最多5位，其中必须有两位小数
    -   decimal：浮点型，表示金钱使用该类型，不会出现精度缺失问题
    -   char：固定长度字符串类型
    -   varchar：可变长度字符串类型
    -   text(clob)：字符串类型
    -   blob：字节类型
    -   date：日期类型，格式为：yyyy-mm-dd
    -   time：时间类型，格式为：hh：mm：ss
    -   timestamp：时间戳类型

### 2.DDL操作数据库

-   查看所有数据库：SHOW DATABASES

-   切换（选择要操作的）数据库：USE database_name

-   创建数据库：CREATE DATABASE [IF NOT EXISTS] mydb1 [CHARSET=utf8]

-   删除数据库：DROP DATABASE [IF EXISTS] mydb1

-   修改数据库编码：ALTER DATABASE mydb1 CHARACTER SET utf8

### 3.DDL操作表

-   创建表：

```sql
CREATE TABLE [IF NOT EXISTS] table_name(
    column_name1 data_type(size),
	column_name2 data_type(size),
	column_name3 data_type(size),
	....
);
```

-   查看当前数据库中所有表名称：

```sql
SHOW TABLES;
```

-   查看表结构：

```sql
DESC table_name;
```

-   删除表：

```sql
DROP TABLE table_name;
```

-   修改表：前缀：`ALTER TABLE 表名`

    -   添加列

    ```sql
    ALTER TABLE 表名 ADD(
    	列名 列类型;
        列名 列类型;
        ...
    );
    ```

    -   修改列类型（如果修改已存在数据，那么新的类型可能会影响到已存在数据）

    ```sql
    ALTER TABLE 表名 MODIFY 列名 列类型;
    ```

    -   修改列名

    ```sql
    ALTER TABLE 表名 CHANGE 原列名 新列名 列类型;
    ```

    -   删除列

    ```sql
    ALTER TABLE 表名 DROP 列名;
    ```

    -   修改表名

    ```sql
    ALTER TABLE 原表名 RENAME TO 新表名;
    ```

## 第三章：DML（数据操作语言）

### 1.插入数据

-   INSERT INTO table_name (column1,column2,column3,...) VALUES (*value1*,*value2*,*value3*,...);
	-   在表名后给出要插入的列名，其他没有指定的列等同与插入null值，所以插图记录总是插入一行，不可能是半行
    -   在VALUES后给出列值，值的顺序和个数必须与前面指定的列对应
-   INSERT INTO table_name VALUES (value1,value2,value3,...);
    -   没有给出要插入的列，那么表示插入所有列
    -   值的个数必须是该表列的个数
    -   值的顺序，必须与表创建时给出的列的顺序相同

### 2.修改数据

-   UPDATE table_name SET column1=value1, column2=value2, ... [WHERE option];
    -   条件是可选的
        -   条件必须是一个boolean类型的值或表达式
        -   运算符：=、!=、<>、>、<、>=、<=、BETWEEN...AND、IN(...)、IS NULL、NOT、OR、AND

### 3.删除数据

-   DELETE FROM table_name [WHERE option];
-   TRUNCATE TABLE table_name;
    -   TRUNCATE是DDL语句它是先删除drop该表，再create该表，而且无法回滚。

## 第四章：DCL（数据控制语言）

### 1.创建用户

-   CREATE USER user_name@ip_addres IDENTIFIED BY 'password';
    -   用户只能在指定的IP地址上登录
-   CREATE USER user_name@'%' IDENTIFIED BY 'password';
    -   用户可以在任意IP地址上登录

### 2.给用户授权

-   GRANT 权限1, ..., 权限n ON database.* TP user_name@ip_address;
    -   权限、用户、数据库
    -   给用户分配在指定的数据库上的指定的权限
-   GRANT ALL ON database.* TO user_name@ip_address;
    -   给用户分配指定数据库上的所有权限

### 3.撤销授权

-   REVOKE 权限1, ... ,权限n ON database.* FROM user_name@ip_address;
    -   撤销指定用户在指定数据库上的指定权限

### 4.查看权限

-   SHOW GRANTS FOR user_name@ip_address
    -   查看指定用户的权限

### 5.删除用户

-   DROP USER user_name@ip_address



