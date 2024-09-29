package core;

import javax.swing.*;

public class Helper {

    public static void setTheme()
    {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fields)
    {
        for (JTextField field : fields){
            if (isFieldEmpty(field)){
                return true;
            }
        }
        return false;
    }

    public static boolean isEmailValid(String email)
    {
        if (email == null || email.trim().isEmpty())
        {
            return false;
        }

        if (!email.contains("@"))
        {
            return false;
        }

        String[] parse = email.split("@");

        if (parse.length != 2){
            return false;
        }

        if (parse[0].trim().isEmpty() || parse[1].trim().isEmpty())
        {
            return false;
        }

        if (!parse[1].contains("."))
        {
            return false;
        }
        return true;
    }

    public static void showMsg(String message)
    {
        String msj = "";
        String title = "";

        switch (message){
            case "fiil":
                msj = "Please fill in all fields";
                title = "Error";
                break;
            case "done":
                msj = "Operation successful";
                title = "Result";
                break;
            case "error":
                msj = "An error occurred";
                title = "Error";
                break;
            default:
                msj = message;
                title = "Message";
        }
        JOptionPane.showMessageDialog(null, msj, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String str)
    {
        String msg;

        if (str.equals("sure")){
            msg = "Are you sure ?";
        }else{
            msg = str;
        }

        return JOptionPane.showConfirmDialog(null,msg,"Are you sure?",JOptionPane.YES_NO_CANCEL_OPTION) == 0;
    }
}
