package lesson6.first;

class TaskAnimal {

  public static void main(String[] args) {
    Cat catOne = new Cat("Барсик");
    Dog dogOne = new Dog("Шарик", "Пудель");
    Dog dogTwo = new Dog("Мухтар", "Овчарка");
    double jump = 0.2;
    int run = 550;
    int swim = 10;
    System.out.printf(
        "Попросим кота %s и собак %s и %s прыгнуть в высоту на %.1f м,%nпробежать %d м,%nпроплыть %d м%n",
        catOne.getNameOwn(), dogOne.getNameOwn(), dogTwo.getNameOwn(), jump, run, swim);
    catOne.catInfo();
    catOne.jump(jump);
    catOne.run(run);
    catOne.swim(swim);
    dogOne.runRace(dogOne.getRace());
    dogOne.dogInfo();
    dogOne.jump(jump);
    dogOne.run(run);
    dogOne.swim(swim);
    dogTwo.runRace(dogTwo.getRace());
    dogTwo.dogInfo();
    dogTwo.jump(jump);
    dogTwo.run(run);
    dogTwo.swim(swim);
    System.out.printf("Учавствствовали %d котов, %d собак, всего животных %d", Cat.countCat,
        Dog.countDog, Animal.countAnimal);
  }

}
