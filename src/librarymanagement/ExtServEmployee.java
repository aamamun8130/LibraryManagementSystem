
package librarymanagement;


public class ExtServEmployee extends ServiceEmployee{
    
    double bon;
    double exb;
    
    public ExtServEmployee(String svname, String svid) {
        super(svname, svid);
    }
    
    public double calculateTotalSalary(double salary){
     return bon+salary+exb;   
    }
    
    public void calculateEidBonus(double salary,double bonus ){
        bon = salary*bonus;
    }
    
    public void ExtraBonus(double salary,double bonus){
        exb = salary * bonus;
    }
    
}
