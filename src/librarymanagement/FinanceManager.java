
package librarymanagement;

import java.util.Observable;
import javafx.collections.ObservableList;

public class FinanceManager {
    
    // constuctor
    
    public void canSeeDueStdList(){
        
    }
    public void canCalculateStdDue(ObservableList<Student>jj){
        for(Student stdl : jj){
         
            if("17/12/01".compareTo(stdl.slbinfo.getStdbooksubdate()) > 0 && stdl.getAccountstatus().equals("NULL")  ){
                stdl.setDue(500.0);
                stdl.setAccountstatus("NO");
            }
            
            else if(stdl.getDue()==500.0) {
                
                
            }
            
            else{
                stdl.setDue(0.0);
            }
            
      
        }
        
    }
    public void canCreateStdDueinfoList(ObservableList<Student> k ,ObservableList<DueStdList> p){
        
        for(Student stdl: k){
            if(stdl.getDue()==500.0){
                p.add(new DueStdList(stdl.getStd_username(),stdl.getDue()));
            
       }
      }
    }
    public int canCountDueStdNo(ObservableList<Student> ss){
        int no = 0;
        for(Student s : ss){
            if(s.getDue()==500.0){
               no++; 
            }
        }
        return no;
    }
    public double canCalculateTotalDue(ObservableList<Student> ss){
        double total= 0;
        for(Student s : ss){
            if(s.getDue()==500.0){
               total+=500.0; 
            }
        }
        return total;
    }
}
