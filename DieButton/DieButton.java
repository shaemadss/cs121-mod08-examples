import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

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
                System.out.println("Creating icon: " + faceFiles[i]);

        }
        this.setPreferredSize(new Dimension(112, 112));
        
        /* Remove the border */
        this.setFocusPainted(false);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        this.setBorder(emptyBorder);

        this.setIcon(myDieFaces[myDie.getFaceValue()]);
        this.addActionListener(new DieButtonListener());
    }

    /* Methods */

    /**
     * Return the integer face value of the internal Die object
     * @return face value of the internal Die object
     */
    public int getFaceValue() {
        return this.myDie.getFaceValue();
    }

    /**
     * Set an internal flag that changes the DieButton face to blank (image at index 0) after each roll of the dice
     */
    public void enableHideAfterRoll() {
        this.hideAfterRoll = true;
    }

    /**
     * Reset an internal flag that changes updates the DieButton face to the image that cooresponds to the updated face value of the internal Die object after each roll.
     */
    public void disableHideAfterRoll() {
        this.hideAfterRoll = false;
    }

    /**
     * Update the face image on the DieButton with the image that cooresponds to the current face value of the internal Die object
     */
    public void showFace() {
        setIcon(myDieFaces[myDie.getFaceValue()]);
    }

    /**
     * Call the roll() method on the internal Die object.  If hide after roll flag is enable, change the DieButton face image to blank (index 0) otherwise set the face image icon to the updated face value of the internal Die object after the roll has occurred.
     */
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
