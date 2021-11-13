package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainMenu implements ActionListener {
    
    // Declaring variable
    JFrame frame;
    JPanel panel;
    JLabel label ;
    JButton btnLogin, btnRegistrasi, btnSearch, btnExit;

    public MainMenu() {

        // Set JFrame
        frame = new JFrame("Main menu");
        frame.setSize(450, 550);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\image\\Logo_Color.png");  
        frame.setIconImage(icon);

        // Set JPanel
        panel = new JPanel();
        panel.setBackground(new Color(254, 245, 237));
        panel.setSize(450, 550);
        panel.setLayout(null);
        
        // Set Jlabel
        label = new JLabel("Silahkan pilih menu di bawah");
        label.setForeground(new Color(63, 77, 63));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(85, 20, 450, 20);

        // Set components
        // Set JButton
        btnLogin = new JButton("Login Pengguna");
        btnLogin.setBackground(new Color(173, 194, 169));
        btnLogin.setForeground(new Color(63, 77, 63));
        btnLogin.setBounds(70, 80, 300, 60);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
        
        btnRegistrasi = new JButton("Registrasi Pengguna Baru");
        btnRegistrasi.setBackground(new Color(173, 194, 169));
        btnRegistrasi.setForeground(new Color(63, 77, 63));
        btnRegistrasi.setBounds(70, 180, 300, 60);
        btnRegistrasi.setFont(new Font("Arial", Font.BOLD, 20));
        
        btnSearch = new JButton("Lihat Data Pengguna");
        btnSearch.setBackground(new Color(173, 194, 169));
        btnSearch.setForeground(new Color(63, 77, 63));
        btnSearch.setBounds(70, 280, 300, 60);
        btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
        
        btnExit = new JButton("Exit");
        btnExit.setBackground(new Color(173, 194, 169));
        btnExit.setForeground(new Color(63, 77, 63));
        btnExit.setBounds(110, 380, 220, 60);
        btnExit.setFont(new Font("Arial", Font.BOLD, 20));

        btnLogin.addActionListener(this);
        btnRegistrasi.addActionListener(this);
        btnSearch.addActionListener(this);
        btnExit.addActionListener(this);

        // Adding components
        panel.add(label);
        panel.add(btnLogin);
        panel.add(btnRegistrasi);
        panel.add(btnSearch);
        panel.add(btnExit);
        frame.setContentPane(panel);

        // Set vicibility
        frame.setVisible(true);
        panel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "Login Pengguna":
                new LoginMenu();
                frame.dispose();
                break;
            case "Registrasi Pengguna Baru":
                new RegistrationMenu();
                frame.dispose();
                break;
            case "Lihat Data Pengguna":
                new SearchMenu();
                frame.dispose();
                break;
            case "Exit":
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Thankyou for using our app : )");
                System.exit(0);
                break;
            default: 
                break;
        }
    }
}
