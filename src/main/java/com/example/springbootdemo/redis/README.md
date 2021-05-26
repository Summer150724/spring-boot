# Redis服务端
1. 启动Redis服务端 
redis根目录运行:`redis-server.exe redis.windows.conf`
default:`redis-server.exe`

# Redis基础命令
1. CTRL + T RDM打开命令行
2. SELECT [DB] 切换数据库
3. DBSIZE 查看DB大小
4. KEYS * 查看所有KEY
5. FLUSHDB 清除数据库
   FLUSHALL 清除所有库
6. EXPIRE [KEY] 失效KEY
7. TTL [KEY]

## 1.基础知识
> Redis是单线程的!  (6.0版本之后支持多线程)

- ___Redis基于内存操作,CPU不是REDIS性能的瓶颈,机器的内存和带宽才是___
- ___Redis是C语言写的,100K+的QPS(每秒查询率),不比Memcache差___
- ___速度比较:CPU>内存>硬盘___
- ___核心:Redis将所有数据放在内存中___

## 2.数据类型
### 2.1 五大数据类型
> 