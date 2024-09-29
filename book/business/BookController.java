package business;

import core.Helper;
import dao.BookDao;
import entity.Book;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class BookController {
    private final BookDao bookDao = new BookDao();

    public ArrayList<Book> findAll() {
        return this.bookDao.findAll();  
    }

    public boolean save(Book book) {
        return this.bookDao.save(book);
    }

    public Book findById(int id) {
        return this.bookDao.findById(id);
    }

    public boolean update(Book book) {

        if (this.findById(book.getId()) == null) {
            Helper.showMsg("ID ERROR");
            return false;
        }
        return this.bookDao.update(book);
    }

    public boolean delete(int id) {

        if (this.findById(id) == null) {
            Helper.showMsg("ID ERROR");
            return false;
        }

        return this.bookDao.delete(id);
    }

    public ArrayList<Book> filter(String name, Book.Type type){
        String query = "Select * from book";
        ArrayList<String> where = new ArrayList<>();

        if (name.length() > 0){
            where.add("name LIKE '%" + name + "%'");
        }

        if (type != null){
            where.add("status = '" + type + "'");
        }

        if (where.size() > 0)
        {
            String whereQuery = String.join(" and ", where);
            query += " where " + whereQuery;
        }

        return this.bookDao.query(query);

    }
}
