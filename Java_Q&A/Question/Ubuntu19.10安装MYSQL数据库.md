# Ubuntu19.10安装MYSQL数据库

### 1.安装MYSQL

```shell
sudo apt-get install mysql-server
```

### 2.查看默认用户名和密码

默认用户名和密码存放在/etc/mysql/debian.cnf文件中。

```shell
sudo cat /etc/mysql/debian.cnf
```

### 3.使用默认用户登录mysql

```shell
mysql -udebian-sys-maint -p
```

### 4.修改用户名和密码

```mysql
show databases;		// 查看mysql中的默认数据库
use mysql;		// 使用mysql数据库
update user set authentication_string='' where user='root';		// 将root用户名的密码设置为空
// 不可以使用update user set authentication_string=password(密码) where user='root';，其原因是该版本mysql没有password函数。
select user,authentication_string from user where user='root';		// 清空root用户默认的密码
ALTER user 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '123456';	// 为root设置密码
select user,authentication_string from user where user='root'; 		// 查看设置root用户和密码
```

### 5.修改数据库的编码

登录mysql后使用\s查看默认的编码，

如果不是utf8，编辑/etc/mysql/my.cnf添加如下内容：

```shell
[mysql]
default-character-set=utf8

[mysqld]
character-set-server=utf8

[client]
default-character-set=utf8
```