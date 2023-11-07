package lab02;


public class Employee {
    private Long id;
    private String name;
    public Employee(Long id, String name) {
        this.name = name;
        this.id = id;
    }
    public void setId(Long id){
        this.id=id;
    }
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        if (!id.equals(employee.id)) return false;
        return name.equals(employee.name);
    }
}
