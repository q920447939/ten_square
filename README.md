**本人模仿这个项目的时候出现的问题以及解决办法(QQ群:124569404)**

1. condition 如果报错需要改成别的字段,因为这个是mysql的关键字
2. elasticsearch不能安装到有包含空格的路径下,否则安装ik分词的时候会报io异常
3. 如果有Chrome,那么不需要安装ElasticSearch Head  ,直接在Chrome插件里面搜索ElasticSearch Head 就可以了,效果跟安装ElasticSearch Head 一样
4. ten_search 项目pom.xml中如果引入spring-data-elasticsearch 报错,那么就像我一样去掉版本号,这样启动就不会报错了
5. 有的项目可能依赖了common.但是common又继承了parent ,parent中有有mysql-connection jar包,导致启动的时候会自动的注入DataSource Bean ,所以启动的时候可以排除掉mysql的DataSource Bean的配置