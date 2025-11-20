package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        // Increased window size for better layout
        setBounds(350, 100, 800, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Thank you " + name + " for playing Simple Minds", SwingConstants.CENTER);
        heading.setBounds(200, 30, 400, 30); // Centered
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);
        
        JLabel lblscore = new JLabel("Your score is " + score, SwingConstants.CENTER);
        lblscore.setBounds(200, 470, 400, 30); // Centered
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(325, 520, 150, 40); // Centered
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        // Panel to hold questions
        JPanel questionsPanel = new JPanel();
        questionsPanel.setLayout(new BorderLayout());
        
        JLabel questionsLabel = new JLabel();
        questionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        questionsLabel.setText(
            "<html>" + 
                "<b>Quiz Questions:</b> " + "<br><br>" +

                "1. Which planet is known as the Red Planet?" + "<br>" +
                "   a) Earth   b) Mars   c) Jupiter   d) Venus" + "<br>" +
                "<b>Correct Answer: Mars</b>" + "<br><br>" +

                "2. Who wrote the play 'Romeo and Juliet'?" + "<br>" +
                "   a) Charles Dickens   b) William Shakespeare   c) Jane Austen   d) Leo Tolstoy" + "<br>" +
                "<b>Correct Answer: William Shakespeare</b>" + "<br><br>" +

                "3. What is the capital of Japan?" + "<br>" +
                "   a) Seoul   b) Tokyo   c) Beijing   d) Bangkok" + "<br>" +
                "<b>Correct Answer: Tokyo</b>" + "<br><br>" +

                "4. Which is the longest river in the world?" + "<br>" +
                "   a) Amazon River   b) Yangtze River   c) Nile River   d) Mississippi River" + "<br>" +
                "<b>Correct Answer: Nile River</b>" + "<br><br>" +

                "5. Which is the smallest continent by land area?" + "<br>" +
                "   a) Europe   b) Antarctica   c) Australia   d) South America" + "<br>" +
                "<b>Correct Answer: Australia</b>" + "<br><br>" +

                "6. Who invented the telephone?" + "<br>" +
                "   a) Thomas Edison   b) Nikola Tesla   c) Alexander Graham Bell   d) Isaac Newton" + "<br>" +
                "<b>Correct Answer: Alexander Graham Bell</b>" + "<br><br>" +

                "7. What is the chemical symbol for gold?" + "<br>" +
                "   a) Go   b) Gd   c) Ag   d) Au" + "<br>" +
                "<b>Correct Answer: Au</b>" + "<br><br>" +

                "8. Which ocean is the largest by surface area?" + "<br>" +
                "   a) Atlantic Ocean   b) Indian Ocean   c) Pacific Ocean   d) Arctic Ocean" + "<br>" +
                "<b>Correct Answer: Pacific Ocean</b>" + "<br><br>" +

                "9. Which organ in the human body produces insulin?" + "<br>" +
                "   a) Liver   b) Pancreas   c) Kidney   d) Heart" + "<br>" +
                "<b>Correct Answer: Pancreas</b>" + "<br><br>" +

                "10. Who was the first person to step on the moon?" + "<br>" +
                "   a) Buzz Aldrin   b) Yuri Gagarin   c) Neil Armstrong   d) Michael Collins" + "<br>" +
                "<b>Correct Answer: Neil Armstrong</b>" + "<br><br>" +

            "</html>"
        );

        questionsPanel.add(questionsLabel, BorderLayout.CENTER);

        // Scroll pane to allow scrolling
        JScrollPane scrollPane = new JScrollPane(questionsPanel);
        scrollPane.setBounds(20, 80, 750, 380); // Increased height for better spacing
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(scrollPane);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
