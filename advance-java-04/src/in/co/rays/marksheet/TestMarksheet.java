package in.co.rays.marksheet;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testSearch();
		testFindByPk();

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

	private static void testSearch() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.search();

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
		bean.setId(11);
		bean.setRollNo(111);
		bean.setName("hhh");
		bean.setPhysics(78);
		bean.setChemistry(67);
		bean.setMaths(78);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

}
