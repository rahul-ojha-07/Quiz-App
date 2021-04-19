package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaQuiz extends JFrame implements ActionListener{
    
    JButton rulesButton, exitButton;
    JTextField textField;
    JavaQuiz(){
        setBounds(500, 300, 800, 500);
        setResizable(false);
        getContentPane().setBackground(Utils.backgroundBlack);
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/java.png"));
        Image image = icon.getImage()
                .getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel iconLabel = new JLabel(imageIcon);
        iconLabel.setBounds(30, 100, 256, 256);
        add(iconLabel);
        
        JLabel titleLabel = new JLabel("Java Quiz");
        titleLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        titleLabel.setForeground(Utils.titleColor);
        titleLabel.setBounds(300, 30, 300, 45);
        add(titleLabel);
        
        JLabel nameLabel = new JLabel("Enter Your Name");
        nameLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        nameLabel.setForeground(Utils.title2Color);
        nameLabel.setBounds(430, 150, 300, 20);
        add(nameLabel);
        
        textField = new JTextField();
        textField.setBounds(340, 190, 400, 40);
        textField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(BorderFactory.createEmptyBorder());
        add(textField);
        
        rulesButton = new JButton("Rules");
        rulesButton.setBounds(400, 250, 120, 35);
        rulesButton.setBackground(Utils.buttonColor);
        rulesButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        rulesButton.setForeground(Utils.buttonTextColor);
        rulesButton.setFocusPainted(false);
        rulesButton.setBorderPainted(false);
        rulesButton.setBorder(BorderFactory.createEmptyBorder());
        rulesButton.addActionListener(this);
        add(rulesButton);
        
        exitButton = new JButton("Exit");
        exitButton.setBounds(550, 250, 120, 35);
        exitButton.setBackground(Utils.buttonColor);
        exitButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        exitButton.setForeground(Utils.buttonTextColor);
        exitButton.setFocusPainted(false);
        exitButton.setBorderPainted(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.addActionListener(this);
        add(exitButton);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == rulesButton){
            String name = textField.getText();
            this.setVisible(false);
            new Rules(name);
        }else{
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new JavaQuiz();
    }
    
}
