package composite;

public class Employee implements OrgComponent {
    private final String name;
    private final double salary;

    // Create an Employee with a name and salary
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Get the total salary of this employee
    @Override
    public double getTotalSalary() {
        return salary;
    }

    // Generate XML representation of this employee
    @Override
    public String toXml(String indent) {
        return indent + "<employee name=\"" + name + "\" salary=\"" + salary + "\" />\n";
    }
}
