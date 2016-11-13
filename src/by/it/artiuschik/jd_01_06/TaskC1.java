package by.it.artiuschik.jd_01_06;

public class TaskC1 {
    private static String formatString(String str) {
        StringBuilder result = new StringBuilder();
        String[] lines = str.split("\\n");
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }
        int[] numberOfSpaces = new int[lines.length];//сколько пробелов надо вставить в i  строку
        for (int i = 0; i < numberOfSpaces.length; i++) {
            numberOfSpaces[i] = maxLength - lines[i].length();
        }

        for (int i = 0; i < lines.length; i++) {
            String appendString=Util.insertSpacesToString(numberOfSpaces[i], lines[i]) + "\n";
            result.append(appendString);
        }
        return result.toString();

    }
    public static void main(String[] args) {
        System.out.println("--------Исходный текст---------");
        System.out.println(Data.POEM);
        System.out.println("--------Результат---------");
        String str = formatString(Data.POEM);
        System.out.println(str);
    }

}
