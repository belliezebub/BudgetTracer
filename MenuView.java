package menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class MenuView extends JPanel {
    private JButton createButton;
    private JButton budgetsRepositoryButton;
    private JButton editUserButton;
    private JButton accountSettingsButton;

    public MenuView() {
        setBackground(new Color(0X475C7A));
        setLayout(null);

        createButton = new JButton("CREATE");
        createButton.setFont(new Font("KANIT", Font.BOLD, 30));
        createButton.setBounds(240, 90, 300, 70);
        createButton.setBackground(new Color(0XFCBB6D));
        add(createButton);

        budgetsRepositoryButton = new JButton("BUDGET REPOSITORY");
        budgetsRepositoryButton.setFont(new Font("KANIT", Font.BOLD, 23));
        budgetsRepositoryButton.setBounds(240, 190, 300, 70);
        budgetsRepositoryButton.setBackground(new Color(0XFCBB6D));
        add(budgetsRepositoryButton);

        editUserButton = new JButton("Edit User's Access");
        editUserButton.setFont(new Font("KANIT", Font.BOLD, 27));
        editUserButton.setBounds(240, 290, 300, 70);
        editUserButton.setBackground(new Color(0XFCBB6D));
        add(editUserButton);

        accountSettingsButton = new JButton("Account Settings");
        accountSettingsButton.setFont(new Font("KANIT", Font.BOLD, 30));
        accountSettingsButton.setBounds(240, 390, 300, 70);
        accountSettingsButton.setBackground(new Color(0XFCBB6D));
        add(accountSettingsButton);
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JButton getBudgetsRepositoryButton() {
        return budgetsRepositoryButton;
    }

    public JButton getEditUserButton() {
        return editUserButton;
    }

    public JButton getAccountSettingsButton() {
        return accountSettingsButton;
    }
}