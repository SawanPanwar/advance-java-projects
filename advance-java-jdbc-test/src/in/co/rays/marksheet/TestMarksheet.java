package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();

		// testReadAll();

		testSearch();

	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(16);
		bean.setRollNo(116);
		bean.setName("tonu");
		bean.setPhysics(10);
		bean.setChemistry(20);
		bean.setMaths(30);

		MarskheetModel model = new MarskheetModel();
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

		MarskheetModel model = new MarskheetModel();
		model.update(bean);
	}

	public static void testDelete() throws Exception {

		MarskheetModel model = new MarskheetModel();
		model.delete(13);

	}

	public static void testFindByPk() throws Exception {

		MarskheetModel model = new MarskheetModel();

		MarksheetBean bean = model.findByPk(15);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		} else {
			System.out.println("id not found");
		}
	}

	public static void testReadAll() throws Exception {

		MarskheetModel model = new MarskheetModel();

		List list = model.readAll();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Object obj = it.next();

			MarksheetBean bean = (MarksheetBean) obj;

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}
	}

	public static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setName("v");

		bean.setRollNo(101);

		MarskheetModel model = new MarskheetModel();

		List list = model.search2(bean, 1, 5);

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
