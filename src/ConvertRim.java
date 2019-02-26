// класс для конвертации римских чисел в арабские

public class ConvertRim {

    private int aNum = 0;
    private int lastNumber = 0;

    public int arabToRimNum(String arabNumber) {
        String rimNum = arabNumber.toUpperCase(); // преобразовываем в верхний регистр
        for (int i = rimNum.length() - 1; i >= 0; i--) { // перебираем строку
            char c = rimNum.charAt(i);    // вытаскиваем символ
            switch (c) {
                case 'X':
                    aNum = tt(10, lastNumber, aNum);  // вызываем метод
                    lastNumber = 10;   // запоминаем значение
                    break;
                case 'V':
                    aNum = tt(5, lastNumber, aNum);
                    lastNumber = 5;
                    break;
                case 'I':
                    aNum = tt(1, lastNumber, aNum);
                    lastNumber = 1;
                    break;
                default:
                    Main.inFormat = false;     // делаем отметку если нет нужного значения
                    break;
            }
        }
        return aNum;   // возвращаем конвертируемое число
    }

    public static int tt(int aNum, int lastNumber, int aNum2) {
        if (lastNumber > aNum) { // если предыдущее число больше то вычитаем
            return aNum2 - aNum;      // IV   5-1 наше число aNum 4
        } else {
            return aNum2 + aNum;     // XI   10+1 aNum 11
        }
    }
}
