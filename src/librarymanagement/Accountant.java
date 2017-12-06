
package librarymanagement;

import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

public class Accountant implements ISearchstudent{
    private String acc_name;
    private String acc_pass;

    public Accountant(String acc_name, String acc_pass) {
        this.acc_name = acc_name;
        this.acc_pass = acc_pass;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public String getAcc_pass() {
        return acc_pass;
    }
    
    public int searchStudent(ObservableList<Student> s, String un){
        for(Student ss : s){
            if(ss.getSTD_USERNAME().equals(un)){
               return 1; 
            }
        }
        return 2;
    }
    
    public int canPayStdDue(ObservableList<Student> s, String un){
        for(Student st : s){
           if(st.getSTD_USERNAME().equals(un)){
               st.setDue(0.0);
               return 1;
           }
        }
        return 2;
    }
    
}
