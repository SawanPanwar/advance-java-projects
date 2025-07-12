package in.co.rays.returns;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		// testAdd();

		// testUpdate();

		// testDelete();

		// testFindByPk();

		// testFindByRollNo();

		testSearch();
	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setRollNo(108);
		bean.setName("karan");
		bean.setPhysics(78);
		bean.setChemistry(88);
		bean.setMaths(99);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(13);
		bean.setRollNo(113);
		bean.setName("khush");
		bean.setPhysics(10);
		bean.setChemistry(20);
		bean.setMaths(30);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);
	}

	public static void testDelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(13);
	}

	public static void testFindByPk() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByPk(100);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		} else {
			System.out.println("Id does not exist...!!");
		}

	}

	public static void testFindByRollNo() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByRollNo(102);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		} else {
			System.out.println("Roll No does not exist...!!");
		}

	}

	public static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();
//		bean.setRollNo(108);
//		bean.setName("karan");
		bean.setPhysics(78);
		bean.setChemistry(88);
//		bean.setMaths(99);

		MarksheetModel model = new MarksheetModel();

		List list = model.search(null, 0, 0);

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
}