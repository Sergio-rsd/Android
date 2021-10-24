package Lesson3;

import java.util.Arrays;

public class Task3 {

  public static void main(String[] args) {

    createOne();
    createTwo();
    createThree();
    createFour();
    createFive();
    createSixMinMax();
    createSevenEqualSides();
    createShift();

  }


  private static void createOne() {
    //    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    int[] arrZeroOne = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    Util.printArray(arrZeroOne);
//        обработка в методе в файле Util

    for (int i = 0; i < arrZeroOne.length; i++) {
      arrZeroOne[i] = arrZeroOne[i] == 0 ? 1 : 0;
    }
    Util.printArray(arrZeroOne);
    System.out.println();
  }

  private static void createTwo() {
//    2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    int[] arr = new int[100];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }
    Util.printArray(arr);
    System.out.println();
  }

  private static void createThree() {
//    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    int[] upDown = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    int test = 6;
    Util.printArray(upDown);

    for (int i = 0; i < upDown.length; i++) {
      upDown[i] = upDown[i] < test ? upDown[i] * 2 : upDown[i];
    }
    Util.printArray(upDown);
    System.out.println();
  }

  private static void createFour() {
//    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    final int SIZE = 7;
    int[][] arr = new int[SIZE][SIZE];

    for (int i = 0; i < arr.length; i++) {
      arr[i][i] = 1;
      arr[i][arr[i].length - i - 1] = 1;
    }
    Util.printArray(arr);
    System.out.println();
  }

  private static void createFive() {
//    5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    int len = 5;
    String initialValue = "Hello Java!";
    Util.printArray(doArray(len, initialValue));
    System.out.println();
  }

  private static String[] doArray(int len, String initialValue) {
    String[] arr = new String[len];
    for (int i = 0; i < len; i++) {
      arr[i] = initialValue;
    }
    return arr;
  }

  private static void createSixMinMax() {
//    6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
//    randomNumber = (int) (Math.random() * 10);
    final int SIZE = 10;
    int[] arr = new int[SIZE];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) ((Math.random() * 21) - 11);
    }
    Util.printArray(arr);

    int min = arr[0];
    int max = min;
    for (int i = 1; i < arr.length; ++i) {
      if (arr[i] < min) {
        min = arr[i];
      }
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    System.out.printf("Минимальное число: %d %nМаксимальное число: %d %n", min, max);
  }

  private static void createSevenEqualSides() {
//  7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    int[] arr1 = {1, 1, 1, 2, 1};
    int[] arr2 = {2, 1, 1, 2, 1};
    int[] arr3 = {10, 10};
    int[] arr4 = {2, 2, 2, 1, 2, 2, 10, 1};
    int[] arr5 = {1, 1, 1, 2, 1};

    System.out.println(checkBalance(arr1));
    System.out.println(checkBalance(arr2));
    System.out.println(checkBalance(arr3));
    System.out.println(checkBalance(arr4));
    System.out.println(checkBalance(arr5));
  }

  private static boolean checkBalance(int[] array) {
    int sumTotal = 0;
    int sumRight;
    int sumLeft = 0;

    for (int num : array) {
      sumTotal += num;
    }

    for (int value : array) {
      sumLeft += value;
      sumRight = sumTotal - sumLeft;
      if (sumLeft == sumRight) {
        return true;
      }
    }
    return false;
  }

  //8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
  private static void createShift() {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//    int[] array = {1, 2, 3, 4, 5};
    System.out.println(Arrays.toString(array));
    int n = Util.readIntArgument("Введите число для сдвига (можно отрицательное): ");
    moveArrayByNItems(array, n);
    System.out.println(Arrays.toString(array));
  }

  private static void moveArrayByNItems(int[] arr, int n) {
    // Если n > длины массива, берем такое значение, при котором сдвиг массива будет аналогичным (остаток от деления)
    if (Math.abs(n) > arr.length) {
      if (n > 0) {
        n = (n % arr.length);
      } else {
        n = -(n % arr.length);
      }
    }
    // Если n отрицательное и модуль n меньше длины массива, берем такое положительное значение, при котором сдвиг массива будет аналогичным влево
    if (n < 0) {
      n = arr.length + n;
    }
    System.out.println("Величина сдвига = " + n);

    // Двигаем массив по часовой стрелке на одну позицию n количество раз
    for (int j = 0; j < n; j++) {
      int currentIndex = 0;
      int currentItem = arr[currentIndex];

      for (int i = 0; i < arr.length; i++) {
        int nextIndex = currentIndex + 1;
        if (nextIndex >= arr.length) {
          nextIndex = nextIndex
              % arr.length; // следующий индекс больше длины массива -> остаток берем -> перескакиваем на начало массива на остаток
        }
        int tempItem = arr[nextIndex];
        arr[nextIndex] = currentItem;
        currentItem = tempItem;
        currentIndex = nextIndex;
      }
    }
  }
}