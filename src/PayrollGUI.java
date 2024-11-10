import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayrollGUI {
    private EmployeeManager employeeManager;
    private PayrollManager payrollManager;
    private JFrame frame;
    private JTextField nameField;
    private JTextField hourlyRateField;
    private JTextField taxRateField;

    public PayrollGUI() {
        employeeManager = new EmployeeManager();
        payrollManager = new PayrollManager(employeeManager);
        frame = new JFrame("Employee Payroll System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(10, 10, 100, 25);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 10, 150, 25);
        frame.add(nameField);

        JLabel hourlyRateLabel = new JLabel("Hourly Rate: ");
        hourlyRateLabel.setBounds(10, 40, 100, 25);
        frame.add(hourlyRateLabel);

        hourlyRateField = new JTextField();
        hourlyRateField.setBounds(120, 40, 150, 25);
        frame.add(hourlyRateField);

        JLabel taxRateLabel = new JLabel("Tax Rate: ");
        taxRateLabel.setBounds(10, 70, 100, 25);
        frame.add(taxRateLabel);

        taxRateField = new JTextField();
        taxRateField.setBounds(120, 70,150, 25);
        frame.add(taxRateField);

        JButton addButton = new JButton("Add Employee");
        addButton.setBounds(10, 100, 150, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double hourlyRate = Double.parseDouble(hourlyRateField.getText());
                double taxRate = Double.parseDouble(taxRateField.getText());

                employeeManager.addEmplyee(name, hourlyRate, taxRate);
                JOptionPane.showMessageDialog(frame, "Employee added successfully!");
            }
        });
        frame.add(addButton);

        JButton calculateButton = new JButton("Calculate Payroll");
        calculateButton.setBounds(10, 120, 150, 25);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeIdStr = JOptionPane.showInputDialog(frame, "Enter Employee ID: ");
                int employeeId = Integer.parseInt(employeeIdStr);
                String hoursWorkedStr = JOptionPane.showInputDialog(frame, "Enter Hours Worked: ");
                double hoursWorked = Double.parseDouble(hoursWorkedStr);
                String month = JOptionPane.showInputDialog(frame, "Enter Month: ");
                int year = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Year: "));

                Payroll payroll = payrollManager.calculatePayroll(employeeId, hoursWorked, month, year);
                if(payroll != null) {
                    JOptionPane.showMessageDialog(frame, "Payroll calculated!\nGross Salary: " + payroll.getGrossSalary() +
                            "\nTaxes: " + payroll.getTaxes() + "\nNet Salary: " + payroll.getNetSalary());
                }else{
                    JOptionPane.showMessageDialog(frame, "Employee not found.");
                }
            }
        });
        frame.add(calculateButton);

        frame.setSize(300,220);
        frame.setVisible(true);
    }

}
