package edu.ap.spring.view;

import edu.ap.spring.model.EightBall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class EightBallForm {
    private JFrame jFrame;
    private JPanel controlPanel;

    private JButton btnGetAnwer;
    private JLabel lblQuestion;
    private JTextField txtQuestion;
    private JLabel lblAnwer;
    private javax.swing.JPanel JPanel;


    @Autowired
    private EightBall eightBall;

    public EightBallForm() {

    }
    public void setupUI() {
        jFrame = new JFrame("Spring JFrame");
        jFrame.setLayout(new FlowLayout());

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2));

        lblQuestion = new JLabel();
        lblQuestion.setText("Ask Eightball a question");
        txtQuestion = new JTextField(15);

        lblAnwer = new JLabel();

        btnGetAnwer = new JButton();
        btnGetAnwer.setText("Ask");
        btnGetAnwer.addActionListener(e -> {
            String question = txtQuestion.getText();
            String answer = eightBall.getRandomAnswer(question);
            lblAnwer.setText(answer);
        });
        //btnAddUser.setTransferHandler(new TransferHandler("text"));
        //btnAddUser.addActionListener(eventHandler::whenButtonClicked);

        controlPanel.add(lblQuestion);
        controlPanel.add(txtQuestion);
        controlPanel.add(lblAnwer);
        controlPanel.add(btnGetAnwer);

        jFrame.add(controlPanel);

        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
