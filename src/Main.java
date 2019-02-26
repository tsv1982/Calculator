import java.util.Scanner;

public class Main {

    private static int a;
    private static boolean boolAB = true;
    private static int b;
    private static String op;
    private static boolean boolOp = true;
    private static String exit = "y";
    private static boolean arabBool = true;
    private static boolean rimBool = true;
    public static boolean inFormat = true;

    private static void nullNum() {    // обнуляем
        a = 0;
        b = 0;
        op = null;
        inFormat = true;
        boolAB = true;
        boolOp = true;
        rimBool = true;
        arabBool = true;
    }

    private static int arabOrRim(String s) {
        int arab = 0;
        char c = s.charAt(0);    //  вытаскиваем первый символ для проверки какое число было введено арабское или римское

        if (Character.isDigit(c) & arabBool) {   // проверяем является ли числом и не вводилось ли предыдущее число римское

            try {
                arab = Integer.parseInt(s);
                boolAB = false;
            } catch (NumberFormatException e) {  // отлавливаем ошибку
                System.out.println("не правельнный ввод \n повторите ввод)");
            }
            rimBool = false;
        } else if (Character.isLetter(c) & rimBool) {

            arab = new ConvertRim().arabToRimNum(s);
            arabBool = false;
            boolAB = false;
        } else {
            inFormat = false;
        }

        return arab;  // возвращаем обработанное число
    }

    public static void main(String[] args) {

        while ("y".equals(exit)) {

            System.out.println("Введите первое число:");

            Scanner in = new Scanner(System.in);

            while (boolAB) {
                a = arabOrRim(in.nextLine());    // вводим первое число и обрабатываем
            }
            boolAB = true;

            System.out.println("Введите оператор:");

            while (boolOp) {
                op = in.nextLine();        // вводи оператор
                if (util.boolOper(op)) {
                    boolOp = false;
                } else
                    System.out.println("не правельный ввод пример ('+' '-' '*' '/')");
            }

            System.out.println("Введите второе число:");

            while (boolAB) {                    // вводим второе число
                b = arabOrRim(in.nextLine());
                if (!inFormat) {
                    System.out.println("ошибка (пример ввода '1+10' или 'IX+X' \n  числа 'I' 'V' 'X' " +
                            "\n повторите ввод");
                    inFormat = true;
                    boolAB = true;
                }
            }

            System.out.println(new Calculator().calc(a, b, op)); // создаем экземпляр класса и вызываем метод calc
            // передаем для просчета данные
            System.out.println("продолжить нажмите 'y' для выхода 'n'");
            exit = in.nextLine();
            nullNum();
        }
    }
}
