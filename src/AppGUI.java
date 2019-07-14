import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI extends JFrame {
    private JButton myButton;
    private JTextArea myTextArea;
    private JPanel rootPanel;
    private JButton exitButton;
    int numberClicked;
    public AppGUI(){
        numberClicked = 0;
        add(rootPanel); // This uses the form designer form
        setTitle("First App");
        setSize(400,400);
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numberClicked+=1;
                myTextArea.setText("Great you have clicked the button"+String.valueOf(numberClicked));
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(1);
            }
        });
    }
}
