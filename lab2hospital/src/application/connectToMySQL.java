package application;
import java.sql.*;

public class connectToMySQL {
	private static connectToMySQL instance = null;
	private Connection conn;
	private Statement stm;
	
	private connectToMySQL() throws ClassNotFoundException {
		//register jdbc driver
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	
	public static connectToMySQL getInstance() {
		if(instance == null)
			try {
				instance = new connectToMySQL();
			} catch (ClassNotFoundException e) {
				System.out.println("register jdbc driver failed");
				e.printStackTrace();
			}
		return instance;
	}
	
	/*
	 * connect to database
	 * @param username
	 * @param password
	 */
	public void connectDataBase(String username, String password) throws SQLException
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_lab2?useUnicode=true&characterEncoding=UTF-8"
				+ "&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT",username, password);
		stm = conn.createStatement();
	}
	
	
	/*
	 * close the connection to database
	 */
	public void deConnect() throws SQLException {
		conn.close();
	}
	
	
	/*
	 * 获取表的所有列信息
	 */
	public ResultSet getAllTableData(String tablename) {
		try {
			System.out.println("get table data...");
			return stm.executeQuery("select * from" + tablename);
		} catch (SQLException e) {
			System.out.println("get table data failed");
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getPatientInfo(String patientId) {
		try {
			return stm.executeQuery("select * from patient where pid = " + patientId);
		} catch (SQLException e) {
			System.out.println("get patient data failed");
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getDoctorInfo(String doctorId) {
		try {
			return stm.executeQuery("select * from doctor where docid = " + doctorId);
		} catch (SQLException e) {
			System.out.println("get doctor data failed");
			e.printStackTrace();
			return null;
		}
	}
	
	public void updatePatientLoginTime(String patientId, String time) {
		try {
			stm.executeUpdate("update patient set last_login_datetime = \"" + time + "\" where pid = " + patientId);
		} catch (SQLException e) {
			System.out.println("update patient login time failed");
			e.printStackTrace();
			return;
		}
	}
	
	public void updateDoctorLoginTime(String doctorId, String time) {
		try {
			stm.executeUpdate("update doctor set last_login_datetime = \"" + time + "\" where docid = " + doctorId);
		} catch (SQLException e) {
			System.out.println("update doctor login time failed");
			e.printStackTrace();
			return;
		}
	}
}
