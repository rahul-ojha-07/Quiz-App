package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{
    JButton backButton, startButton;
    String username;
    Rules(String username){
        this.username = username;
        setBounds(600, 200, 750, 650);
        getContentPane().setBackground(Utils.backgroundBlack);
        setLayout(null);
        setResizable(false);

        JLabel titleLabel = new JLabel("Welcome " + username + ", to Java Quiz");
        titleLabel.setForeground(Utils.titleColor);
        titleLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 28));
        titleLabel.setBounds(150, 20, 700, 30);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        add(titleLabel);
        
        JLabel rulesLabel= new JLabel("");
        rulesLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        rulesLabel.setBounds(80, 50, 600, 500);
        rulesLabel.setForeground(Utils.textColor);
        rulesLabel.setText(
            "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>"
        );
        add(rulesLabel);
        
        backButton = new JButton("Back");
        backButton.setBounds(250, 550, 100, 30);
        backButton.setBackground(Utils.buttonColor);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        backButton.setForeground(Utils.buttonTextColor);
        backButton.addActionListener(this);
        add(backButton);
        
        startButton = new JButton("Start");
        startButton.setBounds(400, 550, 100, 30);
        startButton.setBackground(Utils.buttonColor);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        startButton.setForeground(Utils.buttonTextColor);
        startButton.addActionListener(this);
        add(startButton);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == backButton){
            this.setVisible(false);
            new JavaQuiz().setVisible(true);
        }else if(ae.getSource() == startButton){
            this.setVisible(false);
            new Quiz(username).setVisible(true);
        }
    }
// TODO: create a test method
    public static void main(String[] args){
        new Rules("Rahul");
    }
}
