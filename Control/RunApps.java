package Control;

import Class.Animal;
import Class.Animals.*;
import Class.Counter;

import java.util.LinkedList;

import static View.GetAnswer.*;
import static View.Menus.*;

public class RunApps {
    static String notPoint = "Такого пункта в меню нет, попробуйте ещё раз";

    public static void Run() {
        LinkedList<Animal> lstAnimals = new LinkedList<>();
        while (true) {
            MainMenu(Counter.getCounter());
            int choice = ChoiceInMenu();
            switch (choice) {
                case 1 -> {
                    try (Counter count = new Counter()) {
                        System.out.println("Начинаем процедуру добавления животного");
                        Animal tmp = AddAnimal();
                        if (tmp != null) {
                            System.out.println("Укажите список команд, через запятую, которые может выполнять ваше животное");
                            tmp.addCommands(GetString().split(","));
                            if (tmp.getName().length() == 0) throw new RuntimeException("Не указано имя питомца");
                            if (tmp.getCommands().size() == 0) throw new RuntimeException("Не указано ни одной команды");
                            count.add();
                            lstAnimals.add(tmp);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Повторите попытку");
                        System.out.println();
                    }
                }
                case 2 -> {
                    if (lstAnimals.size() != 0) {
                        System.out.println("Выберите животное, которое хотите обучить");
                        System.out.println("Ниже список животных, которых сдали в питомник:\n");
                        ShowListAnimals(lstAnimals);
                        int numAnimal = ChoiceInMenu();
                        if (numAnimal >= 0 && numAnimal < lstAnimals.size()) {
                            System.out.println("Укажите команду или команды (через запятую) которым хотите обучить питомца");
                            String commands = GetString();
                            lstAnimals.get(numAnimal).addCommands(commands.split(","));
                        } else {
                            System.out.println("Животного с данным номером нет в питомнике");
                        }
                    } else System.out.println("На данный момент питомник не содержит животных\n");
                }
                case 3 -> {
                    if (lstAnimals.size() != 0) {
                        System.out.println("Ниже список животных, которых сдали в питомник:\n");
                        ShowListAnimals(lstAnimals);
                    } else System.out.println("На данный момент питомник не содержит животных\n");
                }
                case 4 -> {
                    if (lstAnimals.size() != 0) {
                        System.out.println("Какое животное из списка ниже вы хотите узнать лучше");
                        System.out.println("Ниже список животных, которых сдали в питомник:\n");
                        ShowListAnimals(lstAnimals);
                        int numAnimal = ChoiceInMenu();
                        if (numAnimal >= 0 && numAnimal < lstAnimals.size()) {
                            System.out.println(lstAnimals.get(numAnimal));
                            ShowListMakeCommands(lstAnimals.get(numAnimal));
                        } else {
                            System.out.println("Животного с данным номером нет в питомнике");
                        }
                    } else System.out.println("На данный момент питомник не содержит животных\n");
                }
                case 0 -> {
                    System.out.println("До свидания");
                    return;
                }
                default -> System.out.println(notPoint);
            }
        }
    }

    public static Animal AddAnimal() {
        System.out.println("Введите имя животного:");
        String name = GetString();
        while (true) {
            TypeAnimalMenu();
            int choiceType = ChoiceInMenu();
            switch (choiceType) {
                case 1:
                    //noinspection TextLabelInSwitchStatement
                    loopPets:
                    while (true) {
                        ShowKindPets();
                        int choiceKind = ChoiceInMenu();
                        switch (choiceKind) {
                            case 1:
                                return new Dog(name);
                            case 2:
                                return new Cat(name);
                            case 3:
                                return new Hamster(name);
                            case 0:
                                break loopPets;
                            default:
                                System.out.println(notPoint);
                                break;
                        }
                    }
                    break;
                case 2:
                    //noinspection TextLabelInSwitchStatement
                    loopPackAnimal:
                    while (true) {
                        ShowKindPackAnimals();
                        int choiceKind = ChoiceInMenu();
                        switch (choiceKind) {
                            case 1:
                                return new Horse(name);
                            case 2:
                                return new Donkey(name);
                            case 3:
                                return new Camel(name);
                            case 0:
                                break loopPackAnimal;
                            default:
                                System.out.println(notPoint);
                                break;
                        }
                    }
                    break;
                case 0:
                    return null;
                default:
                    System.out.println(notPoint);
            }
        }
    }
}