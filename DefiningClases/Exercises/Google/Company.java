package Advanced.DefiningClasses.Exe.Google;

public class Company {
        private String name;
        private String department;
        private double salary;

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Company: ");
            if(!getName().equals(" ")){
                sb.append(getName());
                sb.append(" ");
                sb.append(getDepartment());
                sb.append(" ");
                sb.append(String.format("%.2f",getSalary()));
            }
        return sb.toString();
    }
}
