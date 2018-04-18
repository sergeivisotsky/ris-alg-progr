package secondSemester;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.util.Random;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SecondCompetition extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblYouHave;
    private int counter = 7;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SecondCompetition frame = new SecondCompetition();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public SecondCompetition() {
        setTitle("Guess a Number");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 357);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblInputANumber = new JLabel("Input a number: (1-100)");
        lblInputANumber.setFont(new Font("Tahoma", Font.PLAIN, 16));

        textField = new JTextField();
        textField.setColumns(10);

        lblYouHave = new JLabel("You have 7 attempts to guess a number");
        lblYouHave.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JButton btnOk = new JButton("OK");
        btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));

        btnOk.addActionListener(e -> OKbtnActionListener());

        JButton btnNewGame = new JButton("New game");
        btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewGame.addActionListener(e -> newGameBtnActionListener());

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                                        .addComponent(lblInputANumber, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblYouHave)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(21)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(btnNewGame, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblInputANumber, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(lblYouHave)
                                .addGap(18)
                                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnNewGame, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(60, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

    private void newGameBtnActionListener() {
        counter = 7;
        lblYouHave.setText("You have " + counter + " attempts!");
    }
    private int generated = numberGenerator();
    private void OKbtnActionListener() {
        if (!textField.getText().equals("")) {
            String getFieldText = textField.getText();
            if (counter > 0) {
                if (Integer.parseInt(getFieldText) == generated) {
                    lblYouHave.setText("Number is guessed!");
                } else {
                    counter--;
                    lblYouHave.setText("Number not found! You have " +
                            counter + " attempts!");
                    if (Integer.parseInt(textField.getText()) > generated) {
                        JOptionPane.showMessageDialog(contentPane, "Number is greater than intented number!");
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Number is smaller than intented number!");
                    }
                }
            } else {
                lblYouHave.setText("No more attempt are allowed!");
            }
        } else {
            JOptionPane.showMessageDialog(contentPane, "Field is empty!");
        }
    }

    private int numberGenerator() {
        Random rd = new Random();
        return rd.nextInt(100)+ 1;
    }
}