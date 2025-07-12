package in.co.rays.marksheet;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		// testAdd();

		// testUpdate();

		// testDelete();

		// testFindByPk();

		// testFindByRollNo();

		// testSearch();
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
		model.findByPk(2);
	}

	public static void testFindByRollNo() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.findByRollNo(102);
	}

	public static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();
//		bean.setRollNo(108);
//		bean.setName("karan");
		bean.setPhysics(78);
		bean.setChemistry(88);
//		bean.setMaths(99);

		MarksheetModel model = new MarksheetModel();
		model.search(bean, 7, 10);
	}
}