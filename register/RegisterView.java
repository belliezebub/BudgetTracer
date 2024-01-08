package register;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import loginsys.LoginController;

class RegisterView extends JPanel{
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton cancelRegisterButton;
    private String alert;
	private JFrame frame;

    public RegisterView(){
        setLayout(null);
        setBackground(new Color(71,92,122));

        JLabel registerLabel = new JLabel("     Create an account");
        registerLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
        registerLabel.setForeground(Color.WHITE);
        registerLabel.setBounds(264, 40, 800, 50);
        add(registerLabel);

        JLabel firstnameLabel = new JLabel("First Name");
        firstnameLabel.setFont(new Font("Monospaced Plain", Font.PLAIN, 15));
        firstnameLabel.setForeground(Color.WHITE);
        firstnameLabel.setBounds(400, 110, 100, 20);
        add(firstnameLabel);

        JTextField firstnameField = new JTextField();
        firstnameField.setBounds(400, 140, 250, 40);
        add(firstnameField);

        JLabel lastnameLabel = new JLabel("Last Name");
        lastnameLabel.setFont(new Font("Monospaced Plain", Font.PLAIN, 15));
        lastnameLabel.setForeground(Color.WHITE);
        lastnameLabel.setBounds(400, 180, 100, 20);
        add(lastnameLabel);

        JTextField lastnameField = new JTextField();
        lastnameField.setBounds(400, 210, 250, 40);
        add(lastnameField);

        JLabel usernameRegisterLabel = new JLabel("Username");
        usernameRegisterLabel.setFont(new Font("Monospaced Plain", Font.PLAIN, 15));
        usernameRegisterLabel.setForeground(Color.WHITE);
        usernameRegisterLabel.setBounds(400, 250, 100, 20);
        add(usernameRegisterLabel);

        JTextField usernameRegisterField = new JTextField();
        usernameRegisterField.setBounds(400, 280, 250, 40);
        add(usernameRegisterField);

        JLabel passwordRegisterLabel = new JLabel("Password");
        passwordRegisterLabel.setFont(new Font("Monospaced Plain", Font.PLAIN, 15));
        passwordRegisterLabel.setForeground(Color.WHITE);
        passwordRegisterLabel.setBounds(400, 320, 100, 20);
        add(passwordRegisterLabel);

        JPasswordField passwordRegisterField = new JPasswordField();
        passwordRegisterField.setBounds(400, 350, 250, 40);
        add(passwordRegisterField);

        JLabel confirmPasswordRegisterLabel = new JLabel("Confirm Password");
        confirmPasswordRegisterLabel.setFont(new Font("Monospaced Plain", Font.PLAIN, 15));
        confirmPasswordRegisterLabel.setForeground(Color.WHITE);
        confirmPasswordRegisterLabel.setBounds(400, 390, 200, 20);
        add(confirmPasswordRegisterLabel);

        JPasswordField confirmPasswordRegisterField = new JPasswordField();
        confirmPasswordRegisterField.setBounds(400, 420, 250, 40);
        add(confirmPasswordRegisterField);



        JButton registerButton = new JButton("REGISTER");
         registerButton.setFont(new Font("Arial", Font.BOLD, 15));
        registerButton.setBackground(new Color(252, 187, 109));
        registerButton.setBounds(400, 500, 250, 40);  
        add(registerButton);

        cancelRegisterButton = new JButton("CANCEL");
        cancelRegisterButton.setFont(new Font("Arial", Font.BOLD, 15));
        cancelRegisterButton.setBackground(new Color(252, 187, 109));
        cancelRegisterButton.setBounds(400, 560, 250, 40);  
        add(cancelRegisterButton);
		cancelRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Container parent = RegisterView.this.getParent();
			parent.remove(RegisterView.this); // Remove current RegisterView panel

			// Assuming LoginController is responsible for displaying the login panel
			// Create a LoginController instance and display the login panel
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(parent);
			if (frame != null) {
				frame.getContentPane().removeAll(); // Remove all components from the frame
				new LoginController(frame); // Show the login panel using LoginController
				frame.revalidate();
				frame.repaint();
				}
			}
		});

    }

    public void addCancelActionListener(ActionListener listener) {
        cancelRegisterButton.addActionListener(listener);
    }

	public void setFrame(JFrame frame){
		this.frame = frame;
	}
    public void addRegisterActionListener(ActionListener listener) {
        registerButton.addActionListener(listener);
    }

    public String getName() {
        return firstnameField.getText();
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
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