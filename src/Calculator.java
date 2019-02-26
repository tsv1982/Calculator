// класс для арифметических операций

public class Calculator {

    private int result;

    public int calc(int a, int b, String op) {
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                try {
                    result = a / b;
                } catch (ArithmeticException e) {  // обабатываем ошибку при делении на ноль
                    System.out.println("недопустимая арифметическая операция \n " +
                            "деление на нолю запрещенно");
                }
                break;
        }
        return result;
    }
}

