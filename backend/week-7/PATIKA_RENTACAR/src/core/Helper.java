package core;

import javax.swing.*;
import java.awt.*;

import static java.nio.file.Files.size;

public class Helper {
    public static void setTheme() {
        optionPaneTr();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void showMsg(String str) {

        String msg;
        String title;
        switch (str) {
            case "fill":
                msg = "Lütfen tüm alanları doldurunuz";
                title = "HATA!";
                break;
            case "done":
                msg = "İşlem başarılı.";
                title = "Sonuç:";
                break;
            case "notFound":
                msg = "Kayıt bulunamadı";
                title = "Bulunamadı.";
                break;
            case "error":
                msg = "Hatalı kayıt yaptınız.";
                title = "Hata!";
                break;
            default:
                msg = str;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String str){

        String msg;
        if(str.equals("sure")){
            msg = "Bu işlemi yapmak istediğinize emin misiniz?";
        }else{
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null, msg,"Emin misin?", JOptionPane.YES_NO_OPTION) == 0;
    }

    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }

    public static void optionPaneTr(){
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");

    }
}
