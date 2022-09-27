import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ПКС-419 Федоров 19
public class Main {
    private static final int MAX_WORD_LENGTH = 8;

    public static void main(String[] args) {
        System.out.println("Введите слово");
        Scanner input = new Scanner(System.in);
        String inputWord = input.next();

        System.out.println(checkValidWord(inputWord));

        System.out.println("Введите строку содержащую время");
        findTimeInString(input.next());

        int[] inputNumbers = new int[10];
        for (int i = 0; i < inputNumbers.length; i++) {
            System.out.printf("Введите %d элемент массива%n", i + 1);
            inputNumbers[i] = input.nextInt();
        }

        System.out.println("Введите число b");
        int b = input.nextInt();
        System.out.println("Введите число di");
        int di = input.nextInt();

        System.out.printf("Ответ = %f%n", calculateSum(inputNumbers, b, di));
    }

    //Задача 1
    public static String checkValidWord(String word) {
        try {
            if (word.length() >= MAX_WORD_LENGTH) {
                return "Слово превышает " + MAX_WORD_LENGTH + " симоволов!";
            }
            if (Pattern.matches("(.*кн.*)", word)) {
                return word;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "Вхождений не найдено!";
    }

    //Задача 2
    public static float calculateSum(int[] numbersArray, int b, int di) {
        try {
            if (di > 10) {
                return 0.0F;
            }

            int summaUp = 0;
            int summaDown = 0;

            //Сумма Числителя и Знаменателя
            for (int i = 0; i < 10; i++) {
                int number = numbersArray[i];
                summaUp += ((number * number) - b);
                summaDown += (number - b);
            }

            return (float) (summaUp / summaDown) - (numbersArray[di - 1] - b);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    //Задача 3
    public static void findTimeInString(String string) {
        try {
            if (Pattern.matches("^.*(1?[0-9]|2[0-3]):[0-5][0-9].*", string)) {
                System.out.printf("Строка содержит время%n"); //Текст 11:11
            }
            //".*(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9].*"
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

