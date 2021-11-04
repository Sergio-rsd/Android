package lesson6.first;

// Класс животные
abstract class Animal {

  abstract void jump(double jumpHeight);

  abstract void run(int runLength);

  abstract void swim(int swimLength);

  static int countAnimal = 0;

  static String goodJump = "%s хорошо прыгает, легко прыгнет на %.1f м%n";
  static String badJump = "%s не сможет прыгнуть выше %.1f м%n";
  static String goodRun = "%s хорошо бегает, легко пробежит %d м%n";
  static String badRun = "%s не сможет пробежать сразу дальше %d м, увы..%n";
  static String goodSwim = "%s хорошо плавает и проплывает %d м%n";
  static String badSwim = "%s вряд ли столько %d м проплывет, утонет..%n";

}