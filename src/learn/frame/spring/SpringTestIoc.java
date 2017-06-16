package learn.frame.spring;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import learn.frame.spring.annotation.BeanAnnotation;
import learn.frame.spring.annotation.BeanInvoker;
import learn.frame.spring.annotation.resource.TestAtResource;
import learn.frame.spring.entity.People;
import learn.frame.spring.impl.PeopleServiceImpl;
import learn.frame.spring.properties.PropertyPlaceholder;
import learn.frame.spring.service.AutoWiringService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class SpringTestIoc extends SpringJunitBase {
	
	public SpringTestIoc(){
		super("classpath:applicationContext.xml");
	}

	/**
	 * 测试bean的三种创建方式，以构造器为主
	 */
	@Test
	public void testCreateBean(){
		//构造器创建
		People p1 = super.getBean("p1");
		System.out.println(p1);
		//静态工厂
		Calendar c = super.getBean("calendar");
		System.out.println(c.getTime());
		//实例工厂
		Date d = super.getBean("cdate");
		System.out.println(d);
	}
	
	/**
	 * 测试bean的延迟实例化
	 */
	@Test
	public void testLazyInit(){
		//如果配置了lazy-init="false",这里面什么都不写，也会有内容输出
		//测试了延迟加载lazy-init="true",只有使用的时候才会加载
		//延迟加载还有一种方式，全局延迟加载<beans />的属性default-lazy-init
		super.getBean("lazyInit");
	}
	
	/**
	 * 测试setter方式注入
	 */
	@Test
	public void testSetter(){
		PeopleServiceImpl peopleService = (PeopleServiceImpl) super.getBean("peopleService");
		People p = new People();
		p.setName("张三");
		p.setAge(18);
		peopleService.save(p);
	}
	/**
	 * 测试构造器方式注入
	 */
	@Test
	public void testConstructor(){
		PeopleServiceImpl peopleService = (PeopleServiceImpl) super.getBean("peopleService");
		People p = new People();
		p.setName("张三");
		p.setAge(18);
		peopleService.save(p);
	}
	
	/**
	 * 测试bean的作用域
	 */
	@Test
	public void testArea(){
		//singleton单例
		Date d1 = (Date) super.getBean("dateSingleton");
		Date d2 = (Date) super.getBean("dateSingleton");
		System.out.println(d1==d2);
		//prototype
		Date d3 = (Date) super.getBean("datePrototype");
		Date d4 = (Date) super.getBean("datePrototype");
		System.out.println(d3==d4);
	}
	/**
	 * 测试bean的初始化
	 */
	@Test
	public void testInit(){
		super.getBean("people");
	}
	/**
	 * 测试Aware 
	 */
	@Test
	public void testAware(){
		//ApplicationContextAware
		System.out.println("testApplicationContext: "+super.getBean("testApplicationContext").hashCode());
		System.out.println("--------------------------------");
		//BeanNameAware
		System.out.println("testBeanName: "+super.getBean("testBeanName").hashCode());
	}
	/**
	 * 测试自动装配byName,byType,constructor
	 */
	@Test
	public void testAutoWiring(){
		/*
		 * byName,需要set方法的参数跟装配的bean的id一致，byType跟id无关，constructor，需要有一个以装配对象为参数的构造方法
		 */
		AutoWiringService service = (AutoWiringService)super.getBean("autoWiringService");
		service.say("this is auto wiring test...");
	}
	/**
	 * 测试Resource
	 */
	@Test
	public void testResource(){
		TestResource tr = super.getBean("testResource");
		//通过classpath获取资源
		tr.resourceByClasspath();
		//通过file system获取资源
		tr.resourceByFileSystem();
		//通过url获取资源
		tr.resourceByUrl();
		//什么也不通过(none)获取资源/依赖于applicationContext的创建方式
		tr.resourceByNone();
	}
	
	/**
	 * 测试注解自动扫描
	 */
	@Test
	public void testAnnotationAutoScan(){
		//默认bean的id为类的首字母小写
		BeanAnnotation ba = super.getBean("beanAnnotation");
		ba.say("this is bean annotation and auto scan test");
	}
	
	/**
	 * 测试@Autowired注解List跟Map
	 */
	@Test
	public void testAutowiredForListAndMap(){
		//可以看下输出的顺序，如果希望排序使用@Order注解，或实现Ordered接口，只对list排序，对map无作用
		BeanInvoker bik = super.getBean("beanInvoker");
		bik.say();
	}
	
	/**
	 * 测试spring加载properties
	 */
	@Test
	public void testProperties(){
//		Properties properties = super.getBean("const");
//		System.out.println(properties.get("jdbc.username"));
		//PropertyPlaceholderConfigurer p1 = super.getBean("propertyConfigurer");
		PropertyPlaceholder p = super.getBean("propertyPlaceholder");
		String username = PropertyPlaceholder.getPropert("jdbc.username");
		System.out.println(username);
		Properties properties = p.getProperties();
		System.out.println(properties);
	}
	
	/**
	 * 测试@Qualifier
	 */
	@Test
	public void testQualifier(){
		BeanInvoker bik = super.getBean("beanInvoker");
		bik.say();
	}
	
	/**
	 * 测试@Bean
	 */
	@Test
	public void testBean(){
		//TODO
	}
	
	/**
	 * test @ImportResource加载properties文件
	 */
	@Test
	public void testImportResource(){
		//TODO
	}
	
	/**
	 * test @Resource注解
	 */
	@Test
	public void testAtResource(){
		TestAtResource tar = super.getBean("testAtResource");
		tar.testAtResource();
	}
}
