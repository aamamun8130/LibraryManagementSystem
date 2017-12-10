package librarymanagement;

public class StdInFo {
    private String uname;
    private String utype;
    private String ubname;
    private String ubsubdate;
    private double udue;

    public StdInFo(String uname, String utype, String ubname, String ubsubdate, double udue) {
        this.uname = uname;
        this.utype = utype;
        this.ubname = ubname;
        this.ubsubdate = ubsubdate;
        this.udue = udue;
    }
    
    

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public void setUbname(String ubname) {
        this.ubname = ubname;
    }

    public void setUbsubdate(String ubsubdate) {
        this.ubsubdate = ubsubdate;
    }

    public void setUdue(double udue) {
        this.udue = udue;
    }

    public String getUname() {
        return uname;
    }

    public String getUtype() {
        return utype;
    }

    public String getUbname() {
        return ubname;
    }

    public String getUbsubdate() {
        return ubsubdate;
    }

    public double getUdue() {
        return udue;
    }
    
    
}
