package composite;

public class Main {
    public static void main(String[] args) {

        // Create the company
        Department company = new Department("Company");

        // Create Departments
        Department it = new Department("IT");
        Department softwareDev = new Department("Software Development");

        // Create Employees
        Employee anne = new Employee("Anne", 3000.0);
        Employee bob = new Employee("Bob", 2500.0);
        Employee peter = new Employee("Peter", 4000.0);

        // Build hierarchy
        it.add(anne);
        it.add(bob);

        softwareDev.add(peter);

        it.add(softwareDev);   // Software Development under IT
        company.add(it);       // IT under Company

        // Print total salary
        System.out.println("Total Salary: " + company.getTotalSalary());

        // Print XML
        System.out.println("\nOrganization Structure (XML):");
        System.out.print(company.toXml(""));
    }
}
