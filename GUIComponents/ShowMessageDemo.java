import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Demonstrate how to easily display popup messages to the user
 *    using JOptionPane
 * @author Luke Hindman
 */

@SuppressWarnings("serial")
public class ShowMessageDemo extends JPanel {

    private JButton b1, b2, b3;

    public ShowMessageDemo() {
        /* Setup a row of buttons */
        b1 = new JButton("Info Message");
        b1.setToolTipText("Click to display info message");

        b2 = new JButton("Warning Message");
        b2.setToolTipText("Click to display warning message");

        b3 = new JButton("Error Message");
        b3.setToolTipText("Click to display error message");

        /* 
         * Setup a single ActionListener instance for all buttons 
         */
        MessageButtonListener buttonListener = new MessageButtonListener();
        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener);
        b3.addActionListener(buttonListener);

        /*
         * Google RGB Color Picker https://g.co/kgs/seiAWc
         */
        Color darkGray = new Color(77, 82, 78);
        this.setBackground(darkGray);

        this.setPreferredSize(new Dimension(500,100));

        /* Layout the buttons in a single row */
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(b1);
        this.add(Box.createHorizontalGlue());
        this.add(b2);
        this.add(Box.createHorizontalGlue());
        this.add(b3);

    }

    private class MessageButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clicked = (JButton) e.getSource();
            if (clicked == b1) {
                JOptionPane.showMessageDialog(null, "This is the body of the information message", "Info Message Title", JOptionPane.INFORMATION_MESSAGE);
            } else if (clicked == b2) {
                JOptionPane.showMessageDialog(null, "This is the body of the warning message", "Warning Message Title", JOptionPane.WARNING_MESSAGE);
            } else if (clicked == b3) {
                JOptionPane.showMessageDialog(null, "This is the body of the error message", "Error Message Title", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame ("ShowMessageDemo by Luke Hindman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ShowMessageDemo());

        frame.pack();
        frame.setVisible(true);
    }
}
