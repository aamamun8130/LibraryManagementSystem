
package librarymanagement;
import javafx.collections.ObservableList;
public class Counsellor {
    
    
    public void canCreateCommentStdList(ObservableList<Student> p,ObservableList<CommentStdInfo> s_c_info){
        for(Student s : p){
            if(!s.coment.equals("null")){
                s_c_info.add(new CommentStdInfo(s.getStd_username(),s.coment));
            
            }
        }
        
    }
    
    public int canSeeCommentStdInfo(ObservableList<CommentStdInfo> p){
      if(!p.equals(null)){
        return 1;  
      }
        return 6;
    }
    
}
