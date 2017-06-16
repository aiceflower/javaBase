Spring大专题之IOC
一、什么是AOP
	面向切面编程，通过预编译方式和运行期代理实现程序功能的统一维护的一种技术
	主要的功能：日志记录，性能统计，安全控制，事务处理，异常处理等
二、AOP实现方式
	1.预编译
		AspectJ
	2.运行期动态代理(JDK动态代理，CGLib动态代理)
		SpringAop、JbossAop
三、AOP的几个相关概念
	1.切面(aspect):一个关注点的模块化
	2.连接点(joinPoint):程序执行过程中的某个特点的点
	3.通知(advice):在切面的某个特定的连接点上执行的动作
	4.切入点(pointCut):匹配连接点的断言，在AOP中通知和一个切入点表达式关联
	5.引入(introduction):在不修改类代码的前提下，为类添加新的方法和属性
	6.目标对象(target object):被一个或多个切面所通知的对象
	7.AOP代理(AOP proxy):AOP框架创建的对象，用来实现切面契约(aspect contract)(包括通知方法执行等功能)
	8.织入(weaving):把切面连接到其它的应用程序类型或者对象上，并创建一个被通知的对象，分为:编译时织入、类加载时织入、执行时织入
四、advice的类型
	1.前置通知(before advice):在某个连接点之前执行的通知，但不能阻止连接点前的执行(除非它抛出一个异常)
	2.返回后通知(after returning advice):在某个连接点正常完成后执行的通知
	3.抛出异常后通知(after throwing advice):在方法抛出异常退出时执行的通知
	4.后通知(after(finally) advice):在某连接点退出的时候执行的通知(不论是正常返回还是异常退出)
	5.环绕通知(around advice):包围一个连接点的通知
五、有接口和无接口的AOP实现
	有接口：spring默认用JKD动态代理（一个类实现了某个接口）
	无接口：spring可使用CGLIB动态代理（一个类没有实现任何接口）
六、配置aop
	spring所有的切面和通知器都必须放在一个<aop:config>内,可以配置多个
	每一个<aop:config>可以包含pointcut,advisor,和aspect元素，它们的顺序不能反
七、基于配置的aop的实现
	见配置
八、Introductions
	简介允许一个切面声明一个实现指定接口的通知对象，且提供了一个接口实现类来代表这些对象
	由<aop:aspect>中的<aop:declare-parents>元素申明该元素用于所匹配的类型拥有一个新的parent
	原本类没有实现某接口，但加入上述配置后可以强转为某接口
	