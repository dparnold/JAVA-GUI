import javax.swing.*;
import java.awt.*;

public class MainWindow {
    JFrame f;
    Dimension d;
    MainWindow() {
        f = new JFrame();//creating instance of JFrame
        JButton b = new JButton("Enter Data");//creating instance of JButton
        b.setBounds(130, 100, 100, 40);

        f.add(b);//adding button in JFrame

        f.setSize(400, 500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setAlwaysOnTop(true);

        d=new Dimension();
        d.setSize(200,200);
        f.setMinimumSize(d);

    }
    public static void main(String[] args) {
        new MainWindow();
    }
}