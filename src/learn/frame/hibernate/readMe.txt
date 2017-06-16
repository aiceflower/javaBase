一、在hibernate框架中使用Configuration获取数据库连接的时候需要如下包
1.hibernate3.2.7.jar hibernate核心jar包
2.ojdbc14.jar 数据库连接驱动，否则会报找不到驱动错误
3.c3p0.jar 管理连接的连接池所需jar包 com/mchange/v2/c3p0/DataSources
4.commons-collections.jar 否则会报classNotFound org/apache/commons/collections/map/LRUmap
5.jta.jar 否则会报javax.transaction错
