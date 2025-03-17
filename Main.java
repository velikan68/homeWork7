import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"}; // Объявляем массив продуктов
        int[] prices = {50, 14, 80}; // Объявляем массив цены на продукты
        int[] cart = new int[products.length]; // Добавляем массив для хранения продуктов

        Scanner sc = new Scanner(System.in); //Добавляем сканер (импорт)

        //Вывод списка товаров
        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
        //Начальная сумма продуктов
        int sumProducts = 0;

        // Цикл покупок
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = sc.nextLine();

            if ("end".equals(input)) {
                break;
            }

            try {
                String[] parts = input.split(" ");
                int productNumber = Integer.parseInt(parts[0]) - 1;
                int productCount = Integer.parseInt(parts[1]);

                if (productNumber >= 0 && productNumber < products.length) {
                    cart[productNumber] += productCount;
                    System.out.println("Товар добавлен.");
                } else {
                    System.out.println("Некорректный номер.");
                }

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Некорректный ввод. Введите номер товара и количество через пробел.");

            }
        }

        // Показываем корзину и сумму
        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (cart[i] > 0) {
                int currentPrice = prices[i];
                int totalCost = cart[i] * currentPrice;
                System.out.println(products[i] + " " + cart[i] + " шт " + currentPrice + " руб/шт " + totalCost + " руб в сумме");
                sumProducts += totalCost;
            }
        }

        System.out.println("Итого " + sumProducts + " руб");
        sc.close();
    }
}