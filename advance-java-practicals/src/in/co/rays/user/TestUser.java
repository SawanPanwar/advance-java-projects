package in.co.rays.user;

import java.util.Date;

public class TestUser {

	public static void main(String[] args) throws Exception {

		testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testSearch();

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("abc");
		bean.setLastName("xyz");
		bean.setLoginId("abc@gmail.com");
		bean.setPassword("123");
		bean.setDob(new Date());
		bean.setAddress("indore");

		UserModel model = new UserModel();

		model.add(bean);

	}

}
