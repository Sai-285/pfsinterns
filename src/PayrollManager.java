public class PayrollManager {
    private EmployeeManager employeeManager;

    public PayrollManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    public Payroll calculatePayroll(int employeeId, double hoursWorked, String month, int year) {
        Employee employee = employeeManager.getEmployeeById(employeeId);
        if (employee == null) return null;

        double grossSalary = employee.getHourlyRate() * hoursWorked;
        double taxes = grossSalary * (employee.getTaxRate() / 100);
        double netSalary = grossSalary - taxes;

        Payroll payroll = new Payroll(employeeId, hoursWorked, month, year);
        payroll.setGrossSalary(grossSalary);
        payroll.setTaxes(taxes);
        payroll.setNetSalary(netSalary);

        return payroll;
    }
}
