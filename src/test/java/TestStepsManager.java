import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class TestStepsManager {
    StepsManager manager1 = new StepsManager();
    StepsManager manager2 = new StepsManager();

    @ParameterizedTest
    @CsvSource({"7000, 12000, 17000, -1", "8000, 8000, 16000, 0", "13000, 6000, 8000, 1"})
    public void checkComparator(int steps1, int steps2, int min, int expected) {
        ComparatorDays comp = new ComparatorDays(min);

        manager1.addSteps(steps1);
        manager1.addSteps(steps1 + 7000);
        manager1.addSteps(steps1 + 12000);

        manager2.addSteps(steps2);
        manager2.addSteps(steps2 + 7000);
        manager2.addSteps(steps2 + 12000);

        int actual = comp.compare(manager1, manager2);
        Assertions.assertEquals(expected, actual, "ComparatorDays class");
    }

    @Test
    public void stepsNegative() {
        StepsManager stepsManager = new StepsManager();
        Assertions.assertThrows(IllegalStepsException.class, () -> stepsManager.add(8, -700));
    }

    @Test
    public void day366() {
        StepsManager stepsManager = new StepsManager();
        Assertions.assertThrows(IllegalDayException.class, () -> stepsManager.add(366, 11000));
    }

    @Test
    public void dayMinusOne() {
        StepsManager stepsManager = new StepsManager();
        Assertions.assertThrows(IllegalDayException.class, () -> stepsManager.add(-1, 9000));
    }


}