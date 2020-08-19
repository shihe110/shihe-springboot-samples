## SpringSecurity之数据库获取用户

- 1.添加mysql连接
- 2.使用security提供的建表语句，新建用户权限表
org/springframework/security/core/userdetails/jdbc/users.ddl
- 3.配置UserDetailsService （注入DataSource）配置若干用户
- 4.启动测试