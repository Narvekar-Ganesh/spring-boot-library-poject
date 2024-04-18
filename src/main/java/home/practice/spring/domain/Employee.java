package home.practice.spring.domain;

public class Employee {
    private int employeeNumber;
    private String employeeName;

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static void main(String[] args) {
        Employee employee1 =new Employee();
        employee1.setEmployeeName("ram");
        System.out.println("Employee 1"  + employee1.getEmployeeName());
//        displayEmployeeObject( employee1);
//        Employee employe2 =employee1;
//        employe2.setEmployeeName("jai shree ram");
//        System.out.println("Employee 2:"+employe2.getEmployeeName());
    }

    public  void displayEmployeeObject( Employee employee1){

        Employee employe2 =employee1;
        employe2.setEmployeeName("jai shree ram");
        System.out.println("Employee 2:"+employe2.getEmployeeName());


    }
}




