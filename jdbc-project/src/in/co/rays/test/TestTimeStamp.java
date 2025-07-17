package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {
		
		BaseBean bean = new BaseBean();
		
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));

	}
}