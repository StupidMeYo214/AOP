import java.lang.reflect.Proxy;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsx.aop.LogInterceptor;
import com.bjsx.dao.UserDAO;
import com.bjsx.dao.impl.UserDAOImpl1;
import com.bjsx.service.UserService;
import com.bjsx.spring.User;

public class ClassTest {


	
/*	@Test
	public void test2() throws Exception {
		//ApplicationContext factory = new ClassPathXmlApplicationContext("springConfigAuto-Detecting-Component.xml");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("springConfigAuto-Detecting-Component.xml");
		UserService service1= (UserService)factory.getBean("service");
		UserService service2= (UserService)factory.getBean("service");
		//System.out.println(service.getUserDAO());
		System.out.println(service1 == service2);
		//service.add(new User());
		//factory.destroy();
		
	}*/
	
	@Test
	public void testProxy() throws Exception{
		UserDAO userDAO = new UserDAOImpl1();
		LogInterceptor logInterceptor = new LogInterceptor();
		logInterceptor.setTarget(userDAO);
		UserDAO userDAOProxy = (UserDAO)Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), userDAO.getClass().getInterfaces(), logInterceptor);
		userDAOProxy.delete(new User());
		userDAOProxy.save(new User());
	}

}
