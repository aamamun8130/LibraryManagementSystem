
package librarymanagement;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class ForeigenStudent extends Student{
    private String commment;
    
    //constuctor
    
    ForeigenStudent(String std_username, String std_password ,String std_type){
        super(std_username,std_password,std_type,"NULL","NULL");
    }
    
    double calculateDollerCurrency(StdInFo si){
      return (getDue()*23.0)/90.0;  
    }
    double calculateEuroCurrency(StdInFo si){
     return (si.getUdue()*23.0)/123.0;
    }

   // public void setCommment(String commment) {
        //this.commment = commment;
    //}

    public String getCommment() {
        return commment;
    }
    
    public int canComment(ObservableList<Student> s ,String n ,String com ){
        for(Student z : s){
            if(z.getSTD_USERNAME().equals(n)){
               z.coment =  com;
               return 1;
            }
        }
        
        return 2;
    }

    
    
}
