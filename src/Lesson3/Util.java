package Lesson3;

import java.util.Scanner;

public class Util {

  // печать массивов
  static void printArray(int[] arrayToPrint) {
    for (int item : arrayToPrint) {
      System.out.print(item + " ");
    }
    System.out.print('\n');
  }

  static void printArray(int[][] arrayToPrint) {
    for (int[] item : arrayToPrint) {
      for (int inner : item) {
        System.out.print(inner + " ");
      }
      System.out.println();
    }
  }

  static void printArray(String[] arrayToPrint) {
    for (String item : arrayToPrint) {
      System.out.print(item + " ");
    }
    System.out.println();
  }

  // считывание данных
  public static Scanner readText(String userText) {
    Scanner userInput = new Scanner(System.in);
    System.out.print(userText);
    return userInput;
  }

  static String readStringArgument(String userText) {
    return readText(userText).nextLine().toLowerCase();
  }

  static int readIntArgument(String userText) {
    return readText(userText).nextInt();
  }
}
