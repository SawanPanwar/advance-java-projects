package in.co.rays.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private static JDBCDataSource datasource;

	private ComboPooledDataSource cpds = null;

	private JDBCDataSource() {
	}

	public static JDBCDataSource getInstance() {

		if (datasource == null) {
			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();
			try {
				datasource.cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			datasource.cpds.setJdbcUrl("jdbc:mysql://localhost:3307/advance_practicals");
			datasource.cpds.setUser("root");
			datasource.cpds.setPassword("root");
			datasource.cpds.setInitialPoolSize(5);
			datasource.cpds.setAcquireIncrement(5);
			datasource.cpds.setMaxPoolSize(30);
		}
		return datasource;
	}

	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	}

	public static void trnRollback(Connection connection) throws Exception {
		if (connection != null) {

			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new Exception(ex.toString());
			}
		}
	}

}
