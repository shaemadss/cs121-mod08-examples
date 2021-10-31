import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SnakeEyes extends JPanel {

    /* Constant Data */
    private final String[] d6FaceFiles = { "d6-images/blank.png", "d6-images/f1.png", "d6-images/f2.png", "d6-images/f3.png", "d6-images/f4.png",
    "d6-images/f5.png", "d6-images/f6.png" };

    /* Instance Variables */
    private DieButton db1;
    private DieButton db2;
    private JButton revealButton;
    private JButton rollButton;
    private JLabel playerScoreLabel;
    private JLabel dealerScoreLabel;

    private int playerScore;
    private int dealerScore;

    /* Constructor */
    public SnakeEyes() {

        this.setPreferredSize(new Dimension(600,400));
        this.setBackground(Color.gray);
        this.setLayout(new BorderLayout());

        Color gameboardColor = new Color(3,99,25);

        /* Setup individual subpanels */
        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(Color.gray);
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS));
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.gray);
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.gray);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.gray);
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(gameboardColor);


        db1 = new DieButton(6,d6FaceFiles);
        db1.setBackground(gameboardColor);
        db1.enableHideAfterRoll();
        centerPanel.add(db1);

        db2 = new DieButton(6,d6FaceFiles);
        db2.setBackground(gameboardColor);
        db2.enableHideAfterRoll();      
        centerPanel.add(db2);

        revealButton = new JButton("Reveal");
        buttonPanel.add(revealButton);

        rollButton = new JButton("Roll");
        buttonPanel.add(rollButton);

        GameButtonListener gbl = new GameButtonListener();
        revealButton.addActionListener(gbl);
        rollButton.addActionListener(gbl);

        playerScoreLabel = new JLabel();
        dealerScoreLabel = new JLabel();
        scorePanel.add(Box.createRigidArea(new Dimension(20, 0)));
        scorePanel.add(playerScoreLabel);
        scorePanel.add(Box.createHorizontalGlue());
        scorePanel.add(dealerScoreLabel);
        scorePanel.add(Box.createRigidArea(new Dimension(20, 0)));

        /* Add sub panels to this panel */
        this.add(scorePanel,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.add(leftPanel,BorderLayout.WEST);
        this.add(rightPanel,BorderLayout.EAST);
        this.add(centerPanel,BorderLayout.CENTER);

        resetGame();
    }

    private void resetGame() {
        playerScore = 0;
        dealerScore = 0;
        updateScores();
    }

    private void updateScores() {
        playerScoreLabel.setText("Player Score: " + playerScore);
        dealerScoreLabel.setText("Dealer Score: " + dealerScore);
    }

    private class GameButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == revealButton) {
                db1.showFace();
                db2.showFace();
                
                int totalValue = db1.getFaceValue() + db2.getFaceValue();
                if (totalValue == 2) { 
                    /* Snake Eyes, Game Over */
                    if (playerScore > dealerScore) {
                        JOptionPane.showMessageDialog(null, "Player Wins!");
                    } else if (playerScore < dealerScore) {
                        JOptionPane.showMessageDialog(null, "Dealer Wins!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Tie Game!");
                    }
                    resetGame();
                } else if (totalValue == 7 || db1.getFaceValue() == db2.getFaceValue()) {
                    playerScore++;
                } else {
                    dealerScore++;
                }
                updateScores();
            } else if (e.getSource() == rollButton) {
                db1.rollDie();
                db2.rollDie();
            }
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Eyes - By Luke Hindman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnakeEyes());
        frame.pack();
        frame.setVisible(true);
    }

}
