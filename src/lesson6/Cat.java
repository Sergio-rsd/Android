package lesson6;

// Класс Коты
public class Cat extends lesson6.Animal {

  private final String nameOwn;
  protected double jumpMax = 2;
  protected int runMax = 200;
  protected int swimMax = 0;

  public Cat(String nameOwn) {
    this.nameOwn = nameOwn;
  }

  public String getNameOwn() {
    return nameOwn;
  }

  public void catInfo() {
    System.out.printf("Кот по кличке %s%n", nameOwn);
  }

  @Override
  public void jump(double jumpHeight) {
    if (jumpHeight > jumpMax) {
      jumpHeight = jumpMax;
      System.out.printf(badJump, nameOwn, jumpHeight);
    } else {
      System.out.printf(goodJump, nameOwn, jumpHeight);
    }
  }

  @Override
  public void run(int runLength) {
    if (runLength > runMax) {
      runLength = runMax;
      System.out.printf(badRun, nameOwn, runLength);
    } else {
      System.out.printf(goodRun, nameOwn, runLength);
    }
  }

  @Override
  public void swim(int swimLength) {
    if (swimLength >= swimMax) {
      System.out.printf("%s не поплывет, утонет..%n", nameOwn);
    }
  }
}
