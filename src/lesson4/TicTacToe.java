package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  // блок настроек игры
  private static char[][] map; // матрица игры
  private static int SIZE = 3; // размер поля
  private static int CHIPS = 3; // количество фишек
  private static final char DOT_EMPTY = '•'; //пустое простанство
  private static final char DOT_X = 'X'; // крестик
  private static final char DOT_O = 'O'; // нолик
  //  private static final String HEADER_FIRST_MAP = "♥";
  private static final String SPACE_MAP = " ";

  private static final Scanner scanner = new Scanner(System.in);
  private static final Random random = new Random();
  private static final boolean SILLY_MODE = false;
//    private static final boolean SILLY_MODE = true; // тупой ПК

  public static void main(String[] args) {
    initGame();
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

  private static void initGame() {
    System.out.println("Начинаем игру в крестики нолики!");
    System.out.println("Укажите размер поля для игры (по умолчанию лучше оставить 3X3)");
    SIZE = numberCheck();
    setTheNumberOfChips();
  }

  private static void setTheNumberOfChips() {
    System.out.println("Укажите количество победных фишек (для поля 3X3 - 3 фишки)\nВсе равно поставим нужное количество :-)");
    CHIPS = numberCheck();
    if (SIZE >= 3 && SIZE <= 5) {
      CHIPS = 3;
    } else if (SIZE >= 6 && SIZE <= 10) {
      CHIPS = 4;
    } else if (SIZE >= 11) {
      CHIPS = 5;
    } else {
      CHIPS = 3;
    }
    System.out.println("Выбрано количество фишек " + CHIPS);
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

    for (int i = 0, k = 0; i < SIZE; i++, k++) {
      if (k == 1) {
        i = 0;
      }
      System.out.print(k + SPACE_MAP);
      for (int j = 0; j < SIZE; j++) {
        System.out.print(k == 0 ? j + 1 + SPACE_MAP : map[i][j] + SPACE_MAP);
      }
      System.out.println();
    }
  }

  //ход человека
  private static void humanTurn() {
    int x, y;

    do {
      System.out.print("Введите координаты ячейки по вертикали (X) ");
      y = isCellValid(numberCheck()) - 1; // Считывание номера строки
      System.out.print("Введите координаты ячейки по горизонтали (Y) ");
      x = isCellValid(numberCheck()) - 1; // Считывание номера столбца

    }
    while (isCellValid(x, y));
    // смотрим
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
          // проверка на пустую клетку - занято

          if (map[i][j] == DOT_EMPTY) { // клетка свободна
            // проверка на соседний знак хода ПК
            // обозначаем квадрат поисков в одну ячейку рядом
            minY = searchQuadrantMin(i - 1);
            minX = searchQuadrantMin(j - 1);
            maxY = searchQuadrantMax(i);
            maxX = searchQuadrantMax(j);
            for (int k = minY; k < maxY; k++) {
              for (int l = minX; l < maxX; l++) {
                if (map[k][l] == map[i][j]) { // соседняя клетка своя
                  // фиксируем координаты
                  y = i;
                  x = j;
                  flagChek = true;
                  break;
                }
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

  public static int searchQuadrantMax(int el) {
    if (el == 0) {
      return 1;
    } else {
      return 2;
    }
  }

  // Метод валидации корректного ввода координат
  // на ввод символа
  public static int numberCheck() {
    while (true) {
      if (scanner.hasNextInt()) {
        return scanner.nextInt();
      } else {
        scanner.next();
        System.out.println("Введите число");
      }
    }
  }

  // на цифру в диапазоне
  // проверка на диапазон для хода человека (одно значение)
  private static int isCellValid(int el) {
    while (true) {
      if (el >= 0 && el <= SIZE) {
        return el;
      } else {
        scanner.nextLine();
        System.out.println("Введите цифры от 1 до " + SIZE);
        el = numberCheck();
      }
    }

  }

  public static boolean isCellValid(int x, int y) {
    boolean result = false;
    if (!(x >= 0 && x < SIZE && y >= 0 && y < SIZE)) {
      System.out.println("Введите цифры от 1 до " + SIZE);
      return true;
    }
    if (map[y][x] != DOT_EMPTY) {
      result = true;
    }

    return result;
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
  // -- вроде работает

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

}
