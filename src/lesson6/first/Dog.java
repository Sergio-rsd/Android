package lesson6.first;

// Класс Собаки
class Dog extends Animal {

  private final String nameOwn;
  private final String race;
  protected double jumpMax = 0.5;
  protected int runMax = 500;
  protected int swimMax = 10;
  static int countDog = 0;

  Dog(String nameOwn, String race) {
    this.nameOwn = nameOwn;
    this.race = race;
    countDog++;
    Animal.countAnimal++;
  }

  String getNameOwn() {
    return nameOwn;
  }

  String getRace() {
    return race;
  }

  void dogInfo() {
    System.out.printf("Собака по кличке %s, породы %s%n", nameOwn, race);
  }

  void runRace(String race) {
    if (race.equals("Овчарка")) {
      runMax = 600;
    } else if (race.equals("Пудель")) {
      runMax = 400;
    }
  }

  @Override
  void jump(double jumpHeight) {
    if (jumpHeight > jumpMax) {
      jumpHeight = jumpMax;
      System.out.printf(badJump, nameOwn, jumpHeight);
    } else {
      System.out.printf(goodJump, nameOwn, jumpHeight);
    }
  }

  @Override
  void run(int runLength) {
    if (runLength > runMax) {
      runLength = runMax;
      System.out.printf(badRun, nameOwn, runLength);
    } else {
      System.out.printf(goodRun, nameOwn, runLength);
    }
  }

  @Override
  void swim(int swimLength) {
    if (swimLength > swimMax) {
      swimLength = swimMax;
      System.out.printf(badSwim, nameOwn, swimLength);
    } else {
      System.out.printf(goodSwim, nameOwn, swimLength);
    }
  }

}
