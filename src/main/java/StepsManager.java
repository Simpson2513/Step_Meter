import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StepsManager implements Comparable<StepsManager>  {

    private List<Integer> stat = new ArrayList<>();

    public List<Integer> getDaysList(){
        return stat;
    }

    public void addSteps(int steps){
        if(steps >= 0) {
            stat.add(steps);
        }
    }

    public int getSteps(int day){
        if (day < 1 || day >= stat.size()){
            return -1;
        }
        return stat.get(day-1);
    }

    public int add(int day, int steps) {
        if ((day > stat.size() || day < 1) || steps < 0)
            return -1;
        int maxDay = stat.get(getMaxDay() - 1);
        stat.set(day - 1, stat.get(day - 1) + steps);
        return Math.max((maxDay - stat.get(day - 1)) + 1, 0);
    }

    public int getMaxDay() {
        int maxDay = 0;
        for (int i = 0; i < stat.size(); i++) {
            if (stat.get(i) > stat.get(maxDay)) {
                maxDay = i;
            }
        }
        return maxDay + 1;
    }

    @Override
    public int compareTo(StepsManager x) {
        int stepsManager1 = 0;
        int stepsManager2 = 0;
        for (int i : stat) {
            stepsManager1 += i;
        }
        for (int i : x.getDaysList()) {
            stepsManager2 += i;
        }
        return stepsManager1 - stepsManager2;
    }

    public Stream<Integer> getAllAbove(int steps) {
        return stat.stream().filter(i -> i > steps);
    }
}
