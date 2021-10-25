package Lesson3;

//  Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
public class GuessNumber {

  private static final int ATTEMPTS = 3;

  public static void main(String[] args) {

    playGame();

  }

  static void playGame() {
    int desirePlay;
    int randomNumber;

    do {
      System.out.printf("%nУгадайте число от 0 до 9, у Вас %d попытки %n", ATTEMPTS);
      randomNumber = (int) (Math.random() * 10);
      System.out.println(randomNumber);
      desirePlay = playGameOne(randomNumber);
    } while (desirePlay == 1);
  }

  static int playGameOne(int randomNumberRound) {
    int attemptNumber = ATTEMPTS;
    int answerUser;
    int round;

    do {
      answerUser = Util.readIntArgument("Введите число : ");
      if (answerUser < 0 || answerUser > 9) {
        attemptNumber--;
        System.out.printf("Введите число от 0 до 9. У Вас осталось попыток %d %n",
            attemptNumber);

      } else if (answerUser < randomNumberRound) {
        attemptNumber--;
        System.out.printf("Введенное число меньше загаданного, У Вас осталось попыток %d %n",
            attemptNumber);

      } else if (answerUser > randomNumberRound) {
        attemptNumber--;
        System.out.printf("Введенное число больше загаданного. У Вас осталось попыток %d %n",
            attemptNumber);


      } else {
        System.out.println("Ура!! Вы угадали!!");
        break;
      }
    } while (attemptNumber != 0);
    if (answerUser != randomNumberRound) {
      System.out.println("Вы проиграли! Правильное число " + randomNumberRound);
    }
    round = Util.readIntArgument("Повторить игру еще раз? 1 – да / 0 – нет : ");
    return round;
  }

}
