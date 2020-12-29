import javax.swing.*;
import java.awt.event.*;

/**
 * This version of the RetailCalculator class displays debugging messages to the
 * console window.
 * 
 * @Author Josh Alcoba 
 * Prof. Marzelli 
 * CISM 254 
 * 3/10/2016
 */

public class RetailCalculator extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel; 
	private JLabel messageLabel1; 
	private JLabel messageLabel2; 
	private JTextField wholesaleTextField; 
	private JTextField markupTextField; 
	private JButton calcButton; 
	private final int WINDOW_WIDTH = 320;
	private final int WINDOW_HEIGHT = 125;

	public RetailCalculator() {
		
		// Call the JFrame constructor.
		super("Retail Price Calculator");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify what happens when the close
		// button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel and add it to the frame.
		buildPanel();

		// Add the panel to the frame's content pane.
		add(panel);

		// Display the window.
		setVisible(true);
	}

	/**
	 * The buildPanel method adds labels, text field, and a button to a panel.
	 */

	private void buildPanel() {
		// Create the labels, text field, and button components.
		messageLabel1 = new JLabel("Enter the wholesale cost");
		wholesaleTextField = new JTextField(10);
		messageLabel2 = new JLabel("Enter the markup percentage");
		markupTextField = new JTextField(10);
		calcButton = new JButton("Calculate Retail Price");

		// Add an action listener to the button.
		calcButton.addActionListener(new CalcButtonListener());

		// Create a panel to hold the components.
		panel = new JPanel();

		// Add the labels, text field, and button to the panel.
		panel.add(messageLabel1);
		panel.add(wholesaleTextField);
		panel.add(messageLabel2);
		panel.add(markupTextField);
		panel.add(calcButton);
	}

	/**
	 * Private inner class that handles the event when the user clicks the calculate
	 * button.
	 */

	private class CalcButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String wholesaleString;
			String markupString;
			double retailPrice;

			
			wholesaleString = wholesaleTextField.getText();
			markupString = markupTextField.getText();
			
			/*
			// For debugging, display the text entered, and
			// its value converted to a double.
			System.out.println("Reading " + wholesaleString + " from the text field.");
			System.out.println("Reading " + markupString + " from the text field.");
			System.out.println("Converted value: " + Double.parseDouble(wholesaleString));
			System.out.println("Converted value: " + Double.parseDouble(markupString));
			*/

			
			retailPrice = Double.parseDouble(wholesaleString)
					+ (Double.parseDouble(wholesaleString) * Double.parseDouble(markupString) * .01);

			// Display a message dialog showing the retail price.
			JOptionPane.showMessageDialog(null, "The retail price is " + retailPrice);

		}
	}

	/**
	 * The main method creates an instance of the RetailCalculator class, which
	 * displays a window on the screen.
	 */

	public static void main(String[] args) {
		new RetailCalculator();
	}
}