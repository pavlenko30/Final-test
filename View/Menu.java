package View;

import Classes.Animal;

import java.util.LinkedList;

public class Menus {
    public static void MainMenu(int values) {
        System.out.println("В нашем питомнике вы можете оствить ваше животное на время или обучить новым коммандам:");
        System.out.println("На данный момент у нас в наличии " + values + " животных");
        System.out.println("1. Оставить животное");
        System.out.println("2. Обучить животное");
        System.out.println("3. Посмотреть список животных в питомнике");
        System.out.println("4. Выбрать животное, для просмотра списка известных команд");
        System.out.println("0. Уйти\n");
    }

    public static void TypeAnimalMenu() {
        System.out.println("Мы занимаемся следующими животными, какое вы хотите добавить:");
        System.out.println("1. Домашними животными");
        System.out.println("2. Вьючными животными");
        System.out.println("0. Назад\n");
    }

    public static void ShowKindPets() {
        System.out.println("Наши питомник имеет условия для приёма следующих домашних животных:");
        System.out.println("1. Собаки");
        System.out.println("2. Кошки");
        System.out.println("3. Хомячки");
        System.out.println("0. Назад\n");
    }

    public static void ShowKindPackAnimals() {
        System.out.println("Наши питомник имеет условия для приёма следующих вьючных животных:");
        System.out.println("1. Лошади");
        System.out.println("2. Ослы");
        System.out.println("3. Верблюды");
        System.out.println("0. Назад\n");
    }

    public static void ShowListAnimals(LinkedList<Animal> lstAnimals) {
        String divider = "-".repeat(80);
        System.out.println(divider);
        System.out.printf("| %7s | %20s | %20s | %20s |\n", "номер", "имя", "тип животного", "вид животного");
        System.out.println(divider);
        for (int i = 0; i < lstAnimals.size(); i++) {
            System.out.printf("| %7s | %20s | %20s | %20s |\n", i, lstAnimals.get(i).getName(), lstAnimals.get(i).getTypeAnimal(), lstAnimals.get(i).getKindAnimal());
            System.out.println(divider);
        }
    }

    public static void ShowListMakeCommands(Animal animal) {
        System.out.println(animal.getName() + " может выполнять следующие команды:");
        for (int i = 0; i < animal.getCommands().size(); i++) {
            System.out.printf("\t%d. %s%n", i, animal.getCommands().get(i));
        }
        System.out.println();
    }
}