import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;


public class ElectronicVisitorsBook {
	public static Vector<USER_DATA> Vec_User_Data = new Vector<USER_DATA>();
	
	public static void main(String[] Args){
		//ImportData();
		ImportDB();
		
		MAINFRAME MF = new MAINFRAME(Vec_User_Data);
	}
	
	public static void ImportData() throws IOException{

		BufferedReader BF = new BufferedReader(new InputStreamReader(
				new FileInputStream("data/data.txt"),"MS949"));	
		
		String s = BF.readLine();
		//System.out.println(s);
		String Info;
		while((Info = BF.readLine()) != null){
			String Name = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String Sex = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String StNum = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String StGraDate = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String PostStNum = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String PostGraDate = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String Lab = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String Phone = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String Email = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String HomeAdress = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String HomePost = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String JobAdress = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String JobPost = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String JobName = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String Department = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String Position = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String Working = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String Cafe = Info.substring(0, Info.indexOf('/'));
			Info = Info.substring(Info.indexOf('/') + 1);
			
			String Mobile = Info;
			
			//USER_DATA User_Data = new USER_DATA(Name, Sex, StNum, StGraDate, Lab, 
			//		PostStNum, PostGraDate, Phone, Email, HomeAdress, HomePost, JobAdress, 
			//		JobPost, JobName, Department, Position, Working, Cafe, Mobile);
			
			//Vec_User_Data.add(User_Data);
		}
		
		BF.close();
	}

	public static void ImportDB(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//System.out.println("드라이버 연결 성공");
			
			JOptionPane.showMessageDialog(null, "드라이버 연결 성공", 
					"완료", JOptionPane.INFORMATION_MESSAGE);
			
			String url = "jdbc:odbc:USERDATABASE";
			try {
				Connection conn = DriverManager.getConnection(url);
				//System.out.println("mdb파일 연결 성공");
				
				JOptionPane.showMessageDialog(null, "DB 연결 성공!!", 
						"완료", JOptionPane.INFORMATION_MESSAGE);
				
				Statement stmt = null;
				ResultSet rs = null;
				String query = "select * from User_Data";
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				
				while(rs.next()){
					String Name = rs.getString(1);
					String Sex = rs.getString(2);
					String StNum = rs.getString(3);
					String StGraDate = rs.getString(4);
					String PostStNum = rs.getString(5);
					String PostGraDate = rs.getString(6);
					String Lab = rs.getString(7);
					String Phone = rs.getString(8);
					String Email = rs.getString(9);
					String HomeAdress = rs.getString(10);
					String HomePost = rs.getString(11);
					String JobAdress = rs.getString(12);
					String JobPost = rs.getString(13);
					String JobName = rs.getString(14);
					String Department = rs.getString(15);
					String Position = rs.getString(16);
					String Working = rs.getString(17);
					String Cafe = rs.getString(18);
					String Mobile = rs.getString(19);
					
					
					//System.out.println(ID);
					
					USER_DATA User_Data = new USER_DATA(Name, Sex, StNum, StGraDate, Lab, 
							PostStNum, PostGraDate, Phone, Email, HomeAdress, HomePost, JobAdress, 
							JobPost, JobName, Department, Position, Working, Cafe, Mobile, 2);
					
					Vec_User_Data.add(User_Data);
				}
				
				rs.close();
				stmt.close();
				
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
