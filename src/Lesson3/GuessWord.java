package Lesson3;

public class GuessWord {

  //  Создать массив из слов/
// При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах
// Играем до тех пор, пока игрок не отгадает слово.
//  Используем только маленькие буквы.

  public static void main(String[] args) {
    String[] arrayWords = new String[]{"apple", "orange", "lemon", "banana", "apricot",
        "avocado",
        "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
        "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
        "potato"};
    // компютер загадывает слово
    int randomIndexWord = (int) (Math.random() * (arrayWords.length + 1));
    System.out.println(arrayWords[randomIndexWord]);
    String magicWord = arrayWords[randomIndexWord];

    // играем
    playGame(magicWord);
  }

  private static void playGame(String wordComputer) {
    String answerUser;
    do {
      answerUser = Util.readStringArgument("Введите слово : ");
      String resultSearch = searchChar(answerUser, wordComputer);
      if (resultSearch.equals(wordComputer)) {
        System.out.println("Вы угадали слово !!!");
      } else {
        System.out.println(resultSearch + "###############");
      }
    } while (!answerUser.equals(wordComputer));
  }

  private static String searchChar(String answerUser, String wordComputer) {
    String resultSearch = "";
    int start = 0;
    int end = 0;
    boolean flag = false;

    if (answerUser.length() > wordComputer.length()) { // длина введеного больше загаданного
      return resultSearch;
    }

    for (int i = 0; i < answerUser.length(); i++) {
      if (answerUser.charAt(i) == wordComputer.charAt(i)) {
        end = i;
        flag = true;
      }
    }
    if (!flag) {
      return resultSearch;
    } else {
      resultSearch = answerUser.substring(start, end + 1);
      return resultSearch;
    }
  }

}
