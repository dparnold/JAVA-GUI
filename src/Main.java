import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception{
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){

        }
        AppGUI app =new AppGUI();
        app.setVisible(true);
    }
}
