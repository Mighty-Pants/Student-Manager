package manageStudent;

public class home {
     private int homeID;
     private String name = "";
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
    public String toString()
    {
    	return name + "; " + homeID;
    }
	public boolean parse(String s)
	{
		String param[] = s.split(";");
		if(param.length < 2) 
			return false;
		param[0] = param[0].trim();
		param[1] = param[1].trim();
		
		if(checkName(param[0]))
		    name = param[0];
		else return false;
		
		if(checkHomeID(param[1]))
		   homeID = Integer.parseInt(param[1]);
		else return false;
		
		return true;	
	}
	public boolean checkName(String s)
	{
		return s.matches("^[[a-z A-z]+\\s*]+$");
	}
	public boolean checkHomeID(String s)
	{
		return s.matches("^\\d+$");
	}
}
