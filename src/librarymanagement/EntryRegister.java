
package librarymanagement;


public class EntryRegister extends IntServEmployee{
    
    double exb;
    
    public EntryRegister(String svname, String svid) {
        super(svname, svid);
    }
   
    public double calculateTotalSalary(double salary){
     return exb+bonn+salary;   
    }
    
    void ExtraBonus(double salary,double bonus){
        exb = salary * bonus;
    }
    
}
