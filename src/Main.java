import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите код оперции 1- добавить ,2- показать, 3- удалить ,4- поиск покупки по слову :");
            String value = scanner.nextLine();
            int val = Integer.parseInt(value);
            if (val == 1) {
                addProduct(list, scanner);
            }
            if (val == 2) {
                shoppingList(list);
            }
            if (val == 3) {
                deleteProduct(list, scanner);
            }
            if (val == 4) {
                searchProduct(list, scanner);
            }
        }
    }

    private static void searchProduct(List<String> list, Scanner scanner) {
        System.out.println("Введите текст для поиска :");
        String text = scanner.nextLine();
        String queryLower = text.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            String itemLower = list.get(i).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println(i + 1 + ".  " + list.get(i));
            }
        }
    }

    private static void deleteProduct(List<String> list, Scanner scanner) {
        System.out.println("Список покупок:");
        shoppingList(list);
        System.out.println("Какую хотите удалить? Введите номер или название");
        try {
            int number = scanner.nextInt();
            System.out.println("Покупка  <" + list.get(number - 1) + "> удалена, список покупок:");
            list.remove(number - 1);
            shoppingList(list);
        } catch (InputMismatchException exception) {
            String product = scanner.nextLine();
            list.remove(product);
            System.out.println("Покупка  <" + product + "> удалена, список покупок:");
            shoppingList(list);
        }
    }

    private static void addProduct(List<String> list, Scanner scanner) {
        System.out.println("Какую покупку хотите добавить?");
        String product = scanner.nextLine();
        list.add(product);
        System.out.println("Итого в списке покупок: " + list.size());
    }

    public static void shoppingList(List<String> list) {
        System.out.println("Список покупок:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ".  " + list.get(i));
        }
    }
}