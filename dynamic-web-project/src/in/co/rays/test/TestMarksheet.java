package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		//testAdd();
		// testUpdate();
		// testDelete();
		// testSearchSimple();
		testFindByPk();
		 // testSearch();
		// testNextPk();

	}

	private static void testNextPk() throws Exception {

		MarksheetModel model = new MarksheetModel();

		int pk = model.nextPk();

		System.out.println("pk = " + pk);

	}

	private static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(6);
		bean.setName("b");

		MarksheetModel model = new MarksheetModel();

		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}
	}

	private static void testFindByPk() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByPk(1);

		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getName());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());

	}

	private static void testSearchSimple() throws Exception {

		MarksheetModel model = new MarksheetModel();
		List list = model.searchSimple();
		Iterator it = list.iterator();

		while (it.hasNext()) {
			MarksheetBean bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}
	}

	private static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.delete(11);

	}

	private static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(4);
		bean.setRollNo(104);
		bean.setName("rishi");
		bean.setPhysics(78);
		bean.setChemistry(67);
		bean.setMaths(78);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		//bean.setId(11);
		bean.setRollNo(111);
		bean.setName("hhh");
		bean.setPhysics(78);
		bean.setChemistry(67);
		bean.setMaths(78);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

}
