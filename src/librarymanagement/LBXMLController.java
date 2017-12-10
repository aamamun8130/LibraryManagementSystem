
package librarymanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LBXMLController implements Initializable {
    //Database Controll
    static PreparedStatement ps = null;
    static Connection conn = null;
    public static void Connector() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:librarymanagement.sqlite");
    }
    


    
    StdInFo lif;
    public String login_u_n_catcher;
   
    
   //student optoin all design controll start from
    
        
    boolean login = false;
    int p;
    int q;
    
    @FXML
    private PasswordField st_pass,st_cpass;
    
    @FXML
    private TextField st_uname;
    
    @FXML
    private Label reg_warning;
    
    @FXML
    private JFXButton btn_regst;
    
    void clearCreateAccountField(){
        st_pass.setText("");
        st_cpass.setText("");
        st_uname.setText("");
    }
    void clearLoginField(){
        log_p_word_Id.setText("");
        log_u_name_Id.setText("");
    }
    ForeigenStudent fstd;
    LocalStudent lstd;
    int loc_std = 0;
    int fore_std = 0;
    public ObservableList<Student>stdList = FXCollections.observableArrayList();              /////
    
     @FXML
    void st_registration(ActionEvent event) {
        if(!st_pass.getText().equals(st_cpass.getText())){
            reg_warning.setText("Password Not Matched!!!");
        }
        else{
           reg_warning.setText("Submission Successful");
           if(fore_std==1){
               fstd.createAccount(stdList,fstd,st_uname.getText(),st_pass.getText());     //    std create account method
               //fstd = new ForeigenStudent(st_uname.getText(),st_pass.getText(),"foreigen");
               //stdList.add(fstd);
               
           }
           if(loc_std==1){
               lstd.createAccount(stdList,lstd,st_uname.getText(),st_pass.getText());
                //lstd = new LocalStudent(st_uname.getText(),st_pass.getText(),"local");
               //stdList.add(lstd);
           }
           clearCreateAccountField();
        }
       
        
        
    }
    
    @FXML
    private JFXButton studentButton;

    @FXML
    private AnchorPane studentNavigation;

    @FXML
    private JFXButton createAccountButton;

    @FXML
    private JFXButton loginButton;

    @FXML
    private AnchorPane createAccountNavigation;
    
    @FXML
    private AnchorPane loginNavigation;
    
    @FXML
    private JFXButton loginbutton2;
    
    @FXML
    private Label logoutLavel;
    
    @FXML
    private AnchorPane plate;
    
    @FXML
    private AnchorPane bookSearchpane;
    
    @FXML
    void createAccountButtonAction(ActionEvent event) {
        createAccountNavigation.setVisible(true);
        loginNavigation.setVisible(false);
        p=2;
    }
     
    
    @FXML
    void loginButtonAction(ActionEvent event) {
       
         loginNavigation.setVisible(true);
        createAccountNavigation.setVisible(false);
        p=2;   
        
        
    }
     @FXML
    private AnchorPane std_typer;
    
    @FXML
    void studentButtonAction(ActionEvent event) {
       if(!login){
           std_typer.setVisible(true);
           login=true;
           q=1;
          
       }
    }
    
    
    @FXML
    void localButtonAction(ActionEvent event) {
        loc_std = 1;
        fore_std = 0;
        studentNavigation.setVisible(true);
        studentNavigation.setLayoutX(240);
        studentNavigation.setLayoutY(197);
        loginNavigation.setVisible(false);
        createAccountNavigation.setVisible(false);
    }
    @FXML
    void foreignButtonAction(ActionEvent event) {
        fore_std = 1;
        loc_std = 0;
        studentNavigation.setVisible(true);
        studentNavigation.setLayoutX(240);
        studentNavigation.setLayoutY(270);
        loginNavigation.setVisible(false);
        createAccountNavigation.setVisible(false);
    }
     @FXML
    void std_type_lavel_exit(MouseEvent event) {
        fore_std = 0;
        loc_std = 0;
     std_typer.setVisible(false);
     login=false;
     loginNavigation.setVisible(false);
     createAccountNavigation.setVisible(false);
     studentNavigation.setVisible(false);
     
    }
    
    @FXML
    private TextField log_u_name_Id;
      @FXML
    private PasswordField log_p_word_Id;
      
       @FXML
    private Label login_alarm;
       int enp_sList;
       
       String std_uname;
       String std_ubooksubdate;
       String std_bname;
       double std_fine ;
       String std_typ;
       
       
       
     void assignStdInfo(){
       std_uname = lif.getUname();
       std_ubooksubdate = lif.getUbsubdate();
       std_bname = lif.getUbname();
       std_fine = lif.getUdue();
       std_typ = lif.getUtype(); 
     }
     
     @FXML
     private Label stypelab;
       
     @FXML
     private Label comlabButton; 
     
     @FXML
     private Pane commentpane;               


    
    @FXML
    void loginButton2Action(ActionEvent event) {
         //canLoginAccount(stdList,fore_std,loc_std,log_u_name_Id.getText(),log_p_word_Id.getText())
            login_u_n_catcher = log_u_name_Id.getText();
        if(fstd.canLoginAccount(stdList,fore_std,loc_std,log_u_name_Id.getText(),log_p_word_Id.getText(),lif)==0){
            plate.setVisible(true);
            loginNavigation.setVisible(false);
            createAccountNavigation.setVisible(false);
            studentNavigation.setVisible(false);
            std_typer.setVisible(false);
            clearLoginField();
            stypelab.setText("foreigen");
            login = true;
            enp_sList = 1;
            comlabButton.setVisible(true);
            
            assignStdInfo();     // asssign std info function calll
         }
         else  if (lstd.canLoginAccount(stdList,fore_std,loc_std,log_u_name_Id.getText(),log_p_word_Id.getText(),lif)==1){
                 plate.setVisible(true);
            loginNavigation.setVisible(false);
            createAccountNavigation.setVisible(false);
            studentNavigation.setVisible(false);
            std_typer.setVisible(false);
            clearLoginField();
            login = true;
            enp_sList = 1;
            stypelab.setText("local");
            comlabButton.setVisible(false);
            assignStdInfo();       // asssign std info function calll
           }
         
         else if(lstd.canLoginAccount(stdList,fore_std,loc_std,log_u_name_Id.getText(),log_p_word_Id.getText(),lif)==2){
             
                login_alarm.setText("Alarm!!! Wrong Entry");
                enp_sList = 1;
         } 
        else
            {
                 login_alarm.setText("No Student Account Found!");
            }
          //System.out.println(loc_std+"  "+fore_std);
       // for(Student d : stdList){
       //     System.out.println(d.getSTD_USERNAME()+ " "+ d.getSTD_PASSWORD());
       // }
            
       }
    
    @FXML
    void logoutAction(MouseEvent event) {
        if(loc_std==1){
        if(lstd.CanlogOut()){                                                  // Log out function call  Student 
          login = false;
          plate.setVisible(false);
          selmover.setVisible(true);
          selmover.setLayoutX(30.0);
          bookSearchpane.setVisible(true);
          yourlibinfo.setVisible(false);
          stdfinePane.setVisible(false);
          commentpane.setVisible(false);
        }
              }
        if(fore_std==1){
          if(fstd.CanlogOut()){                                                  // Log out function call foreign std
          login = false;
          plate.setVisible(false);
          selmover.setVisible(true);
          selmover.setLayoutX(30.0);
          bookSearchpane.setVisible(true);
          yourlibinfo.setVisible(false);
          stdfinePane.setVisible(false);
          commentpane.setVisible(false);
        }
        }
    }
    
    @FXML
    private Pane selmover;
    
    @FXML
    private Label lab1;

    @FXML
    private Label lab2;

    @FXML
    private Label lab3;
    
    @FXML
    private AnchorPane yourlibinfo;
    
    @FXML
    private Label stdxlab1;
        
    @FXML
    private Label stdxlab2;
            
    @FXML
    private Label stdxlab3;
    
    @FXML
    private Label student_t_lab;
    
    @FXML
    private Label local_currency_lab;
    
    @FXML
    private Label doller_currency_lab;
    
    @FXML
    private Label eueo_currency_lab;
    
    @FXML
    private Pane stdfinePane;
   //std lb info pane info
    
    @FXML
    private Label stdLbInfo_u_name_lab;
    
    @FXML
    private Label stdLbInfo_u_b_name_lab1;
    
    @FXML
    private Label stdLbInfo_u_b_subDate_lab11;
     
             
   //end
    
    
    @FXML
    void act1(MouseEvent event) {
        if(event.getSource() == lab1){
        selmover.setVisible(true);
        selmover.setLayoutX(30.0);
        bookSearchpane.setVisible(true);
        yourlibinfo.setVisible(false);
        stdfinePane.setVisible(false);
        commentpane.setVisible(false);
        
        }
        else if(event.getSource() == lab2){
        selmover.setVisible(true);
        selmover.setLayoutX(154.0);
        yourlibinfo.setVisible(true);
        bookSearchpane.setVisible(false);
         stdfinePane.setVisible(false);
         commentpane.setVisible(false);
          if(lstd.SeeLbInfo(lif)==1) {                                                                    // std see lib info function
         stdLbInfo_u_name_lab.setText(lif.getUname());
         stdLbInfo_u_b_name_lab1.setText(lif.getUbname());                     ///very inportant area lib info std
         stdLbInfo_u_b_subDate_lab11.setText(lif.getUbsubdate());
          }
         
        }
        else if(event.getSource() == lab3){
        selmover.setVisible(true);
        selmover.setLayoutX(270.0);
        stdfinePane.setVisible(true);
        yourlibinfo.setVisible(false);
        bookSearchpane.setVisible(false);
        student_t_lab.setText(std_typ);
        commentpane.setVisible(false);
        
        local_currency_lab.setText(Double.toString(lstd.CanSeebdtFine(lif)) + " BDT");   /// can see local currency
        doller_currency_lab.setText(Double.toString(lstd.calculateDollerCurrency(lif)) + " $");                                       ///can see doller currency
        if(lif.getUtype().equals("local")){
        eueo_currency_lab.setVisible(false);                        // need change // euro lab erase  kortay hobay
        }
        else{
            eueo_currency_lab.setVisible(true);
            eueo_currency_lab.setText(Double.toString(fstd.calculateEuroCurrency(lif)));                                    //can see euro currency
        }
        
        }
        else if(event.getSource() == stdxlab1){
            fore_std = 0;
            loc_std = 0;
            studentNavigation.setVisible(false);
            std_typer.setVisible(false);
            if(p!=2){
             login=false;   
            }
            q=0;
        }
        else if(event.getSource() == stdxlab2){
            createAccountNavigation.setVisible(false);
            
            if(q!=1){
             login=false;   
            }
            p=0;
            reg_warning.setText("");
            clearCreateAccountField();
            
        }
        else if(event.getSource() == stdxlab3){
            loginNavigation.setVisible(false);
            
            if(q!=1){
             login=false;   
            }
            p=0;
            login_alarm.setText("");
            clearLoginField();
        }
        else if(event.getSource() == exit_lab){
            jlbsalpane.setVisible(false);
        }
      

    }
    
    @FXML
    void act5(MouseEvent event){
         if(event.getSource() == comlabButton){
            commentpane.setVisible(true);
            yourlibinfo.setVisible(false);
            bookSearchpane.setVisible(false);
            stdfinePane.setVisible(false);
            comsubnotilab.setText("");
            commentfield.setText("");
        } 
    }
    @FXML
    private JFXTextField commentfield;
    
    @FXML
    private Label comsubnotilab;
    
    @FXML
    void comsubButtonAction(ActionEvent event){
       if(fstd.canComment(stdList,login_u_n_catcher,commentfield.getText())==1){
           comsubnotilab.setText("Submission Sucessful!!");
           commentfield.setText("");
       }
       else{
           comsubnotilab.setText("Submiss Not Sucessful!!");
       }
    }
    
    @FXML
    private Label searchBookNoti_lab;
    
    @FXML
    private Label book_t_lab;
    @FXML
    private Label book_n_lab;
    @FXML
    private Label book_i_lab;
    
    @FXML
    private Label book_sno_lab;
    
    @FXML
    private TextField searchBookFeild;
    
    int enpt_BookListIdentifier = 0;
    
    
    @FXML
    void searchBookButtonAction(ActionEvent event){
        //lstd.SearchBook(bk,searchBookFeild.getText())
        
        
        
      if(loc_std==1){  
        for(Book bk : BookList){
            enpt_BookListIdentifier = 1;
        if(lstd.SearchBook(bk,searchBookFeild.getText())==1){                    ///  loc std book search method call
            book_n_lab.setText(bk.getBookname());
            book_t_lab.setText(bk.getBooktype());
            book_i_lab.setText(bk.getBookid());
            book_sno_lab.setText(Double.toString(bk.getBookselfno()));
            searchBookNoti_lab.setText("Book Found!");
            enpt_BookListIdentifier=2;
        }
        
        else{
            enpt_BookListIdentifier = 4;
        }
        
        
        }
        
        if(enpt_BookListIdentifier==4){
           searchBookNoti_lab.setText("Book Not Found!");
        }
       
        if(enpt_BookListIdentifier == 0){
            searchBookNoti_lab.setText("No Book List Found!");
        }
        
    }
      
      
      
      if(fore_std==1){  
        for(Book bk : BookList){
            enpt_BookListIdentifier = 1;
        if(lstd.SearchBook(bk,searchBookFeild.getText())==1){                    ///  foreigen std book search method call
            book_n_lab.setText(bk.getBookname());
            book_t_lab.setText(bk.getBooktype());
            book_i_lab.setText(bk.getBookid());
            book_sno_lab.setText(Double.toString(bk.getBookselfno()));
            searchBookNoti_lab.setText("Book Found!");
            enpt_BookListIdentifier=2;
        }
        
        else{
            enpt_BookListIdentifier = 4;
        }
        
        
        }
        
        if(enpt_BookListIdentifier==4){
           searchBookNoti_lab.setText("Book Not Found!");
        }
       
        if(enpt_BookListIdentifier == 0){
            searchBookNoti_lab.setText("No Book List Found!");
        }
        
    }
      
    }
    
        
            
            
           

    // student design control end................end
    
    
    // librarian design control start from..........
    
    @FXML
    private Label librarianNavigationExit;
    
    @FXML
    private Label lib_neg_exit;
        
    @FXML
    private AnchorPane librarianafterloginancorepane;
        
     @FXML
    void act2(MouseEvent event) {
        
        if(event.getSource()==librarianNavigationExit){
            slb = 0;
            jlb = 0;
            librarianNavigation.setVisible(false);
            login=false;
             lib_login_alarm_lab.setText("");
        }
        else if(event.getSource()==lib_neg_exit){
            lib_neg_lab.setVisible(false);
            login=false;
            
        }
        

    }
    
    @FXML
    private AnchorPane librarianNavigation;
    
    @FXML
    private Pane lib_neg_lab;
    
    
    @FXML
    void librarianButtonAction(ActionEvent event) {
       if(!login){
           lib_neg_lab.setVisible(true);
         //librarianNavigation.setVisible(true);
         login=true;
       }
    }
    
    int jlb = 0;
    int slb = 0;
    
    @FXML
    void seniorLibButtonAction(ActionEvent event){
        slb = 1;
        librarianNavigation.setVisible(true);
        lib_neg_lab.setVisible(false);
    }
    @FXML
    private TextField e_b_nameFeild;
    
    @FXML
    private TextField e_b_typeFeild;
    
    @FXML
    private TextField e_b_idFeild;
    
    @FXML
    private TextField e_b_selfnoFeild;
    @FXML
    private Label book_include_noti_lab;
    
    ObservableList<Book>BookList = FXCollections.observableArrayList();
    
    @FXML
    void bookAddButtonAction(ActionEvent event){
        jlb1.canAddBook(BookList,e_b_nameFeild.getText(), e_b_idFeild.getText(), e_b_typeFeild.getText(), Integer.parseInt(e_b_selfnoFeild.getText()));
        book_include_noti_lab.setText("Adding Book Successful!!!");
    }
    
    
    @FXML
    void juniorLibButtonAction(ActionEvent event){
        jlb = 1;
        librarianNavigation.setVisible(true);
        lib_neg_lab.setVisible(false);
    }
    @FXML
    private TextField lib_username_field;

    @FXML
    private PasswordField lib_password_field;
    
    @FXML
    private Label lib_login_alarm_lab;
    
    
    @FXML
    void librarianLoginAction(ActionEvent event) {     ///          librarian log in function call
        try{
        if(slb == 1 && !slb1.getLib_block_status() && slb1.canlogin(slb1, lib_username_field.getText(), lib_password_field.getText())){
            SlbHomePane.setVisible(true);
        }
        else if(jlb ==1 && !jlb1.getLib_block_status() && jlb1.canlogin(jlb1, lib_username_field.getText(), lib_password_field.getText())){
            librarianafterloginancorepane.setVisible(true);
            librarianNavigation.setVisible(false);
            lib_login_alarm_lab.setText("");
        }
        else if(slb == 1 && slb1.getLib_block_status()){
            lib_login_alarm_lab.setText("Account Blocked!!!");
        }
        else if(jlb == 1 && jlb1.getLib_block_status()){
            lib_login_alarm_lab.setText("Account Blocked");
            
        }
        else{
            lib_login_alarm_lab.setText("Wrong Entry! Try again!!!");
        }
        
        } catch(Exception e){
            lib_login_alarm_lab.setText("Something wrong! Try again!!!");
        }
    }
    
    @FXML
    void librarianLogoutButtonAction(ActionEvent event) {
        slb = 0;
        jlb = 0;
    librarianafterloginancorepane.setVisible(false);
    studentinfopane.setVisible(false);
    borrowbookpane.setVisible(false);
    submissionbookpane.setVisible(false);
    settingpane.setVisible(false);
    login=false;
    }
    
        @FXML
    private AnchorPane studentinfopane;

    @FXML
    private AnchorPane borrowbookpane;

    @FXML
    private AnchorPane submissionbookpane;

    @FXML
    private AnchorPane settingpane;
    
    @FXML
    private Label s_u_name_lab;
    @FXML
    private Label s_u_pass_lab;
    @FXML
    private Label s_u_type_lab;
    @FXML
    private Label s_u_borrbook_lab;
    @FXML
    private Label s_u_subdatebook_lab;
    @FXML
    private Label s_u_fine_lab;
    
    int found = 0;
    
    @FXML
    void studentinfoButtonAction(ActionEvent event) {
        studentinfopane.setVisible(true);
        borrowbookpane.setVisible(false);
        submissionbookpane.setVisible(false);
        settingpane.setVisible(false);
        found = 0;
        for(Student liststd : stdList){
            if(jlb1.seeStdInformation(liststd,jlbsearchstdusernameField.getText())==1){
                s_u_name_lab.setText(liststd.getSTD_USERNAME());
                s_u_pass_lab.setText(liststd.getSTD_PASSWORD());
                s_u_type_lab.setText(liststd.getSTD_TYPE());
                s_u_borrbook_lab.setText(liststd.slbinfo.getStdbookname());
                s_u_subdatebook_lab.setText(liststd.slbinfo.getStdbooksubdate());
                s_u_fine_lab.setText(Double.toString(liststd.getDue()));  
            }
            else if(jlb1.seeStdInformation(liststd,jlbsearchstdusernameField.getText())==2){
                s_u_name_lab.setText(liststd.getSTD_USERNAME());
                 s_u_pass_lab.setText(liststd.getSTD_PASSWORD());
                s_u_type_lab.setText(liststd.getSTD_TYPE());
                s_u_borrbook_lab.setText(liststd.slbinfo.getStdbookname());
                s_u_subdatebook_lab.setText(liststd.slbinfo.getStdbooksubdate());
                 s_u_fine_lab.setText(Double.toString(liststd.getDue()));
            }
        }
        
        
        /*for(Student liststd : stdList){
        if(jlbsearchstdusernameField.getText().equals(liststd.getSTD_USERNAME()) && liststd.getSTD_TYPE().equals("local")){
         s_u_name_lab.setText(liststd.getSTD_USERNAME());
         s_u_pass_lab.setText(liststd.getSTD_PASSWORD());
         s_u_type_lab.setText(liststd.getSTD_TYPE());
         s_u_borrbook_lab.setText(liststd.slbinfo.getStdbookname());
         s_u_subdatebook_lab.setText(liststd.slbinfo.getStdbooksubdate());
         s_u_fine_lab.setText("null");
        }
        else if(jlbsearchstdusernameField.getText().equals(liststd.getSTD_USERNAME()) && liststd.getSTD_TYPE().equals("foreigen")){
         s_u_name_lab.setText(liststd.getSTD_USERNAME());
         s_u_pass_lab.setText(liststd.getSTD_PASSWORD());
         s_u_type_lab.setText(liststd.getSTD_TYPE());
         s_u_borrbook_lab.setText(liststd.slbinfo.getStdbookname());
         s_u_subdatebook_lab.setText(liststd.slbinfo.getStdbooksubdate());
         s_u_fine_lab.setText("null");
            
        }
        
        }*/
        
        
    }
    @FXML
    void borrowbookButtonAction(ActionEvent event) {
        studentinfopane.setVisible(false);
        borrowbookpane.setVisible(true);
        submissionbookpane.setVisible(false);
        settingpane.setVisible(false);
    }

    @FXML
    void submissionbookButtonAction(ActionEvent event) {
        studentinfopane.setVisible(false);
        borrowbookpane.setVisible(false);
        submissionbookpane.setVisible(true);
        settingpane.setVisible(false);
        bookSubmNotiLab.setText("");
       
        for(Student liststd : stdList){
        if(jlbsearchstdusernameField.getText().equals(liststd.getSTD_USERNAME()) && liststd.getSTD_TYPE().equals("local")){

         subboookname_lab.setText(liststd.slbinfo.getStdbookname());
         subboookid_lab.setText(liststd.slbinfo.getStdbooksubdate());
         
        }
        else if(jlbsearchstdusernameField.getText().equals(liststd.getSTD_USERNAME()) && liststd.getSTD_TYPE().equals("foreigen")){
         subboookname_lab.setText(liststd.slbinfo.getStdbookname());
         subboookid_lab.setText(liststd.slbinfo.getStdbooksubdate());
         
            
        }
        
        }
    }
    
    
    @FXML
    void settingButtonAction(ActionEvent event) {
        studentinfopane.setVisible(false);
        borrowbookpane.setVisible(false);
        submissionbookpane.setVisible(false);
        settingpane.setVisible(true);
    }
    @FXML
    private Label borrow_b_noti_lab;
    @FXML
    private TextField borrowbookFeild;
    
    @FXML
    private TextField setbooksubmissionField;
    
    @FXML
    private TextField jlbsearchstdusernameField;
    
    int hh;
    int ll = 0;
    
    @FXML
    void borrow_b_ButtonAction(ActionEvent event){
        
      for(Student sl : stdList){
          if( jlb1.giveBook(sl, jlbsearchstdusernameField.getText()) ==1 && sl.getSTD_TYPE().equals("local")){
              for(Book bk :BookList){
                  if(bk.getBookid().equals(borrowbookFeild.getText())){
                  sl.slbinfo.setStdbookname(bk.getBookname());
                  sl.slbinfo.setStdbooksubdate(setbooksubmissionField.getText());
                  borrow_b_noti_lab.setText("Lent successful!!!");
                  sl.setAccountstatus("NULL");
                  ll = 1;
                  }
              }
              
              hh=1;
              if(ll == 0){
                  borrow_b_noti_lab.setText("BookId Not Found!");
              }
              else
              {
                 ll=0; 
              }
              
          }
          
          else if(jlb1.giveBook(sl, jlbsearchstdusernameField.getText()) ==2 && sl.getSTD_TYPE().equals("foreigen")){
              
              for(Book bk :BookList){
                  if(bk.getBookid().equals(borrowbookFeild.getText())){
                    sl.slbinfo.setStdbookname(bk.getBookname());
                  sl.slbinfo.setStdbooksubdate(setbooksubmissionField.getText());
                  borrow_b_noti_lab.setText("Lent successful!!!");
                  ll = 1;  
                  }
                  
              }
              
              hh=1;
              
              if(ll == 0){
                  borrow_b_noti_lab.setText("BookId Not Found!");
              }
              else
              {
                 ll=0; 
              }
          }
          
      }
      
      if(hh==0){
         borrow_b_noti_lab.setText("Add Not Successful!!"); 
      }
        
        
    }
    
    @FXML
    private Label jlbstdsearrchnoti_lab;
    
    int ff;
     @FXML
    void std_uname_sreh_FieldButtonAction(ActionEvent event) {
        jlbstdsearrchnoti_lab.setText("");
        ff = 0;

    }
    
    
    int gg = 1;
    @FXML
    void jlbsearchButtonAction(ActionEvent event){                                       // jlb search std account
        
        if(jlb1.searchStudent(stdList,jlbsearchstdusernameField.getText())==1){
          jlbstdsearrchnoti_lab.setText("Account Found!!!");  
        }
        else{
          jlbstdsearrchnoti_lab.setText("Account Not Found!!!"); 
        }
        /*for(Student liststd : stdList){
        if(jlbsearchstdusernameField.getText().equals(liststd.getSTD_USERNAME()) && liststd.getSTD_TYPE().equals("local")){
           jlbstdsearrchnoti_lab.setText("Account Found!!!");
           ff = 1;
           //gg = 0;
         
        }
        else if(jlbsearchstdusernameField.getText().equals(liststd.getSTD_USERNAME()) && liststd.getSTD_TYPE().equals("foreigen")){
            jlbstdsearrchnoti_lab.setText("Account Found!!!");
          ff = 1;
         // gg = 0;
            
        }
        
        }
        
        if(ff==0){
            jlbstdsearrchnoti_lab.setText("Account Not Found!!!");
        }
        else{
           ff = 0;
        }*/
    }
    @FXML
    private Label subboookname_lab;
    
    @FXML
    private Label subboookid_lab;
    
    @FXML
    private Label bookSubmNotiLab;
    
    
    @FXML
    void clrstdbookhisButtonAction(ActionEvent event){
       
        for(Student liststd : stdList){
            
        if(jlb1.canTakeBookReturn(liststd, jlbsearchstdusernameField.getText()) ==1){

         subboookname_lab.setText("Clear");
         subboookid_lab.setText("Clear");
         liststd.slbinfo.setStdbookname("NULL");
         liststd.slbinfo.setStdbooksubdate("NULL");
         bookSubmNotiLab.setText("History Clear!!!");
         found = 1;
        }
        else if(jlb1.canTakeBookReturn(liststd, jlbsearchstdusernameField.getText()) ==2){
         subboookname_lab.setText("Clear");
         subboookid_lab.setText("Clear");
         liststd.slbinfo.setStdbookname("NULL");
         liststd.slbinfo.setStdbooksubdate("NULL");
          bookSubmNotiLab.setText("History Clear!!!");
         found = 1;
            
        }
        
        
        } 
        
        if(found==0){
            bookSubmNotiLab.setText("UserName Not Found!!!");
        }
        
    }
    
    @FXML
    private Label sal_lab;
    
    @FXML
    private Label b_lab;
    
    @FXML
    private Label exit_lab;
    @FXML
    private Pane jlbsalpane;
    
    
    @FXML
    void jlbSalaryButtonAction(ActionEvent event){
        System.out.println("ok");
        jlb1.calculateSalary();
        jlb1.calculateBonus();
        jlbsalpane.setVisible(true);
        sal_lab.setText(Double.toString(jlb1.salary));
        b_lab.setText(Double.toString(jlb1.bonus));
    }
    
    // seniorlb control design start
      @FXML
    private TextField b_name_field;
       @FXML
    private TextField b_type_field;
        @FXML
    private TextField b_id_field;
         @FXML
    private TextField b_selfno_field;
    
         @FXML
    private Label seni_sub_con_noti_lab;
    
         @FXML
    void SeniorLbButtonAction(ActionEvent event){
        slb1.canAddBook(BookList,b_name_field.getText(), b_id_field.getText(), b_type_field.getText(), Integer.parseInt(b_selfno_field.getText()));
        //System.out.println("hhjjfdj");
        //slb1.canAddBook(BookList, b_name_field.getText(), b_type_field.getText(), b_id_field.getText(),Integer.parseInt(b_selfno_field.getText()));
        //System.out.println("hhjjfdj");
        seni_sub_con_noti_lab.setText("Add Sucessful!!");
        //System.out.println(b_name_field.getText() +" "+b_type_field.getText()+" "+b_id_field.getText()+" "+b_selfno_field.getText());
    }
    
     @FXML
    private Pane SlbHomePane;
     
     @FXML
    private Pane slbsalarypane;
     
      @FXML
    private Pane slbaddbookpane;
     
     
     
     @FXML
    private Label t_s_lab;
     
     @FXML
    private Label e_b_lab;
    
     @FXML
    private TableView<Student> slbTable;

    @FXML
    private TableColumn<Student,String> slbtabun;

    @FXML
    private TableColumn<Student,String> slbtabpass;

    @FXML
    private TableColumn<Student,String> slbtabdue;
    
    @FXML
    void SlbSalButAction(ActionEvent event){
        slbsalarypane.setVisible(true);
         slbTable.setVisible(false);
         slbaddbookpane.setVisible(false);
         //jlb1.calculateSalary();
         //jlb1.calculateBonus();
         slb1.calculateSalary();
         slb1.calculateBonus();
         t_s_lab.setText(Double.toString(slb1.salary));
         e_b_lab.setText(Double.toString(slb1.bonus));
    }
    
    @FXML
    void SlbLogoutButAction(ActionEvent event){
        if(slb1.canLogOut()){
        SlbHomePane.setVisible(false);
        slbsalarypane.setVisible(false);
         slbTable.setVisible(false);
         slbaddbookpane.setVisible(false);
         
        }
    }
    @FXML
    void SlbViewButAction(ActionEvent event){
        slbsalarypane.setVisible(false);
         slbTable.setVisible(true);
         slbaddbookpane.setVisible(false);
         slbTable.setItems(FXCollections.observableArrayList(slb1.seestdInf(stdList)));
        slbTable.getItems().clear();
         slbTable.getItems().addAll(slb1.seestdInf(stdList));
        slbtabun.setCellValueFactory(new PropertyValueFactory<>("std_username"));
        slbtabpass.setCellValueFactory(new PropertyValueFactory<>("std_password"));
        slbtabdue.setCellValueFactory(new PropertyValueFactory<>("std_type"));
    }
    @FXML
    void SlbAddBookButAction(ActionEvent event){
        slbsalarypane.setVisible(false);
         slbTable.setVisible(false);
         slbaddbookpane.setVisible(true);
    }
    
    
    
    
    
      // librarian design control ..........end 
    
    
    // Accountant design control start from..........
  
    @FXML
    private JFXButton log;
    
    @FXML
    private Label accountantNavigationExit1;
    
        @FXML
    void accountantNavigationExit(MouseEvent event) {
        if(event.getSource()==accountantNavigationExit1){
          accountantNavigation.setVisible(false);
             login=false;  
        }

    }
    @FXML
    private AnchorPane accountantNavigation;
    
    @FXML
    void accountantButtonAction(ActionEvent event) {
        
        if(!login){
             accountantNavigation.setVisible(true);
             login=true;
             acc_login_noti_lab.setText("");
        }

    }
    @FXML
    private Label a_l_c_lab;
    @FXML
    private Label a_d_c_lab;
    @FXML
    private Label p_s_n_lab;
    @FXML
    private Label a_u_c_lab;
    @FXML
    private TextField acc_u_n_field;
    @FXML
    private TextField a__d_field;
    @FXML
    private Label acc_std_typ;
    
    @FXML
    private TextField p_d_a_field;
    
    int kk;
    
    @FXML
    void accSearchButtonAction(ActionEvent event){
        if(acant.searchStudent(stdList,acc_u_n_field.getText())==1){
            for(Student s : stdList){
                if(s.getSTD_USERNAME().equals(acc_u_n_field.getText())){
                 p_s_n_lab.setText("User Found!!");
                acc_std_typ.setText(s.getSTD_TYPE());
                a_l_c_lab.setText(Double.toString(s.getDue()) + " BDT");
                }
            }
        }
        else{
             p_s_n_lab.setText("User Not Found!!");
        }
        
       /* for(Student std : stdList){
            if(std.getSTD_USERNAME().equals(acc_u_n_field.getText())){
               p_s_n_lab.setText("User Found!!");
                kk=1;
                acc_std_typ.setText(std.getSTD_TYPE());
                a_l_c_lab.setText(Double.toString(std.getDue()) + " BDT");
                
            }
            
        } 
        if(kk!=1){
           p_s_n_lab.setText("User Not Found!!");  
        }
        else{
            kk=0;
        }*/
          
       }
    
    
    @FXML
    void accsubButtonAction(ActionEvent event){
        
       if(p_d_a_field.getText().equals("500")){
           if(acant.canPayStdDue(stdList,acc_u_n_field.getText())==1){   //             pay due function        
                p_s_n_lab.setText("Due Paid Sucessful");
             }
           else{
                p_s_n_lab.setText("Account Not Founf!!");
           }
           }
       else{
           p_s_n_lab.setText("Entry Due Not Match!");
       }
        /*for(Student std : stdList){
            if(std.getSTD_USERNAME().equals(acc_u_n_field.getText())){
                 
                 if(p_d_a_field.getText().equals("500")){
                     std.setDue(0.0);
                 p_s_n_lab.setText("Due Paid Sucessful");
                 
                 }
                 else{
                     p_s_n_lab.setText("Entry Due Not Match!");
                 }
                
            }
            
        } */
        
    }
    
    @FXML
    private AnchorPane accountantafterloginpane;
    
    @FXML
    private Label acc_login_noti_lab;
    @FXML
    private TextField acc_usernamefield;
    @FXML
    private TextField acc_passwordfield;
    
    @FXML
    void accountantLoginButtonAction(ActionEvent event) {
        
        if(acc_usernamefield.getText().equals(acant.getAcc_name()) && acc_passwordfield.getText().equals(acant.getAcc_pass()) ){
       accountantNavigation.setVisible(false); 
     accountantafterloginpane.setVisible(true);
        }
        else{
            acc_login_noti_lab.setText("Wrong Entry!!!");
        }
    }
    
    @FXML
    void accountantSignoutButtonAction(ActionEvent event) {
     accountantafterloginpane.setVisible(false);
     login=false;
    }
    
    
    // Accountant design control ..........end 
    
    
    // Authority design control start from..........
    
    
    @FXML
    private AnchorPane authorityNavigation;
    
    @FXML
    private Pane aut_neg_lab;
    
    @FXML
    void authorityButtonAction(ActionEvent event) {
        if(!login){
            aut_neg_lab.setVisible(true);
         //authorityNavigation.setVisible(true);
         login=true;
        }
        
       }
    
    
    
    
    @FXML
    private Pane librarianSettingPane;

    @FXML
    private Pane studentSettingPane;


    @FXML
    private Pane accountantSettingPane;
    
    
    @FXML
    void authorityStudentButton(ActionEvent event) {
        librarianSettingPane.setVisible(false);
        studentSettingPane.setVisible(true);
        accountantSettingPane.setVisible(false);

    }

    @FXML
    void authoritylibrarianButton(ActionEvent event) {
        librarianSettingPane.setVisible(true);
        studentSettingPane.setVisible(false);
        accountantSettingPane.setVisible(false);

    }
    @FXML
    void authorityAccountanttButton(ActionEvent event) {
        librarianSettingPane.setVisible(false);
        studentSettingPane.setVisible(false);
        accountantSettingPane.setVisible(true);

    }
    
     @FXML
    void adminButtonAction(ActionEvent event) {
        authorityNavigation.setVisible(true);
        aut_neg_lab.setVisible(false);

    }
    
    @FXML
    void authorityLogoutButtonAction(ActionEvent event) {
    authorityNavigation.setVisible(false);
    acc_u_p_set_pane.setVisible(false);
    acc_noti_lab.setText("");
    
    login=false;
    
    }
    
    @FXML
    private Pane controller_home_pane;
    
     @FXML
    void counsellerButtonAction(ActionEvent event) {
        controller_home_pane.setVisible(true);
        aut_neg_lab.setVisible(false);

    }
    
    @FXML
    void controllerLogoutButtonAction(ActionEvent event) {
        controller_home_pane.setVisible(false);
        login=false;

    }
    
    @FXML
    private Pane finance_m_Home_pane;

    @FXML
    void financeManagerButtonAction(ActionEvent event) {
        finance_m_Home_pane.setVisible(true);
        aut_neg_lab.setVisible(false);

    }
    
     @FXML
    void financeMangLogoutButtonAction(ActionEvent event) {
        finance_m_Home_pane.setVisible(false);
        login=false;

    }
    
    
    @FXML
    private Label aut_neg_exit_lab;

    
     @FXML
    void act3(MouseEvent event) {
        if(event.getSource()==aut_neg_exit_lab){
            aut_neg_lab.setVisible(false);
            login=false;
        }

    }
    
    
        //LB_setting ontrol start from here
    
    @FXML
    private Pane lb_block_acc_pane;
    
    @FXML
    private Pane view_lb_p_u_pane;
    
    @FXML
    private Pane set_u_p_lb_pane;
    
    @FXML
    private Label juniorLb_acc_status_lab;
    
    @FXML
    private Label seniorLb_acc_status_lab;
    
    @FXML
    private Label view_u_p_noti_lab;
    
    
     @FXML
    void block_lb_ButtonAction(ActionEvent event) {
        view_u_p_noti_lab.setText("");
        lb_block_acc_pane.setVisible(true);
        view_lb_p_u_pane.setVisible(false);
        set_u_p_lb_pane.setVisible(false);
       try{
        if(!slb1.getLib_block_status()){
            seniorLb_acc_status_lab.setText("Unblock");
            
        }
        else{
            seniorLb_acc_status_lab.setText("Blocked");
        }
        if(!jlb1.getLib_block_status()){
           juniorLb_acc_status_lab.setText("Unblock");
        }
        else{
            juniorLb_acc_status_lab.setText("Blocked");
        }
        
       } catch(Exception e){
           
           System.out.println(e);
       }

    }
    @FXML
    private JFXRadioButton seniorLb_block_tog;
    @FXML
    private JFXRadioButton juniorLb_block_tog;
    @FXML
    private JFXRadioButton seniorLb_unblock_tog;
    @FXML
    private JFXRadioButton juniorLb_unblock_tog;
    
    @FXML
    void lb_block_ButtonAction(ActionEvent event){
     
        try{
        if(seniorLb_block_tog.isSelected()){
            slb1.setLib_block_status(true);
            
        }
        else if(juniorLb_block_tog.isSelected()){
            jlb1.setLib_block_status(true);
        }
        else{
            System.out.println("sorry not selected");
        }
        
        } catch(Exception e){
            System.out.println(e);
        }
        
        
        try{
        if(!slb1.getLib_block_status()){
            seniorLb_acc_status_lab.setText("Unblock");
            
        }
        else{
            seniorLb_acc_status_lab.setText("Blocked");
        }
        if(!jlb1.getLib_block_status()){
           juniorLb_acc_status_lab.setText("Unblock");
        }
        else{
            juniorLb_acc_status_lab.setText("Blocked");
        }
        
       } catch(Exception e){
           
           System.out.println(e);
       }
        
    }
    
    @FXML
    void lb_unblock_ButtonAction(ActionEvent event){
        if(seniorLb_unblock_tog.isSelected()){
            slb1.setLib_block_status(false);
            
        }
        else if(juniorLb_unblock_tog.isSelected()){
            jlb1.setLib_block_status(false);
        }
        else{
            System.out.println("sorry not selected");
        }
        
        try{
        if(!slb1.getLib_block_status()){
            seniorLb_acc_status_lab.setText("Unblock");
            
        }
        else{
            seniorLb_acc_status_lab.setText("Blocked");
        }
        if(!jlb1.getLib_block_status()){
           juniorLb_acc_status_lab.setText("Unblock");
        }
        else{
            juniorLb_acc_status_lab.setText("Blocked");
        }
        
       } catch(Exception e){
           
           System.out.println(e);
       }
        
    }
    
    @FXML
    private Label slb_u_view_lab;
    
    @FXML
    private Label jlb_u_view_lab;
    
    @FXML
    private Label slb_p_view_lab;
    
    @FXML
    private Label jlb_p_view_lab;
    
    
     @FXML
    void view_u_p_ButtonAction(ActionEvent event) {
        try{
        slb_u_view_lab.setText(slb1.getLib_u_name());
        slb_p_view_lab.setText(slb1.getLib_p_word());
        jlb_u_view_lab.setText(jlb1.getLib_u_name());
        jlb_p_view_lab.setText(jlb1.getLib_p_word());
        
        }catch(Exception e){
            view_u_p_noti_lab.setText("Account Not Found!!!");
            
        }
        lb_block_acc_pane.setVisible(false);
        view_lb_p_u_pane.setVisible(true);
        set_u_p_lb_pane.setVisible(false);

    }
     @FXML
    void set_u_p_ButtonAction(ActionEvent event) {
        view_u_p_noti_lab.setText("");
        lb_block_acc_pane.setVisible(false);
        view_lb_p_u_pane.setVisible(false);
        set_u_p_lb_pane.setVisible(true);

    }
    
     @FXML
    private JFXRadioButton set_seniorLb_radio_id;

    @FXML
    private JFXRadioButton set_juniorLb_radio_id;

    @FXML
    private TextField set_lb_u_name_field;

    @FXML
    private TextField set_lb_p_word_field;
    
    SeniorLibrarian slb1;
    JuniorLibrarin jlb1;
    
    @FXML
    private Label set_lb_u_p_noti_lab;
    
    Admin ad = new Admin("Ali","as3455");
    
    
     @FXML
    void set_u_p_submitButtonAction(ActionEvent event) {
        
        if(set_seniorLb_radio_id.isSelected()){
            slb1 = ad.canCreateSeniorLbaccount(set_lb_u_name_field.getText(),set_lb_p_word_field.getText());
            //slb1 = new SeniorLibrarian(set_lb_u_name_field.getText(),set_lb_p_word_field.getText());
            set_lb_u_p_noti_lab.setText("Submission Successful!!!");
        }
        
        else if(set_juniorLb_radio_id.isSelected()){
            jlb1 = ad.canCreateJuniorLbaccount(set_lb_u_name_field.getText(), set_lb_p_word_field.getText());
            //jlb1 = new JuniorLibrarin(set_lb_u_name_field.getText(),set_lb_p_word_field.getText());
            set_lb_u_p_noti_lab.setText("Submission Successful!!!");
        }
        
        else{
            set_lb_u_p_noti_lab.setText("Submission Not Successful!!!");
        }
        

    }
    
    
    
    
        //LB_setting ontrol end here
    
    
    @FXML
    private Label acc_noti_lab;

    @FXML
    private TextField set_acc_usernamefield;
    @FXML
    private TextField set_acc_passfield;
    
    @FXML
    private Pane acc_u_p_set_pane;
    
    Accountant acant;
    
    @FXML
    void adminsetacc_u_pButtonAction(ActionEvent event){
        
        acant = ad.canCreateAccountantId(set_acc_usernamefield.getText(),set_acc_passfield.getText());
       //acant = new Accountant(set_acc_usernamefield.getText(),set_acc_passfield.getText());
       acc_noti_lab.setText("Set Sucessful!!");
    }
    
    @FXML
    void accetting_u_p_Buttonaction(ActionEvent event){
        acc_u_p_set_pane.setVisible(true);

    }
      
    
     @FXML
    private TableView<CommentStdInfo> StdCommentTable;

    @FXML
    private TableColumn<CommentStdInfo, String> CommentStdUserName;

    @FXML
    private TableColumn<CommentStdInfo, String> commentstdComment;
    
    
    
    ObservableList<CommentStdInfo> cstdinfo;
    Counsellor cs;
    

    @FXML
    void CommentStdListButtonAction(ActionEvent event) {
        for(CommentStdInfo f : cstdinfo){
            System.out.println(f.getCscomment());
        }
        System.out.println("hi");
       cs.canCreateCommentStdList(stdList,cstdinfo);
           
       if(cs.canSeeCommentStdInfo(cstdinfo) ==1){
           StdCommentTable.setItems(FXCollections.observableArrayList(cstdinfo));
        StdCommentTable.getItems().clear();
        StdCommentTable.getItems().addAll(cstdinfo);
        CommentStdUserName.setCellValueFactory(new PropertyValueFactory<>("csname"));
        commentstdComment.setCellValueFactory(new PropertyValueFactory<>("cscomment"));
           
       }
       
    }                                                                           // see std comment function
    
    @FXML
    private TableView<DueStdList> finestdtable;

    @FXML
    private TableColumn<DueStdList,String> finestdusernameclumn;

    @FXML
    private TableColumn<DueStdList, String> finestdduecolumn;
    
    @FXML
    private Label TotalDueStdNoLab;
    
     @FXML
    private Label TotalDueStdLab;
     
     int fstdtotal = 0;
     double totaldue = 0.0;
     
     FinanceManager fn = new FinanceManager("kamal","GH98","Junior");
       ObservableList<DueStdList> duestdinfo = FXCollections.observableArrayList();
    
    @FXML
    void DueStudentListButtonAction(ActionEvent event){
        int fstdtotal = 0;
        double totaldue = 0.0;
        
        //for(Student s : stdList){
            //System.out.println(s.getStd_username() + " " + s.getDue());
            //System.out.println(s.slbinfo.getStdbooksubdate());
        //}
          fn.canCalculateStdDue(stdList);
          fn.canCreateStdDueinfoList(stdList,duestdinfo);
       /* for(Student stdl : stdList){
         
            if("17/12/01".compareTo(stdl.slbinfo.getStdbooksubdate()) > 0 && stdl.getAccountstatus().equals("NULL")  ){
                stdl.setDue(500.0);
                stdl.setAccountstatus("NO");
                fstdtotal++;
                totaldue = totaldue + 500.0;
            }
            
            else if(stdl.getDue()==500.0) {
                
                
            }
            
            else{
                stdl.setDue(0.0);
            }
            
            if(stdl.getDue() == 500.0){
               fstdtotal++;
               totaldue = totaldue + 500.0;
              
           }
        }
        */
        
        finestdtable.setItems(FXCollections.observableArrayList(duestdinfo ));
        finestdtable.getItems().clear();
         finestdtable.getItems().addAll(duestdinfo);
        finestdusernameclumn.setCellValueFactory(new PropertyValueFactory<>("uname"));
        finestdduecolumn.setCellValueFactory(new PropertyValueFactory<>("sdue"));
        TotalDueStdNoLab.setText(Integer.toHexString(fn.canCountDueStdNo(stdList)));
        TotalDueStdLab.setText(Double.toString(fn.canCalculateTotalDue(stdList)));
        
        
        
        
    }
        
    
      // Authority design control ..........end 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*for(Student stdl : stdList){
            if("01/12/17".compareTo(stdl.slbinfo.getStdbooksubdate())<0 && "01/12/17".compareTo(stdl.slbinfo.getStdbooksubdate())> -21){
                stdl.setDue(500.0);
                
            }
            else{
                stdl.setDue(0.0);
            } 
        }
           */
       // System.out.println("30/10/17".compareTo("01/12/17"));
       cs = new Counsellor("Faruq","VHG564");
       cstdinfo = FXCollections.observableArrayList();
       fstd = new ForeigenStudent("","","");
       lstd = new LocalStudent("","","");
       lif= new StdInFo("","","","",0.0);
       
    }    
    
}