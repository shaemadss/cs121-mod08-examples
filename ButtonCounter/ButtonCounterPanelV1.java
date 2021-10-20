import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ButtonCounterPanelV1 extends JPanel {

	
	public ButtonCounterPanelV1() {
		BobButton b0 = new BobButton();
		BobButton b1 = new BobButton();
		BobButton b2 = new BobButton();
		BobButton b3 = new BobButton();
		this.add(b0);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
	}

}
