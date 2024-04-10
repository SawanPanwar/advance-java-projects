package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		testSearch();
		// testFindByPk();
	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(12);
		bean.setRollNo(112);
		bean.setName("kanak");
		bean.setPhysics(90);
		bean.setChemistry(34);
		bean.setMaths(67);

		MarksheetModel model = new MarksheetModel();

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(12);
		bean.setRollNo(112);
		bean.setName("rahul");
		bean.setPhysics(90);
		bean.setChemistry(34);
		bean.setMaths(67);

		MarksheetModel model = new MarksheetModel();

		model.update(bean);

	}

	public static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.delete(11);

	}

	public static void testSearch() throws Exception {

		MarksheetModel model = new MarksheetModel();

		List list = model.search();

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

	public static void testFindByPk() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByPk(15);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		} else {
			System.out.println("no record found..!!");
		}

	}

}
