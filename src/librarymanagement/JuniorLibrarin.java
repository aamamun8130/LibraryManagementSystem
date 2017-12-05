
package librarymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class JuniorLibrarin extends Librarian{
    
    // constuctor
    public JuniorLibrarin(String lib_u_name, String lib_p_word){
        super(lib_u_name,lib_p_word);
    }
    
    public void canAddBook(ObservableList<Book>BookList,String bookname,String bookid,String booktype,int bookselfno){
       BookList.add(new Book(bookname,bookid,booktype,bookselfno));
    }
    public int seeStdInformation(Student s,String u){
            if(u.equals(s.getSTD_USERNAME()) && s.getSTD_TYPE().equals("local")){
                return 1;
            }
            else if(u.equals(s.getSTD_USERNAME()) && s.getSTD_TYPE().equals("foreigen")){
                return 2;
            }
        
        return 6;
    }
    public int lbsearchStd(ObservableList<Student>p,String u){
        
        for(Student liststd : p){
        if(u.equals(liststd.getSTD_USERNAME()) && liststd.getSTD_TYPE().equals("local")){
           
         return 1;
        }
        else if(u.equals(liststd.getSTD_USERNAME()) && liststd.getSTD_TYPE().equals("foreigen")){
            
            return 1;
        }
        
        }
       return 7; 
    }
    
    public int giveBook(Student sl ,String u ){
        
            if(u.equals(sl.getSTD_USERNAME()) && sl.getSTD_TYPE().equals("local")){
                return 1;
            }
            else if(u.equals(sl.getSTD_USERNAME()) && sl.getSTD_TYPE().equals("foreigen")){
               return 2; 
            }
            return 0;
    }
    
  public int canTakeBookReturn(Student s,String un){
      
      if(un.equals(s.getSTD_USERNAME()) && s.getSTD_TYPE().equals("local")){
        return 1;  
      }
      else if(un.equals(s.getSTD_USERNAME()) && s.getSTD_TYPE().equals("foreigen")){
          return 2;
      }
    return 0;  
  }
    
}
