package clickableLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import selectuser.*;
public class CustomClickableLabel extends CustomLabel {
    private Class<?> targetClass; // Class parameter for dynamic instantiation

    public CustomClickableLabel(String text, Color color, int size) {
        super(text);
        setFont(new Font("Arial", Font.ITALIC, size));
        setForeground(color); // Set text color
    }

    public void addClickListener(JFrame frame,UserSelection parentPanel, Class<?> targetClass) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					Object instance = targetClass.getDeclaredConstructor(JFrame.class).newInstance(frame);
					parentPanel.setVisible(false); // Hide the parent panel
					frame.getContentPane().remove(parentPanel); // Remove the parent panel from the frame
					frame.getContentPane().add((JPanel) instance); // Add the RegisterController panel to the frame
					frame.revalidate();
					frame.repaint();
				} catch (Exception ex) {
					ex.printStackTrace();
					// Handle instantiation failure
				}
			}
		});
	}
	
	    @Override
    public void setLabelBounds(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }
}
