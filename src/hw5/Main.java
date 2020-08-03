package hw5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович","Уборщик","ggggg@mail.ru","1234567890", 9000, 19);
        employees[1] = new Employee("Соболев Николай Иванович","Директор","ggggg@mail.ru","1234567890", 10000000, 30);
        employees[2] = new Employee("Смирнов Жора Иванович","Зам.","ggggg@mail.ru","1234567890", 100, 25);
        employees[3] = new Employee("Гончаров Алексей Иванович","Педагог","ggggg@mail.ru","1234567890", 20000, 45);
        employees[4] = new Employee("Сидоров Некто Иванович","Уборщик","ggggg@mail.ru","1234567890", 9000, 56);

        for (Employee employee : employees) {
            if (employee.getAge() >= 40) {
                employee.info();
            }
        }

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Иванов Иван Иванович","Уборщик","ggggg@mail.ru","1234567890", 9000, 19));

        for (int i = 0; i < list.size(); i++)  {
            if (list.get(i).getAge() >= 40) {
                list.get(i).info();
            }
        }

    }
}
