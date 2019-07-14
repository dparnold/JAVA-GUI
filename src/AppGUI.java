import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AppGUI extends JFrame {
    private JButton myButton;
    private JTextArea myTextArea;
    private JPanel rootPanel;
    private JButton exitButton;
    private JTextField textField;
    int numberClicked;
    String textArea = "";

    public void mybuttonPressed(){
        numberClicked+=1;
        textArea = textArea+"Great you have added the value \""+textField.getText()+"\" to the database with the "+String.valueOf(numberClicked)+". transaction.\n";
        myTextArea.setText(textArea);
        textField.setText("");
        textField.requestFocusInWindow();
    }
    public AppGUI(){
        numberClicked = 0;
        add(rootPanel); // This uses the form designer form
        setTitle("First App");
        setSize(400,400);

        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mybuttonPressed();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(1);
            }
        });

        // Automatically entering the value if "enter" is pressed
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mybuttonPressed();
            }
        });
    }
}
