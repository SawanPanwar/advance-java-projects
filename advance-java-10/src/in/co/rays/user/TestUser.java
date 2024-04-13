package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUser {

	public static void main(String[] args) throws Exception {

		// testAdd();

		testSearch();

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

	public static void testSearch() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserBean bean = new UserBean();
		// bean.setFirstName("pqr");
		bean.setDob(sdf.parse("13-04-2024"));

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

}
