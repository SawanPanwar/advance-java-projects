package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testSearch();

	}

	private static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setName("r");
		// bean.setRollNo(102);

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

		MarksheetBean bean = model.findByPk(20);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
		} else {
			System.out.println("ID not exist..!!!");
		}
	}

	private static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.delete(10);

	}

	private static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(3);
		bean.setRollNo(103);
		bean.setName("uuu");
		bean.setPhysics(87);
		bean.setChemistry(78);
		bean.setMaths(67);

		MarksheetModel model = new MarksheetModel();

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(15);
		bean.setRollNo(115);
		bean.setName("qwe");
		bean.setPhysics(87);
		bean.setChemistry(78);
		bean.setMaths(67);

		MarksheetModel model = new MarksheetModel();

		model.add(bean);

	}

}
