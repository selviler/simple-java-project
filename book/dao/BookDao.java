package dao;

import core.Database;
import entity.Book;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {

    private Connection connection;

    public BookDao() {
        this.connection = Database.getInstance();
    }

    public ArrayList<Book> findAll(){
        ArrayList<Book> books = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM book");
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setDesc(rs.getString("description"));
                book.setPage(rs.getString("page"));
                book.setStatus(Book.Type.valueOf(rs.getString("status")));
                books.add(book);
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return books;
    }

    public Book findById(int id){
        Book book = new Book();

        String query = "SELECT * FROM book WHERE id = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setDesc(rs.getString("description"));
                book.setPage(rs.getString("page"));
                book.setStatus(Book.Type.valueOf(rs.getString("status")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    public boolean save(Book book)
    {
        String query = "INSERT INTO book (name, description, page, status) VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, book.getName());
            pr.setString(2, book.getDesc());
            pr.setString(3, book.getPage());
            pr.setString(4, book.getStatus().toString());
            return pr.executeUpdate() != -1;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Book book){
        String query = "UPDATE book SET name = ?, description = ?, page = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, book.getName());
            pr.setString(2, book.getDesc());
            pr.setString(3, book.getPage());
            pr.setString(4, book.getStatus().toString());
            pr.setInt(5, book.getId());
            return pr.executeUpdate() != -1;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int id)
    {
        String query = "DELETE FROM book WHERE id = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Book> query(String query)
    {
        ArrayList<Book> books = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery(query);
            while (rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setDesc(rs.getString("description"));
                book.setPage(rs.getString("page"));
                book.setStatus(Book.Type.valueOf(rs.getString("status")));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
