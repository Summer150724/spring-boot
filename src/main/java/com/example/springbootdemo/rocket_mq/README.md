# 本地部署RocketMQ
## 安装部署服务端
1. 下载Binary安装包.
http://rocketmq.apache.org/release_notes/release-notes-4.2.0/
2. 配置环境变量.
ROCKETMQ:${install_path}
3. 启动NAMESERVER.
bin目录下执行`start mqnamesrv.cmd`
4. 启动BROKER.
bin目录下执行`start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true`
> ‘错误: 找不到或无法加载主类 xxxxxx’。打开runbroker.cmd，然后将‘%CLASSPATH%’加上英文双引号。保存并重新执行start语句。
## 运行客户端
1. RocketMQ插件部署 https://github.com/apache/rocketmq-externals.git
2. `rocketmq-externals\rocketmq-console\src\main\resources`文件夹，打开‘application.properties’进行配置
3. 编译`mvn clean package -Dmaven.test.skip=true`
4. 启动`rocketmq-console-ng-1.0.0.jar`