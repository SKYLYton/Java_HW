package hw5;

public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = Math.max(salary, 0);
        this.age = Math.max(age, 0);
    }

    public void info(){
        System.out.printf("ФИО: %s%nДолжность: %s%nЭл. почта: %s%nТелефон: %s%nЗарплата: %d%nВозраст: %d%n%n",
                fio, position, email, phone, salary, age);
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }


}
