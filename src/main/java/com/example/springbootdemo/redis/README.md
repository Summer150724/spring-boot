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
8. ./REDIS-CLI --RAW 中文支持

## 1.基础知识
> Redis是单线程的!  (6.0版本之后支持多线程)

- ___Redis基于内存操作,CPU不是REDIS性能的瓶颈,机器的内存和带宽才是___
- ___Redis是C语言写的,100K+的QPS(每秒查询率),不比Memcache差___
- ___速度比较:CPU>内存>硬盘___
- ___核心:Redis将所有数据放在内存中___

## 2.数据类型
### 2.1 五大数据类型
### 1.String

> 基础命令

```REDIS
# 拼接(key不存在时会自动SET)
APPEND [key] [value] 
# 自增/自减
INCR [key]
DECR [key]
# 自增步长/自减步长
INCRBY [key] [len]
DECRBY [key] [len]
# 截取字符串
GETRANGE [key] [start] [end]
## 获取全部字符串
GETRANGE [key] 0 -1
# 替换字符串 (replace)
SETRANGE [key] [offset] [value]
# 特殊SET(REDIS LOCK)
SETEX(SET WITH EXPIRE)
SETNX(SET NOT EXISTS)
# 批量操作
MSET [key1] [v1] [key2] [v2]
MGET [key1] [key2] 
MSETNX 
# 设置对象(`:`的用法)
SET user:1 {name:summer,age:24}
MSET user:1:name summer user:1:age 24
> 区别:结构不同
# 组合命令
```

### 2.List

> 给他玩成栈,队列,阻塞队列
>
> 所有命令都以L开头
>
> 本质是链表

``` REDIS
# 压入
LPUSH [key] value [value value]
# 获取
LRANGE [key] 0 -1
# 压入最右端
RPUSH [key] value
# 弹出
LPOP [key] value // 弹出队列的第一个元素
RPOP [key] value // 弹出队列的最后个元素

# INDEX
LINDEX [key] [index] // 获取指定index值
# 长度
LLEN [key]
# 移除指定的元素
LREM [key] [count] [value] // count>0 从左到右 count<0 从右到左
# 截取
LTRIM [key] [start] [end]

# 组合命令
RPOPLPUSH [source] [destination] // 弹出source队列的最后元素压入目标队列中

# 更新列表指定index的value
LSET [key] [index] [value]

# 插入
LINSERT [key] before|after pivot element

```



### 3.Set

### 4.Hash

### 5.Zset

