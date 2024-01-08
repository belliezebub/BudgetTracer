import javax.swing.*;
import java.awt.event.*;
import selectuser.*;

public class Main {
    public static void main(String[] args) {
		ImageIcon budgetIcon = new ImageIcon("budgetTracer.png");
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Budget Tracker");
			frame.setIconImage(budgetIcon.getImage());
            frame.setSize(1000, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           

            UserSelection user = new UserSelection(frame); // Pass both instances
            frame.add(user);
            frame.setVisible(true);
        });
    }
}