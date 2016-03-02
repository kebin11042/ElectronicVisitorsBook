import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class MAINFRAME extends JFrame implements ActionListener{
	public static Vector<USER_DATA> Vec_User_Data;
	
	private MEMBERVIEW_DIALOG MemberView_Dialog;
	private SUBMAIN_DIALOG SubMain_Dialog;
	
	private Container Con;
	private JPanel Pan_1, Pan_2, Pan_3, Pan_4, Pan_5;
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	private JLabel Lbimage_1, Lbimage_2, LbTitle, LbTitle_1;
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	private JLabel LbName, LbSex, LbStNum, LbGraduationDate, LbLab, LbLab_1, LbPostStNum, LbPostGraduationDate;
	private JTextField TfName;
	private ButtonGroup BgSex;
	private JRadioButton RbSex_M, RbSex_W;
	private JComboBox<String> CbStNum, CbGraduationDate, CbLab, CbPostStNum, CbPostGraduationDate;
	private String[] StNum = {"선택","87","88","89","90","91","92","93","94","95","96","97","98","99","00","01",
			"02","03","04","05","06","07","08","09","10","11","12","13","14"};
	private String[] StNum_post = {"선택","87","88","89","90","91","92","93","94","95","96","97","98","99","00","01",
			"02","03","04","05","06","07","08","09","10","11","12","13","14","해당없음"};
	private String[] GraduationDat, GraduationDat_post;
	private String[] Lab = {"선택","소영성","최창석","한승수","강환일","김인택","백승화","신서용","김덕년","김대원","김성철","동용배",
			"배종우","유철우","염대현","이관수","이종명","황유모","기타"};
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	private JLabel LbPhone, LbPhone_1, LbPhone_2, LbEmail, LbEmail_1, LbHomeAdress, LbHomePost, LbHomePost_1, LbJobAdress,
					LbJobPost, LbJobPost_1;
	private JTextField TfPhone_1, TfPhone_2, TfEmail_1, TfEmail_2, TfHomeAdress, TfHomePost_1, TfHomePost_2,
					TfJobAdress, TfJobPost_1, TfJobPost_2;
	private JComboBox<String> CbPhone;
	private String[] Phone = {"010","011","016","017","018","019"};
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	private JLabel LbJobName, LbDepartment, LbPosition, LbWorking;
	private JComboBox<String> CbWorking;
	private JTextField TfJobName, TfDepartment, TfPosition;
	private String[] Working = {"선택","통신 HW","통신 SW","정보처리 HW","정보처리 SW","정보보안","웹/앱/데이터베이스","영업/사무/관리직","기타"};
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	private JLabel LbCafe, LbMobile;
	private JRadioButton RbCafe_Y, RbCafe_N, RbMobile_Y, RbMobile_N;
	private ButtonGroup BgCafe, BgMobile;
	private JButton BtnNew, BtnSave, BtnChange, BtnMemberView, BtnDelMember;
	
	public MAINFRAME(Vector<USER_DATA> Vec_User_Data){
		this.Vec_User_Data = Vec_User_Data;
		this.setTitle("총동문회 전자 방명록");
		
		Start();
		Init();
		Init_1();
		Init_2();
		Init_3();
		Init_4();
		Init_5();
		
		BtnNew.addActionListener(this);
		BtnSave.addActionListener(this);
		BtnDelMember.addActionListener(this);
		BtnChange.addActionListener(this);
		BtnMemberView.addActionListener(this);
		
		this.setSize(850, 700);
		this.setVisible(true);
	}
	
	public void Start(){
		
		MemberView_Dialog = new MEMBERVIEW_DIALOG(this, Vec_User_Data);
		SubMain_Dialog = new SUBMAIN_DIALOG(this, Vec_User_Data);
		
		int Cnt = 0;
		for(int i=1990;i<2019;i++){
			Cnt++;
		}
		GraduationDat = new String[Cnt + 1];
		GraduationDat_post = new String[Cnt + 2];
		Cnt = 0;
		GraduationDat[0] = "선택";
		for(int i=1990;i<2019;i++){
			GraduationDat[Cnt + 1] = "" + i;
			Cnt++;
		}
		GraduationDat_post = GraduationDat;
		GraduationDat_post[GraduationDat_post.length - 1] = "해당없음";
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public void Init(){
		this.setLayout(null);
		
		Con = this.getContentPane();
	}
	
	public void Init_1(){
		Pan_1 = new JPanel();
		Pan_1.setSize(850, 100);
		Pan_1.setLocation(0, 0);
		Pan_1.setBackground(new Color(255,255,255));
		Pan_1.setLayout(null);
		
		ImageIcon img = new ImageIcon("images/명지.gif");
		Lbimage_1 = new JLabel(img);
		Lbimage_1.setSize(80, 80);
		Lbimage_1.setLocation(10, 10);
		
		Lbimage_2 = new JLabel(img);
		Lbimage_2.setSize(80, 80);
		Lbimage_2.setLocation(750, 10);
		
		LbTitle = new JLabel("명지대학교 정보통신공학과");
		LbTitle.setSize(350, 30);
		LbTitle.setLocation(270, 5);
		LbTitle.setFont(new Font("고딕체", Font.BOLD, 25));
		
		LbTitle_1 = new JLabel("총 동문회 전자 방명록");
		LbTitle_1.setSize(350, 20);
		LbTitle_1.setLocation(310, 55);
		LbTitle_1.setFont(new Font("고딕체", Font.BOLD, 20));
		
		Pan_1.add(Lbimage_1);
		Pan_1.add(Lbimage_2);
		Pan_1.add(LbTitle);
		Pan_1.add(LbTitle_1);
		
		Con.add(Pan_1);
	}
	
	public void Init_2(){
		Pan_2 = new JPanel();
		//Pan_2.setBackground(new Color(255,100,200));
		Pan_2.setLayout(null);
		Pan_2.setBorder(new TitledBorder(" "));
		Pan_2.setSize(850, 130);
		Pan_2.setLocation(0, 100);
		
		LbName = new JLabel("이 름 ");
		LbName.setSize(60, 20);
		LbName.setLocation(20, 20);
		
		TfName = new JTextField();
		TfName.setSize(100, 20);
		TfName.setLocation(65, 20);
		
		LbSex = new JLabel("성 별");
		LbSex.setSize(100, 20);
		LbSex.setLocation(20, 55);
		
		BgSex = new ButtonGroup();
		RbSex_M = new JRadioButton("남자");
		RbSex_M.setSize(55, 20);
		RbSex_M.setLocation(60, 55);
		
		RbSex_W = new JRadioButton("여자");
		RbSex_W.setSize(55, 20);
		RbSex_W.setLocation(120, 55);
		BgSex.add(RbSex_M);
		BgSex.add(RbSex_W);
		
		LbStNum = new JLabel("학부 학번");
		LbStNum.setSize(80, 20);
		LbStNum.setLocation(235, 20);
		
		CbStNum = new JComboBox<String> (StNum);
		CbStNum.setSize(80, 20);
		CbStNum.setLocation(330, 20);
		
		LbGraduationDate = new JLabel("학부 졸업 년도");
		LbGraduationDate.setSize(100, 20);
		LbGraduationDate.setLocation(220, 55);
		
		CbGraduationDate = new JComboBox<String> (GraduationDat);
		CbGraduationDate.setSize(100, 20);
		CbGraduationDate.setLocation(320, 55);
		
		LbLab = new JLabel("출신 연구실");
		LbLab.setSize(80, 20);
		LbLab.setLocation(230, 90);
		
		CbLab = new JComboBox<String> (Lab);
		CbLab.setSize(100, 20);
		CbLab.setLocation(320, 90);
		
		LbLab_1 = new JLabel("교수님");
		LbLab_1.setSize(60, 20);
		LbLab_1.setLocation(430, 90);
		
		LbPostStNum = new JLabel("대학원 학번");
		LbPostStNum.setSize(100, 20);
		LbPostStNum.setLocation(500, 20);
		
		CbPostStNum = new JComboBox<String> (StNum_post);
		CbPostStNum.setSize(80, 20);
		CbPostStNum.setLocation(610, 20);
		
		LbPostGraduationDate = new JLabel("대학원 졸업 년도");
		LbPostGraduationDate.setSize(150, 20);
		LbPostGraduationDate.setLocation(490, 55);
		
		CbPostGraduationDate = new JComboBox<String> (GraduationDat_post);
		CbPostGraduationDate.setSize(100, 20);
		CbPostGraduationDate.setLocation(600, 55);
		
		Pan_2.add(LbName);
		Pan_2.add(TfName);
		Pan_2.add(LbSex);
		Pan_2.add(RbSex_M);
		Pan_2.add(RbSex_W);
		Pan_2.add(LbStNum);
		Pan_2.add(CbStNum);
		Pan_2.add(LbGraduationDate);
		Pan_2.add(CbGraduationDate);
		Pan_2.add(LbLab);
		Pan_2.add(CbLab);
		Pan_2.add(LbLab_1);
		Pan_2.add(LbPostStNum);
		Pan_2.add(CbPostStNum);
		Pan_2.add(LbPostGraduationDate);
		Pan_2.add(CbPostGraduationDate);
		
		Con.add(Pan_2);
	}
	
	public void Init_3(){
		Pan_3 = new JPanel();
		//Pan_3.setBackground(new Color(255,255,180));
		Pan_3.setLayout(null);
		Pan_3.setBorder(new TitledBorder(" "));
		Pan_3.setSize(850, 170);
		Pan_3.setLocation(0, 230);
		
		LbPhone = new JLabel("핸드폰");
		LbPhone.setSize(80, 20);
		LbPhone.setLocation(20, 20);
		
		CbPhone = new JComboBox<String>(Phone);
		CbPhone.setSize(60, 20);
		CbPhone.setLocation(70, 20);
		
		LbPhone_1 = new JLabel("-");
		LbPhone_1.setSize(10, 20);
		LbPhone_1.setLocation(135, 20);
		
		TfPhone_1 = new JTextField();
		TfPhone_1.setSize(50, 20);
		TfPhone_1.setLocation(145, 21);
		
		LbPhone_2 = new JLabel("-");
		LbPhone_2.setSize(10, 20);
		LbPhone_2.setLocation(200, 20);
		
		TfPhone_2 = new JTextField();
		TfPhone_2.setSize(50, 20);
		TfPhone_2.setLocation(210, 21);
		
		LbEmail = new JLabel("이메일");
		LbEmail.setSize(50, 20);
		LbEmail.setLocation(20, 55);
		
		TfEmail_1 = new JTextField();
		TfEmail_1.setSize(110, 20);
		TfEmail_1.setLocation(75, 56);
		
		LbEmail_1 = new JLabel("@");
		LbEmail_1.setSize(15, 20);
		LbEmail_1.setLocation(185, 55);
		
		TfEmail_2 = new JTextField();
		TfEmail_2.setSize(100, 20);
		TfEmail_2.setLocation(200, 56);
		
		LbHomeAdress = new JLabel("집주소");
		LbHomeAdress.setSize(60, 20);
		LbHomeAdress.setLocation(360, 20);
		
		TfHomeAdress = new JTextField();
		TfHomeAdress.setSize(400, 20);
		TfHomeAdress.setLocation(420, 21);
		
		LbHomePost = new JLabel("우편번호");
		LbHomePost.setSize(60, 20);
		LbHomePost.setLocation(360, 50);
		
		TfHomePost_1 = new JTextField();
		TfHomePost_1.setSize(40,20);
		TfHomePost_1.setLocation(420, 51);
		
		LbHomePost_1 = new JLabel("-");
		LbHomePost_1.setSize(10, 20);
		LbHomePost_1.setLocation(462, 51);
		
		TfHomePost_2 = new JTextField();
		TfHomePost_2.setSize(40,20);
		TfHomePost_2.setLocation(470, 51);
		
		LbJobAdress = new JLabel("직장주소");
		LbJobAdress.setSize(60, 20);
		LbJobAdress.setLocation(360, 85);
		
		TfJobAdress = new JTextField();
		TfJobAdress.setSize(400, 20);
		TfJobAdress.setLocation(420, 86);
		
		LbJobPost = new JLabel("우편번호");
		LbJobPost.setSize(60, 20);
		LbJobPost.setLocation(360, 115);
		
		TfJobPost_1 = new JTextField();
		TfJobPost_1.setSize(40,20);
		TfJobPost_1.setLocation(420, 116);
		
		LbJobPost_1 = new JLabel("-");
		LbJobPost_1.setSize(10, 20);
		LbJobPost_1.setLocation(462, 115);
		
		TfJobPost_2 = new JTextField();
		TfJobPost_2.setSize(40,20);
		TfJobPost_2.setLocation(470, 116);
		
		Pan_3.add(LbPhone);
		Pan_3.add(CbPhone);
		Pan_3.add(LbPhone_1);
		Pan_3.add(TfPhone_1);
		Pan_3.add(LbPhone_2);
		Pan_3.add(TfPhone_2);
		Pan_3.add(LbEmail);
		Pan_3.add(TfEmail_1);
		Pan_3.add(LbEmail_1);
		Pan_3.add(TfEmail_2);
		Pan_3.add(LbHomeAdress);
		Pan_3.add(TfHomeAdress);
		Pan_3.add(LbHomePost);
		Pan_3.add(TfHomePost_1);
		Pan_3.add(LbHomePost_1);
		Pan_3.add(TfHomePost_2);
		Pan_3.add(LbJobAdress);
		Pan_3.add(TfJobAdress);
		Pan_3.add(LbJobPost);
		Pan_3.add(TfJobPost_1);
		Pan_3.add(LbJobPost_1);
		Pan_3.add(TfJobPost_2);
		
		Con.add(Pan_3);
	}

	public void Init_4(){
		Pan_4 = new JPanel();
		Pan_4.setLayout(null);
		//Pan_4.setBackground(new Color(120,255,200));
		Pan_4.setBorder(new TitledBorder(" "));
		Pan_4.setSize(850, 150);
		Pan_4.setLocation(0, 400);
		
		LbJobName = new JLabel("직장명");
		LbJobName.setSize(60, 20);
		LbJobName.setLocation(25, 15);
		
		TfJobName = new JTextField();
		TfJobName.setSize(100, 20);
		TfJobName.setLocation(85, 16);
		
		LbDepartment = new JLabel("근무부서");
		LbDepartment.setSize(60, 20);
		LbDepartment.setLocation(20, 45);
		
		TfDepartment = new JTextField();
		TfDepartment.setSize(100, 20);
		TfDepartment.setLocation(85, 45);
		
		LbPosition = new JLabel("직  급");
		LbPosition.setSize(60, 20);
		LbPosition.setLocation(30, 75);
		
		TfPosition = new JTextField();
		TfPosition.setSize(100, 20);
		TfPosition.setLocation(85, 75);
		
		LbWorking = new JLabel("현재 하고있는 일");
		LbWorking.setSize(110, 20);
		LbWorking.setLocation(10, 105);
		
		CbWorking = new JComboBox<String>(Working);
		CbWorking.setSize(200, 20);
		CbWorking.setLocation(125, 105);
		
		Pan_4.add(LbJobName);
		Pan_4.add(TfJobName);
		Pan_4.add(LbDepartment);
		Pan_4.add(TfDepartment);
		Pan_4.add(LbPosition);
		Pan_4.add(TfPosition);
		Pan_4.add(LbWorking);
		Pan_4.add(CbWorking);
		
		Con.add(Pan_4);
	}

	public void Init_5(){
		Pan_5 = new JPanel();
		Pan_5.setLayout(null);
		Pan_5.setSize(850, 150);
		Pan_5.setLocation(0, 550);
		//Pan_5.setBackground(new Color(255,255,255));
		
		LbCafe = new JLabel("총동문회 네이버 카페 가입 여부");
		LbCafe.setSize(190, 20);
		LbCafe.setLocation(30, 10);
		
		BgCafe = new ButtonGroup();
		
		RbCafe_Y = new JRadioButton("예");
		RbCafe_Y.setSize(38, 20);
		RbCafe_Y.setLocation(230, 10);
		
		RbCafe_N = new JRadioButton("아니오");
		RbCafe_N.setSize(70, 20);
		RbCafe_N.setLocation(265, 10);
		
		BgCafe.add(RbCafe_Y);
		BgCafe.add(RbCafe_N);
		
		LbMobile = new JLabel("총동문회 카페 모바일 앱 설치 여부");
		LbMobile.setSize(200, 20);
		LbMobile.setLocation(30, 35);
		
		BgMobile = new ButtonGroup();
		
		RbMobile_Y = new JRadioButton("예");
		RbMobile_Y.setSize(38, 20);
		RbMobile_Y.setLocation(240, 35);
		
		RbMobile_N = new JRadioButton("아니오");
		RbMobile_N.setSize(70, 20);
		RbMobile_N.setLocation(275, 35);
		
		BgMobile.add(RbMobile_Y);
		BgMobile.add(RbMobile_N);
		
		BtnNew = new JButton("신규");
		BtnNew.setSize(60, 25);
		BtnNew.setLocation(230, 90);
		
		BtnSave = new JButton("저장");
		BtnSave.setSize(60, 25);
		BtnSave.setLocation(310, 90);
		
		BtnChange = new JButton("검색");
		BtnChange.setSize(60, 25);
		BtnChange.setLocation(390, 90);
		
		BtnDelMember = new JButton("삭제");
		BtnDelMember.setSize(60, 25);
		BtnDelMember.setLocation(440, 90);
		
		BtnMemberView = new JButton("등록 명단 보기");
		BtnMemberView.setSize(120, 25);
		BtnMemberView.setLocation(700, 90);
		
		Pan_5.add(LbCafe);
		Pan_5.add(RbCafe_Y);
		Pan_5.add(RbCafe_N);
		Pan_5.add(LbMobile);
		Pan_5.add(RbMobile_Y);
		Pan_5.add(RbMobile_N);
		Pan_5.add(BtnNew);
		Pan_5.add(BtnSave);
		Pan_5.add(BtnChange);
		//Pan_5.add(BtnDelMember);
		Pan_5.add(BtnMemberView);
		
		Con.add(Pan_5);
	}

	
	public boolean EMPTY_FLAG(){	//비어있는 정보 검출 메소드
		boolean Empty_Flag = 
				TfName.getText().equals("") || CbStNum.getSelectedItem().equals("선택") || 
				CbGraduationDate.getSelectedItem().equals("선택") || CbLab.getSelectedItem().equals("선택") ||
				CbPostStNum.getSelectedItem().equals("선택") || CbPostGraduationDate.getSelectedItem().equals("선택") ||
				TfPhone_1.getText().equals("") || TfPhone_2.getText().equals("") || TfEmail_1.getText().equals("") ||
				TfEmail_2.getText().equals("") || TfHomeAdress.getText().equals("") ||  
				TfJobAdress.getText().equals("") || TfJobName.getText().equals("") || 
				TfDepartment.getText().equals("") || TfPosition.getText().equals("") || CbWorking.getSelectedItem().equals("선택") ||
				(BgSex.getSelection() == null) || (BgCafe.getSelection() == null) || (BgMobile.getSelection() == null);
		return Empty_Flag;
	}
	
	public boolean OVERLAP_FLAG(String Name, String Phone){
		boolean OverLap_Falg = false;
		
		USER_DATA User_Data;
		Iterator<USER_DATA> It = Vec_User_Data.iterator();
		while(It.hasNext()){
			User_Data = It.next();
			if(Name.equals(User_Data.GetName())){
				if(Phone.equals(User_Data.GetPhone())){
					OverLap_Falg = true;
				}
			}
		}
		
		return OverLap_Falg;
	}
	
	public boolean DEL_FLAG_1(String Name){
		boolean Del_Flag_1 = false;
		
		USER_DATA User_Data;
		Iterator<USER_DATA> It = Vec_User_Data.iterator();
		while(It.hasNext()){
			User_Data = It.next();
			if(Name.equals(User_Data.GetName())){
				Del_Flag_1 = true;
			}
		}
		
		return Del_Flag_1;
	}
	
	public boolean DEL_FLAG_2(String Email){
		boolean Del_Flag_2 = false;
		
		USER_DATA User_Data;
		Iterator<USER_DATA> It = Vec_User_Data.iterator();
		while(It.hasNext()){
			User_Data = It.next();
			if(Email.equals(User_Data.GetEmail())){
				Del_Flag_2 = true;
			}
		}
		
		return Del_Flag_2;
	}
	
	public void DelMember(String Name, String Email){
		USER_DATA User_Data;
		
		Iterator<USER_DATA> It = Vec_User_Data.iterator();
		int index = 0;
		while(It.hasNext()){
			User_Data = It.next();
			if(Name.equals(User_Data.GetName()) && Email.equals(User_Data.GetEmail())){
				break;
			}
			index++;
		}
		
		Vec_User_Data.remove(index);
		
		try {
			ExportData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ClearInfo(){
		TfName.setText("");
		TfPhone_1.setText("");
		TfPhone_2.setText("");
		TfEmail_1.setText("");
		TfEmail_2.setText("");
		TfHomeAdress.setText("");
		TfHomePost_1.setText("");
		TfHomePost_2.setText("");
		TfJobAdress.setText("");
		TfJobPost_1.setText("");
		TfJobPost_2.setText("");
		TfJobName.setText("");
		TfDepartment.setText("");
		TfPosition.setText("");
		CbWorking.setSelectedIndex(0);
		
		CbStNum.setSelectedIndex(0);
		CbGraduationDate.setSelectedIndex(0);
		CbLab.setSelectedIndex(0);
		CbPostStNum.setSelectedIndex(0);
		CbPostGraduationDate.setSelectedIndex(0);
		
		BgSex.clearSelection();
		BgCafe.clearSelection();
		BgMobile.clearSelection();
	}
	
	public void ExportData() throws IOException{
		try {
			BufferedWriter BF = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("data/data.txt"),"MS949"));
			
			BF.write("이름/성별/학부 학번/학부 졸업년도/대학원 학번/대학원 졸업년도/출신 연구실/핸드폰/이메일/집 주소/집 우편번호/직장 주소/직장 우편번호/" +
					"직장명/근무 부서/직급/현재 하고 있는 일/총 동문회 네이버 카페 가입여부/총 동문회 카페 모바일 앱 설치 여부");
			BF.newLine();
			
			Iterator<USER_DATA> It = Vec_User_Data.iterator();
			while(It.hasNext()){
				USER_DATA UD = It.next();
				
				BF.write(UD.GetName() + "/");
				BF.write(UD.GetSex() + "/");
				BF.write(UD.GetStNum() + "/");
				BF.write(UD.GetStGraDate() + "/");
				BF.write(UD.GetPostStNum() + "/");
				BF.write(UD.GetPostGraDate() + "/");
				BF.write(UD.GetLab() + "/");
				BF.write(UD.GetPhone() + "/");
				BF.write(UD.GetEmail() + "/");
				BF.write(UD.GetHomeAdress() + "/");
				BF.write(UD.GetHomePost() + "/");
				BF.write(UD.GetJobAdress() + "/");
				BF.write(UD.GetJobPost() + "/");
				BF.write(UD.GetJobName() + "/");
				BF.write(UD.GetDepartment() + "/");
				BF.write(UD.GetPosition() + "/");
				BF.write(UD.GetWorking() + "/");
				BF.write(UD.GetCafe() + "/");
				BF.write(UD.GetMobile());
				
				BF.newLine();
			}
			
			BF.close();
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//UTF-8로 읽으면 한글 깨짐
	}
	
	public void ReNewDB(){
		Vec_User_Data.removeAllElements();
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//System.out.println("드라이버 연결 성공");
			
			String url = "jdbc:odbc:USERDATABASE";
			try {
				Connection conn = DriverManager.getConnection(url);
				//System.out.println("mdb파일 연결 성공");
				
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
	
	public void ExportDB(USER_DATA User_Data){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//System.out.println("드라이버 연결 성공");
			
			String url = "jdbc:odbc:USERDATABASE";
			try {
				Connection conn = DriverManager.getConnection(url);
				//System.out.println("mdb파일 연결 성공");
				
				Statement stmt = null;
				PreparedStatement pstmt = null;

				String query = 
						"insert into User_Data values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = conn.createStatement();
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, User_Data.GetName());
				pstmt.setString(2, User_Data.GetSex());
				pstmt.setString(3, User_Data.GetStNum());
				pstmt.setString(4, User_Data.GetStGraDate());
				pstmt.setString(5, User_Data.GetPostStNum());
				pstmt.setString(6, User_Data.GetPostGraDate());
				pstmt.setString(7, User_Data.GetLab());
				pstmt.setString(8, User_Data.GetPhone());
				pstmt.setString(9, User_Data.GetEmail());
				pstmt.setString(10, User_Data.GetHomeAdress());
				pstmt.setString(11, User_Data.GetHomePost());
				pstmt.setString(12, User_Data.GetJobAdress());
				pstmt.setString(13, User_Data.GetJobPost());
				pstmt.setString(14, User_Data.GetJobName());
				pstmt.setString(15, User_Data.GetDepartment());
				pstmt.setString(16, User_Data.GetPosition());
				pstmt.setString(17, User_Data.GetWorking());
				pstmt.setString(18, User_Data.GetCafe());
				pstmt.setString(19, User_Data.GetMobile());
				
				//System.out.println("입력 성공");
				pstmt.executeUpdate();
				

				pstmt.close();
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
	
	public void ChangeDB(USER_DATA User_Data){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("드라이버 연결 성공");
			
			String url = "jdbc:odbc:USERDATABASE";
			try {
				Connection conn = DriverManager.getConnection(url);
				System.out.println("mdb파일 연결 성공");
				
				Statement stmt = null;
				PreparedStatement pstmt = null;

				String query = 
						"update User_Data set 이름 = ?, 성별 = ?, 학부학번 = ?, 학부졸업년도 = ?, 대학원학번 = ?," +
						" 대학원졸업년도 = ?, 연구실 = ?, 이메일 = ?, 집주소 = ?, 집우편번호 = ?, 직장주소 = ?," +
						" 직장우편번호 = ?, 직장명 = ?, 근무부서 = ?, 직급 = ?, 현재하고있는일 = ?, 총동문회네이버카페가입여부 = ?," +
						" 총동문회카페모바일앱설치여부 = ? where 핸드폰 = ?";
				stmt = conn.createStatement();
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, User_Data.GetName());
				pstmt.setString(2, User_Data.GetSex());
				pstmt.setString(3, User_Data.GetStNum());
				pstmt.setString(4, User_Data.GetStGraDate());
				pstmt.setString(5, User_Data.GetPostStNum());
				pstmt.setString(6, User_Data.GetPostGraDate());
				pstmt.setString(7, User_Data.GetLab());
				pstmt.setString(8, User_Data.GetEmail());
				pstmt.setString(9, User_Data.GetHomeAdress());
				pstmt.setString(10, User_Data.GetHomePost());
				pstmt.setString(11, User_Data.GetJobAdress());
				pstmt.setString(12, User_Data.GetJobPost());
				pstmt.setString(13, User_Data.GetJobName());
				pstmt.setString(14, User_Data.GetDepartment());
				pstmt.setString(15, User_Data.GetPosition());
				pstmt.setString(16, User_Data.GetWorking());
				pstmt.setString(17, User_Data.GetCafe());
				pstmt.setString(18, User_Data.GetMobile());
				pstmt.setString(19, User_Data.GetPhone());
				//pstmt.setInt(20, (User_Data.GetID()+1));
				
				//System.out.println("입력 성공");
				pstmt.executeUpdate();
				

				pstmt.close();
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
	
	public USER_DATA SetUserDataInfo(){
		String Name = TfName.getText();
		String StNum = (String)CbStNum.getSelectedItem();
		String StGraDate = (String)CbGraduationDate.getSelectedItem();
		String Lab = (String)CbLab.getSelectedItem();
		String PostStNum = (String)CbPostStNum.getSelectedItem();
		String PostGraDate = (String)CbPostGraduationDate.getSelectedItem();
		
		String Phone = (String)CbPhone.getSelectedItem() + "-" +
				TfPhone_1.getText() + "-" + TfPhone_2.getText();
		String Email = TfEmail_1.getText() + "@" + TfEmail_2.getText();
		String HomeAdress = TfHomeAdress.getText();
		String HomePost = TfHomePost_1.getText() + " - " + TfHomePost_2.getText();
		String JobAdress = TfJobAdress.getText();
		String JobPost = TfJobPost_1.getText() + " - " + TfJobPost_2.getText();
		
		String JobName = TfJobName.getText();
		String Department = TfDepartment.getText();
		String Position = TfPosition.getText();
		String Working = (String)CbWorking.getSelectedItem();
		
		String Sex = "";
		if(RbSex_M.isSelected()){
			Sex = "남";
		}
		else if(RbSex_W.isSelected()){
			Sex = "여";
		}
		
		String Cafe = "";
		if(RbCafe_Y.isSelected()){
			Cafe = "예";
		}
		else if(RbCafe_N.isSelected()){
			Cafe = "아니오";
		}
		
		String Mobile = "";
		if(RbMobile_Y.isSelected()){
			Mobile = "예";
		}
		else if(RbMobile_N.isSelected()){
			Mobile = "아니오";
		}
		
		USER_DATA UD = new USER_DATA(Name, Sex, StNum, StGraDate, Lab, PostStNum, PostGraDate, 
				Phone, Email, HomeAdress, HomePost, JobAdress, JobPost, JobName, Department, 
				Position, Working, Cafe, Mobile, Vec_User_Data.size());
		
		return UD;
	}

	public void ChangeMemberInfo(){
	}
	
	public void SetFrame(USER_DATA User_Data){
		TfName.setText(User_Data.GetName());
		if(User_Data.GetSex().equals("남")){
			RbSex_M.setSelected(true);
		}
		else{
			RbSex_W.setSelected(true);
		}
		CbStNum.setSelectedItem(User_Data.GetStNum());
		CbGraduationDate.setSelectedItem(User_Data.GetStGraDate());
		CbLab.setSelectedItem(User_Data.GetLab());
		CbPostStNum.setSelectedItem(User_Data.GetPostStNum());
		CbPostGraduationDate.setSelectedItem(User_Data.GetPostGraDate());
		
		String Phone = User_Data.GetPhone();
		String Phone_1 = Phone.substring(0, Phone.indexOf('-'));
		Phone = Phone.substring(Phone.indexOf('-') + 1);
		String Phone_2 = Phone.substring(0, Phone.indexOf('-'));
		Phone = Phone.substring(Phone.indexOf('-') + 1);
		String Phone_3 = Phone;
		CbPhone.setSelectedItem(Phone_1);
		TfPhone_1.setText(Phone_2);
		TfPhone_2.setText(Phone_3);
		
		String Email = User_Data.GetEmail();
		String Email_1 = Email.substring(0, Email.indexOf("@"));
		Email = Email.substring(Email.indexOf("@") + 1);
		TfEmail_1.setText(Email_1);
		TfEmail_2.setText(Email);
		
		TfHomeAdress.setText(User_Data.GetHomeAdress());
		TfJobAdress.setText(User_Data.GetJobAdress());
		
		String HomePost = User_Data.GetHomePost();
		String HomePost_1 = HomePost.substring(0, HomePost.indexOf("-") - 1);
		HomePost = HomePost.substring(HomePost.indexOf("-") + 2);
		TfHomePost_1.setText(HomePost_1);
		TfHomePost_2.setText(HomePost);
		
		String JobPost = User_Data.GetJobPost();
		String JobPost_1 = JobPost.substring(0, JobPost.indexOf("-") - 1);
		JobPost = JobPost.substring(JobPost.indexOf("-") + 2);
		TfJobPost_1.setText(JobPost_1);
		TfJobPost_2.setText(JobPost);
		
		TfJobName.setText(User_Data.GetJobName());
		TfDepartment.setText(User_Data.GetDepartment());
		TfPosition.setText(User_Data.GetPosition());
		CbWorking.setSelectedItem(User_Data.GetWorking());
		
		if(User_Data.GetCafe().equals("예")){
			RbCafe_Y.setSelected(true);
		}
		else{
			RbCafe_N.setSelected(true);
		}
		if(User_Data.GetMobile().equals("예")){
			RbMobile_Y.setSelected(true);
		}
		else{
			RbMobile_N.setSelected(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String a = e.getActionCommand();
		
		if(a == "신규"){
			int result = JOptionPane.showConfirmDialog(null, "초기화 하시겠습니까?", "신규", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				ClearInfo();
			}
		}
		else if(a == "저장"){
			if(EMPTY_FLAG()){
				JOptionPane.showMessageDialog(null, "입력하지 않은 정보가 있습니다.", "저장 불가능", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				if(SubMain_Dialog.Change_Flag){
					int result = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "수정", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION){
						USER_DATA User_Data = SetUserDataInfo();
						ChangeDB(User_Data);
						
						JOptionPane.showMessageDialog(null, "수정 완료!!", 
								"완료", JOptionPane.INFORMATION_MESSAGE);
						
						SubMain_Dialog.Change_Flag = false;
						CbPhone.setEnabled(true);
						TfPhone_1.setEnabled(true);
						TfPhone_2.setEnabled(true);
						ClearInfo();
					}
				}
				else{
					int result = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "저장", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION){
						String Name = TfName.getText();
						String Phone = (String)CbPhone.getSelectedItem() + "-" +
								TfPhone_1.getText() + "-" + TfPhone_2.getText();
						
						if(OVERLAP_FLAG(Name, Phone)){
							JOptionPane.showMessageDialog(null, "이미 등록된 데이터가 있습니다.", "저장 불가능", 
									JOptionPane.INFORMATION_MESSAGE);
						}
						else{
							USER_DATA User_Data = SetUserDataInfo();
							ExportDB(User_Data);
							Vec_User_Data.add(User_Data);
							MemberView_Dialog.Update_Vector(Vec_User_Data);
							
							JOptionPane.showMessageDialog(null, "데이터가 저장 되었습니다.", "저장 성공", 
									JOptionPane.INFORMATION_MESSAGE);
							
							ClearInfo();
						}
					}
				}
			}
		}
		else if(a == "삭제"){
			String Name = JOptionPane.showInputDialog("삭제하실 이름을 입력하세요.");
			if(DEL_FLAG_1(Name)){
				String Email = JOptionPane.showInputDialog("삭제하실 " + Name + "님의 이메일을 입력해 주세요.");
				if(DEL_FLAG_2(Email)){
					DelMember(Name, Email);
					MemberView_Dialog.Update_Vector(Vec_User_Data);
					JOptionPane.showMessageDialog(null, Name + "님 데이터 삭제 완료!!", "삭제", 
							JOptionPane.PLAIN_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "입력하신 이메일이 일치하지 않습니다.", "삭제 불가능", 
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "입력하신 이름이 데이터에 존재하지 않습니다.", "삭제 불가능", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(a == "검색"){
			SubMain_Dialog = new SUBMAIN_DIALOG(this, Vec_User_Data);
			SubMain_Dialog.setVisible(true);
			ReNewDB();
			MemberView_Dialog.Update_Vector(Vec_User_Data);
			
			if(SubMain_Dialog.Change_Flag){
				USER_DATA User_Data = SubMain_Dialog.GetUserData();
				SetFrame(User_Data);
				CbPhone.setEnabled(false);
				TfPhone_1.setEnabled(false);
				TfPhone_2.setEnabled(false);
			}
		}
		else if(a == "등록 명단 보기"){
			MemberView_Dialog.setVisible(true);
		}
	}

}
