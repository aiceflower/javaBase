package learn.frame.spring.annotation.property;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@Configuration
//@ImportResource("classpath:jdbc.properties")
public class TestProperties {
	
//	@Value("${jdbc.username}")
	private String username;
	
//	@Value("${jdbc.password}")
	private String password;
	
//	@Value("${jdbc.driver}")
	@SuppressWarnings("unused")
	private String driver;
	
//	@Value("${jdbc.url}")
	private String url;
	
//	@Bean
	public DataSource dataSource(){
		return new DriverManagerDataSource(url,username,password);
	}
}
