
import static org.junit.Assert.*;

import org.junit.Test;

import com.bjsx.service.UserService;
import com.bjsx.spring.User;

public class UserServiceTest {

	@Test
	public void testAdd() {
		UserService service = new UserService();
		User user = new User();
		service.add(user);
	}
	
	@Test
	public void testAdd2() {
		UserService service = new UserService();
		User user = new User();
		service.add(user);
	}

}
