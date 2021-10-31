import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The DieButton class "has-a" Die as an instance variable which is an example of a
 *   aggregation relationship. It also demonstrates inheritence by extending the 
 *   JButton class.  DieButton "is-a" JButton plus a little bit more. :)
 * 
 * @author Luke Hindman
 */
@SuppressWarnings("serial")
public class DieButton extends JButton {

    /* Instance Variables */
    private Die myDie;
    private ImageIcon[] myDieFaces;
    private boolean hideAfterRoll;

    /* Constructor */
    public DieButton(int numSides, String[] faceFiles) {

        /* Check to ensure we have face images for each side
         *    of the die + a blank face */
        if (faceFiles.length < numSides + 1) {
            throw new java.lang.RuntimeException("Error: Die has more sides than faces");
        }

        this.myDie = new Die(numSides);
        this.hideAfterRoll = false;

        /* Create the icons */
        this.myDieFaces = new ImageIcon[faceFiles.length];
        for (int i = 0; i < faceFiles.length; i++) {
                myDieFaces[i] = new ImageIcon(faceFiles[i]);
        }
        this.setPreferredSize(new Dimension(112, 112));
        this.setBackground(Color.white);

        this.setIcon(myDieFaces[myDie.getFaceValue()]);
        this.addActionListener(new DieButtonListener());
    }

    /* Methods */
    public int getFaceValue() {
        return this.myDie.getFaceValue();
    }

    public void enableHideAfterRoll() {
        this.hideAfterRoll = true;
    }

    public void disableHideAfterRoll() {
        this.hideAfterRoll = false;
    }

    public void showFace() {
        setIcon(myDieFaces[myDie.getFaceValue()]);
    }

    public void rollDie() {
        this.myDie.roll();
        if (hideAfterRoll) {
            setIcon(myDieFaces[0]);
        } else {
            setIcon(myDieFaces[myDie.getFaceValue()]);
        }
    }

    private class DieButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            rollDie();
        }

    }


    

    
}
