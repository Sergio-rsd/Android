package lesson5;

public class TaskEmployee {

  public static void main(String[] args) {
//    2. Конструктор класса должен заполнять эти поля при создании объекта;
    Employee personal = new Employee("Иванов", "Директор", "dir@mail.ru", "89991234567", 1000000,
        45);

    personal.infoEmployee();

//    4. Создать массив из 5 сотрудников:

    Employee[] personArray = new Employee[5];
    personArray[0] = new Employee("Иванов", "Директор", "dir@mail.ru", "89991234567", 1000000,
        45);
    personArray[1] = new Employee("Петров", "Зам.Директора", "zamdir@mail.ru", "89991234577",
        500000,
        35);
    personArray[2] = new Employee("Сидоров", "Мастер", "master@mail.ru", "89991234580", 400000,
        41);
    personArray[3] = new Employee("Баширов", "Рабочий", "worker1@mail.ru", "89991234567", 300000,
        49);
    personArray[4] = new Employee("Марков", "Рабочий", "worker2@mail.ru", "89991234567", 250000,
        25);
    //    С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    System.out.println("Перечень сотрудников старше 40 лет");
    for (Employee value : personArray) {
      if (value.age > 40) {
        value.infoEmployee();
        Employee.count++;
      }
    }
    System.out.println("Всего: " + Employee.count);
  }
}
