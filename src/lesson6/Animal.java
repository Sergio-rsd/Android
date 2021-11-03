package lesson6;

// Класс животные
public abstract class Animal {

  public abstract void jump(double jumpHeight);

  public abstract void run(int runLength);

  public abstract void swim(int swimLength);

  protected static String goodJump = "%s хорошо прыгает, легко прыгнет на %.1f м%n";
  protected static String badJump = "%s не сможет прыгнуть выше %.1f м%n";
  protected static String goodRun = "%s хорошо бегает, легко пробежит %d м%n";
  protected static String badRun = "%s не сможет пробежать сразу дальше %d м, увы..%n";
  protected static String goodSwim = "%s хорошо плавает и проплывает %d м%n";
  protected static String badSwim = "%s вряд ли столько %d м проплывет, утонет..%n";

}