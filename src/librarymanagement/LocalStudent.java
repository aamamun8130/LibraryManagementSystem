
package librarymanagement;
public class LocalStudent extends Student{
    
    //constuctor
    LocalStudent(String std_username, String std_password ,String std_type){
        super(std_username,std_password,std_type,"NULL","NULL");
    }
    
    public double calculateDollerCurrency(StdInFo si){
      return si.getUdue()/85.0;  
    }
}
