package lesson6;

// Класс Собаки
public class Dog extends lesson6.Animal {

  private final String nameOwn;
  private final String race;
  protected double jumpMax = 0.5;
  protected int runMax = 500;
  protected int swimMax = 10;

  public Dog(String nameOwn, String race) {
    this.nameOwn = nameOwn;
    this.race = race;
  }

  public String getNameOwn() {
    return nameOwn;
  }

  public String getRace() {
    return race;
  }

  public void dogInfo() {
    System.out.printf("Собака по кличке %s, породы %s%n", nameOwn, race);
  }

  public void runRace(String race) {
    if (race.equals("Овчарка")) {
      runMax = 600;
    } else if (race.equals("Пудель")) {
      runMax = 400;
    }
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
    if (swimLength > swimMax) {
      swimLength = swimMax;
      System.out.printf(badSwim, nameOwn, swimLength);
    } else {
      System.out.printf(goodSwim, nameOwn, swimLength);
    }
  }


}
