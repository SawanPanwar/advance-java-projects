package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.model.UserModel;

public class TestUser {

	public static void main(String[] args) throws Exception {

		testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testSearch();
		// testAuth();

	}

	private static void testAuth() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.authenticate("rohit@gmail.com", "123");

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		} else {
			System.out.println("login id & password is invalid...!!");
		}

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		UserBean existBean = model.findByPk(3);

		if (existBean != null) {
			model.delete(existBean.getId());
		} else {
			System.out.println("Id not found...!!!");
		}

	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(2);

		bean.setFirstName("rohit");
		bean.setLoginId("rohit@gmail.com");
		bean.setDob(new Date());

		model.update(bean);

	}

	private static void testSearch() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserBean bean = new UserBean();
		// bean.setFirstName("a");
		// bean.setDob(sdf.parse("12/01/2024"));

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

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		UserBean bean = new UserBean();
		bean.setFirstName("abc");
		bean.setLastName("xyz");
		bean.setLoginId("xyz@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("11/11/2022"));
		bean.setAddress("indore");

		UserModel model = new UserModel();

		try {
			model.add(bean);
		} catch (DuplicateRecordException e) {
			System.out.println("exception: " + e.getMessage());
		}

	}
}
