package by.it.artiuschik.jd_01_06;

public class TaskC2 {
    public static String createMillionString(String str) {
        String[] words = by.it.artiuschik.jd_01_06.Util.words(by.it.artiuschik.jd_01_06.Data.POEM);
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
            result+= by.it.artiuschik.jd_01_06.Util.findWord(words,resultLength-result.length());
        }
        return result;
    }
    public static StringBuilder createMillionStringBuilder(String str)
    {
        StringBuilder result=new StringBuilder("");
        result.ensureCapacity(1600000);
        String[] words = by.it.artiuschik.jd_01_06.Util.words(by.it.artiuschik.jd_01_06.Data.POEM);
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
            result.append(by.it.artiuschik.jd_01_06.Util.findWord(words,resultLength-result.length()));
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println("--------Исходный текст---------");
        System.out.println(by.it.artiuschik.jd_01_06.Data.POEM);
        System.out.println("--------Результат---------");
        System.out.println("Выигрыш в миллисекундах:="+ by.it.artiuschik.jd_01_06.Util.timeWin(Data.POEM));
    }

}


