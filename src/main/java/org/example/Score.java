package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {
    private String username;
    Score(String username, int score) {
        this.username = username;
        setBounds(600, 150, 750, 550);
        getContentPane().setBackground(Utils.backgroundBlack);
        setLayout(null);
        setResizable(false);
        String fileName = "";
        if (score == 0) {
            fileName = "emotional.png";
        } else if (score > 0 && score < 5) {
            fileName = "sad.png";
        } else if (score == 5) {
            fileName = "happy.png";
        } else if (score > 5 && score < 10) {
            fileName = "smile.png";
        } else if (score == 10) {
            fileName = "cool.png";
        }
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/" + fileName));
        Image image = icon.getImage()
                .getScaledInstance(256, 256, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel iconLabel = new JLabel(imageIcon);
        iconLabel.setBounds(80, 150, 256, 256);
        add(iconLabel);

        JLabel titleLabel = new JLabel("Thank You for Playing Java Quiz!!");
        titleLabel.setBounds(100, 30, 700, 30);
        titleLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 26));
        titleLabel.setForeground(Utils.titleColor);
        add(titleLabel);

        JLabel scoreLabel = new JLabel("Your Score is " + score + "!!");
        scoreLabel.setBounds(350, 250, 300, 30);
        scoreLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        scoreLabel.setForeground(Utils.textColor);
        add(scoreLabel);

        JButton playAgainBtn = new JButton("Play Again");
        playAgainBtn.setBackground(Utils.buttonColor);
        playAgainBtn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        playAgainBtn.setForeground(Utils.buttonTextColor);
        playAgainBtn.setFocusPainted(false);
        playAgainBtn.setBorderPainted(false);
        playAgainBtn.setBorder(BorderFactory.createEmptyBorder());
        playAgainBtn.addActionListener(this);

        playAgainBtn.setBounds(400, 300, 120, 30);
        add(playAgainBtn);
    }

    public static void main(String[] args) {
        new Score("", 4).setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
        new Rules(username).setVisible(true);
    }
}
