package librarymanagement;

public abstract class ServiceEmployee {
    private String svname;
     private String svid;

    public ServiceEmployee(String svname, String svid) {
        this.svname = svname;
        this.svid = svid;
    }

    public String getSvname() {
        return svname;
    }

    public String getSvid() {
        return svid;
    }

    public void setSvname(String svname) {
        this.svname = svname;
    }

    public void setSvid(String svid) {
        this.svid = svid;
    }
     
    public boolean Logout(){
        return true;
    }
    
    abstract double calculateTotalSalary(double salary);
    abstract void calculateEidBonus(double salary,double bonus);
    abstract void ExtraBonus(double salary,double bonus);
    
}
