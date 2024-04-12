package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUser {

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserBean bean = new UserBean();
		// bean.setId(2);
		bean.setFirstName("pqr");
		bean.setLastName("xyz");
		bean.setLoginId("pqr@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("11-01-2024"));
		bean.setAddress("indore");

		UserModel model = new UserModel();

		model.add(bean);

	}

}
