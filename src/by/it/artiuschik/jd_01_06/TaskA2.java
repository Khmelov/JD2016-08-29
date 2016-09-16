package by.it.artiuschik.jd_01_06;
public class TaskA2 {
    public static void main(String[] args){
        String[] words=Data.POEM.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i <words.length ; i++) {
            if(words[i]!=""){
                int counter=1;
                for(int j=i+1;j<words.length;j++){
                    if(words[i].equalsIgnoreCase(words[j])) {
                        counter++;
                        words[j] = "";
                    }
                }
                System.out.println(words[i]+":"+counter);
            }

        }



    }
}
