import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class SUBMAIN_DIALOG extends JDialog implements ActionListener{
	private Vector<USER_DATA> Vec_User_Data;
	
	private int index;
	public boolean Change_Flag;
	
	private JLabel LbName, LbSex, LbStNum, LbPostNum, LbLab, LbPhone, LbEmail, LbJobName, LbPeopleCnt;
	private JTextField TfName, TfPhone_1, TfPhone_2, TfEmail, TfJobName;
	private JComboBox<String> CbSex, CbStNum, CbPostNum, CbLab, CbPhone;
	
	private String Sex[] = {"선택", "남", "여"};
	private String[] StNum = {"선택","90","91","92","93","94","95","96","97","98","99","00","01",
			"02","03","04","05","06","07","08","09","10","11","12","13","14"};
	private String[] StPostNum = {"선택","90","91","92","93","94","95","96","97","98","99","00","01",
			"02","03","04","05","06","07","08","09","10","11","12","13","14","해당없음"};
	private String[] Lab = {"선택","소영성","최창석","한승수","강환일","김인택","백승화","신서용","김덕년","김대원","김성철","동용배",
			"배종우","유철우","염대현","이관수","이종명","황유모","기타"};
	private String[] Phone = {"010","011","016","017","018","019"};
	
	private JLabel LbInfo;
	private JButton BtnSearch, BtnChange, BtnDel;
	private JList<String> LiMemberInfo;
	private JScrollPane ScrPane;
	
	
	public SUBMAIN_DIALOG(JFrame Main_Frame, Vector<USER_DATA> Vec_User_Data){
		super(Main_Frame, "검색 창", true);
		Change_Flag = false;
		this.Vec_User_Data = Vec_User_Data;
		
		Init();
		Start();
		
		BtnSearch.addActionListener(this);
		BtnChange.addActionListener(this);
		BtnDel.addActionListener(this);
		
		this.setLayout(null);
		this.setSize(560, 450);
	}
	
	public void Init(){
		LbName = new JLabel("이 름");
		LbName.setSize(50, 20);
		LbName.setLocation(20, 20);
		
		TfName = new JTextField();
		TfName.setSize(100, 20);
		TfName.setLocation(70, 20);
		
		LbSex = new JLabel("성 별");
		LbSex.setSize(50, 20);
		LbSex.setLocation(20, 50);
		
		CbSex = new JComboBox<String>(Sex);
		CbSex.setSize(80, 20);
		CbSex.setLocation(80, 50);
		
		LbStNum = new JLabel("학부 학번");
		LbStNum.setSize(70, 20);
		LbStNum.setLocation(190, 20);
		
		CbStNum = new JComboBox<String>(StNum);
		CbStNum.setSize(70, 20);
		CbStNum.setLocation(270, 20);
		
		LbPostNum = new JLabel("대학원 학번");
		LbPostNum.setSize(70, 20);
		LbPostNum.setLocation(185, 50);
		
		CbPostNum = new JComboBox<String>(StPostNum);
		CbPostNum.setSize(90, 20);
		CbPostNum.setLocation(270, 50);
		
		LbLab = new JLabel("연구실");
		LbLab.setSize(50, 20);
		LbLab.setLocation(370, 20);
		
		CbLab = new JComboBox<String>(Lab);
		CbLab.setSize(80, 20);
		CbLab.setLocation(430, 20);
		
		LbPhone = new JLabel("핸드폰");
		LbPhone.setSize(50, 20);
		LbPhone.setLocation(20, 80);
		
		CbPhone = new JComboBox<String>(Phone);
		CbPhone.setSize(50, 20);
		CbPhone.setLocation(70, 80);
		
		TfPhone_1 = new JTextField();
		TfPhone_1.setSize(50, 20);
		TfPhone_1.setLocation(130, 80);
		
		TfPhone_2 = new JTextField();
		TfPhone_2.setSize(50, 20);
		TfPhone_2.setLocation(190, 80);
		
		LbEmail = new JLabel("이메일");
		LbEmail.setSize(50, 20);
		LbEmail.setLocation(20, 110);
		
		TfEmail = new JTextField();
		TfEmail.setSize(170, 20);
		TfEmail.setLocation(70, 110);
		
		LbJobName = new JLabel("직장명");
		LbJobName.setSize(50, 20);
		LbJobName.setLocation(320, 95);
		
		TfJobName = new JTextField();
		TfJobName.setSize(100, 20);
		TfJobName.setLocation(370, 95);
		
		BtnSearch = new JButton("검색");
		BtnSearch.setSize(70, 25);
		BtnSearch.setLocation(450, 140);
		
		LbInfo = new JLabel("이름       성별     학부  학번     대학원 학번            핸드폰                           이메일");
		LbInfo.setSize(500, 20);
		LbInfo.setLocation(40, 180);
		
		LiMemberInfo = new JList<String>();
		LiMemberInfo.setSize(500, 160);
		
		ScrPane = new JScrollPane(LiMemberInfo);
		ScrPane.setSize(500, 160);
		ScrPane.setLocation(20, 200);
		
		LbPeopleCnt = new JLabel("검색 데이터 : 0 명");
		LbPeopleCnt.setSize(150, 20);
		LbPeopleCnt.setLocation(25, 370);
		
		BtnChange = new JButton("수정");
		BtnChange.setSize(70, 25);
		BtnChange.setLocation(370, 370);
		
		BtnDel = new JButton("삭제");
		BtnDel.setSize(70, 25);
		BtnDel.setLocation(450, 370);
		
		this.add(LbName);
		this.add(TfName);
		this.add(LbSex);
		this.add(CbSex);
		this.add(LbStNum);
		this.add(CbStNum);
		this.add(LbPostNum);
		this.add(CbPostNum);
		this.add(LbLab);
		this.add(CbLab);
		this.add(LbPhone);
		this.add(CbPhone);
		this.add(TfPhone_1);
		this.add(TfPhone_2);
		this.add(LbEmail);
		this.add(TfEmail);
		this.add(LbJobName);
		this.add(TfJobName);
		this.add(BtnSearch);
		this.add(LbInfo);
		this.add(ScrPane);
		this.add(LbPeopleCnt);
		this.add(BtnChange);
		this.add(BtnDel);
	}
	
	public void Start(){
		this.setResizable(false);
	}
	
	public boolean EMPTY_FLAG(){
		boolean Empty_Flag = false;
		
		if(TfName.getText().equals("") && ((String)CbSex.getSelectedItem()).equals("선택") && 
				((String)CbStNum.getSelectedItem()).equals("선택") && ((String)CbPostNum.getSelectedItem()).equals("선택") &&
				((String)CbLab.getSelectedItem()).equals("선택") && TfPhone_1.getText().equals("") && 
				TfEmail.getText().equals("") && TfJobName.getText().equals("")){
			Empty_Flag = true;
		}
		
		return Empty_Flag;
	}
	
	public String SetQuery(){
		Vector<String> Vec_Query = new Vector<>();
		
		String q;
		if((q = TfName.getText()).equals("")){
			
		}
		else{
			String qq = "이름 = '" + q + "'";
			Vec_Query.add(qq);
		}
		
		if((q = (String)CbSex.getSelectedItem()).equals("선택")){
			
		}
		else{
			String qq = "성별 = '" + q + "'";
			Vec_Query.add(qq);
		}
		
		if((q = (String)CbStNum.getSelectedItem()).equals("선택")){
			
		}
		else{
			String qq = "학부 학번 = '" + q + "'";
			Vec_Query.add(qq);
		}
		
		if((q = (String)CbPostNum.getSelectedItem()).equals("선택")){
			
		}
		else{
			String qq = "대학원 학번 =  '" + q + "'";
			Vec_Query.add(qq);
		}
		
		if((q = (String)CbLab.getSelectedItem()).equals("선택")){
			
		}
		else{
			String qq = "연구실 = '" + q + "'";
			Vec_Query.add(qq);
		}
		
		if(TfPhone_1.getText().equals("") || TfPhone_2.getText().equals("")){
			
		}
		else{
			q = (String)CbPhone.getSelectedItem() + "-" +
					TfPhone_1.getText() + "-" + TfPhone_2.getText();
			String qq = "핸드폰  = '" + q + "'";
			Vec_Query.add(qq);
		}
		
		if((q = TfEmail.getText()).equals("")){
			
		}
		else{
			String qq = "이메일 = '" + q + "'";
			Vec_Query.add(qq);
		}
		
		if((q = TfJobName.getText()).equals("")){
			
		}
		else{
			String qq = "직장명 = '" + q + "'";
			Vec_Query.add(qq);
		}
		
		String Query = " ";
		if(Vec_Query.size() == 0){}
		else{
			Query += Vec_Query.elementAt(0);
			for(int i=1;i<Vec_Query.size();i++){
				Query += " and " + Vec_Query.elementAt(i);
			}
		}
		
		return Query;
	}
	
	public void SearchDB(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//System.out.println("드라이버 연결 성공");
			
			String url = "jdbc:odbc:USERDATABASE";
			try {
				Connection conn = DriverManager.getConnection(url);
				//System.out.println("mdb파일 연결 성공");
				
				Statement stmt = null;
				ResultSet rs = null;
				
				Vector<String> Vec_Info = new Vector<>();
				String query = "select * from User_Data";
				
				if(EMPTY_FLAG()){
					
				}
				else{
					query = query + " where";
					query = query + SetQuery();
					//System.out.println(query);
				}
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				
				
				while(rs.next()){
					//System.out.println(rs.getString(1));
					String info = String.format("%6s %8s %15s %20s %30s %25s", 
							rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getString(8), rs.getString(9));
					Vec_Info.add(info);
				}
				
				LiMemberInfo.setListData(Vec_Info);
				LbPeopleCnt.setText("검색 데이터 : " + Vec_Info.size() + " 명");
				
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
	
	public void FindDB(){
		String SelectedList = LiMemberInfo.getSelectedValue();
		if(SelectedList == null){
			//System.out.println("호놀룰루");
			index = -1;
		}
		else{
			int i = 0;
			Iterator<USER_DATA> It = Vec_User_Data.iterator();
			while(It.hasNext()){
				USER_DATA User_Data = It.next();
				if(SelectedList.contains(User_Data.GetName()) && SelectedList.contains(User_Data.GetSex()) &&
						SelectedList.contains(User_Data.GetPhone()) && SelectedList.contains(User_Data.GetEmail()) &&
						SelectedList.contains(User_Data.GetStNum())){
					index = i;
				}
				i++;
			}
		}
		System.out.println(index);
	}
	
	public void DeleteDB(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//System.out.println("드라이버 연결 성공");
			
			String url = "jdbc:odbc:USERDATABASE";
			try {
				Connection conn = DriverManager.getConnection(url);
				//System.out.println("mdb파일 연결 성공");
				
				USER_DATA User_Data = Vec_User_Data.elementAt(index);
				String Name = User_Data.GetName();
				String Email = User_Data.GetEmail();
				String Phone = User_Data.GetPhone();
				
				String query = "delete from User_Data where 이름  = ? and 이메일 = ? and 핸드폰 = ?";
				
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, Name);
				pstmt.setString(2, Email);
				pstmt.setString(3, Phone);
				pstmt.executeUpdate();
				
				Vec_User_Data.remove(index);
				
				pstmt.close();
				
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String a = e.getActionCommand();
		
		if(a == "검색"){
			SearchDB();
		}
		else if(a == "수정"){
			FindDB();
			if(index == -1){
				JOptionPane.showMessageDialog(null, "먼저 데이터를 선택 후 버튼을 눌러주세요.", "수정 불가능", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				Change_Flag = true;
				this.setVisible(false);
			}
		}
		else if(a == "삭제"){
			FindDB();
			if(index == -1){
				JOptionPane.showMessageDialog(null, "먼저 데이터를 선택 후 버튼을 눌러주세요.", "삭제 불가능", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				USER_DATA User_Data = Vec_User_Data.elementAt(index);
				int result = JOptionPane.showConfirmDialog(null, User_Data.GetName() + 
						"님의 데이터를 삭제 하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION){
					DeleteDB();
					SearchDB();
					JOptionPane.showMessageDialog(null, "삭제 완료!!!", 
							"완료", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	USER_DATA GetUserData(){
		USER_DATA User_Data = Vec_User_Data.elementAt(index);
		
		return User_Data;
	}
}
