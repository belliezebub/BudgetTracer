package clickableLabel;

import javax.swing.*;
import java.awt.*;


abstract class CustomLabel extends JLabel {
    public CustomLabel(String text) {
        super(text);
        setForeground(Color.WHITE); // Set default text color
        setFont(new Font("Arial", Font.ITALIC, 20));
    }

    // Abstract method for setting bounds
    public abstract void setLabelBounds(int x, int y, int width, int height);
}
