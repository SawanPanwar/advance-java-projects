package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.MarsksheetBean;
import in.co.rays.util.JDBCDataSource;

public class MarksheetModel {

	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");

		ResultSet rs = ps.executeQuery();

		conn.close();

		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;
	}

	public void add(MarsksheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollNo());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());

		int i = ps.executeUpdate();

		conn.close();

		System.out.println("Data Inserted " + i);

	}

	public void update(MarsksheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement(
				"update marksheet set name = ?, roll_no = ?, physics = ?, chemistry = ?, maths = ? where id = ?");

		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRollNo());
		ps.setInt(3, bean.getPhysics());
		ps.setInt(4, bean.getChemistry());
		ps.setInt(5, bean.getMaths());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();

		conn.close();

		System.out.println("Data Updated " + i);

	}

	public void delete(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		conn.close();

		System.out.println("Data Deleted " + i);

	}

	public MarsksheetBean findById(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		MarsksheetBean bean = null;

		while (rs.next()) {
			bean = new MarsksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}

		conn.close();

		return bean;

	}

	public List search(MarsksheetBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}

			if (bean.getRollNo() > 0) {
				sql.append(" and roll_no = " + bean.getRollNo());
			}
		}

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			sql.append(" limit " + pageNo + ", " + pageSize);

		}

		System.out.println("SQL = " + sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarsksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);
		}
		conn.close();

		return list;

	}

}
