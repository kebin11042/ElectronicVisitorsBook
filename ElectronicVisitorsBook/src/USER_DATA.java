
public class USER_DATA {
	private String Name;
	private String Sex;
	private String StNum;
	private String StGraDate;
	private String Lab;
	private String PostStNum;
	private String PostGraDate;
	
	private String Phone;
	private String Email;
	private String HomeAdress;
	private String HomePost;
	private String JobAdress;
	private String JobPost;
	
	private String JobName;
	private String Department;
	private String Position;
	private String Working;
	
	private String Cafe;
	private String Mobile;
	
	private int ID;
	
	public USER_DATA(String Name, String Sex, String StNum, String StGraDate, String Lab,
			String PostStNum, String PostGraDate, String Phone, String Email, String HomeAdress,
			String HomePost, String JobAdress, String JobPost, String JobName, String Department,
			String Position, String Working, String Cafe, String Mobile, int ID){	
		this.Name = Name;
		this.Sex = Sex;
		this.StNum = StNum;
		this.StGraDate = StGraDate;
		this.Lab = Lab;
		this.PostStNum = PostStNum;
		this.PostGraDate = PostGraDate;
		
		this.Phone = Phone;
		this.Email = Email;
		this.HomeAdress = HomeAdress;
		this.HomePost = HomePost;
		this.JobAdress = JobAdress;
		this.JobPost = JobPost;
		
		this.JobName = JobName;
		this.Department = Department;
		this.Position = Position;
		this.Working = Working;
		
		this.Cafe = Cafe;
		this.Mobile = Mobile;
		
		this.ID = ID;
	}

	public String GetName(){ return Name; }
	public String GetSex(){ return Sex; }
	public String GetStNum(){ return StNum; }
	public String GetStGraDate(){ return StGraDate; }
	public String GetLab(){ return Lab; }
	public String GetPostStNum(){ return PostStNum; }
	public String GetPostGraDate(){ return PostGraDate; }
	public String GetPhone(){ return Phone; }
	public String GetEmail(){ return Email; }
	public String GetHomeAdress(){ return HomeAdress; }
	public String GetHomePost(){ return HomePost; }
	public String GetJobAdress(){ return JobAdress; }
	public String GetJobPost(){ return JobPost; }
	public String GetJobName(){ return JobName; }
	public String GetDepartment(){ return Department; }
	public String GetPosition(){ return Position; }
	public String GetWorking(){ return Working; }
	public String GetCafe(){ return Cafe; }
	public String GetMobile(){ return Mobile; }
	public int GetID(){ return ID; }
	
	public void SetName(String Name){ this.Name = Name; }
	public void SetSex(String Sex){ this.Sex = Sex; }
	public void SetStNum(String StNum){ this.StNum = StNum; }
	public void SetStGraDate(String StGraDate){ this.StGraDate = StGraDate; }
	public void SetLab(String Lab){ this.Lab = Lab; }
	public void SetPostStNum(String PostStNum){ this.PostStNum = PostStNum; }
	public void SetPostGraDate(String PostGraDate){ this.PostGraDate = PostGraDate; }
	public void SetPhone(String Phone){ this.Phone = Phone; }
	public void SetEmail(String Email){ this.Email = Email; }
	public void SetHomeAdress(String HomeAdress){ this.HomeAdress = HomeAdress; }
	public void SetHomePost(String HomePost){ this.HomePost = HomePost; }
	public void SetJobAdress(String JobAdress){ this.JobAdress = JobAdress; }
	public void SetJobPost(String JobPost){ this.JobPost = JobPost; }
	public void SetJobName(String JobName){ this.JobName = JobName; }
	public void SetDepartment(String Department){ this.Department = Department; }
	public void SetPosition(String Position){ this.Position = Position; }
	public void SetWorking(String Working){ this.Working = Working; }
	public void SetCafe(String Cafe){ this.Cafe = Cafe; }
	public void SetMobile(String Mobile){ this.Mobile = Mobile; }
}
