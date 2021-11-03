package lesson6;

public class TaskAnimal {

  public static void main(String[] args) {
    Cat catOne = new Cat("Барсик");
    Dog dogOne = new Dog("Шарик", "Пудель");
    double jump = 0.2;
    int run = 550;
    int swim = 10;
    System.out.printf(
        "Попросим кота %s и собаку %s прыгнуть в высоту на %.1f м,%nпробежать %d м,%nпроплыть %d м%n",
        catOne.getNameOwn(), dogOne.getNameOwn(), jump, run, swim);
    catOne.catInfo();
    catOne.jump(jump);
    catOne.run(run);
    catOne.swim(swim);
    dogOne.runRace(dogOne.getRace());
    dogOne.dogInfo();
    dogOne.jump(jump);
    dogOne.run(run);
    dogOne.swim(swim);
  }

}
