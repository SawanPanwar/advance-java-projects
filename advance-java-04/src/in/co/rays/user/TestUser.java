package in.co.rays.user;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUser {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();

	}

	private static void testSearch() throws Exception {

		UserBean bean = new UserBean();
		bean.setFirstName("a");

		UserModel model = new UserModel();

		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		}

	}

	private static void testFindByPk() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(2);

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getAddress());

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(2);

	}

	private static void testUpdate() throws Exception {

		UserBean bean = new UserBean();

		bean.setId(2);
		bean.setFirstName("pqr");
		bean.setLastName("abc");
		bean.setLoginId("pqr@gmail.com");
		bean.setPassword("123");
		bean.setDob(new Date());
		bean.setAddress("indore");

		UserModel model = new UserModel();

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();

		bean.setFirstName("xyz");
		bean.setLastName("abc");
		bean.setLoginId("xyz@gmail.com");
		bean.setPassword("123");
		bean.setDob(new Date());
		bean.setAddress("indore");

		UserModel model = new UserModel();

		model.add(bean);

	}

}
