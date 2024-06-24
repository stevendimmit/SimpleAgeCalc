import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;


public class BirthdayCalcFrame extends JFrame {
	
	private JPanel panel;
	private JTextField monthField;
	private JTextField dayField;
	private JTextField yearField;
	private JTextField ageField;  // displays age after month day year are set and button is pushed.
	private JLabel monthLabel;
	private JLabel dayLabel;	
	private JLabel yearLabel;
	private JLabel ageLabel;
	private JButton calcButton;
	
	//constructor to create GUI components
	
	public BirthdayCalcFrame() {
		setTitle("Age Calculator");
		monthLabel = new JLabel("Birth Month:");
		dayLabel = new JLabel("Birth Day:");
		yearLabel = new JLabel("Birth Year:");
		ageLabel = new JLabel("Age:");
		monthField = new JTextField();
		dayField = new JTextField();
		yearField = new JTextField();
		ageField = new JTextField();
		ageField.setEditable(false);
		calcButton = new JButton("Calculate Age");
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });
		
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,2));
		panel.add(monthLabel);
		panel.add(monthField);
		panel.add(dayLabel);
		panel.add(dayField);
		panel.add(yearLabel);
		panel.add(yearField);
		panel.add(ageLabel);
		panel.add(ageField);
		panel.add(calcButton);		
		add(panel);
		
	}

	
	// method for calculating the age from entered birthday
    private void calculateAge() {
        try {
            // Get birthdate info from input fields
            int birthYear = Integer.parseInt(yearField.getText());
            int birthMonth = Integer.parseInt(monthField.getText());
            int birthDay = Integer.parseInt(dayField.getText());
            // using the local date module calculate the birthday.
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
            int age = Period.between(birthDate, currentDate).getYears();

            // Display age in ageField
            ageField.setText(String.valueOf(age));
        } catch (Exception e) {   // Catch invalid input 
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for year, month, and day.");
        }
    }
	
	public static void main(String[] args) {
		BirthdayCalcFrame frame = new BirthdayCalcFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setVisible(true);
		
	}

}
