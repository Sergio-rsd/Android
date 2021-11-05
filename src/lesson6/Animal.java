package lesson6;

// Класс животные
class Animal {

  String name;
  static int contAnimal;

  // каждое животное имеет кличку
  Animal(String name) {
    this.name = name;
    contAnimal++;
  }

  // каждое животное бегает
  static boolean run(int runLength, int runMax) {
    return runLength <= runMax;
  }

  // каждое животное плавает (иногда)
  static boolean swim(int swimLength, int swimMax) {
    return swimLength <= swimMax;
  }

  static String goodRun = "%s хорошо бегает, легко пробежит %d м%n";
  static String badRun = "%s не сможет пробежать сразу дальше %d м, увы..%n";
  static String goodSwim = "%s хорошо плавает и проплывает %d м%n";
  static String badSwim = "%s вряд ли %d м проплывет, утонет..%n";
}