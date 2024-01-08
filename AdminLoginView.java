package loginsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import selectuser.*;

class AdminLoginView extends JPanel {
	private	JButton	loginButton;
	private	JButton backButton;
	private	JPasswordField passwordField;
	private String iconPath;
	
    public AdminLoginView(JFrame frame) {
        iconPath = "admin.png"; // Setting the icon path for admin login

        setLayout(null);
        setBackground(new Color(71, 92, 122));

        ImageIcon originalIcon = new ImageIcon(iconPath);
        Image originalImage = originalIcon.getImage();
        int desiredWidth = 200;
        int desiredHeight = 200;
        BufferedImage resizedImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.drawImage(originalImage, 0, 0, desiredWidth, desiredHeight, null);
        g2.dispose();
        ImageIcon icon = new ImageIcon(resizedImage);

        JLabel userLabel = new JLabel(icon);
        userLabel.setBounds(420, 50, 200, 200);
        add(userLabel);

        

        // Adjust the position of other components
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Monospaced Plain", Font.PLAIN, 25));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(455, 250, 200, 40);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
        passwordField.setBounds(400, 300, 250, 40);
		add(passwordField);
		
		loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setBackground(new Color(252, 187, 109));
        loginButton.setBounds(400, 380, 250, 40);
        add(loginButton);
        
		backButton = new JButton("Back");
		backButton.setFont(new Font("Arial", Font.BOLD, 15));
		backButton.setBackground(Color.WHITE);
        backButton.setBounds(400, 440, 250, 40);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container parent = getParent();
                parent.remove(AdminLoginView.this);

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(parent);
                if (frame != null) {
                    frame.getContentPane().removeAll();
                    UserSelection panel = new UserSelection(frame);
					panel.addUserSelectionToFrame(frame);
                    frame.revalidate();
                    frame.repaint();
                }
            }
        });
		add(backButton);
    }

    // Overriding methods to match the behavior of AdminLogin
    
    public String getUsername() {
        // AdminLogin does not have a username field, so return empty string
        return "Admin";
    }

	public String getPasswords() {
        char[] pass =passwordField.getPassword();
        String input = new String(pass);
        return input;
    }
	
    public void addLoginActionListener(ActionListener listener) {
        // AdminLogin uses getPasswordField() instead of passwordField
		loginButton.addActionListener(listener);
    }
    
	 public void showLoginSuccessMessage() {
        JOptionPane.showMessageDialog(null, "Login successful!");
    }

    public void showInvalidPasswordMessage() {
        JOptionPane.showMessageDialog(null, "Invalid password.");
    }
    // Other overridden methods as needed for AdminLogin-specific behavior

}