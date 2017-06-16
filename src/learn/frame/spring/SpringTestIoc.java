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
	 * ����bean�����ִ�����ʽ���Թ�����Ϊ��
	 */
	@Test
	public void testCreateBean(){
		//����������
		People p1 = super.getBean("p1");
		System.out.println(p1);
		//��̬����
		Calendar c = super.getBean("calendar");
		System.out.println(c.getTime());
		//ʵ������
		Date d = super.getBean("cdate");
		System.out.println(d);
	}
	
	/**
	 * ����bean���ӳ�ʵ����
	 */
	@Test
	public void testLazyInit(){
		//���������lazy-init="false",������ʲô����д��Ҳ�����������
		//�������ӳټ���lazy-init="true",ֻ��ʹ�õ�ʱ��Ż����
		//�ӳټ��ػ���һ�ַ�ʽ��ȫ���ӳټ���<beans />������default-lazy-init
		super.getBean("lazyInit");
	}
	
	/**
	 * ����setter��ʽע��
	 */
	@Test
	public void testSetter(){
		PeopleServiceImpl peopleService = (PeopleServiceImpl) super.getBean("peopleService");
		People p = new People();
		p.setName("����");
		p.setAge(18);
		peopleService.save(p);
	}
	/**
	 * ���Թ�������ʽע��
	 */
	@Test
	public void testConstructor(){
		PeopleServiceImpl peopleService = (PeopleServiceImpl) super.getBean("peopleService");
		People p = new People();
		p.setName("����");
		p.setAge(18);
		peopleService.save(p);
	}
	
	/**
	 * ����bean��������
	 */
	@Test
	public void testArea(){
		//singleton����
		Date d1 = (Date) super.getBean("dateSingleton");
		Date d2 = (Date) super.getBean("dateSingleton");
		System.out.println(d1==d2);
		//prototype
		Date d3 = (Date) super.getBean("datePrototype");
		Date d4 = (Date) super.getBean("datePrototype");
		System.out.println(d3==d4);
	}
	/**
	 * ����bean�ĳ�ʼ��
	 */
	@Test
	public void testInit(){
		super.getBean("people");
	}
	/**
	 * ����Aware 
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
	 * �����Զ�װ��byName,byType,constructor
	 */
	@Test
	public void testAutoWiring(){
		/*
		 * byName,��Ҫset�����Ĳ�����װ���bean��idһ�£�byType��id�޹أ�constructor����Ҫ��һ����װ�����Ϊ�����Ĺ��췽��
		 */
		AutoWiringService service = (AutoWiringService)super.getBean("autoWiringService");
		service.say("this is auto wiring test...");
	}
	/**
	 * ����Resource
	 */
	@Test
	public void testResource(){
		TestResource tr = super.getBean("testResource");
		//ͨ��classpath��ȡ��Դ
		tr.resourceByClasspath();
		//ͨ��file system��ȡ��Դ
		tr.resourceByFileSystem();
		//ͨ��url��ȡ��Դ
		tr.resourceByUrl();
		//ʲôҲ��ͨ��(none)��ȡ��Դ/������applicationContext�Ĵ�����ʽ
		tr.resourceByNone();
	}
	
	/**
	 * ����ע���Զ�ɨ��
	 */
	@Test
	public void testAnnotationAutoScan(){
		//Ĭ��bean��idΪ�������ĸСд
		BeanAnnotation ba = super.getBean("beanAnnotation");
		ba.say("this is bean annotation and auto scan test");
	}
	
	/**
	 * ����@Autowiredע��List��Map
	 */
	@Test
	public void testAutowiredForListAndMap(){
		//���Կ��������˳�����ϣ������ʹ��@Orderע�⣬��ʵ��Ordered�ӿڣ�ֻ��list���򣬶�map������
		BeanInvoker bik = super.getBean("beanInvoker");
		bik.say();
	}
	
	/**
	 * ����spring����properties
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
	 * ����@Qualifier
	 */
	@Test
	public void testQualifier(){
		BeanInvoker bik = super.getBean("beanInvoker");
		bik.say();
	}
	
	/**
	 * ����@Bean
	 */
	@Test
	public void testBean(){
		//TODO
	}
	
	/**
	 * test @ImportResource����properties�ļ�
	 */
	@Test
	public void testImportResource(){
		//TODO
	}
	
	/**
	 * test @Resourceע��
	 */
	@Test
	public void testAtResource(){
		TestAtResource tar = super.getBean("testAtResource");
		tar.testAtResource();
	}
}
