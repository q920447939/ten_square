**本人模仿这个项目的时候出现的问题以及解决办法(QQ群:124569404)**

本项目`orm`并未采用`spring-data-jpa`,采用的是`mybatis-plus ,[mybatis-plus](http://mp.baomidou.com/),自动生成的代码模板可参照

`mybatis-plus`官方提供的模板,也可采用我修改的模板,[点击进入](https://github.com/q920447939/mybatisplus-spring-boot)

1. `condition `如果报错需要改成别的字段,因为这个是mysql的关键字

2. elasticsearch不能安装到有包含空格的路径下,否则安装ik分词的时候会报io异常

3. 如果有Chrome,那么不需要安装ElasticSearch Head  ,直接在Chrome插件里面搜索`ElasticSearch Head` 就可以了,效果跟安装ElasticSearch Head 一样

4. ten_search 项目pom.xml中如果引入spring-data-elasticsearch 报错,那么就像我一样去掉版本号,这样启动就不会报错了

5. 有的项目可能依赖了common.但是common又继承了parent ,parent中有有mysql-connection jar包,导致启动的时候会自动的注入DataSource Bean ,所以启动的时候可以排除掉mysql的DataSource Bean的配置

6. 如果使用 如下[1]方式启动 ,但是用使用`docker ps -a `发现es 没有启动起来,也没有报错的情况下可以采用第[2]种方式启动

   1. ```c
      docker run -di --name=ten_square_es -p 9200:9200 -p 9300:9300  docker.elastic.co/elasticsearch/elasticsearch:6.3.2
      ```

   2. ```c
      1,拉取docker镜像:
      docker pull docker.elastic.co/elasticsearch/elasticsearch:6.1.1
      2,启动:
      docker run -p 9200:9200 -e "http.host=0.0.0.0" -e "transport.host=127.0.0.1" docker.elastic.co/elasticsearch/elasticsearch:6.1.1
      
      ```

​	**Elasticsearch 的默认账户为 elastic 默认密码为 changme**

​	修改默认密码:

```shell
curl -XPUT -u elastic 'http://localhost:9200/_xpack/security/user/elastic/_password' -d '{
  "password" : "yourpasswd"
}'s
curl -XPUT -u elastic 'http://localhost:9200/_xpack/security/user/kibana/_password' -d '{
  "password" : "yourpasswd"
}'
```



​	 附docker安装以及常用命令:

   ```shell
      安装docker
   
   　　yum -y install docker-io
   
   　　启动docker
   
   　　service docker start
   
   　　开机启动
   
   　　[root@localhost ~]# systemctl enable docker
   	Created symlink from /etc/systemd/system/multi-user.target.wants/docker.service to /usr/lib/systemd/system/docker.service.
   	
   	将指定用户添加到用户组
   	usermod -aG docker your_username
   	
   	退出，然后重新登录，以便让权限生效。
   ```

 **但是并不能够通过java代码访问到配置的9300端口**

一开始以为是集群没有设置名称以及以为服务器没有开放端口,其实都是有的 



### Docker 安装RabbitMQ

​	1.拉取镜像

```shell
docker pull rabbitmq:3-management

```

​	2.启动镜像（默认用户名密码）,默认guest 用户，密码也是 guest

```shell
docker run -d --hostname my-rabbit --name rabbit -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password  -p 5671:5671 -p 5672:5672 -p 4369:4369 -p 15671:15671 -p 15672:15672 rabbitmq:3-management
```



  	3,完成之后访问 [http://localhost:15672/]( http://localhost:15672/) (ps:不要使用代理,这样会访问不到.亲测)



​	**spring boot配置RabbitMQ注意:**

```yaml
spring:
  datasource:
    rabbitmq:
        host: your service ip host
        username: user   #因为设置了账号和密码 所以这里需要设置账号和密码
        password: password
```



#### 