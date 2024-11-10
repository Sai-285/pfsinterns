public class Payroll {
    private int employeeId;
    private double hoursWorked;
    private double grossSalary;
    private double netSalary;
    private double taxes;
    private String month;;
    private int year;

    public Payroll(int employeeId, double hoursWorked, String Month, int year){
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
        this.month = month;
        this.year = year;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }
}
