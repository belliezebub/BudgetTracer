package creation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;




class BudgetsCreationView extends JPanel{
	private JTextField filenameField;
	private JTextField budgetField;
	private JTextField tagField;
	private JTextField budgetAllocField;
	private JTable table;
	private JComboBox<String> tagsCombo ;
	private JLabel balanceLabel;	
	private JLabel unallocatedBudgetLabel;
	private JButton addTagButton;	
	private JButton createButton;
	private JButton cancelButton;
	private JButton addBudgetButton;
	private JButton addAllocation;
	private double balance;
	private double budgetAllocated;	
	
	private double unallocatedBudget;

	public BudgetsCreationView(){
		setLayout(null);
		setBackground(Color.decode("#475C7A"));
		JPanel tagPanel= new JPanel();
		tagPanel.setBounds(50,220,350,300);
		add(tagPanel);
		
		JPanel budgetAllocPanel= new JPanel();
		budgetAllocPanel.setBounds(510,220,400,300);
	
		add(budgetAllocPanel);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Tags");
        model.addColumn("Allocated Amount");
		
		JScrollPane scrollPane = new JScrollPane(table);
		budgetAllocPanel.add(scrollPane);
		
		
		String[] options = {"Select Tags", "Meal Expenses"};
		tagsCombo = new JComboBox<>(options);
		tagsCombo.setBounds(510,130,400,30);
		add(tagsCombo);
		
		budgetAllocField = new JTextField("Amount to allocate");
		budgetAllocField.setBounds(510,170,300,30);
		add(budgetAllocField);
		
		
	
		
		balanceLabel= new JLabel("Balance: "+balance);
		balanceLabel.setBounds(510,90,200,30);
		add(balanceLabel);
		
		
		JLabel unallocatedBudgetLabel = new JLabel("Unallocated Budget: "+unallocatedBudget);
		unallocatedBudgetLabel.setBounds(730,90,200,30);
		add(unallocatedBudgetLabel);
		
		addTagButton= new JButton("ADD");
		addTagButton.setBounds(320,130,80,30);
		add(addTagButton);
		
		filenameField= new JTextField(20);
		filenameField.setBounds(50,50,350,30);
		filenameField.setText("FILENAME");
		add(filenameField);
		
		budgetField= new JTextField();
		budgetField.setBounds(510,50,300,30);
		budgetField.setText("BUDGET");
		add(budgetField);
		
		tagField = new JTextField(20);
		tagField.setBounds(50,130,250,30);
		tagField.setText("ADD TAGS");
		add(tagField);
		
		addAllocation = new JButton("ADD");
		addAllocation.setBounds(830,170,80,30);
		add(addAllocation);
		
		addBudgetButton = new JButton("ADD");
		addBudgetButton.setBounds(830,50,80,30);
		add(addBudgetButton);
		
		
		createButton = new JButton("CREATE");
		createButton.setBounds(810,580,100,30);
		add(createButton);
		
		cancelButton = new JButton("CANCEL");
		cancelButton.setBounds(680,580,100,30);
		add(cancelButton);
		
		
		focusListener(filenameField,"FILENAME");
		focusListener(budgetField,"BUDGET");
		focusListener(tagField,"ADD TAGS");
		focusListener(budgetAllocField,"Amount to allocate");
		
		addBudgetButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(validateAmount(budgetField.getText())){
					
					unallocatedBudget=+balance;
					unallocatedBudgetLabel.setText("Unallocated Buget: "+String.format("%.2f", unallocatedBudget));
					unallocatedBudgetLabel.setForeground(Color.WHITE);
					balanceLabel.setText("Balance: "+String.format("%.2f", balance));
					balanceLabel.setForeground(Color.WHITE);
					budgetField.setText(null);  
					
				}else{
				JOptionPane.showMessageDialog(null,"Invalid Input: Make sure no other characters entered!");
				}
			}
		});
		
		
		addAllocation.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(validateAmount(budgetAllocField.getText())){
					
					unallocatedBudgetLabel.setText("Balance: "+String.format("%.2f", unallocatedBudget));
					budgetAllocField.setText(null);  
					
				}else{
				JOptionPane.showMessageDialog(null,"Invalid Input: Make sure no other characters entered!");
				}
			}
		});
		
    }
	
	public boolean validateAmount(String text) {
    try {
        double amount = Double.parseDouble(text);
        balance = amount; // Update the balance with the parsed amount
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

	
	
	
	public void focusListener(JTextField field,String text){
		        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String filename = field.getText();
                if (filename.equals(text)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String filename = field.getText();
                if (filename.isEmpty()) {
                    field.setText(text);
                    field.setForeground(Color.GRAY);
                }
            }
        });
	}
	
	
	public String getFilenameField(){
		return filenameField.getText();
	}
	
	public String getTagField(){
		return tagField.getText();
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public JButton getAddAllocation(){
		return this.addAllocation;
	}
	
	public JButton getAddBudgetButton(){
		return this.addBudgetButton;
	}
	
	public JButton getCreateButton(){
		return this.createButton;
	}
	
	public JButton getCancelButton(){
		return this.cancelButton;
	}
	
	

}