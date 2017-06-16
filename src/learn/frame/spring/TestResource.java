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
	 * 测试通过classpath获取资源，classpath在项目的build path 的source里面
	 */
	public void resourceByClasspath(){
		//通过classpath获取资源
		Resource resource = context.getResource("classpath:config.txt");
		if(resource.exists()){
			String filename = resource.getFilename();
			System.out.println("getResource by classpath:  "+filename);
		}else{
			System.out.println("resource not exists!");
		}
	}
	
	/**
	 * 测试通过file system获取资源
	 */
	public void resourceByFileSystem(){
		//通过文件系统获取资源
		Resource resource = context.getResource("file:D:\\java\\workspace\\designpatterns\\src\\config.txt");
		if(resource.exists()){
			String filename = resource.getFilename();
			System.out.println("getResource by file system: "+filename);
		}else{
			System.out.println("resource not exists!");
		}
	}
	
	/**
	 * 测试通过rul获取资源
	 */
	public void resourceByUrl(){
		//通过文件系统获取资源
		Resource resource = context.getResource("url:http://www.baidu.com/xxx.png");
		if(resource.exists()){
			String filename = resource.getFilename();
			System.out.println("getResource by url: "+filename);
		}else{
			System.out.println("resource not exists!");
		}
	}
	
	/**
	 * 测式什么都不通过获取资源
	 * 这种方式依赖于applicationContext的创建方式(ClassPathXmlApplicationContext的创建方式，
	 * 这里用的是classpath,所以none也是通过classpath加载资源)
	 */
	public void resourceByNone(){
		//通过文件系统获取资源
		Resource resource = context.getResource("config.txt");
		if(resource.exists()){
			String filename = resource.getFilename();
			System.out.println("getResource by none: "+filename);
		}else{
			System.out.println("resource not exists!");
		}
	}

}
