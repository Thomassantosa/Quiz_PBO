package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

// import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.QueryController;
import model.User;

public class LoginMenu implements ActionListener{
    
    // Declaring variable
    JFrame frame;
    JPanel panel;
    JLabel lLogin, lEmail, lPassword;
    JTextField tfEmail;
    JPasswordField pfPassword;
    JButton btnLogin, btnBack;

    public LoginMenu() {

        // Set JFrame
        frame = new JFrame("Login Menu");
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
        lLogin = new JLabel("Login Menu");
        lLogin.setForeground(new Color(63, 77, 63));
        lLogin.setFont(new Font("Arial", Font.BOLD, 30));
        lLogin.setBounds(85, 20, 450, 40);

        lEmail = new JLabel("Email :");
        lEmail.setForeground(new Color(63, 77, 63));
        lEmail.setFont(new Font("Arial", Font.BOLD, 20));
        lEmail.setBounds(85, 120, 200, 20);

        lPassword = new JLabel("Password :");
        lPassword.setForeground(new Color(63, 77, 63));
        lPassword.setFont(new Font("Arial", Font.BOLD, 20));
        lPassword.setBounds(85, 220, 200, 20);

        // Set JTextField
        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        tfEmail.setBounds(200, 110, 250, 40);

        // Set JPasswordField
        pfPassword = new JPasswordField();
        pfPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        pfPassword.setBounds(200, 210, 250, 40);

        // Set JButton
        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(173, 194, 169));
        btnLogin.setForeground(new Color(63, 77, 63));
        btnLogin.setBounds(100, 400, 150, 60);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
        
        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(173, 194, 169));
        btnBack.setForeground(new Color(63, 77, 63));
        btnBack.setBounds(300, 400, 150, 60);
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));

        btnLogin.addActionListener(this);
        btnBack.addActionListener(this);

        // Adding components
        panel.add(lLogin);
        panel.add(lEmail);
        panel.add(lPassword);
        panel.add(tfEmail);
        panel.add(pfPassword);
        panel.add(btnLogin);
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
            case "Login":
                System.out.println("TEST 1");

                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());
                if (email.equals("") && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all field !");
                } else {
                    QueryController queryController = new QueryController();
                    User user = queryController.getUser(email, password);
                    if (user == null) {
                        JOptionPane.showMessageDialog(null, "User not found");
                    } else {
                        System.out.println(user.toString());
                    }
                }
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
