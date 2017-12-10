
package librarymanagement;

public class DueStdList {
    private String uname;
    private double sdue;
    //constuctor

    public DueStdList(String uname, double sdue) {
        this.uname = uname;
        this.sdue = sdue;
    }
    

    public String getUname() {
        return uname;
    }

    public double getSdue() {
        return sdue;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setSdue(double sdue) {
        this.sdue = sdue;
    }
    
    
}
