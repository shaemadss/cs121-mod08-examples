import javax.swing.JFrame;

/**
 * Example code from Basic graphics
 * HistogramComponent extends the functionality of a JComponent
 *   in order to draw a histogram.
 * @author zyBooks
 */
public class HistogramViewer {
   public static void main(String[] args) {
      JFrame appFrame = new JFrame();
      HistogramComponent histogramComponent = new HistogramComponent();

      appFrame.setSize(400, 250);
      appFrame.setTitle("Histogram Viewer");
      appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Add the HistogramComponent object to the frame
      appFrame.add(histogramComponent);
      
      // Set the frame and its contents visible
      appFrame.setVisible(true);
   }
}
