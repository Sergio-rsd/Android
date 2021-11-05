package lesson6;

// Класс Коты
class Cat extends lesson6.Animal {

  protected int runMax = 200;
  protected int swimMax = 0;
  static int countCat = 0;

  Cat(String name) {
    super(name);
    countCat++;
  }

  Cat(String name, int runMax) {
    super(name);
    this.runMax = runMax;
    countCat++;
  }

  void catInfo() {
    System.out.printf("У кота %s ограничение по бегу %d м и плавать он не может!%n", name, runMax);
  }

  void run(int runLength) {
    if (Animal.run(runLength, runMax)) {
      System.out.printf(goodRun, name, runLength);
    } else {
      runLength = runMax;
      System.out.printf(badRun, name, runLength);
    }
  }

  void swim(int swimLength) {
    if (!Animal.swim(swimLength, swimMax)) {
      System.out.printf("%s не поплывет, утонет..%n", name);
    }
  }

}
