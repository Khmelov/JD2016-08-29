package by.it.artiuschik.jd_01_06;

public class TaskC2 {
    static String createMillionString() {
        String[] words = Util.words(Data.POEM);
        String result="";
        int resultLength=1000000;
        String word = words[(int) (Math.random() * (words.length - 1))];
        while(result.length()+1+word.length()<resultLength) {
            result +=word;
            result += " ";
            word = words[(int) (Math.random() * (words.length - 1))];
        }
        if(result.length()!=resultLength)
        {
            result+= Util.findWord(words,resultLength-result.length());
        }
        return result;
    }
    static StringBuilder createMillionStringBuilder()
    {
        StringBuilder result=new StringBuilder("");
        result.ensureCapacity(1600000);
        String[] words = Util.words(Data.POEM);
        int resultLength=1000000;
        String word = words[(int) (Math.random() * (words.length - 1))];
        while(result.length()+1+word.length()<resultLength) {
            result.append(word);
            result.append(" ");
            word = words[(int) (Math.random() * (words.length - 1))];
            //System.out.print(word+" "+result.length());
        }
        if(result.length()!=resultLength)
        {
            result.append(Util.findWord(words,resultLength-result.length()));
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println("--------Исходный текст---------");
        System.out.println(Data.POEM);
        System.out.println("--------Результат---------");
        System.out.println("Выигрыш в миллисекундах:="+ Util.timeWin());
    }

}


