package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarsksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindById();
		testSearch();

	}

	private static void testSearch() throws Exception {

		MarsksheetBean bean = new MarsksheetBean();

		bean.setName("shu");
		// bean.setRollNo(101);

		MarksheetModel model = new MarksheetModel();

		List list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarsksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}

	private static void testFindById() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarsksheetBean bean = model.findById(14);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		} else {

			System.out.println("ID does not exist...!!!");

		}

	}

	private static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.delete(14);

	}

	private static void testUpdate() throws Exception {

		MarsksheetBean bean = new MarsksheetBean();
		bean.setId(14);
		bean.setName("gabbar");
		bean.setRollNo(114);
		bean.setPhysics(23);
		bean.setChemistry(45);
		bean.setMaths(10);

		MarksheetModel model = new MarksheetModel();

		model.update(bean);
	}

	private static void testAdd() throws Exception {

		MarsksheetBean bean = new MarsksheetBean();

		bean.setName("gabbar");
		bean.setRollNo(114);
		bean.setPhysics(23);
		bean.setChemistry(45);
		bean.setMaths(1);

		MarksheetModel model = new MarksheetModel();

		model.add(bean);

	}

}
