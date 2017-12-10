
package librarymanagement;

import javafx.collections.ObservableList;

public class SeniorLibrarian extends JuniorLibrarin {
    public double salary;
    public double bonus;
    // constuctor
    
    public SeniorLibrarian(String lib_u_name, String lib_p_word){
        super(lib_u_name,lib_p_word);
    }
    
    public ObservableList<Student> seestdInf(ObservableList<Student> s){
        return s;
    }
   public void calculateSalary(){
       salary = salary()*3 + eidbonus + (super.bonus * 0.4); 
    }
    public void calculateBonus(){                               //////////////over ride here
        bonus = eidbonus + (super.bonus * 0.2); 
    }
    //login in function
    
    // add book 
    
   
    
}
