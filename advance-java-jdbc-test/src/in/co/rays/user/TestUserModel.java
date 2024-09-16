package in.co.rays.user;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testAdd();

		// testUpdate();

		// testDelete();

		// testFindByPk();

		// testSearch();
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

		UserBean bean = model.findByPk(3);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("id not found");
		}

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(15);

	}

	private static void testUpdate() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(14);

		bean.setFirstName("kkk");
		bean.setLastName("ppp");

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();

		// bean.setId(15);
		bean.setFirstName("aaa");
		bean.setLastName("bbb");
		bean.setLoginId("aa@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setAddress("indore");

		try {
			UserModel model = new UserModel();

			model.add(bean);

		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		}
	}

}
