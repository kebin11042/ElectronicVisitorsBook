import java.util.Iterator;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class MEMBERVIEW_DIALOG extends JDialog{
	private Vector<USER_DATA> Vec_User_Data;
	
	private JLabel LbMemberInfo, LbPeoPleCnt;
	private JList<String> LiMemberInfo;
	private JScrollPane ScrPane;
	
	public MEMBERVIEW_DIALOG(JFrame Main_Frame, Vector<USER_DATA> Vec_User_Data){
		super(Main_Frame, "등록 명단");
		
		this.Vec_User_Data = Vec_User_Data;
		
		Start();
		Init();
		Update();
		
		this.setLayout(null);
		this.setSize(250, 500);
	}
	
	public void Start(){
		this.setResizable(false);
	}
	
	public void Init(){
		LbMemberInfo = new JLabel(" 이름                            핸드폰");
		LbMemberInfo.setSize(200, 20);
		LbMemberInfo.setLocation(30, 18);
		
		LiMemberInfo = new JList<String>();
		LiMemberInfo.setSize(200, 400);
		
		ScrPane = new JScrollPane(LiMemberInfo);
		ScrPane.setSize(200, 400);
		ScrPane.setLocation(20, 40);
		
		LbPeoPleCnt = new JLabel("0 명");
		LbPeoPleCnt.setSize(50, 20);
		LbPeoPleCnt.setLocation(180,445);
		
		this.add(LbMemberInfo);
		this.add(ScrPane);
		this.add(LbPeoPleCnt);
	}
	
	public void Update(){
		Vector<String> Vec_List = new Vector<String>();
		
		Iterator<USER_DATA> It = Vec_User_Data.iterator();
		while(It.hasNext()){
			USER_DATA User_data = It.next();
			String Name = User_data.GetName();
			String Phone = User_data.GetPhone();
			String list = String.format("%6s %30s", Name, Phone);
			Vec_List.add(list);
			
			//System.out.println(Name);
		}
		
		LiMemberInfo.setListData(Vec_List);
		LbPeoPleCnt.setText(Vec_List.size() + " 명");
	}
	
	public void Update_Vector(Vector<USER_DATA> Vec_User_Data){
		this.Vec_User_Data = Vec_User_Data;
		this.Update();
	}
}
