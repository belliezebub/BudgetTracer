package selectuser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import loginsys.*;
import register.*;
import clickableLabel.CustomClickableLabel;

public class UserSelection extends JPanel{
	private JButton adminUser;
	private JButton otherUser;
	
	public UserSelection(JFrame frame){
		
		setLayout(null);
		setBackground(new Color(71,92,122));
		
		JLabel greet = new JLabel("Welcome to Budget Tracer");
		greet.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		greet.setForeground(Color.WHITE);
		greet.setBounds(260,50,800,50);
		add(greet);
		
		JLabel signInLabel = new JLabel("Sign in Options: ");
		signInLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		signInLabel.setForeground(Color.WHITE);
		signInLabel.setBounds(400,135,800,50);
		add(signInLabel);
		
		JLabel adminLabel =  new JLabel("Admin");
		adminLabel.setFont(new Font("Arial",Font.ITALIC, 30));
		adminLabel.setForeground(Color.WHITE);
		adminLabel.setBounds(300,200,256,40);
		add(adminLabel);
		
		Icon adminIcon = new ImageIcon("admin.png");
		adminUser = new JButton(adminIcon);
		adminUser.setBackground(new Color(71,92,122));
		adminUser.setBounds(224,260,256,256);
		adminUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				new AdminLoginController(frame);
			}
		});
		
		add(adminUser);
		
		
		
		
		JLabel otherUserLabel =  new JLabel("Other User");
		otherUserLabel.setFont(new Font("Arial",Font.ITALIC, 30));
		otherUserLabel.setForeground(Color.WHITE);
		otherUserLabel.setBounds(580,200,256,40);
		add(otherUserLabel);
		
		Icon otherIcon = new ImageIcon("emplo.png");
		otherUser = new JButton(otherIcon);
		otherUser.setBackground(new Color(71,92,122));
		otherUser.setBounds(524,260,256,256);
		otherUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				new LoginController(frame);
			}
		});
		add(otherUser);
		

		JLabel questionLabel = new JLabel("Doesn't have an account yet?");
		questionLabel.setForeground(Color.WHITE); // Set text color
		questionLabel.setFont(new Font("Arial",Font.ITALIC, 20));
		questionLabel.setBounds(300,600,400,20);
		add(questionLabel);
		

		CustomClickableLabel clickHereLabel = new CustomClickableLabel("Register Here!", Color.BLUE,20);
        clickHereLabel.setLabelBounds(570, 600, 200,20);
		clickHereLabel.addClickListener(frame,this, RegisterController.class); // Assuming LoginView extends JFrame
        add(clickHereLabel);
		
	}
		
		
	public void addUserSelectionToFrame(JFrame frame){
		frame.add(this); // Add UserSelection panel
		frame.revalidate();
		frame.repaint();
	}


}

