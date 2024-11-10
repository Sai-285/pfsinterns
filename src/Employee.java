public class Employee {
    private int employeeID;
    private String name;
    private double hourlyRate;
    private double taxRate;


    public Employee(int employeeID, String name, double hourlyRate, double taxRate){
        this.employeeID = employeeID;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.taxRate = taxRate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getTaxRate() {
        return taxRate;
    }
}
