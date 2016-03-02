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
	private String[] StNum = {"����","87","88","89","90","91","92","93","94","95","96","97","98","99","00","01",
			"02","03","04","05","06","07","08","09","10","11","12","13","14"};
	private String[] StNum_post = {"����","87","88","89","90","91","92","93","94","95","96","97","98","99","00","01",
			"02","03","04","05","06","07","08","09","10","11","12","13","14","�ش����"};
	private String[] GraduationDat, GraduationDat_post;
	private String[] Lab = {"����","�ҿ���","��â��","�ѽ¼�","��ȯ��","������","���ȭ","�ż���","�����","����","�輺ö","�����",
			"������","��ö��","������","�̰���","������","Ȳ����","��Ÿ"};
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
	private String[] Working = {"����","��� HW","��� SW","����ó�� HW","����ó�� SW","��������","��/��/�����ͺ��̽�","����/�繫/������","��Ÿ"};
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	private JLabel LbCafe, LbMobile;
	private JRadioButton RbCafe_Y, RbCafe_N, RbMobile_Y, RbMobile_N;
	private ButtonGroup BgCafe, BgMobile;
	private JButton BtnNew, BtnSave, BtnChange, BtnMemberView, BtnDelMember;
	
	public MAINFRAME(Vector<USER_DATA> Vec_User_Data){
		this.Vec_User_Data = Vec_User_Data;
		this.setTitle("�ѵ���ȸ ���� ����");
		
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
		GraduationDat[0] = "����";
		for(int i=1990;i<2019;i++){
			GraduationDat[Cnt + 1] = "" + i;
			Cnt++;
		}
		GraduationDat_post = GraduationDat;
		GraduationDat_post[GraduationDat_post.length - 1] = "�ش����";
		
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
		
		ImageIcon img = new ImageIcon("images/����.gif");
		Lbimage_1 = new JLabel(img);
		Lbimage_1.setSize(80, 80);
		Lbimage_1.setLocation(10, 10);
		
		Lbimage_2 = new JLabel(img);
		Lbimage_2.setSize(80, 80);
		Lbimage_2.setLocation(750, 10);
		
		LbTitle = new JLabel("�������б� ������Ű��а�");
		LbTitle.setSize(350, 30);
		LbTitle.setLocation(270, 5);
		LbTitle.setFont(new Font("���ü", Font.BOLD, 25));
		
		LbTitle_1 = new JLabel("�� ����ȸ ���� ����");
		LbTitle_1.setSize(350, 20);
		LbTitle_1.setLocation(310, 55);
		LbTitle_1.setFont(new Font("���ü", Font.BOLD, 20));
		
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
		
		LbName = new JLabel("�� �� ");
		LbName.setSize(60, 20);
		LbName.setLocation(20, 20);
		
		TfName = new JTextField();
		TfName.setSize(100, 20);
		TfName.setLocation(65, 20);
		
		LbSex = new JLabel("�� ��");
		LbSex.setSize(100, 20);
		LbSex.setLocation(20, 55);
		
		BgSex = new ButtonGroup();
		RbSex_M = new JRadioButton("����");
		RbSex_M.setSize(55, 20);
		RbSex_M.setLocation(60, 55);
		
		RbSex_W = new JRadioButton("����");
		RbSex_W.setSize(55, 20);
		RbSex_W.setLocation(120, 55);
		BgSex.add(RbSex_M);
		BgSex.add(RbSex_W);
		
		LbStNum = new JLabel("�к� �й�");
		LbStNum.setSize(80, 20);
		LbStNum.setLocation(235, 20);
		
		CbStNum = new JComboBox<String> (StNum);
		CbStNum.setSize(80, 20);
		CbStNum.setLocation(330, 20);
		
		LbGraduationDate = new JLabel("�к� ���� �⵵");
		LbGraduationDate.setSize(100, 20);
		LbGraduationDate.setLocation(220, 55);
		
		CbGraduationDate = new JComboBox<String> (GraduationDat);
		CbGraduationDate.setSize(100, 20);
		CbGraduationDate.setLocation(320, 55);
		
		LbLab = new JLabel("��� ������");
		LbLab.setSize(80, 20);
		LbLab.setLocation(230, 90);
		
		CbLab = new JComboBox<String> (Lab);
		CbLab.setSize(100, 20);
		CbLab.setLocation(320, 90);
		
		LbLab_1 = new JLabel("������");
		LbLab_1.setSize(60, 20);
		LbLab_1.setLocation(430, 90);
		
		LbPostStNum = new JLabel("���п� �й�");
		LbPostStNum.setSize(100, 20);
		LbPostStNum.setLocation(500, 20);
		
		CbPostStNum = new JComboBox<String> (StNum_post);
		CbPostStNum.setSize(80, 20);
		CbPostStNum.setLocation(610, 20);
		
		LbPostGraduationDate = new JLabel("���п� ���� �⵵");
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
		
		LbPhone = new JLabel("�ڵ���");
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
		
		LbEmail = new JLabel("�̸���");
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
		
		LbHomeAdress = new JLabel("���ּ�");
		LbHomeAdress.setSize(60, 20);
		LbHomeAdress.setLocation(360, 20);
		
		TfHomeAdress = new JTextField();
		TfHomeAdress.setSize(400, 20);
		TfHomeAdress.setLocation(420, 21);
		
		LbHomePost = new JLabel("�����ȣ");
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
		
		LbJobAdress = new JLabel("�����ּ�");
		LbJobAdress.setSize(60, 20);
		LbJobAdress.setLocation(360, 85);
		
		TfJobAdress = new JTextField();
		TfJobAdress.setSize(400, 20);
		TfJobAdress.setLocation(420, 86);
		
		LbJobPost = new JLabel("�����ȣ");
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
		
		LbJobName = new JLabel("�����");
		LbJobName.setSize(60, 20);
		LbJobName.setLocation(25, 15);
		
		TfJobName = new JTextField();
		TfJobName.setSize(100, 20);
		TfJobName.setLocation(85, 16);
		
		LbDepartment = new JLabel("�ٹ��μ�");
		LbDepartment.setSize(60, 20);
		LbDepartment.setLocation(20, 45);
		
		TfDepartment = new JTextField();
		TfDepartment.setSize(100, 20);
		TfDepartment.setLocation(85, 45);
		
		LbPosition = new JLabel("��  ��");
		LbPosition.setSize(60, 20);
		LbPosition.setLocation(30, 75);
		
		TfPosition = new JTextField();
		TfPosition.setSize(100, 20);
		TfPosition.setLocation(85, 75);
		
		LbWorking = new JLabel("���� �ϰ��ִ� ��");
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
		
		LbCafe = new JLabel("�ѵ���ȸ ���̹� ī�� ���� ����");
		LbCafe.setSize(190, 20);
		LbCafe.setLocation(30, 10);
		
		BgCafe = new ButtonGroup();
		
		RbCafe_Y = new JRadioButton("��");
		RbCafe_Y.setSize(38, 20);
		RbCafe_Y.setLocation(230, 10);
		
		RbCafe_N = new JRadioButton("�ƴϿ�");
		RbCafe_N.setSize(70, 20);
		RbCafe_N.setLocation(265, 10);
		
		BgCafe.add(RbCafe_Y);
		BgCafe.add(RbCafe_N);
		
		LbMobile = new JLabel("�ѵ���ȸ ī�� ����� �� ��ġ ����");
		LbMobile.setSize(200, 20);
		LbMobile.setLocation(30, 35);
		
		BgMobile = new ButtonGroup();
		
		RbMobile_Y = new JRadioButton("��");
		RbMobile_Y.setSize(38, 20);
		RbMobile_Y.setLocation(240, 35);
		
		RbMobile_N = new JRadioButton("�ƴϿ�");
		RbMobile_N.setSize(70, 20);
		RbMobile_N.setLocation(275, 35);
		
		BgMobile.add(RbMobile_Y);
		BgMobile.add(RbMobile_N);
		
		BtnNew = new JButton("�ű�");
		BtnNew.setSize(60, 25);
		BtnNew.setLocation(230, 90);
		
		BtnSave = new JButton("����");
		BtnSave.setSize(60, 25);
		BtnSave.setLocation(310, 90);
		
		BtnChange = new JButton("�˻�");
		BtnChange.setSize(60, 25);
		BtnChange.setLocation(390, 90);
		
		BtnDelMember = new JButton("����");
		BtnDelMember.setSize(60, 25);
		BtnDelMember.setLocation(440, 90);
		
		BtnMemberView = new JButton("��� ��� ����");
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

	
	public boolean EMPTY_FLAG(){	//����ִ� ���� ���� �޼ҵ�
		boolean Empty_Flag = 
				TfName.getText().equals("") || CbStNum.getSelectedItem().equals("����") || 
				CbGraduationDate.getSelectedItem().equals("����") || CbLab.getSelectedItem().equals("����") ||
				CbPostStNum.getSelectedItem().equals("����") || CbPostGraduationDate.getSelectedItem().equals("����") ||
				TfPhone_1.getText().equals("") || TfPhone_2.getText().equals("") || TfEmail_1.getText().equals("") ||
				TfEmail_2.getText().equals("") || TfHomeAdress.getText().equals("") ||  
				TfJobAdress.getText().equals("") || TfJobName.getText().equals("") || 
				TfDepartment.getText().equals("") || TfPosition.getText().equals("") || CbWorking.getSelectedItem().equals("����") ||
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
			
			BF.write("�̸�/����/�к� �й�/�к� �����⵵/���п� �й�/���п� �����⵵/��� ������/�ڵ���/�̸���/�� �ּ�/�� �����ȣ/���� �ּ�/���� �����ȣ/" +
					"�����/�ٹ� �μ�/����/���� �ϰ� �ִ� ��/�� ����ȸ ���̹� ī�� ���Կ���/�� ����ȸ ī�� ����� �� ��ġ ����");
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
		}	//UTF-8�� ������ �ѱ� ����
	}
	
	public void ReNewDB(){
		Vec_User_Data.removeAllElements();
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//System.out.println("����̹� ���� ����");
			
			String url = "jdbc:odbc:USERDATABASE";
			try {
				Connection conn = DriverManager.getConnection(url);
				//System.out.println("mdb���� ���� ����");
				
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
			//System.out.println("����̹� ���� ����");
			
			String url = "jdbc:odbc:USERDATABASE";
			try {
				Connection conn = DriverManager.getConnection(url);
				//System.out.println("mdb���� ���� ����");
				
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
				
				//System.out.println("�Է� ����");
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
			System.out.println("����̹� ���� ����");
			
			String url = "jdbc:odbc:USERDATABASE";
			try {
				Connection conn = DriverManager.getConnection(url);
				System.out.println("mdb���� ���� ����");
				
				Statement stmt = null;
				PreparedStatement pstmt = null;

				String query = 
						"update User_Data set �̸� = ?, ���� = ?, �к��й� = ?, �к������⵵ = ?, ���п��й� = ?," +
						" ���п������⵵ = ?, ������ = ?, �̸��� = ?, ���ּ� = ?, �������ȣ = ?, �����ּ� = ?," +
						" ��������ȣ = ?, ����� = ?, �ٹ��μ� = ?, ���� = ?, �����ϰ��ִ��� = ?, �ѵ���ȸ���̹�ī�䰡�Կ��� = ?," +
						" �ѵ���ȸī�����Ͼۼ�ġ���� = ? where �ڵ��� = ?";
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
				
				//System.out.println("�Է� ����");
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
			Sex = "��";
		}
		else if(RbSex_W.isSelected()){
			Sex = "��";
		}
		
		String Cafe = "";
		if(RbCafe_Y.isSelected()){
			Cafe = "��";
		}
		else if(RbCafe_N.isSelected()){
			Cafe = "�ƴϿ�";
		}
		
		String Mobile = "";
		if(RbMobile_Y.isSelected()){
			Mobile = "��";
		}
		else if(RbMobile_N.isSelected()){
			Mobile = "�ƴϿ�";
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
		if(User_Data.GetSex().equals("��")){
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
		
		if(User_Data.GetCafe().equals("��")){
			RbCafe_Y.setSelected(true);
		}
		else{
			RbCafe_N.setSelected(true);
		}
		if(User_Data.GetMobile().equals("��")){
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
		
		if(a == "�ű�"){
			int result = JOptionPane.showConfirmDialog(null, "�ʱ�ȭ �Ͻðڽ��ϱ�?", "�ű�", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				ClearInfo();
			}
		}
		else if(a == "����"){
			if(EMPTY_FLAG()){
				JOptionPane.showMessageDialog(null, "�Է����� ���� ������ �ֽ��ϴ�.", "���� �Ұ���", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				if(SubMain_Dialog.Change_Flag){
					int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION){
						USER_DATA User_Data = SetUserDataInfo();
						ChangeDB(User_Data);
						
						JOptionPane.showMessageDialog(null, "���� �Ϸ�!!", 
								"�Ϸ�", JOptionPane.INFORMATION_MESSAGE);
						
						SubMain_Dialog.Change_Flag = false;
						CbPhone.setEnabled(true);
						TfPhone_1.setEnabled(true);
						TfPhone_2.setEnabled(true);
						ClearInfo();
					}
				}
				else{
					int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION){
						String Name = TfName.getText();
						String Phone = (String)CbPhone.getSelectedItem() + "-" +
								TfPhone_1.getText() + "-" + TfPhone_2.getText();
						
						if(OVERLAP_FLAG(Name, Phone)){
							JOptionPane.showMessageDialog(null, "�̹� ��ϵ� �����Ͱ� �ֽ��ϴ�.", "���� �Ұ���", 
									JOptionPane.INFORMATION_MESSAGE);
						}
						else{
							USER_DATA User_Data = SetUserDataInfo();
							ExportDB(User_Data);
							Vec_User_Data.add(User_Data);
							MemberView_Dialog.Update_Vector(Vec_User_Data);
							
							JOptionPane.showMessageDialog(null, "�����Ͱ� ���� �Ǿ����ϴ�.", "���� ����", 
									JOptionPane.INFORMATION_MESSAGE);
							
							ClearInfo();
						}
					}
				}
			}
		}
		else if(a == "����"){
			String Name = JOptionPane.showInputDialog("�����Ͻ� �̸��� �Է��ϼ���.");
			if(DEL_FLAG_1(Name)){
				String Email = JOptionPane.showInputDialog("�����Ͻ� " + Name + "���� �̸����� �Է��� �ּ���.");
				if(DEL_FLAG_2(Email)){
					DelMember(Name, Email);
					MemberView_Dialog.Update_Vector(Vec_User_Data);
					JOptionPane.showMessageDialog(null, Name + "�� ������ ���� �Ϸ�!!", "����", 
							JOptionPane.PLAIN_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "�Է��Ͻ� �̸����� ��ġ���� �ʽ��ϴ�.", "���� �Ұ���", 
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "�Է��Ͻ� �̸��� �����Ϳ� �������� �ʽ��ϴ�.", "���� �Ұ���", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(a == "�˻�"){
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
		else if(a == "��� ��� ����"){
			MemberView_Dialog.setVisible(true);
		}
	}

}
