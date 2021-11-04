package lesson6.first;

// Класс Коты
class Cat extends Animal {

  private final String nameOwn;
  protected double jumpMax = 2;
  protected int runMax = 200;
  protected int swimMax = 0;
  static int countCat = 0;

  Cat(String nameOwn) {
    this.nameOwn = nameOwn;
    countCat++;
    Animal.countAnimal++;
  }

  String getNameOwn() {
    return nameOwn;
  }

  void catInfo() {
    System.out.printf("Кот по кличке %s%n", nameOwn);
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
    if (swimLength >= swimMax) {
      System.out.printf("%s не поплывет, утонет..%n", nameOwn);
    }
  }
}
