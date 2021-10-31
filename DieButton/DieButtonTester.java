import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DieButtonTester extends JPanel {

    /* Constant Data */
    private final String[] d6FaceFiles = { "d6-images/blank.png", "d6-images/f1.png", "d6-images/f2.png", "d6-images/f3.png", "d6-images/f4.png",
    "d6-images/f5.png", "d6-images/f6.png" };
  

    /* Instance Data */
    private DieButton myD6Die;
    private JButton revealButton;
    private JButton rollButton;

    /* Constructor */
    public DieButtonTester() {

        this.myD6Die = new DieButton(6,d6FaceFiles);
        myD6Die.enableHideAfterRoll();
        this.add(myD6Die);

        revealButton = new JButton ("Reveal");
        this.add(revealButton);

        rollButton = new JButton ("Roll");
        this.add(rollButton);

        MyButtonListener mbl = new MyButtonListener();
        revealButton.addActionListener(mbl);
        rollButton.addActionListener(mbl);

    }

    private class MyButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == revealButton) {
                myD6Die.showFace();
            } else {
                myD6Die.rollDie();
            }
            
        }

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DieButtonTester());
        frame.pack();
        frame.setVisible(true);
    }


}
