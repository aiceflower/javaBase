Spring��ר��֮IOC
һ��ѧϰ����
	�����÷�-->�������-->����ʵ��-->�����ܽ�-->�ٴ����������ʵ��
----------------------
�������л�С������
	���л����췽���ĵ��ã�
		���л���ʱ�򶼻���ʾ���ã����Ƿ����л���ʱ�����ʾ����ʵ�����л��ӿڸ��ࣨ���ϣ��Ĺ��췽��
----------------------
����spring�ĵ�
	1.http://spring.io/
	2.http://projects.spring.io/spring-framework/
����spring�ſ�
	spring��һ����Դ��ܣ�Ϊ�˽����ҵӦ�ÿ����ĸ����Զ������ģ��������Ѿ���ֹӦ������ҵӦ��
	��һ���������Ŀ��Ʒ�ת(ioc)������������(aop)���������
	����������Ӧ�ö�������ú��������ڣ�
	��ܣ����򵥵�������ã���ϳɸ��ӵ�Ӧ�ã����ƶ�һ�׹淶���߹������������ֹ淶�½��й�����
�ġ���ܵ��ص�
	1.���Ʒ
	2.��װ���ض��Ĵ������̺Ϳ����߼�
	3.����ģ��������������
�塢Ϊʲôʹ�ÿ��
	1.���ϵͳ��������
	2.���öȸߣ�����Ч�ʺ��������
	3.��������ԱҪרע�ڶ��������⣬ʹ������������
	4.�������֣����ٽ������
�����ӿ�
	�ӿ�ʵ�ֵı䶯��Ӱ������ĵ���
�ߡ�Bean
	1.bean��������
		���ã�id��class��scope��constructor-arg��property��autowiring mode(�Զ�װ��ģʽ)��
		lazy-initialization mode(������ģʽ)��initialization/destruction method(��ʼ�������ٵķ���)
	2.bean��������(scope)
		singleton:(default)������ָһ��bean������ֻ����һ��
		prototype:ÿ������ÿ��ʹ�ã������µ�ʵ����destroy��ʽ����Ч(���������ͻ�����)
		request:ÿ��http���󴴽�һ��ʵ���ҽ��ڵ�ǰrequestmw��Ч
		session:ͬ�ϣ�ÿ��http���󴴽�����ǰsession����Ч
		global session:����portle��web����Ч��portlet������global session�����������web�У�ͬsession
	3.bean����������
		����-->��ʼ��-->ʹ��-->����
		
		��ʼ�������ַ�ʽ(���ĳһ��bean)
			1.ʵ��InitializingBean�ӿ�,ʵ��afterPropertiesSet����
			2.����init-method
		���٣����ַ�ʽ(���ĳһ��bean)
			1.ʵ��DisposableBean�ӿڣ�����destroy����
			2.����destroy-method����
		���ȫ�֣�
			��ʼ����default-init-method="init"
			����: default-destroy-method="destroy"
		tips:��ʼ�����ٷ���
			��ʼ�����ȼ���InitializingBean�ӿ� > ����init-method > ����default-init-method="init"
			�������ȼ���ͬ��
			����default-init-method="init"�����û��init����
			������init-method��������䷽��
			������ַ�ʽ�������ˣ���ô����default-init-method="init"������Ч
	4.bean���Զ�װ��
		no:�����κβ���
		byName:(set�����Ĳ�������Ҫ����Ҫע���bean��idһ��)�����������Զ�װ�䣬��ѡ�����������������ֲ�����������ȫһ�µ�bean���������������Զ�װ��
		byType:()��������д���һ����ָ������������ͬ��bean����ô����������Զ�װ�䣻������ڶ��������bean����
			ô�׳��쳣����ָ������ʹ��byType��ʽ�����Զ�װ�䣻���û���ҵ���ƥ���bean����ʲô�¶�������
		constructor:��byType��ʽ���ƣ���֮ͬ��������Ӧ���ڹ��������������������û���ҵ��빹������������һ�µ�bean����ô�׳��쳣
	5.Resources&ResourceLoader
		Resource:
			UrlResource:URL��Ӧ����Դ������һ��URL��ַ���ɹ���
			ClassPathResource:��ȡ��·���µ���Դ�ļ�
			FileSystemResource:��ȡ�ļ�ϵͳ�������Դ
			ServletContextResource:ServletContext��װ����Դ�����ڷ���ServletContext�����µ���Դ
			InputStreamResource:�������������װ����Դ
			ByteArrayResource:������ֽ��������Դ
		ResourceLoader:
			��spring�����е�application context��ʵ����ResourceLoader�ӿڣ����е�context�����Ի�ȡResourceʵ��
			classpath:	classpath:com/myapp/config.xml	��classpath(Build Path�µ�Source)�м�����Դ�ļ�
			file:		file:/data/config.xml			���ļ�ϵͳ������Դ�ļ�
			http:		http://myserver/logo.png		��Ϊһ��url����
			(none)		/data/config.xml				������applicationContext(ClassPathXmlApplicationContext)
�ˡ�Aware(spring���ṩ��һЩ��Aware��β�Ľӿڣ�ʵ���������Ľӿڿ��Ի��һЩ��Ӧ����Դ)
	ApplictionContextAware�����ṩbean��������applictionContext������Ҫʵ��ApplictionContextAware�ӿڲ�����ʵ�ֵ��ൽ�����ļ���
	BeanNameAware�ṩbean��name,��Ҫʵ��BeanName�ӿڣ�������ʵ���ൽ�����ļ���
	BeanClassLoaderAware
	BeanFactoryAware
	BootstrapContextAware
	LoadTimeWeaverAware
�š�Classpathɨ�����������
	��Spring3.0��ʼ��Spring JavaConfig��Ŀ�ṩ�˺ܶ����԰���ʹ��java������XML����bean������
		@Configuration��@Bean��@Import��@DependsOn
	@Component��һ��ͨ��ע�⣬�������κ�bean
	@Repository ��@Service��@Controller�Ǹ�������Ե�ע��
	--@Repositoryͨ������ע��DAO�࣬���־ò�
	--@Serviceͨ������ע��Service�࣬�������
	--@Controllerͨ������Controller�࣬�����Ʋ�(MVC)
	
ʮ��Ԫע�⣺ע���ע��
ʮһ������Զ���⼰Bean��ע��
		1.Spring�����Զ�����ಢע��Bean��ApplicationContext��
		2.<context:component-scan>
		  <context:annotation-config>��ǰ�߰������ߣ�ͨ����ʹ��ǰ�ߺ󣬲�����ʹ�ú���
		3.ʹ�ù����������Զ���ɨ��
			Ĭ�Ϸ����£��౻�Զ����ֲ�ע�ᵽbean�������ǣ�ʹ��
			@Component��@Repository��@Service��@Controllerע���ʹ��@Component���Զ���ע��
		4.����ͨ���������޸��������Ϊ
			�磺�������ӵ�xml���ú������е�@Repositoryע�Ⲣ��"Stub"����
			<beans>
				<context:component-scan base-package="org.example">
					<context:include-filter type="regex" expression=".*Stub.*Repository"/>
					<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
				</context:component-scan>
			</beans>
			������ʹ��use-default-filters="false"�����Զ�������ע��
		5.bean������
			ɨ�貢ע��beanʱbean��name����BeanNameGenerator���ɵ�֮ǰ���ĸ�ע�ⶼ����һ��name����������ʾ����bean name
			���Զ���bean�������ԣ�ʵ��BeanNameGenerator�ӿڣ���һ��Ҫ����һ���޲ι�����
				<beans>
					<context:component-scan base-package="org.example" name-generator="org.example.MyNamegenerator"/>
				</beans>
		6.ע��������
			@Scope("singleton")
			�Զ���scope����,ʵ��ScopeMetadataResolver�ӿڣ��޲ι�����
				<beans>
					<context:component-scan base-package="org.example" scope-resolver="org.example.MyScopeResolver"/>
				</beans>
		7.����ʽ(����ֵ��ѡ��no��interfaces��targetClass)
			<beans>
				<context:component-scan base-package="org.example" scoped-proxy="interfaces"/>
			</beans>
ʮһ������ע��
	1.Requiredע��������bean���Ե�setter���������õ�ʱ��ͱظ�ֵ��
	���ע���ʾ����Ӱ���bean���Ա���������ʱ����䣬ͨ����bean�����ͨ���Զ�װ��һ����ȷ������ֵ
	2.@Autowired/Qualifier(�ɴ�������ע���setterע��)
	Ĭ������£�������Ҳ������ʵ�bean���ᵼ��autowiringʧ���׳��쳣������ͨ������ķ�ʽ����
	@Autowired(required=false)
	setXxx(){}
	ÿ����ֻ����һ�������������Ϊrequired=true
	@Autowired���������ڳ�Ա�����ϣ�setter�����ϣ�Ҳ���������ڹ�������
	@Autowired����Spring BeanPostProcessor����ģ����Բ������Լ���BeanPostProcessor��
		BeanFactoryPostProcessor����Ӧ����Щע�⣬��Щ���ͱ���ͨ��xml����spring��@Beanע�����
	@Autowired����ע��List��Map��ʾ������
	 @Autowired
	 private List<BeanInterface> list;(ʵ��BeanInterface���඼����ע��)
	@Qualifier������Ҫע���bean��id�����ڲ���ǰ�棬����Ǹ������ͽ���װ��ʱ�ж�����ͣ�������@Qualifier����С��Χ
	@Inject/@Named�÷�ͬ@Autowired/@Qualifier������Ҫ������ע��@Named��������������ͬ@Component
	3.@Resourceֻ������Setterע��,���������ڳ�Ա�����ϻ���set�����ϣ�����û��set������
	4.@PostConstruct ע���ʼ�� @PreDestroyע������
	5.@Valueע��spring�ı��ʽ������xml��ָ����Ҫע���properties�ļ�,ʹ��@valueע���ʱ��ע�������Ҫ�����ϵͳ�Ĳ�����ͬ
		�磺
			@Value("${name}")��@Value("${jdbc.name}")��ȡ�������п��ܲ�һ��������д��properties��key��ʱ��ע��һ��
	6.@Bean��ʶһ���������úͳ�ʼ��һ����SpringIoc����������¶���ķ�����������xml�����ļ���<bean/>
		Ĭ����@Beanע��ķ�������beanΪ��������ʹ��@BeanĬ���ǵ����ģ�����ʹ��@Scope���޸ģ�
		@Bean(name="store",initMethod="init",destroyMethod="destroy")�������ó�ʼ�������ٷ���
ʮ����spring����properties
	��ʽһ��
		<bean id="propertyConfigurer"
			class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
			<property name="locations">
				<list>
					<value>classpath:viewserverconfig.properties</value>
				</list>
			</property>
		</bean>
	��ʽ����
		<util:properties id="const" location="classpath:jdbc.properties"/>