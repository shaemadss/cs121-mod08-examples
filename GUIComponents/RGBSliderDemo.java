import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

/**
 * Demonstrate to to use the JSlider with a ChangeListen
 * @author Luke Hindman
 */

@SuppressWarnings("serial")
public class RGBSliderDemo extends JPanel {

    private JPanel colorDisplayPanel;
    private JSlider redSlider, greenSlider, blueSlider;

    public RGBSliderDemo() {

        /*
         * Google RGB Color Picker https://g.co/kgs/seiAWc
         */
        Color rose = new Color(255, 207, 179);

        /*
         * Setup Red Slider Panel and Slider 
         */
        JPanel redSliderPanel = new JPanel();
        redSliderPanel.setBackground(rose);
        redSliderPanel.setPreferredSize(new Dimension (100, 300));
        redSliderPanel.setBorder(BorderFactory.createTitledBorder("Red"));
        
        redSlider = new JSlider(JSlider.VERTICAL,0,255,58);
        redSlider.setMajorTickSpacing(25);
        redSlider.setMinorTickSpacing(1);
        redSlider.setPaintTicks(true);
        redSliderPanel.add(redSlider);

        /*
         * Setup Green Slider Panel and Slider 
         */
        JPanel greenSliderPanel  = new JPanel();
        greenSliderPanel.setBackground(rose);
        greenSliderPanel.setPreferredSize(new Dimension (100, 300));
        greenSliderPanel.setBorder(BorderFactory.createTitledBorder("Green"));
        
        greenSlider = new JSlider(JSlider.VERTICAL,0,255,130);
        greenSlider.setMajorTickSpacing(25);
        greenSlider.setMinorTickSpacing(1);
        greenSlider.setPaintTicks(true);
        greenSliderPanel.add(greenSlider);


        /*
         * Setup Blue Slider Panel and Slider 
         */
        JPanel blueSliderPanel  = new JPanel();
        blueSliderPanel.setBackground(rose);
        blueSliderPanel.setPreferredSize(new Dimension (100, 300));
        blueSliderPanel.setBorder(BorderFactory.createTitledBorder("Blue"));
        
        blueSlider = new JSlider(JSlider.VERTICAL,0,255,206);
        blueSlider.setMajorTickSpacing(25);
        blueSlider.setMinorTickSpacing(1);
        blueSlider.setPaintTicks(true);
        blueSliderPanel.add(blueSlider);

        
        /*
         * Create a shared listener for all sliders
         */
        ColorSelectorListener csl = new ColorSelectorListener();
        redSlider.addChangeListener(csl);
        greenSlider.addChangeListener(csl);
        blueSlider.addChangeListener(csl);

        
        /*
         * Setup the colorDisplayPanel 
         */
        this.colorDisplayPanel = new JPanel();
        this.colorDisplayPanel.setPreferredSize(new Dimension(100,100));
        this.colorDisplayPanel.setBorder(BorderFactory.createTitledBorder("Selected Color"));
        updateColorDisplayPanel();

     
        /*
         * setup the sliderSubPanel
         */
        JPanel sliderSubPanel = new JPanel();
        sliderSubPanel.setLayout(new BoxLayout(sliderSubPanel, BoxLayout.X_AXIS));
        sliderSubPanel.setPreferredSize(new Dimension(400,350));
        sliderSubPanel.setBorder(BorderFactory.createTitledBorder("Color Selectors"));
    
        sliderSubPanel.add(redSliderPanel);
        sliderSubPanel.add(Box.createHorizontalGlue());
        sliderSubPanel.add(greenSliderPanel);
        sliderSubPanel.add(Box.createHorizontalGlue());
        sliderSubPanel.add(blueSliderPanel);
    
        /* Setup layout for this panel and add subpanels */
        setLayout(new BorderLayout());
        add(colorDisplayPanel,BorderLayout.NORTH);
        add(sliderSubPanel,BorderLayout.CENTER);
        
    }

    private void updateColorDisplayPanel() {
        int red = this.redSlider.getValue();
        int green = this.greenSlider.getValue();
        int blue = this.blueSlider.getValue();

        Color selectedColor = new Color(red, green, blue);
        this.colorDisplayPanel.setBackground(selectedColor);
    }

    private class ColorSelectorListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent arg0) {
            updateColorDisplayPanel();

        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame ("RGBSliderDemo by Luke Hindman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RGBSliderDemo());

        frame.pack();
        frame.setVisible(true);
    }
}
