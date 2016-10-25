package by.it.rudzko.Matlab.Interfaces;


public interface IMessages {
    String WRONG_DATA = "Пожалуйста, используйте для парсера только числовые данные.";
    String NULL = "Деление невозможно: попытка деления на ноль.";
    String IMPOSSIBLE_DIV = "Деление данных невозможно. Проверьте правильность введенных значений.";
    String IMPOSSIBLE_MUL = "Умножение данных невозможно. Проверьте правильность введенных значений.";
    String IMPOSSIBLE_SUB = "Вычитание невозможно. Проверьте правильность введенных данных.";
    String IMPOSSIBLE_ADD = "Сложение невозможно. Проверьте правильность введенных данных.";
    String FILE_NOT_FOUND = "Файл не найден.";
    String ENTER_DATA = "Вводите по одному выражения для вычисления. Для завершения вычилений введите \"end\"";
    String ERRORS = "\n\nОшибочные операции для проверки записи в логе:\n";
    String PATH = "/src/by/it/rudzko/Matlab/Extra/";
    String FULL_START = "Полный отчет\nПрограмма запущена: ";
    String END = "Программа завершена: ";
    String SHORT_START = "Краткий отчет\nПрограмма запущена: ";
    String UNDERLINED = "_______";
    String DATA = "Дано выражение: ";
    String RESULT = "Получен результат: ";
    String COMPLETED = " операций произведено.";
}
