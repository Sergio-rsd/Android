package lesson6;

// Класс Собаки
class Dog extends lesson6.Animal {

  protected int runMax = 500;
  protected int swimMax = 10;

  static int countDog = 0;

  Dog(String name) {
    super(name);
    countDog++;
  }

  Dog(String name, int runMax, int swimMax) {
    super(name);
    this.runMax = runMax;
    this.swimMax = swimMax;
    countDog++;
  }

  void setRunMax(int runMax) {
    this.runMax = runMax;
  }

  void setSwimMax(int swimMax) {
    this.swimMax = swimMax;
  }

  void dogInfo() {
    System.out.printf("У собаки по кличке %s ограничение по бегу %d м и заплыву %d м%n", name,
        runMax, swimMax);
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
    if (Animal.swim(swimLength, swimMax)) {
      System.out.printf(goodSwim, name, swimLength);
    } else {
      swimLength = swimMax;
      System.out.printf(badSwim, name, swimLength);
    }
  }

}
