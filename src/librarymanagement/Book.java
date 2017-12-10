
package librarymanagement;

public class Book {
    private String bookname;
    private String bookid;
    private String booktype;
    private int bookselfno;

    public Book(String bookname, String bookid, String booktype, int bookselfno) {
        this.bookname = bookname;
        this.bookid = bookid;
        this.booktype = booktype;
        this.bookselfno = bookselfno;
    }

    public String getBookname() {
        return bookname;
    }

    public String getBookid() {
        return bookid;
    }

    public String getBooktype() {
        return booktype;
    }

    public int getBookselfno() {
        return bookselfno;
    }
    
    
    
    
    
}
