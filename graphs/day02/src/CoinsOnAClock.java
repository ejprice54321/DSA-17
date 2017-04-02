import java.util.*;

public class CoinsOnAClock {

    public static void coinBackTrack(int hour, int hoursInDay, int[] answer, List<int[]> answers,
                                     Map<Integer, Integer> coins){
        if (coins.get(1) == 0 && coins.get(5) == 0  && coins.get(10) == 0){
            answers.add(Arrays.copyOf(answer, answer.length));
        }
        if (answer[hour] == 0){
            for (int coin: coins.keySet()){
                if (coins.get(coin)>0){
                    answer[hour%hoursInDay] = coin;
                    coins.put(coin, coins.get(coin)-1);
                    coinBackTrack((hour+coin)%hoursInDay, hoursInDay ,answer,answers,coins);
                    answer[hour%hoursInDay] = 0;
                    coins.put(coin, coins.get(coin)+1);
                }
            }
        }


    }

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        Map<Integer, Integer> coins = new HashMap<>();
        int[] answer = new int[hoursInDay];
        List<int[]> answers = new ArrayList<>();
        List<char[]> realAnswers = new ArrayList<>();
        char[] realAnswer = new char[hoursInDay];
        coins.put(1,pennies);
        coins.put(5,nickels);
        coins.put(10, dimes);
        coinBackTrack(0,hoursInDay,answer,answers,coins);
        for (int[] answer1: answers){
            realAnswer = new char[hoursInDay];
            for (int i =0;i<answer1.length;i++){
                if (answer1[i] == 1) realAnswer[i] = 'p';
                else if (answer1[i] == 5) realAnswer[i] = 'n';
                else if (answer1[i] == 10) realAnswer[i] = 'd';
            }
            realAnswers.add(Arrays.copyOf(realAnswer, hoursInDay));

        }
        return realAnswers;
    }

}
