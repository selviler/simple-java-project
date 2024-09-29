package view;

import business.BookController;
import business.UserController;
import core.Helper;
import entity.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookUI extends JFrame{
    private JPanel container;
    private JLabel lbl_name;
    private JTextField txt_name;
    private JLabel lbl_description;
    private JTextArea txt_area_description;
    private JLabel lbl_page;
    private JTextField txt_page;
    private JLabel lbl_status;
    private JComboBox<Book.Type> cmbx_status;
    private JButton btn_save;
    private JLabel lbl_process;
    private Book book;
    private BookController bookController;

    public BookUI(Book book) {

        System.out.println(book);
        this.book = book;
        this.bookController = new BookController();
        this.add(container);

        this.setTitle("Book Management");
        this.setSize(300, 500);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);

        this.setVisible(true);

        this.cmbx_status.setModel(new DefaultComboBoxModel<>(Book.Type.values()));


        if(this.book.getId() != 0){
            this.lbl_process.setText("Update");
            this.txt_name.setText(this.book.getName());
            this.txt_area_description.setText(this.book.getDesc());
            this.txt_page.setText(this.book.getPage());
            this.cmbx_status.getModel().setSelectedItem(this.book.getStatus());

        }else{
            this.lbl_process.setText("Create");
        }

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField[] checkList = {txt_name, txt_page};

                if (Helper.isFieldListEmpty(checkList)) {
                    Helper.showMsg("fill");
                }else{
                    boolean result = false;

                    book.setName(txt_name.getText());
                    book.setDesc(txt_area_description.getText());
                    book.setPage(txt_page.getText());
                    book.setStatus((Book.Type) cmbx_status.getSelectedItem());

                    if (book.getId() == 0){
                        result = bookController.save(book);
                    }else{
                        result = bookController.update(book);
                    }
                    if (result){
                        Helper.showMsg("done");
                        dispose();
                    }else{
                        Helper.showMsg("error");
                    }
                }
            }
        });
    }
}
