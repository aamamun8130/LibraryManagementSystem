
package librarymanagement;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//Abstract class

public abstract class Student {
    
    private SimpleStringProperty std_username;
    private  SimpleStringProperty std_password;
    private SimpleStringProperty std_type;
    StdLibraryInfo slbinfo;
    private double due;
    private String accountstatus;
    public String coment;
    
    
    //Constuctor
    
    public Student(String std_username,String std_password,String std_type, String p, String q){
        this.std_password = new SimpleStringProperty(std_password);
        this.std_username = new SimpleStringProperty(std_username);
        this.std_type = new SimpleStringProperty(std_type);
        coment="null";
        slbinfo = new StdLibraryInfo(p,q);
         this.due = 0.0;
         accountstatus = "NULL";
         
         
    }
    // Instance variable getter and setter start 
    
    String getSTD_TYPE(){
        return std_type.get();
    }
    String getSTD_PASSWORD(){
        return std_password.get();
    }
    String getSTD_USERNAME(){
        return std_username.get();
    }

    public String getStd_username() {
        return std_username.get();
    }
    
    public void setDue(double due) {
        this.due = due;
    }

    public String getStd_password() {
        return std_password.get();
    }

    public String getStd_type() {
        return std_type.get();
    }
   
    public double getDue() {
        return due;
    }

    public String getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(String accountstatus) {
        this.accountstatus = accountstatus;
    }
    
    // Instance variable getter and setter end
    
    //All Method Start From
  
    
    public void createAccount(ObservableList<Student> sl,ForeigenStudent fs,String un, String ps){
        fs = new ForeigenStudent(un,ps,"foreigen");
        sl.add(fs);
    }
    
    public void createAccount(ObservableList<Student> sl,LocalStudent ls,String un, String ps){
        ls = new LocalStudent(un,ps,"local");
        sl.add(ls);
    }
    public  int canLoginAccount(ObservableList<Student> h,int p, int q,String su,String sp,StdInFo lif){
          int s=4,t=4,u=4;
        for(Student std : h){
            if(p==1 && std.getSTD_TYPE().equals("foreigen") && std.getSTD_PASSWORD().equals(sp) && std.getSTD_USERNAME().equals(su) ){
                lif.setUname(std.getSTD_USERNAME());
                lif.setUtype(std.getSTD_TYPE());
                lif.setUbname(std.slbinfo.getStdbookname());
                lif.setUbsubdate(std.slbinfo.getStdbooksubdate());
                lif.setUdue(std.getDue());
                
                
                s = 0;
            }
            else if(q==1 && std.getSTD_TYPE().equals("local") && std.getSTD_USERNAME().equals(su) && std.getSTD_PASSWORD().equals(sp) ){
                lif.setUname(std.getSTD_USERNAME());
                lif.setUtype(std.getSTD_TYPE());
                lif.setUbname(std.slbinfo.getStdbookname());
                lif.setUbsubdate(std.slbinfo.getStdbooksubdate());
                lif.setUdue(std.getDue());
                t = 1;
            }
            else{
                u = 2;   
                    }
        }
        if(s==0){
          return 0;  
        }
        else if(t==1){
           return 1; 
        }
        else if(u==2){
            return 2;
        }
    
        return 3;
    }
    
    public int SearchBook(Book b, String bkn){
 
            if(bkn.equals(b.getBookname())){
                return 1;
            }
            
            return 2;
    }
    
    public int SeeLbInfo(StdInFo si){
       if(!si.equals(null)){ 
       return 1;
       }
       return 0;
    }
    public double CanSeebdtFine(StdInFo si){
        return si.getUdue();
    }
    
    public boolean CanlogOut(){
        return true;
    }
    
    // Abstract Method
    
    abstract double calculateDollerCurrency(StdInFo si);                            ///  Abstract method
    
    // method end
    
    
}
