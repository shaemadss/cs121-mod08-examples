import javax.swing.JFrame;

public class ButtonCounter {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Button Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new ButtonCounterPanelV2(10));
		
		frame.pack();
		frame.setVisible(true);

	}

}
