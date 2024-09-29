package view;

import business.BookController;
import core.Helper;
import entity.Book;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DashboardUI extends JFrame {

    private JPanel container;
    private JPanel pnl_top;
    private JButton btn_exit;
    private JLabel lbl_one;
    private JTabbedPane tab_menu;
    private JPanel pnl_customer;
    private JScrollPane scrl_customer;
    private JTable tbl_books;
    private JTextField txt_name;
    private JComboBox cmbx_type;
    private JButton btn_search;
    private JButton btn_clear;
    private JButton btn_add;
    private JPanel top_jpnl;
    private JButton btn_delete;
    private User user;
    private BookController bookController;
    private DefaultTableModel table_book = new DefaultTableModel();
    private JPopupMenu popup_book = new JPopupMenu();


    public DashboardUI(User user) {
        this.user = user;
        this.bookController = new BookController();
        if (user == null){
            Helper.showMsg("error");
            dispose();
        }

        this.add(container);
        this.setTitle("Book Management");
        this.setSize(1000, 500);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);

        this.setVisible(true);

        this.lbl_one.setText("Welcome " + this.user.getName());

        System.out.println(user.toString());

        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginUI loginUI = new LoginUI();
            }
        });


        this.cmbx_type.setModel(new DefaultComboBoxModel<>(Book.Type.values()));

        ArrayList<Book> books = this.bookController.findAll();
        loadBookTable(null);

        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");

                if (tbl_books.getSelectedRow() != -1) {

                    int selectedID = Integer.parseInt(tbl_books.getValueAt(tbl_books.getSelectedRow(), 0).toString());

                    Book book = bookController.findById(selectedID);
                    BookUI bookUI = new BookUI(book);

                    bookUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadBookTable(null);
                        }
                    });
                }else{
                    System.out.println("created");
                    BookUI bookUI = new BookUI(new Book());

                    bookUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadBookTable(null);
                        }
                    });
                }
            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedID = Integer.parseInt(tbl_books.getValueAt(tbl_books.getSelectedRow(), 0).toString());

                if (Helper.confirm("sure")){
                    if (bookController.delete(selectedID)){
                        Helper.showMsg("success");
                        loadBookTable(null);
                    }else{
                        Helper.showMsg("error");
                    }
                }else{
                    Helper.showMsg("error");
                }
            }
        });
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Book> filter = bookController.filter(
                        txt_name.getText(),
                        (Book.Type) cmbx_type.getSelectedItem()
                );

                loadBookTable(filter);
            }
        });
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loadBookTable(null);
                txt_name.setText("");
                cmbx_type.setSelectedIndex(0);
            }
        });
    }

//    private void loadCustomerPopupMenu(){
//
//        this.tbl_books.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                int selectedRow = tbl_books.getSelectedRow(); // Seçilen satırın indeksi
//
//                System.out.println(selectedRow);
//                if (selectedRow != -1) {
//
//                    BookUI bookUI = new BookUI(new Book());
//
//                    // Seçilen satırdaki ID, Ad ve Soyad kolonlarındaki verileri al
//                    Object id = tbl_books.getValueAt(selectedRow, 0);
//                    Object ad = tbl_books.getValueAt(selectedRow, 1);
//                    Object soyad = tbl_books.getValueAt(selectedRow, 2);
//
//                    System.out.println("Seçilen Kayıt: ID = " + id + ", Ad = " + ad + ", Soyad = " + soyad);
//                }
//            }
//        });
//
//    }

    private void loadBookTable(ArrayList<Book> books)
    {
        Object[] columnBook = {"id", "name", "description", "page", "status"};

        if (books == null) {
            books = this.bookController.findAll();
        }

        DefaultTableModel clearModel = (DefaultTableModel) tbl_books.getModel();
        clearModel.setRowCount(0);

        this.table_book.setColumnIdentifiers(columnBook);
        for (Book book : books)
        {
            Object[] rowObject = {
                    book.getId(),
                    book.getName(),
                    book.getDesc(),
                    book.getPage(),
                    book.getStatus()
            };
            this.table_book.addRow(rowObject);
        }

        this.tbl_books.setModel(table_book);
        this.tbl_books.getTableHeader().setReorderingAllowed(false);
        this.tbl_books.getColumnModel().getColumn(0).setMaxWidth(50);
//        this.tbl_books.setEnabled(false);
    }

}
