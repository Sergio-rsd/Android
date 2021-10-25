package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  // блок настроек игры
  private static char[][] map; // матрица игры
  private static final int SIZE = 3; // размер поля
  private static final char DOT_EMPTY = '•'; //пустое простанство
  private static final char DOT_X = 'X'; // крестик
  private static final char DOT_O = 'O'; // нолик

  private static final Scanner scanner = new Scanner(System.in);
  private static final Random random = new Random();
  private static final boolean SILLY_MODE = false;
//    private static final boolean SILLY_MODE = true; // тупой ПК

  public static void main(String[] args) {
    initMap();
    printMap();

    while (true) {
      humanTurn(); //ход человека
      if (isEndGame(DOT_X)) {
        break;

      }
      computerTurn(); //ход компьютера
      if (isEndGame(DOT_O)) {
        break;
      }
    }
    System.out.println("Игра закончена");
  }

  // Метод подготовки поля
  private static void initMap() {
    map = new char[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        map[i][j] = DOT_EMPTY;
      }
    }
  }

  // метод вывода игрового поля - оптимизирован
  private static void printMap() {
    // вроде оптимизирована

    for (int i = 0, k = 0; i < SIZE; i++, k++) {
      if (k == 1) {
        i = 0;
      }
      System.out.print(k + " ");
      for (int j = 0; j < SIZE; j++) {
        System.out.print(k == 0 ? j + 1 + " " : map[i][j] + " ");
      }
      System.out.println();
    }
  }

//  private static void printMap(int[][] elMap) {
//    // для проверки образа map
//
//    for (int i = 0, k = 0; i < SIZE; i++, k++) {
//      if (k == 1) {
//        i = 0;
//      }
//      System.out.print(k + " ");
//      for (int j = 0; j < SIZE; j++) {
//        System.out.print(k == 0 ? j + 1 + " " : elMap[i][j] + " ");
//      }
//      System.out.println();
//    }
//  }

  //ход человека
  private static void humanTurn() {
    int x, y;
    do {
      System.out.println("Введите координаты ячейки (X Y)");
      y = scanner.nextInt() - 1; // Считывание номера строки
      x = scanner.nextInt() - 1; // Считывание номера столбца
    }
    while (isCellValid(x, y));
    map[y][x] = DOT_X;
  }

  // ход компьтера
  private static void computerTurn() {
    int x = -1;
    int y = -1;

    int minY;
    int maxY;
    int minX;
    int maxX;
    boolean flagChek = false;

    if (SILLY_MODE) {
      do {
        x = random.nextInt(SIZE);
        y = random.nextInt(SIZE);
      } while (isCellValid(x, y));
    } else {
      for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
          // проверка клеток по направлениям
/*          if (map[i][j] != DOT_EMPTY) {

            // проверка на пустую клетку - занято
            continue; // ищем пустую дальше
          } else*/
          if (map[i][j] == DOT_EMPTY) { // клетка свободна
            // проверка на соседний знак хода ПК
            // обозначаем квадрат поисков в одну ячейку рядом
            minY = searchQuadrantMin(i - 1);
            minX = searchQuadrantMin(j - 1);
            maxY = searchCvadrantMax(i);
            maxX = searchCvadrantMax(j);
            for (int k = minY; k < maxY; k++) {
              for (int l = minX; l < maxX; l++) {
                if (map[k][l] == map[i][j]) { // соседняя клетка своя

                  // фиксируем координаты
                  y = i;
                  x = j;
                  flagChek = true;
                  break;
                }
/*                else {
                  continue; // ищем похожую дальше
                }*/
              }
              if (flagChek) {
                break;
              }
            }
            if (flagChek) {
              break;
            }
          }
        }
        if (flagChek) {
          break;
        }
      }
      if (!flagChek) {
        do {
          x = random.nextInt(SIZE);
          y = random.nextInt(SIZE);
        } while (isCellValid(x, y));
      }
    }
    // проверка заполнения проверочной таблицы для хода ПК

    System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
    map[y][x] = DOT_O;

  }

  public static int searchQuadrantMin(int el) {
    if (el <= 0) {
      return 0;
    } else {
      return el - 1;
    }
  }

  public static int searchCvadrantMax(int el) {
    if (el == 0) {
      return 1;
    } else {
      return 2;
    }
  }

  // Метод валидации корректного ввода координат
  public static boolean isCellValid(int x, int y) {
    boolean result = x >= 0 && x < SIZE && y >= 0 && y < SIZE;

    if (map[y][x] != DOT_EMPTY) {
      result = false;
    }

    return !result;
  }

  // Метод проверки игры на завершение
  private static boolean isEndGame(char playerSymbol) {
    boolean result = false;
    printMap();
    // проверка необходимости следующего хода
    if (checkWin(playerSymbol)) {
      System.out.println("Победа за " + playerSymbol);
      result = true;
      return result;
    }
    if (isMapFull()) {
      System.out.println("Ничья, увы...");
      result = true;
    }
    return result;
  }

  // проверка на 100% заполненность игрового поля
  private static boolean isMapFull() {
    boolean result = true;
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (map[i][j] == DOT_EMPTY) {
          result = false;
          break;
        }
      }
    }
    return result;
  }

  // Метод проверки победы в игре
  // Всего 8 комбинаций
/*  private static boolean checkWin(char playerSymbol) {
    boolean result = false;

    if (
        (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
            (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
            (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
            (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
            (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
            (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
            (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
            (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)) {
      result = true;
    }

    return result;
  }*/

  // --
  //       Можно еще так сделать проверку на победу:
  //**
//     * Проверка выйгрышных комбинаций компьтера, или человека
//     * @param playerSymbol символ игрока, или компьютера для проверки
//     * @return true or false

  public static boolean checkWin(char playerSymbol) {
    boolean checkLine, checkColumns, checkDiagonalA, checkDiagonalB;
    for (int i = 0; i < map.length; i++) {
      checkLine = true;
      checkColumns = true;
      checkDiagonalA = true;
      checkDiagonalB = true;
      for (int j = 0; j < map.length; j++) {
        checkLine &= (map[i][j] == playerSymbol);
        checkColumns &= (map[j][i] == playerSymbol);
        checkDiagonalA &= (map[j][j] == playerSymbol);
        checkDiagonalB &= (map[map.length - j - 1][j] == playerSymbol);
      }
      if (checkLine || checkColumns || checkDiagonalA || checkDiagonalB) {
        return true;
      }
    }
    return false;
  }
  // --


}
