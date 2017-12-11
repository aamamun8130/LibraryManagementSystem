
package librarymanagement;


public abstract class IntServEmployee extends ServiceEmployee{
    double bonn;
    public IntServEmployee(String svname, String svid) {
        super(svname, svid);
    }
   public void calculateEidBonus(double salary,double bonus ){
        bonn = salary*bonus;
    } 
}
