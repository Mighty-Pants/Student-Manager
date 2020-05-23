package manageStudent;

public class student {
	private int studentID, homeID;
    private String name = "", birthdate = "";
    private Boolean gender = null;
    private float math = 0, physic = 0, chemistry = 0;
    
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getHomeID() {
		return homeID;
	}
	public void setHomeID(int homeID) {
		this.homeID = homeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public float getMath() {
		return math;
	}
	public void setMath(float math) {
		this.math = math;
	}
	public float getPhysic() {
		return physic;
	}
	public void setPhysic(float physic) {
		this.physic = physic;
	}
	public float getChemistry() {
		return chemistry;
	}
	public void setChemistry(float chemistry) {
		this.chemistry = chemistry;
	}
   public String toString()
   {
   	return studentID + "; " + name + "; " + homeID + "; " + birthdate + "; " + gender + "; " +
              math + "; " + physic + "; " + chemistry;
   }
  	public boolean parse(String s)
	{
		String param[] = s.split(";");
		for(int i  = 0 ; i < param.length ; i++)
			param[i] = param[i].trim();
		
		if(checkStudentID(param[0])) 
			studentID = Integer.parseInt(param[0]);

		if(checkName(param[1]))
		   name = param[1];
		else return false;

		if(checkHomeID(param[2]))
			homeID = Integer.parseInt(param[2]);
		
		if(checkBirthdate(param[3]) && checkBirthdateBound(param[3]))
			birthdate = param[3];
		
		if(param[4].equalsIgnoreCase("true"))
			gender = true;
		if(param[4].equalsIgnoreCase("false"))
			gender = false;
		
		if(checkPoint(param[5]) && checkPointBound(Float.parseFloat(param[5])))
			math = Float.parseFloat(param[5]);
		
		if(checkPoint(param[6]) && checkPointBound(Float.parseFloat(param[5])))
			physic = Float.parseFloat(param[6]);
		
		if(checkPoint(param[7]) && checkPointBound(Float.parseFloat(param[5])))
			chemistry = Float.parseFloat(param[7]);
        
		return true;
	} 
  	
  	public boolean checkStudentID(String s)
  	{
  		return s.matches("^\\d{5,}$");
  	}
  	
  	public boolean checkName(String s)
  	{
  		return s.matches("^[[a-z A-z]+\\s*]+$");
  	}
  	
  	public boolean checkHomeID(String s)
  	{
  		return s.matches("^\\d+$");
  	}
  	
  	public boolean checkBirthdate(String s)
  	{
  		return s.matches("^\\d{1,2}/\\d{1,2}/\\d{4,}$");
  	}
  	public boolean checkBirthdateBound(String s)
  	{
  		String param[] = s.split("/", 3);
  		int year = Integer.parseInt(param[2]);
  		int month = Integer.parseInt(param[1]);
  		int day = Integer.parseInt(param[0]);
  		boolean isLunar = false;
  		
  		if(year < 1)
  			return false;
  		
  		if(month < 1 || month > 12)
  			return false;
  		
  		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
  		   month == 10 || month == 12 )
  		     if(day < 1 || day > 31)
  			    return false;
  		if(month == 4 || month == 6 || month == 9 || month == 11)
  		   if(day < 1 || day > 30)
  			    return false;
  		if(year % 100 == 0)
  		{
  			if(year % 400 == 0)
  				isLunar = true;
  			else isLunar = false;
  		}
  		else if(year % 4 == 0) isLunar = true;
  		
  		if(month == 2 && isLunar == true)
  			if(day < 1 || day > 29)
  		        return false;
  		if(month == 2 && isLunar == false)
  			if(day < 1 || day > 28)
  		        return false;
  		  
  		return true;
  	}
  	
  	public boolean checkPoint(String s)
  	{
  		return s.matches("^\\d{1,2}(\\.\\d)*$");
  	}
  	public boolean checkPointBound(float f)
  	{
  		if(f >= 0 && f <= 10) return true;
  		else return false;
  	}
}
