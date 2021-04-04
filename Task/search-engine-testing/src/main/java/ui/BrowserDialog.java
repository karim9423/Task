package ui;

import javax.swing.JOptionPane;
import constants.Configurations;  

	public class BrowserDialog {
 
		 private BrowserDialog() {
			  }
//Display an option dialog to select the execution browser
	public static String selectBroswer() {
		    return (String) JOptionPane.showInputDialog(null, "Browsers",
		        "Select Execution Browser", JOptionPane.QUESTION_MESSAGE, null,Configurations.browsers, // Array of choices
		        Configurations.browsers[0]); 
	}
}
