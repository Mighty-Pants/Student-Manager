package manageStudent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class studentHandle {
     ArrayList<student> stuList = new ArrayList<>();
     ArrayList<student> stuStore = new ArrayList<>();
     ArrayList<home> homeList = new ArrayList<>();
     ArrayList<String> line = new ArrayList<>();
     ArrayList<String> linestore = new ArrayList<>();
     HashSet<Integer> checkStudentID = new HashSet<>();
     
     int maxHomeID = 1;
     int maxStudentID = 0;
     fileHandle fh = new fileHandle();
     
     public void inputHomeFromFile() 
     {
    	 homeList.clear();
    	 try {
			fh.inputFile("quequan.txt", line);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
    	 for(int i = 0 ; i < line.size() ; i++)
    	 {
    		 home homein = new home();
    		 if(homein.parse(line.get(i)) == true)
    		 {
    		 if(foundHomeID(homein.getHomeID()) >= 0 && foundHomeName(homein.getName()) < 0)
        			 linestore.add(homein.getName());
    		 if(foundHomeID(homein.getHomeID()) <  0 && foundHomeName(homein.getName()) < 0 && homein.getHomeID() > 0)
    		 {
    			 homeList.add(homein);
    			 if(maxHomeID < homein.getHomeID()) 
    				 maxHomeID = homein.getHomeID();
    		 }
    		 if(homein.getHomeID() <= 0)
    			 linestore.add(homein.getName());
    	     }
    	 }
    	 if(!linestore.isEmpty())
		 {
			 for(int i = 0 ; i < linestore.size() ; i++)
			 {
				 home homein = new home();
				 homein.setHomeID(++maxHomeID);
				 homein.setName(linestore.get(i));
				 homeList.add(homein);
			 }
				
		 }
    	 linestore.clear();
    	 line.clear();
     }
     
     public void inputStudentFromFile() 
     {
    	 stuList.clear();
         try {
			fh.inputFile("thisinh.txt", line);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
         for(int i = 0 ; i < line.size() ; i++)
         {
        	student st = new student();
        	if (st.parse(line.get(i)) == true)
        	{
        	if(checkStudentID.contains(st.getStudentID()) && st.getStudentID() > 9999)
        		  stuStore.add(st);
        	if(!checkStudentID.contains(st.getStudentID()) && st.getStudentID() > 9999)
        	  {
        		  stuList.add(st);
        		  checkStudentID.add(st.getStudentID());
        		  if(maxStudentID < st.getStudentID())
        		    maxStudentID = st.getStudentID();
        	  }
        	 if(st.getStudentID() <= 9999) stuStore.add(st);
            }
         }
         if(!stuStore.isEmpty())
        	 for(int i = 0 ; i < stuStore.size() ; i++)
        	 {
        		 student st = new student();
        		 st = stuStore.get(i);
        		 st.setStudentID(++maxStudentID);
        		 stuList.add(st);
        		 checkStudentID.add(st.getStudentID());
        		 
        	 }
         line.clear();
     }
     public void outputStudentToFile() 
     {
    	 for(int i = 0 ; i < stuList.size() ; i++)
    		 line.add(stuList.get(i).toString());
    	 try {
			fh.outputFile("thisinh.txt", line);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
    	 line.clear();
    	 System.out.println("Student done");
     }
     public void outputHomeToFile() 
     {
    	
    	 for(int i = 0 ; i < homeList.size() ; i++)
    	 {
    		line.add(homeList.get(i).toString());
    	 }
    	 try {
			fh.outputFile("quequan.txt", line);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
    	 line.clear();
    	 System.out.println("Home done");
     }
     public int addNewHome(String s)
     {
    	 home hm = new home();
    	 hm.setName(s);
    	 hm.setHomeID(++maxHomeID);
    	 homeList.add(hm);
    	 return hm.getHomeID();
     }
     public void updateMax()
     {
    	 maxStudentID ++;
     }
     public void updateCheckID(int i)
     {
    	 checkStudentID.add(i);
     }
     public int foundHomeID(int a)
     {
    	 for(int i = 0 ; i < homeList.size() ; i++)
    	 {
    		 if(a == homeList.get(i).getHomeID())
    			 return i;
    	 }
    	 return -1;
     }
     public int foundHomeName(String a)
     {
    	 for(int i = 0 ; i < homeList.size() ; i++)
    	 {
    		 if(a.equalsIgnoreCase(homeList.get(i).getName()))
    			 return i;
    	 }
    	 return -1;
     }
     public int getMaxStudentID()
     {
    	 return maxStudentID;
     }
     public HashSet<Integer> getCheckStudentID()
     {
    	 return checkStudentID;
     }
     public ArrayList<student> getStudentList()
     {
    	 return stuList;
     }
     public ArrayList<home> getHomeList()
     {
    	 return homeList;
     }
}
