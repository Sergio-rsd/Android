package lesson6;

import java.util.Scanner;

class TaskAnimal {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Cat catOne = new Cat("Барсик");
    Cat catTwo = new Cat("Пушок", 50);
    Cat catTree = new Cat("Мурзик", 120);
    Cat[] catTeam = {catOne, catTwo, catTree};
    Dog dogOne = new Dog("Шарик");
    Dog dogTwo = new Dog("Мухтар");
    dogTwo.setRunMax(600);
    Dog dogThree = new Dog("Жучка");
    dogThree.setSwimMax(8);
    Dog dogFour = new Dog("Амур", 250, 20);
    Dog[] dogTeam = {dogOne, dogTwo, dogThree, dogFour};
    int run;
    int swim;
    String catNames = "";
    String dogNames = "";
    for (Cat catBand : catTeam) {
      catNames = catNames.concat(catBand.name + ", ");
    }
    for (Dog dogBand : dogTeam) {
      dogNames = dogNames.concat(dogBand.name + ", ");
    }
    do {
      System.out.println("Учим котов и собак бегать и плавать!");
      System.out.printf(
          "Попросим котов по именам %sи собак по именам %sпробежать и проплыть.%n",
          catNames, dogNames);
      System.out.print("Укажите дистанцию для пробега: ");
      run = scanner.nextInt();
      System.out.print("Укажите дистанцию для заплыва: ");
      swim = scanner.nextInt();
      for (Cat cat : catTeam) {
        cat.run(run);
        cat.swim(swim);
        cat.catInfo();
      }
      for (Dog dog : dogTeam) {
        dog.run(run);
        dog.swim(swim);
        dog.dogInfo();
      }
      System.out.print("Еще потренируем? (0 - нет, 1 - да): ");

    } while (scanner.nextInt() != 0);
    System.out.println("В тренировке учавствовали:");
    System.out.printf("Всего котов: %d%n", Cat.countCat);
    System.out.printf("Всего собак: %d%n", Dog.countDog);
    System.out.printf("Всего животных: %d%n", Animal.contAnimal);
    scanner.close();
  }

}
