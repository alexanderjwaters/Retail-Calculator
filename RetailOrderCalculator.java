import javax.swing.*;		// Needed for Swing class
import java.awt.*;		// Needed for FlowLayout
import java.awt.event.*;	// Needed for ActionListener

/**
	Alexander Waters, Chapter 12 #01
	RetailOrderCalculator class allows user to enter
	wholeSale and markup value in window to calculate
	total sum and display results.
*/

public class RetailOrderCalculator extends JFrame
{
	private JPanel panel;			// To hold in panel
	private JLabel greeting;		// To hold greeting
	private JLabel saleLabel;		// To hold wholeSale
	private JLabel markupLabel;		// To hold markup
	private JTextField wholeSaleText;	// To hold text
	private JTextField markupText;		// To hold text
	private JButton calcButton;		// To select calculate
	private JButton exitButton;		// To select exit
	
	// Constants.
	private final int WINDOW_WIDTH = 400;	// Window width
	private final int WINDOW_HEIGHT = 200;	// Window height
	private final double CONVERT = 0.01;	// Conert to percent.

	/**
		Constructor
	*/

	public RetailOrderCalculator()
	{
		// Set the title.
		setTitle("Retail Calculator");

		// Set Size.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify close button..
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// BuildPanel and add it to frame.
		buildPanel();

		// Add panel to content pane.
		add(panel);

		// Display window.
		setVisible(true);
	}

	/**
		buildPanel method adds labels, textFields, 
		buttons, and creates multiple panels.
	*/

	public void buildPanel()
	{
		// Create labels.
		greeting = new JLabel("The Retail Calculator");
		saleLabel = new JLabel("Enter WholeSale Cost");
		markupLabel = new JLabel("Enter Mark-Up Value");

		// Create text fields.
		wholeSaleText = new JTextField(10);
		markupText = new JTextField(10);

		// Create buttons.
		calcButton = new JButton("Calculate");
		exitButton = new JButton("Exit");

		// Add actionListener to buttons.
		calcButton.addActionListener(new CalcButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		// Create panel and add labels,
		// textfields, and buttons.
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel = new JPanel();

		// Set to flowLayout.
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 7));

		// Create panels.
		panel1.add(saleLabel);
		panel1.add(wholeSaleText);
		panel2.add(markupLabel);
		panel2.add(markupText);
		panel3.add(calcButton);
		panel3.add(exitButton);

		// Add all to panel in order.
		panel.add(greeting);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
	}

	/**
		Private inner class handles event when user
		clicks calculate button.
	*/

	private class CalcButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double sale, percent, total;
			String wInput, pInput;	// Holds user input

			// Debugger.
			System.out.println("\n\t---Debugger---");
			System.out.println("\nGetting Values..");

			// Get input from user and convert 
			// into doubles.
			wInput = wholeSaleText.getText();
			sale = Double.parseDouble(wInput);
			pInput = markupText.getText();
			percent = Double.parseDouble(pInput) * CONVERT;
			percent = percent * sale;

			// Debugger.
			System.out.println("\nAdding....");
			System.out.println("\nSale: " + sale +
					   "\nMarkUp: " + percent);

			// Sum sale and percent for total.
			total = sale + percent;

			// Debugger.
			System.out.println("\nTotal after conversion: " +
					   total);

			// Display results.
			JOptionPane.showMessageDialog(null, 
				String.format("WholeSale: $%,.2f\n" +
					      "MarkUp: $%,.2f\n" + 
					      "Total: $%,.2f\n",
					      sale, percent, total));

			// Debugger.
			System.out.println("\nReady for input....");
		}
	}

	/**
		Private inner class handles event when user
		clicks exit button.
	*/

	private class ExitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Debugger.
			System.out.println("\nExiting Debugger\n\t\tand System...");

			// Exit System.
			System.exit(0);
		}
	}

	/**
		main method
	*/

	public static void main(String[] args)
	{
		new RetailOrderCalculator();	// Call Constructor
	}
}
