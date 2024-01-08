package register;


import loginsys.LoginController;
import menu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterController {
    private JFrame frame;
    private RegisterView view;
    private String username;
	private String password;
	private String firstName;
	private String lastName;
	private RegisterModel model;

    public RegisterController(JFrame frame) {
        this.frame = frame;
        this.view = new RegisterView();
		this.model = new RegisterModel(null,null,null,null);
        view.setFrame(frame);
        addRegisterViewToFrame();
		initView();
    }

    public void addRegisterViewToFrame() {
        frame.add(view);
        frame.revalidate();
        frame.repaint();
    }
	
	    private void initView() {
        view.addRegisterActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsername();
                String password = view.getPassword();
				String firstName = view.getFirstName();
				String lastName = view.getLastName();
				model = new RegisterModel(firstName,lastName,username,password);
                boolean exists = model.isUserExist();

                if (!exists) {
                    
                    if(password.equals(view.getConfirmPassword())) {
						model.confirmRegister();
						view.showRegisterSuccessMessage(firstName,lastName);
						view.setVisible(false);
						new MenuController(frame);
					}else{
						view.showInvalidPasswordMessage();
					}
                } else {
                    view.showUsernameAlreadyExistMessage();
                }
            }
        });

 
    }


}
