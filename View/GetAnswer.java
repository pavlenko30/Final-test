package View;

import java.util.Scanner;

public class GetAnswer {
    public static int ChoiceInMenu() {
        int choice;
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("--> ");
                choice = in.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Не верный ввод, необходимо указать число от нуля и выше.");
            }
        }
        return choice;
    }

    public static boolean ConfirmData (String data) {
        String ans;
        while (true) {
            System.out.println("Вы подтверждаете следующие данные:");
            System.out.println("\t" + data);
            System.out.println("y/n");
            System.out.print("--> ");
            Scanner in = new Scanner(System.in);
            ans = in.nextLine();
            try {
                if (ans.equals("y") || ans.equals("n")) {
                    return ans.equals("y");
                } else {
                    throw new Exception("Invalid input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Try Again");
            }
        }
    }
    public static String GetString() {
        Scanner in = new Scanner(System.in);
        System.out.print("--> ");
        return in.nextLine();
    }
}