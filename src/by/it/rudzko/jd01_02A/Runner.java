package by.it.rudzko.jd01_02A;

public class Runner {

    public static void main(String[] args) {
	System.out.println ("Please enter some numbers under 1000000000 separated by slash.\nExample: 1/22/333/4444/55555");
        String nums= Util.getNumbers();
        int numbers[]= Util.createAr(nums);
        int longest=Task1.findLongest(numbers);
        int shortest=Task1.findShortest(numbers);
        int llen=String.valueOf(longest).length();
        int slen=String.valueOf(shortest).length();
        System.out.println("The longest one is "+longest+" ("+llen+" symbols) and the shortest is "+shortest+" ("+slen+" symbols).");
        float mean=Task2.AMean(numbers);
        int lessThanMean=Task2.qShort(numbers, mean);
        int [] shortNums=Task2.shortNumsAr(numbers,lessThanMean,mean);
        System.out.println("There are "+lessThanMean+" numbers shorter than average:");
        Util.printArray(shortNums);
        Task3.printNum(numbers);







    }
}
