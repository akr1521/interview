package app.sample.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FinanceApp {

    public int getMaxCount( int  num[]){
        int left =  0;
        int right = num.length - 1 ;
        int[] count = new int[10];
        while (left< right){
            count[num[left]]++;
        }
        for ( int i  : count){
                 System.out.println( "Counter : "  + i);
        }

        return -1;
    }

    public int getWinner(int contestants[]){
        int winner = 0;
        Map<Integer,Integer> contestantStore = new LinkedHashMap<>();
        int maxTasks = 0;
        List<Contestant> contestantList = new ArrayList<>();

        for ( int contestant : contestants){
                if(contestantStore.containsKey( contestant)){
                    contestantStore.put( contestant, contestantStore.get(contestant)+1);
                }else {
                    contestantStore.put(contestant,1);
                }
        }
        if ( contestantStore.keySet().size() == contestants.length){
            return contestants[0];
        }

        for(Map.Entry<Integer,Integer> store : contestantStore.entrySet()){
                     maxTasks= Integer.max( maxTasks, store.getValue());
                    contestantList.add( new Contestant(  store.getKey(), store.getValue()));
        }

        for ( Contestant contestant :contestantList){
                 if ( maxTasks ==  contestant.numberOfTasks){
                     return contestant.contestantNumber;
                 }
        }

        return -1;
    }

}

class  Contestant{
    int contestantNumber;
    int numberOfTasks;

    public Contestant(int contestantNumber ,int numberOfTasks){
            this.contestantNumber = contestantNumber ;
            this.numberOfTasks =  numberOfTasks;
    }

}

