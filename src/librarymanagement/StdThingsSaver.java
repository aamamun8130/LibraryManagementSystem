
package librarymanagement;


public class StdThingsSaver extends IntServEmployee{
    
      double exb;
    
    public StdThingsSaver(String svname, String svid) {
        super(svname, svid);
    }
    
    public double calculateTotalSalary(double salary){
     return exb+bonn+salary;   
    }

    void ExtraBonus(double salary,double bonus){
        exb = salary * bonus;
    }
    
}
