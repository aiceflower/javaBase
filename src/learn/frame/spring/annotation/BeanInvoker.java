package learn.frame.spring.annotation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeanInvoker {
	
	/**
	 * @Autowired������list
	 */
	@Autowired
	private List<BeanInterface> list;
	
	/**
	 * @Autowired������map,map��keyһ��Ҫ��String��
	 */
	@Autowired
	private Map<String, BeanInterface> map;
	
	/**
	 * ����Qualifier
	 */
	@Autowired
	@Qualifier("beanImplOne")//BeanInterface������ʵ���࣬��Qualifier����
	private BeanInterface bi ;
	
	/**
	 * test @Autowire and @Qualifier
	 */
	public void say(){
		
		System.out.println("test list...");
		if(list!=null&&!list.isEmpty()){
			for (BeanInterface bif :list) {
				System.out.println(bif.getClass().getName());
			}
		}else{
			System.out.println("list is empty!!!");
		}
		
		System.out.println();
		
		System.out.println("test map...");
		if(map!=null&&!map.isEmpty()){
			for (Map.Entry<String, BeanInterface> entry:map.entrySet()) {
				System.out.println("key: "+entry.getKey()+" value: "+entry.getValue().getClass().getName());
			}
		}else{
			System.out.println("map is empty!!!");
		}
		 
		System.out.println();
		
		System.out.println("test Qualifier...");
		if(bi!=null){
			System.out.println("test Qualifier: "+bi.getClass().getName());
		}else{
			System.out.println("bi is null...");
		}
	}
	
}
