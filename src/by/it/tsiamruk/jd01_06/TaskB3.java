package by.it.tsiamruk.jd01_06;

/**
 * Task:
 * Отсортировать слова в тексте по убыванию количества вхождений заданного символа,
 * а в случае равенства — по алфавиту.
 */

public class TaskB3 {

    /**
     * textCleaner - method that's create array of Strings
     * from incoming string
     */
    static String[] textCleaner(String sometext) {
        String[] textCleaner = sometext.split("[^а-яА-ЯёЁ]+");
        return textCleaner;
    }


    static Integer symbolInString(String text, char symbol) {

        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == symbol) {
                counter++;
            }
        }

        return counter;
    }

    static String[] sorter(String[] array, char symbol) {
        int[] nums = new int[array.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = symbolInString(array[i], symbol);

        }


        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;

                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else if (nums[i] == nums[j]){
                    if (array[j].compareTo(array[i]) < 0){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;

                        String temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return array;
    }
}