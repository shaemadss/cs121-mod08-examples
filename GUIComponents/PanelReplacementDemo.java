import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Demonstrate Panel Replacement and calling revalidate and repaint on parent panel
 * @author Luke Hindman
 */
@SuppressWarnings("serial")
public class PanelReplacementDemo extends JPanel {

    private JPanel displayPanel;
    private ArrayList<JLabel> eyesInTheDark;

    public PanelReplacementDemo() {

        /* Setup the rebuild button and subpanel */
        JButton rebuildButton = new JButton("rebuild");
        rebuildButton.addActionListener(new RebuildListener());
        JPanel rebuildPanel = new JPanel();
        rebuildPanel.setBackground(Color.DARK_GRAY);
        rebuildPanel.setLayout(new BoxLayout(rebuildPanel, BoxLayout.Y_AXIS));
        rebuildPanel.add(Box.createVerticalGlue());
        rebuildPanel.add(rebuildButton);
        rebuildPanel.add(Box.createVerticalGlue());

        /* Setup the displayPanel and JLabel array list */
        displayPanel = new JPanel();
        displayPanel.setBackground(Color.BLACK);
        displayPanel.setPreferredSize(new Dimension(500,300));
        eyesInTheDark = new ArrayList<JLabel>();
        rebuildDisplayPanel();

        this.setLayout(new BorderLayout());
        this.add(rebuildPanel, BorderLayout.EAST);
        this.add(displayPanel, BorderLayout.CENTER);

    }

    private void rebuildDisplayPanel() {

        /* Remove existing eyes from panel and clear arraylist */
        for (JLabel l : eyesInTheDark) {
            displayPanel.remove(l);
        }
        eyesInTheDark.clear();

        /* Use random number generator to determine number of "eyes" to create */
        Random myRand = new Random();
        int numEyes = myRand.nextInt(20);

        /* Create specified number of "eyes" and add them to the display panel */
        ImageIcon eyesIcon = new ImageIcon("images/eyes.png");
        for (int i = 0; i < numEyes; i++) {
            JLabel eyesLabel = new JLabel();
            eyesLabel.setIcon(eyesIcon);
            eyesInTheDark.add(eyesLabel);
            displayPanel.add(eyesLabel);
        }

        /*
         * Update the parent panel to ensure the new set of eyes are displayed properly
         */
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    private class RebuildListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            rebuildDisplayPanel();
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PanelReplacementDemo by Luke Hindman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PanelReplacementDemo());

        frame.pack();
        frame.setVisible(true);
    }
}
