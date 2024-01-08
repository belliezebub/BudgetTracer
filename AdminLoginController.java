package loginsys;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import menu.*;
import register.RegisterController;

public class AdminLoginController {
    private AdminLoginView view;
    private LoginModel model;
    private JFrame frame;
    private MenuController menu;
    private RegisterController register;
	
	

     public AdminLoginController(JFrame frame) {
        this.view = new AdminLoginView(frame);
        this.model = new LoginModel();
        
        
        this.frame = frame;
        addLoginViewToFrame();
        initView();
    }

    private void addLoginViewToFrame() {
        frame.add(view);
        frame.revalidate();
        frame.repaint();
    }

    private void initView() {
        view.addLoginActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsername();
                String password = view.getPasswords();

                boolean exists = model.getIsUserExist(username);

                if (exists) {
					
                    boolean validPassword = model.validatePassword(password);
                    if (validPassword) {
                        view.showLoginSuccessMessage();
                        view.setVisible(false);
                        new MenuController(frame);

                    } else {
                        view.showInvalidPasswordMessage();
                    }
                }
            }
        });

 
    }
}