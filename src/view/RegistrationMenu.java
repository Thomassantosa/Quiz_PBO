package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.QueryController;

public class RegistrationMenu implements ActionListener {
    
    // Declaring variable
    JFrame frame;
    JPanel panel;
    JLabel lLogin, lEmail, lNama, lPassword;
    JTextField tfEmail, tfNama;
    JPasswordField pfPassword;
    JButton btnRegistrasi, btnBack;
    JComboBox cbCategory;

    public RegistrationMenu() {
        
        // Set JFrame
        frame = new JFrame("Registration Menu");
        frame.setSize(900, 550);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\source\\Logo_Splashscreen.png");    
        frame.setIconImage(icon);

        // Set JPanel
        panel = new JPanel();
        panel.setBackground(new Color(254, 245, 237));
        panel.setSize(900, 550);
        panel.setLayout(null);

        // Set components
        // Set JLabel
        lLogin = new JLabel("Registration Menu");
        lLogin.setForeground(new Color(63, 77, 63));
        lLogin.setFont(new Font("Arial", Font.BOLD, 30));
        lLogin.setBounds(85, 20, 450, 40);

        lEmail = new JLabel("Email :");
        lEmail.setForeground(new Color(63, 77, 63));
        lEmail.setFont(new Font("Arial", Font.BOLD, 20));
        lEmail.setBounds(85, 120, 200, 20);

        lNama = new JLabel("Email :");
        lNama.setForeground(new Color(63, 77, 63));
        lNama.setFont(new Font("Arial", Font.BOLD, 20));
        lNama.setBounds(85, 220, 200, 20);

        lPassword = new JLabel("Password :");
        lPassword.setForeground(new Color(63, 77, 63));
        lPassword.setFont(new Font("Arial", Font.BOLD, 20));
        lPassword.setBounds(85, 320, 200, 20);

        // Set JTextField
        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        tfEmail.setBounds(200, 110, 250, 40);

        tfNama = new JTextField();
        tfNama.setFont(new Font("Arial", Font.PLAIN, 20));
        tfNama.setBounds(200, 210, 250, 40);

        // Set JPasswordField
        pfPassword = new JPasswordField();
        pfPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        pfPassword.setBounds(200, 310, 250, 40);

        // Set JButton
        btnRegistrasi = new JButton("Login");
        btnRegistrasi.setBackground(new Color(173, 194, 169));
        btnRegistrasi.setForeground(new Color(63, 77, 63));
        btnRegistrasi.setBounds(100, 400, 150, 60);
        btnRegistrasi.setFont(new Font("Arial", Font.BOLD, 20));
        
        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(173, 194, 169));
        btnBack.setForeground(new Color(63, 77, 63));
        btnBack.setBounds(300, 400, 150, 60);
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));

        btnRegistrasi.addActionListener(this);
        btnBack.addActionListener(this);

        // Set JComboBox
        QueryController queryController = new QueryController();
        ArrayList<String> categories = queryController.getCategoryUser();  
        String[] categoryList = new String[3];
        for (int i = 0; i < categories.size(); i++) {
            categoryList[i] = categories.get(i);
        } 
        cbCategory = new JComboBox(categoryList); 
        cbCategory.setBounds(300, 210,90,20);
        cbCategory.setVisible(true);    

        // Adding components
        panel.add(lLogin);
        panel.add(lEmail);
        panel.add(lNama);
        panel.add(lPassword);
        panel.add(tfEmail);
        panel.add(tfNama);
        panel.add(pfPassword);
        panel.add(cbCategory);
        panel.add(btnRegistrasi);
        panel.add(btnBack);
        frame.setContentPane(panel);

        // Set vicibility
        panel.setVisible(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "Registrasi":
                System.out.println("ON PROGRESS");
                // User user = new User(idUser, name, email, password, idCategory);
                // frame.dispose();
                break;
            case "Back":
                new MainMenu();
                frame.dispose();
                break;
            default: 
                break;
        }
    }
}
