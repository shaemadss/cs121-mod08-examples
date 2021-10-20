import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Demonstrates the use of a scroll pane, text area, and file chooser.
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class FileReaderPanel extends JPanel
{
	private JTextArea filePreview;
	private JButton openFileButton;
	
	/**
	 * Opens a file chooser dialog, reads the selected file and loads it into a
	 * text area.
	 */
	public FileReaderPanel()
	{
		openFileButton = new JButton("Select File");
		openFileButton.addActionListener(new ButtonActionListener());
		openFileButton.setToolTipText("Click here to select a file...");
		
		filePreview = new JTextArea(20, 30);
		filePreview.setEditable(false);
		
		filePreview.setText("Please select a file to open");
		
		JScrollPane scrollPane = new JScrollPane(filePreview);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(scrollPane);
		add(openFileButton);
	}
	
	private class ButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			// The following starts in the home folder
			//JFileChooser chooser = new JFileChooser();
			
			// The following starts in the current folder, which is often convenient
			JFileChooser chooser = new JFileChooser(".");
			int status = chooser.showOpenDialog(null);

			if (status != JFileChooser.APPROVE_OPTION) {
				filePreview.setText("No File Chosen");
			} else {
				File file = chooser.getSelectedFile();
				
				// Read the contents of the file and display.
				// We don't have to read the contents, we could just pass the
				// File along.
				String bookText = "";
				try {
					Scanner scan = new Scanner(file);
					while (scan.hasNextLine()) {
						bookText += scan.nextLine() + "\n";
					}
					scan.close();
					filePreview.setText(bookText);
				} catch(FileNotFoundException e) {
					filePreview.setText("Could not open file: " + file.getPath());
				}
			}
		}
	}
}
