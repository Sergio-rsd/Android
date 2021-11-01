package lesson5;

public class Employee {

  //1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
  String name;
  String post;
  String email;
  String phone;
  int salary;
  int age;

  static int count = 0;

  // конструктор для класса Employee
  public Employee(String name, String post, String email, String phone, int salary, int age) {
    this.name = name;
    this.post = post;
    this.email = email;
    this.phone = phone;
    this.salary = salary;
    this.age = age;
  }

  public void infoEmployee() {
//    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    System.out.printf(
        "ФИО: %s%nДолжность: %s%nЭлектронная почта: %s%nТелефон: %s%nЗарплата: %,d рублей%nВозраст: %d лет%n",
        name, post, email, phone, salary, age);
    System.out.println();
  }
}
