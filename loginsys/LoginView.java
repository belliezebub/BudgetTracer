package loginsys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import selectuser.*;
import java.awt.image.BufferedImage;
import clickableLabel.*;
import register.*;
class LoginView extends JPanel {
    private JButton loginButton;
    private JButton cancelRegisterButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
	private String iconPath;
    public LoginView(JFrame frame){
       
        
      
        setLayout(null);
        setBackground(new Color(71,92,122));
        iconPath="emplo.png";
		ImageIcon originalIcon = new ImageIcon(iconPath);
		Image originalImage = originalIcon.getImage();
		int desiredWidth = 150; // Change this to your desired width
        int desiredHeight = 150; // Change this to your desired height
		BufferedImage resizedImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.drawImage(originalImage, 0, 0, desiredWidth, desiredHeight, null);
        g2.dispose();
		ImageIcon icon = new ImageIcon(resizedImage);
		
		JLabel userLabel = new JLabel(icon);
		userLabel.setBounds(450,50,150,150);
		add(userLabel);
		
    
        JLabel enterUserNameLabel = new JLabel("Username");
        enterUserNameLabel.setFont(new Font("Monospaced Plain", Font.PLAIN, 25));
        enterUserNameLabel.setForeground(Color.WHITE);
        enterUserNameLabel.setBounds(400, 200, 200, 40);
        add(enterUserNameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.ITALIC, 15));
        usernameField.setBounds(400, 240, 250, 40);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Monospaced Plain", Font.PLAIN, 25));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(400, 280, 200, 40);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.ITALIC, 15));
        passwordField.setBounds(400, 320, 250, 40);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setBackground(new Color(252, 187, 109));
        loginButton.setBounds(400, 380, 250, 40);
        add(loginButton);

		
		
		cancelRegisterButton = new JButton("CANCEL");
        cancelRegisterButton.setFont(new Font("Arial", Font.BOLD, 15));
        cancelRegisterButton.setBackground(Color.WHITE);
        cancelRegisterButton.setBounds(400, 450, 250, 40);  
        add(cancelRegisterButton);
		cancelRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Container parent = LoginView.this.getParent();
			parent.remove(LoginView.this); // Remove current RegisterView panel

			// Assuming LoginController is responsible for displaying the login panel
			// Create a LoginController instance and display the login panel
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(parent);
			if (frame != null) {
				frame.getContentPane().removeAll(); // Remove all components from the frame
				UserSelection panel = new UserSelection(frame); // Show the login panel using LoginController
				panel.addUserSelectionToFrame(frame);
				frame.revalidate();
				frame.repaint();
				}
			}
		});
    }


    public void addLoginActionListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

 

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPasswords() {
        char[] pass =passwordField.getPassword();
        String input = new String(pass);
        return input;
    }

    public void showLoginSuccessMessage() {
        JOptionPane.showMessageDialog(null, "Login successful!");
    }

    public void showInvalidPasswordMessage() {
        JOptionPane.showMessageDialog(null, "Invalid password.");
    }

    public void showUsernameNotExistMessage() {
        JOptionPane.showMessageDialog(null, "Username doesn't exist.");
    }
}


