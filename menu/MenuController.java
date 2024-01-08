package menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import creation.*;

public class MenuController {
    //private MenuModel model;
    private MenuView view;
    private JFrame frame;
    public MenuController(JFrame frame) {
      
        this.view = new MenuView();
        this.frame = frame;
        addMenuToFrame();
		initView();

    /*    // Add action listeners for buttons
        view.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "CREATE" button click
                JOptionPane.showMessageDialog(view.getFrame(), "Create button clicked!");
            }
        });
*/
     /*   view.getBudgetsRepositoryButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "BUDGET REPOSITORY" button click
                new RepositoryController(frame);
            }
        });
*/
      /*  view.getEditUserButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "Edit User's Access" button click
                
				
            }
        });

        */
    }



    public void addMenuToFrame(){

        frame.add(view);
        frame.revalidate();
        frame.repaint();
    }
	
	public void initView(){
		view.getCreateButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				view.setVisible(false);
				new BudgetsCreationController(frame);
			}
		});
	}
}
 // Add this closing brace
/*
// Main Application Class
public class MenuApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuModel model = new MenuModel();
            MenuView view = new MenuView(model);
            MenuController controller = new MenuController(model, view);
        });
    }
}*/