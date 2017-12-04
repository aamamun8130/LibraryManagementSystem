
package librarymanagement;

public class ForeigenStudent extends Student{
    
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
}
