
package librarymanagement;

public class Admin extends Authority{
    
    
  public SeniorLibrarian canCreateSeniorLbaccount(String un, String pass){
     SeniorLibrarian slb1 = new SeniorLibrarian(un,pass);
     return slb1;
  }  
  
  public JuniorLibrarin canCreateJuniorLbaccount(String un, String pass){
      JuniorLibrarin jlb1 = new JuniorLibrarin(un,pass);
      return jlb1;
  }  
  
   public Accountant canCreateAccountantId(String un,String pass){
     Accountant acant = new Accountant(un,pass);
     return acant;
   }
}
