Spring大专题之IOC
一、学习技术
	掌握用法-->深入理解-->不断实践-->反复总结-->再次深入理解与实践
----------------------
关于序列化小插曲：
	序列化构造方法的调用：
		序列化的时候都会显示调用，但是反序列化的时候会显示调用实现序列化接口父类（往上）的构造方法
----------------------
二、spring文档
	1.http://spring.io/
	2.http://projects.spring.io/spring-framework/
三、spring概况
	spring是一个开源框架，为了解决企业应用开发的复杂性而创建的，但现在已经不止应用于企业应用
	是一个轻量级的控制反转(ioc)，和面向切面(aop)的容器框架
	容器（管理应用对象的配置和生命周期）
	框架（将简单的组件配置，组合成复杂的应用）（制定一套规范或者规则，我们在这种规范下进行工作）
四、框架的特点
	1.半成品
	2.封装了特定的处理流程和控制逻辑
	3.成熟的，不断升级的软件
五、为什么使用框架
	1.软件系统日趋复杂
	2.重用度高，开发效率和质量提高
	3.软件设计人员要专注于对领域的理解，使需求分析更充分
	4.易于上手，快速解决问题
六、接口
	接口实现的变动不影响各层间的调用
七、Bean
	1.bean的配置项
		常用：id、class、scope、constructor-arg、property、autowiring mode(自动装载模式)、
		lazy-initialization mode(懒加载模式)、initialization/destruction method(初始化和销毁的方法)
	2.bean的作用域(scope)
		singleton:(default)单例，指一个bean容器中只存在一份
		prototype:每次请求（每次使用）创建新的实例，destroy方式不生效(请求结束后就会销毁)
		request:每次http请求创建一个实例且仅在当前requestmw有效
		session:同上，每次http请求创建，当前session内有效
		global session:基于portle的web中有效（portlet定义了global session），如果是在web中，同session
	3.bean的生命周期
		定义-->初始化-->使用-->销毁
		
		初始化：二种方式(针对某一个bean)
			1.实现InitializingBean接口,实现afterPropertiesSet方法
			2.配置init-method
		销毁：二种方式(针对某一个bean)
			1.实现DisposableBean接口，覆盖destroy方法
			2.配置destroy-method方法
		针对全局：
			初始化：default-init-method="init"
			销毁: default-destroy-method="destroy"
		tips:初始化销毁方法
			初始化优先级：InitializingBean接口 > 配置init-method > 配置default-init-method="init"
			销毁优先级：同上
			配置default-init-method="init"后可以没有init方法
			但配置init-method后必须有其方法
			如果三种方式都配置了，那么配置default-init-method="init"不会生效
	4.bean的自动装配
		no:不做任何操作
		byName:(set方法的参数名需要跟需要注入的bean的id一样)根据属性名自动装配，此选项将检查容器并根据名字查找与属性完全一致的bean，并将其与属性自动装配
		byType:()如果容器中存在一个与指定属性类型相同的bean，那么将与该属性自动装配；如果存在多个该类型bean，那
			么抛出异常，并指出不能使用byType方式进行自动装配；如果没有找到相匹配的bean，则什么事都不发生
		constructor:与byType方式类似，不同之处在于它应用于构造器参数。如果容器中没有找到与构造器参数类型一致的bean，那么抛出异常
	5.Resources&ResourceLoader
		Resource:
			UrlResource:URL对应的资源，根据一个URL地址即可构建
			ClassPathResource:获取类路径下的资源文件
			FileSystemResource:获取文件系统里面的资源
			ServletContextResource:ServletContext封装的资源，用于访问ServletContext环境下的资源
			InputStreamResource:针对于输入流封装的资源
			ByteArrayResource:针对于字节数组的资源
		ResourceLoader:
			在spring中所有的application context都实现了ResourceLoader接口，所有的context都可以获取Resource实例
			classpath:	classpath:com/myapp/config.xml	从classpath(Build Path下的Source)中加载资源文件
			file:		file:/data/config.xml			从文件系统加载资源文件
			http:		http://myserver/logo.png		作为一个url加载
			(none)		/data/config.xml				依赖于applicationContext(ClassPathXmlApplicationContext)
八、Aware(spring中提供了一些以Aware结尾的接口，实现了这样的接口可以获得一些相应的资源)
	ApplictionContextAware可以提供bean的上下文applictionContext，但需要实现ApplictionContextAware接口并配置实现的类到配置文件中
	BeanNameAware提供bean的name,需要实现BeanName接口，并配置实现类到配置文件中
	BeanClassLoaderAware
	BeanFactoryAware
	BootstrapContextAware
	LoadTimeWeaverAware
九、Classpath扫描与组件管理
	从Spring3.0开始，Spring JavaConfig项目提供了很多特性包括使用java而不是XML定义bean，比如
		@Configuration、@Bean、@Import、@DependsOn
	@Component是一个通用注解，可用于任何bean
	@Repository ，@Service，@Controller是更有针对性的注解
	--@Repository通常用于注解DAO类，即持久层
	--@Service通常用于注解Service类，即服务层
	--@Controller通常用于Controller类，即控制层(MVC)
	
十、元注解：注解的注解
十一、类的自动检测及Bean的注册
		1.Spring可以自动检测类并注册Bean到ApplicationContext中
		2.<context:component-scan>
		  <context:annotation-config>，前者包含后者，通常在使用前者后，不用再使用后者
		3.使用过滤器进行自定义扫描
			默认发问下，类被自动发现并注册到bean的条件是：使用
			@Component、@Repository、@Service、@Controller注解可使用@Component的自定义注解
		4.可以通过过滤器修改上面的行为
			如：下面例子的xml配置忽略所有的@Repository注解并用"Stub"代替
			<beans>
				<context:component-scan base-package="org.example">
					<context:include-filter type="regex" expression=".*Stub.*Repository"/>
					<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
				</context:component-scan>
			</beans>
			还可以使用use-default-filters="false"禁用自动发现与注册
		5.bean的名称
			扫描并注册bean时bean的name是由BeanNameGenerator生成的之前的四个注解都会有一个name属性用于显示设置bean name
			可自定义bean命名策略，实现BeanNameGenerator接口，并一定要包含一个无参构造器
				<beans>
					<context:component-scan base-package="org.example" name-generator="org.example.MyNamegenerator"/>
				</beans>
		6.注解作用域
			@Scope("singleton")
			自定义scope策略,实现ScopeMetadataResolver接口，无参构造器
				<beans>
					<context:component-scan base-package="org.example" scope-resolver="org.example.MyScopeResolver"/>
				</beans>
		7.代理方式(三个值可选：no、interfaces、targetClass)
			<beans>
				<context:component-scan base-package="org.example" scoped-proxy="interfaces"/>
			</beans>
十一、其它注解
	1.Required注解适用于bean属性的setter方法（配置的时候就必赋值）
	这个注解表示，受影响的bean属性必须在配置时被填充，通过在bean定义或通过自动装配一个明确的属性值
	2.@Autowired/Qualifier(可处理构造器注入跟setter注入)
	默认情况下，如果因找不到合适的bean将会导致autowiring失败抛出异常，可以通过下面的方式避免
	@Autowired(required=false)
	setXxx(){}
	每个类只能有一个构造器被标记为required=true
	@Autowired可以作用于成员变量上，setter方法上，也可以作用于构造器上
	@Autowired是由Spring BeanPostProcessor处理的，所以不能在自己的BeanPostProcessor或
		BeanFactoryPostProcessor类型应用这些注解，这些类型必须通过xml或者spring的@Bean注解加载
	@Autowired可以注解List或Map，示例如下
	 @Autowired
	 private List<BeanInterface> list;(实现BeanInterface的类都将被注入)
	@Qualifier声明需要注入的bean的id，用在参数前面，如果是根据类型进行装配时有多个类型，可以用@Qualifier来缩小范围
	@Inject/@Named用法同@Autowired/@Qualifier，但需要导包，注：@Named还可作用于类上同@Component
	3.@Resource只能用于Setter注入,可以作用在成员变量上或者set方法上（可以没有set方法）
	4.@PostConstruct 注解初始化 @PreDestroy注解销毁
	5.@Value注入spring的表达式，先在xml中指定需要注入的properties文件,使用@value注解的时候注意参数不要与操作系统的参数相同
		如：
			@Value("${name}")与@Value("${jdbc.name}")获取的内容有可能不一样，所以写信properties的key的时候注意一下
	6.@Bean标识一个用于配置和初始化一个由SpringIoc容器管理的新对象的方法，类似于xml配置文件的<bean/>
		默认用@Bean注解的方法，的bean为方法名（使用@Bean默认是单例的，可以使用@Scope来修改）
		@Bean(name="store",initMethod="init",destroyMethod="destroy")可以配置初始化及销毁方法
十二、spring加载properties
	方式一：
		<bean id="propertyConfigurer"
			class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
			<property name="locations">
				<list>
					<value>classpath:viewserverconfig.properties</value>
				</list>
			</property>
		</bean>
	方式二：
		<util:properties id="const" location="classpath:jdbc.properties"/>