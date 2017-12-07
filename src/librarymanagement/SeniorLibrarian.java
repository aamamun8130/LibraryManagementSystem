
package librarymanagement;

public class SeniorLibrarian extends JuniorLibrarin{
    public double salary;
    public double bonus;
    // constuctor
    
    public SeniorLibrarian(String lib_u_name, String lib_p_word){
        super(lib_u_name,lib_p_word);
    }
    
    public void seestdInf(){
        
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
