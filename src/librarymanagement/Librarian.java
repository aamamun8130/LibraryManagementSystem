
package librarymanagement;


public abstract class Librarian {
    
    private String lib_u_name;
    private String lib_p_word;
    private boolean lib_block_status;
    public double salary = 15000.0;
    public double eidbonus = 0.30;
    
    // Constuctor
    public Librarian(String lib_u_name, String lib_p_word){
        this.lib_u_name = lib_u_name;
        this.lib_p_word = lib_p_word;
        
    }
    
    public String getLib_u_name(){
      return lib_u_name; 
    }
    
    public String getLib_p_word(){
      return lib_p_word; 
    }
    
    public boolean getLib_block_status(){
       return lib_block_status; 
    }
    public void setLib_block_status(boolean lib_acc_lock){
        lib_block_status = lib_acc_lock;
    }
    public boolean canlogin(JuniorLibrarin jlb,String un, String ps){                               /// method overloading
        if(jlb.getLib_u_name().equals(un) && jlb.getLib_p_word().equals(ps)){           // librarian login junior srnior
          return true;  
        }
      return false;  
    }
    
   
    public boolean canlogin(SeniorLibrarian slb,String un,String ps){
        
        if(slb.getLib_u_name().equals(un) && slb.getLib_p_word().equals(ps)){
           return true;  
        }
       return false;  
    }
    public boolean canLogOut(){
        return true;
    }
    abstract void calculateSalary();                                     ///     Abstract class and method
    abstract void calculateBonus();
    
}
