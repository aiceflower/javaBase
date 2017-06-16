package learn.frame.spring.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//@Order(1)
@Component
public class BeanImplTwo implements BeanInterface,Ordered{

	@Override
	public int getOrder() {
		return 1;
	}

}
