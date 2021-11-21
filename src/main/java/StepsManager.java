import java.util.HashMap;

public class StepsManager {

    private int MAX_STEPS = 10_000;
    private HashMap<Integer, Integer> stat = new HashMap<>();

    public void setDay(int day){
        stat.put(day,0);
    }

    public int add(int day, int steps) {
        if (steps < 0 )
            steps = 0;
        if (!stat.containsKey(day)){
            setDay(day);
        }
        stat.put(day, steps + stat.get(day));
        return (MAX_STEPS - stat.get(day));
    }
}
