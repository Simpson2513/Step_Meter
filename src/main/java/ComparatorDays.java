import java.util.Comparator;
import java.util.List;

public class ComparatorDays implements Comparator<StepsManager> {

    private int min = 0;

    public ComparatorDays(int min) {
        this.min = min;
    }

    @Override
    public int compare(StepsManager x1, StepsManager x2) {
        List<Integer> list_o1 = x1.getDaysList();
        List<Integer> list_o2 = x2.getDaysList();
        int day1 = 0;
        int day2 = 0;

        for (int i : list_o1) {
            if (i > min) {
                day1++;
            }
        }
        for (int i : list_o2) {
            if (i > min) {
                day2++;
            }
        }
        return day1 - day2;
    }
}
