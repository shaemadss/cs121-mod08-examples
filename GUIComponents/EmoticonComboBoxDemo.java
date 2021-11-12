import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Demonstrate the JComboBox
 * @author Luke Hindman
 */
@SuppressWarnings("serial")
public class EmoticonComboBoxDemo extends JPanel {

    private final String[] emoticons = { "images/smile.png", "images/wide-smile.png", "images/cool.png",
            "images/frown.png", "images/deep-frown.png" };

    private enum EmoticonSelection {
        Happy, Excited, Great, Unhappy, Sad
    }

    private JLabel reactionLabel;
    private JComboBox<EmoticonSelection> selectionBox;

    public EmoticonComboBoxDemo() {

        reactionLabel = new JLabel();
        reactionLabel.setBackground(Color.YELLOW);

        JPanel reactionPanel = new JPanel();
        reactionPanel.setBackground(Color.YELLOW);
        reactionPanel.add(reactionLabel);

        selectionBox = new JComboBox<EmoticonSelection>(EmoticonSelection.values());
        selectionBox.setToolTipText("Click to select a reaction from the list");
        selectionBox.addActionListener(new UpdateListener());

        JPanel selectionPanel = new JPanel();
        selectionPanel.setBorder(BorderFactory.createTitledBorder("Reaction Selector"));
        selectionPanel.add(selectionBox);

        updateReaction();

        this.setLayout(new BorderLayout());
        this.add(reactionPanel, BorderLayout.CENTER);
        this.add(selectionPanel, BorderLayout.SOUTH);

    }

    private void updateReaction() {
        EmoticonSelection current = (EmoticonSelection) selectionBox.getSelectedItem();
        String emoticon = emoticons[current.ordinal()];
        ImageIcon updatedIcon = new ImageIcon(emoticon);
        reactionLabel.setIcon(updatedIcon);
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            updateReaction();
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame ("EmoticonComboxBoxDemo by Luke Hindman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new EmoticonComboBoxDemo());

        frame.pack();
        frame.setVisible(true);
    }
}
