import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BobButton extends JButton{
	
	private int myCount;
	
	public BobButton() {
		myCount = 0;
		this.setText("Count: " + myCount);
		this.addActionListener(new BobButtonListener());
	}
	
	private class BobButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myCount++;
			setText("Count: " + myCount);
		}
		
		
	}

}
