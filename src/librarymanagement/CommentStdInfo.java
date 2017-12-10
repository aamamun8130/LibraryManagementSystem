
package librarymanagement;

import javafx.beans.property.SimpleStringProperty;


public class CommentStdInfo {
    private SimpleStringProperty csname;
    private  SimpleStringProperty cscomment;

    public CommentStdInfo(String csname, String cscomment) {
        this.csname = new SimpleStringProperty(csname);
        this.cscomment = new SimpleStringProperty(cscomment);
    }

    public String getCsname() {
        return csname.get();
    }

    public String getCscomment() {
        return cscomment.get();
    }

    public void setCsname(String csname) {
       this.csname = new SimpleStringProperty(csname);;
    }

    public void setCscomment(String cscomment) {
        this.cscomment = new SimpleStringProperty(cscomment);
    }
    
    
    
}
