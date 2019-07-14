import javax.swing.*;

public class Main {
    public static Database db = new Database();
    public static void main(String[] args) throws Exception{
        //db.connect();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){

        }
        AppGUI app =new AppGUI();
        app.setVisible(true);
    }
}
