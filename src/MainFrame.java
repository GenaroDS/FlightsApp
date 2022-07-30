import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    JTextField tfFirstName;
    final private Font mainFont = new Font ("Segoe print", Font.BOLD, 18);


    public void initialize(){
        /* First panel */
        JLabel lbFirstName = new JLabel("First Name");
        lbFirstName.setFont(mainFont);
        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);


        /* Main panel */
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());



        setTitle("FlightsApp");
        setSize(500,500);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
