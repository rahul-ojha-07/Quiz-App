package org.example;

import entity.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Quiz extends JFrame implements ActionListener {
    private int count;
    private int timer = 15; // to change the timer time
    private int ans_given;
    private int score;
    private String username;


    JButton next, submit, lifeline;
    JLabel qno, question;
    String[][] pa;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;

    List<Question> questions;

    Quiz(String username) {
        this.username = username;
        setBounds(200, 25, 1181, 1000);
        getContentPane().setBackground(Utils.backgroundBlack);
        setLayout(null);
        setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/online_quiz.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1181, 595);
        add(l1);

        qno = new JLabel("");
        qno.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
        qno.setBounds(100, 620, 60, 50);
        qno.setForeground(Utils.textColor);
        add(qno);

        question = new JLabel("");
        question.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
        question.setForeground(Utils.textColor);
        question.setBounds(150, 620, 900, 50);
        add(question);
        count = 0;
        ans_given = 0;
        score = 0;
        pa = new String[10][1];
        questions = Utils.getQuestionsFromDB();


        opt1 = new JRadioButton("");
        opt1.setBounds(170, 690, 700, 30);
        opt1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        opt1.setBackground(Utils.backgroundBlack);
        opt1.setForeground(Utils.textColor);
        opt1.setFocusPainted(false);
        add(opt1);

        opt2 = new JRadioButton("");
        opt2.setBounds(170, 730, 700, 30);
        opt2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        opt2.setBackground(Utils.backgroundBlack);
        opt2.setForeground(Utils.textColor);
        opt2.setFocusPainted(false);
        add(opt2);

        opt3 = new JRadioButton("");
        opt3.setBounds(170, 770, 700, 30);
        opt3.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        opt3.setBackground(Utils.backgroundBlack);
        opt3.setForeground(Utils.textColor);
        opt3.setFocusPainted(false);
        add(opt3);

        opt4 = new JRadioButton("");
        opt4.setBounds(170, 810, 800, 30);
        opt4.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        opt4.setBackground(Utils.backgroundBlack);
        opt4.setForeground(Utils.textColor);
        opt4.setFocusPainted(false);
        add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        next = new JButton("Next");
        next.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        next.setBackground(Utils.buttonColor);
        next.setFocusPainted(false);
        next.setBorderPainted(false);
        next.setForeground(Utils.buttonTextColor);
        next.addActionListener(this);
        next.setBounds(800, 900, 200, 40);
        add(next);

        lifeline = new JButton("50/50 Lifeline");
        lifeline.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        lifeline.setBackground(Utils.buttonColor);
        lifeline.setForeground(Utils.buttonTextColor);
        lifeline.setFocusPainted(false);
        lifeline.setBorderPainted(false);
        lifeline.setBounds(200, 900, 200, 40);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        submit.setEnabled(false);
        submit.setBackground(Utils.buttonColor);
        submit.setFocusPainted(false);
        submit.setBorderPainted(false);
        submit.setForeground(Utils.buttonTextColor);
        submit.addActionListener(this);
        submit.setBounds(500, 900, 200, 40);
        add(submit);

        start(0);
    }

    public static void main(String[] args) {
        new Quiz("").setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (options.getSelection() == null) {
                pa[count][0] = "";
            } else {
                pa[count][0] = options.getSelection()
                        .getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (options.getSelection() == null) {
                pa[count][0] = "";
            } else {
                pa[count][0] = options.getSelection()
                        .getActionCommand();
            }

            for (int i = 0; i < pa.length; i++) {
                score = pa[i][0].equals(questions.get(i)
                        .getCorrectAnswer()) ? 10 : 0;
            }
            this.setVisible(false);
            new Score(username, score).setVisible(true);
            this.dispose();
        } else if (ae.getSource() == lifeline) {
            int liv = 2;
            if (!questions.get(count)
                    .isOptionCorrect(1) && liv != 0) {
                opt1.setEnabled(false);
                liv--;
            }
            if (!questions.get(count)
                    .isOptionCorrect(2) && liv != 0) {
                opt2.setEnabled(false);
                liv--;
            }
            if (!questions.get(count)
                    .isOptionCorrect(3) && liv != 0) {
                opt3.setEnabled(false);
                liv--;
            }
            if (!questions.get(count)
                    .isOptionCorrect(4) && liv != 0) {
                opt4.setEnabled(false);
                liv--;
            }
            lifeline.setEnabled(false);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left:\n" + timer + " sec"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 900, 620);
        } else {
            g.drawString("Times Up!!", 900, 620);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            pa[count][0] = options.getSelection() == null ? "" : options.getSelection()
                    .getActionCommand();
            if (count == 9) {
                for (int i = 0; i < pa.length; i++) {
                    score = pa[i][0].equals(questions.get(i)
                            .getCorrectAnswer()) ? 10 : 0;
                }
                this.setVisible(false);
                new Score(username, score).setVisible(true);
            } else {
                count++;
                start(count);
            }

        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText("<html>" + questions.get(count)
                .getQuestion() + "</html>");
        opt1.setText(questions.get(count)
                .getAnswer1());
        opt1.setActionCommand(questions.get(count)
                .getAnswer1());
        opt2.setText(questions.get(count)
                .getAnswer2());
        opt2.setActionCommand(questions.get(count)
                .getAnswer2());
        opt3.setText(questions.get(count)
                .getAnswer3());
        opt3.setActionCommand(questions.get(count)
                .getAnswer3());
        opt4.setText(questions.get(count)
                .getAnswer4());
        opt4.setActionCommand(questions.get(count)
                .getAnswer4());
        options.clearSelection();
    }
}
