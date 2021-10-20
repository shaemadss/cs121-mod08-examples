import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ButtonCounterPanelV2 extends JPanel {

	
	public ButtonCounterPanelV2(int numCounters) {
//		BobButton b0 = new BobButton();
//		BobButton b1 = new BobButton();
//		BobButton b2 = new BobButton();
//		this.add(b0);
//		this.add(b1);
//		this.add(b2);
		
		/* Create a subpanel with the vertical box layout */
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
		
		/* Add buttons to subpanel */
		for (int i = 0; i < numCounters; i++) {
			BobButton b = new BobButton();
			buttonPanel.add(b);
		}
		
		/* Add subpanel to scrollpane */
		JScrollPane scroller = new JScrollPane(buttonPanel);
		
		/* SEt the layout on this panel to BorderLayout */
		this.setLayout(new BorderLayout());
		
		/* Add scrollpane to this panel */
		this.add(scroller, BorderLayout.WEST);
		
		
		this.setPreferredSize(new Dimension(400,400));
		this.setBackground(Color.RED);
	}

}
