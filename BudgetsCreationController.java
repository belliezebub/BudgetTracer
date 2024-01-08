package creation;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import menu.*;

public class BudgetsCreationController{
	private BudgetsCreationView view;
	private BudgetsCreationModel model;
	private String filename;
	private String tag;
	private String budgetAllocated;
	private double balance;
	private JFrame frame;
	
	public BudgetsCreationController(JFrame frame){
		this.model= new BudgetsCreationModel();
		this.view= new BudgetsCreationView();
		this.frame = frame;
		addBudgetCreationViewToFrame();
		initView();
	}
	public void addBudgetCreationViewToFrame(){
        frame.add(view);
    }
	
	public void initView(){
		this.filename= view.getFilenameField();
		view.getCreateButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			
				if(model.checkFileNameExists(view.getFilenameField())){
					JOptionPane.showMessageDialog(null,"ERROR: FILENAME ALREADY EXIST");
				}else{
					if(model.createFile(view.getFilenameField())){
						JOptionPane.showMessageDialog(null,"Buget File Successfully Created!");
					}else{
						JOptionPane.showMessageDialog(null,"Unknown Error: Please retry your action!");
					}
				}
			}
		});
		
		view.getCancelButton().addActionListener(new ActionListener(){
			@Override
			
			public void actionPerformed(ActionEvent e){
				model.cancelCreation(view.getFilenameField());
				view.setVisible(false);
				new MenuController(frame);
			}
		});
		
		  
		
	}






}