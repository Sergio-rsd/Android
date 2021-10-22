package lesson2;

import java.util.Scanner;

public class Lesson2 {

  public static void main(String[] args) {
    int numberOne = readIntArgument("Введите первое число: ");
    int numberTwo = readIntArgument("Введите второе число: ");

    System.out.println(comparisonInt(numberOne, numberTwo)
        ? "Сумма входит в интервал от 10 до 20 (включительно) - true"
        : "Сумма не входит в интервал от 10 до 20 (включительно) - false");

    int arg = readIntArgument("Ввести целое число со знаком: ");
    signDefinition(arg);

    System.out.println(signDefinitionNumber(arg));

    String textUser = readStringArgument("Введите любой текст: ");
    int numberAttempts = readIntArgument("Ввести целое число для повторения текста: ");
    repeatText(textUser, numberAttempts);

    int year = readIntArgument("Введите год : ");
    System.out.println(
        leapYear(year) ? year + " - Это високосный год" : year + " - Это НЕ високосный год");
  }

  public static Scanner readText(String userText) {
    Scanner userInput = new Scanner(System.in);
    System.out.print(userText);
    return userInput;
  }

  static int readIntArgument(String userText) {
    return readText(userText).nextInt();
  }

  static String readStringArgument(String text) {
    return readText(text).nextLine();
  }

  //1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
  static boolean comparisonInt(int a, int b) {
    return (a + b > 10) && (a + b <= 20);
  }

  //    2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
  static void signDefinition(int el) {
    System.out.println((el <= 0) ? "Передано число отрицательное" : "Передано число положительное");
  }

  //    3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
  static boolean signDefinitionNumber(int el) {
    return el <= 0;
  }

  //    4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
  static void repeatText(String test, int a) {
    for (int i = 0; i < a; i++) {
      System.out.println(test);
    }
  }

  //    5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
  static boolean leapYear(int year) {
    return ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
  }
}
