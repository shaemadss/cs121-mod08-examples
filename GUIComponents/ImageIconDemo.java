import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * Demonstrate how the ImageIcon can be set on JLabels and JButtons
 * @author Luke Hindman
 */
@SuppressWarnings("serial")
public class ImageIconDemo extends JPanel {

    /* Setup image variables so we can easily find them */
    private final String happyFace = "images/smile.png";
    private final String sadFace = "images/frown.png";
    private final String logo = "images/cubic-pyramid.png";

    public ImageIconDemo() {
        /* Create ImageIcon objects from each png file */
        ImageIcon happyIcon = new ImageIcon(happyFace);
        ImageIcon sadIcon = new ImageIcon(sadFace);
        ImageIcon logoIcon = new ImageIcon(logo);

        /* Create GUI components and add ImageIcons to them 
         *    Each component is added to its own subpanel so
         *    that it isn't stretched when added to the 
         *    master panel with a BorderLayout. */
        JButton happyButton = new JButton();
        happyButton.setIcon(happyIcon);
        happyButton.setBackground(Color.YELLOW);
        JPanel happyPanel = new JPanel();
        happyPanel.add(happyButton);

        JButton sadButton = new JButton();
        sadButton.setIcon(sadIcon);
        sadButton.setBackground(Color.YELLOW);
        JPanel sadPanel = new JPanel();
        sadPanel.add(sadButton);

        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logoIcon);
        JPanel logoPanel = new JPanel();
        logoPanel.add(logoLabel);

        /* Organize components with a Layout and add to this panel */
        this.setLayout(new BorderLayout());
        this.add(happyPanel,BorderLayout.WEST);
        this.add(logoPanel,BorderLayout.CENTER);
        this.add(sadPanel,BorderLayout.EAST);
     
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame ("ImageIconDemo by Luke Hindman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ImageIconDemo());
        frame.pack();
        frame.setVisible(true);
    }
}
