package learn.frame.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class TestResource implements ApplicationContextAware {
	private ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}
	
	/**
	 * ����ͨ��classpath��ȡ��Դ��classpath����Ŀ��build path ��source����
	 */
	public void resourceByClasspath(){
		//ͨ��classpath��ȡ��Դ
		Resource resource = context.getResource("classpath:config.txt");
		if(resource.exists()){
			String filename = resource.getFilename();
			System.out.println("getResource by classpath:  "+filename);
		}else{
			System.out.println("resource not exists!");
		}
	}
	
	/**
	 * ����ͨ��file system��ȡ��Դ
	 */
	public void resourceByFileSystem(){
		//ͨ���ļ�ϵͳ��ȡ��Դ
		Resource resource = context.getResource("file:D:\\java\\workspace\\designpatterns\\src\\config.txt");
		if(resource.exists()){
			String filename = resource.getFilename();
			System.out.println("getResource by file system: "+filename);
		}else{
			System.out.println("resource not exists!");
		}
	}
	
	/**
	 * ����ͨ��rul��ȡ��Դ
	 */
	public void resourceByUrl(){
		//ͨ���ļ�ϵͳ��ȡ��Դ
		Resource resource = context.getResource("url:http://www.baidu.com/xxx.png");
		if(resource.exists()){
			String filename = resource.getFilename();
			System.out.println("getResource by url: "+filename);
		}else{
			System.out.println("resource not exists!");
		}
	}
	
	/**
	 * ��ʽʲô����ͨ����ȡ��Դ
	 * ���ַ�ʽ������applicationContext�Ĵ�����ʽ(ClassPathXmlApplicationContext�Ĵ�����ʽ��
	 * �����õ���classpath,����noneҲ��ͨ��classpath������Դ)
	 */
	public void resourceByNone(){
		//ͨ���ļ�ϵͳ��ȡ��Դ
		Resource resource = context.getResource("config.txt");
		if(resource.exists()){
			String filename = resource.getFilename();
			System.out.println("getResource by none: "+filename);
		}else{
			System.out.println("resource not exists!");
		}
	}

}
