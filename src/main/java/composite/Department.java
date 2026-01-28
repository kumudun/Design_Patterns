package composite;

import java.util.ArrayList;
import java.util.List;

public class Department implements OrgComponent {

    private final String name;
    private final List<OrgComponent> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    // Add method
    public void add(OrgComponent component) {
        children.add(component);
    }

    // Remove method
    public void remove(OrgComponent component) {
        children.remove(component);
    }

    // Get total salary implementation
    @Override
    public double getTotalSalary() {
        double total = 0.0;
        for (OrgComponent c : children) {
            total += c.getTotalSalary();
        }
        return total;
    }

    // Generate XML representation
    @Override
    public String toXml(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("<department name=\"").append(name).append("\">\n");

        for (OrgComponent c : children) {
            sb.append(c.toXml(indent + "    "));
        }

        sb.append(indent).append("</department>\n");
        return sb.toString();
    }
}
