/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ARahman
 */
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
