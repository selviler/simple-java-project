package view;

import business.UserController;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_title;
    private JPanel pnl_bottom;
    private JTextField txt_email;
    private JButton btn_login;
    private JLabel lbl_email;
    private JLabel lbl_password;
    private JPasswordField txt_password;

    private UserController userController;

    public LoginUI() {
        this.userController = new UserController();

        this.add(container);
        this.setTitle("Library Book Management");
        this.setSize(400, 400);
        this.setVisible(true);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);
        this.btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] check = {txt_email, txt_password};
                if (!Helper.isEmailValid(txt_email.getText())) {
                    Helper.showMsg("Please enter a valid email");
                } else if (Helper.isFieldListEmpty(check)) {
                    Helper.showMsg("fiil");
                }else{

                    System.out.println(txt_email.getText());
                    System.out.println(txt_password.getText());
                    User user = userController.findByLogin(txt_email.getText(), txt_password.getText());
                    if (user == null){
                        Helper.showMsg("User not found according to the information you entered");
                    }else{
                        dispose();
                        DashboardUI dashboardUI = new DashboardUI(user);
                        System.out.println("burada");
//                        System.out.println(user.toString());
                    }
                }



            }
        });
    }
}
