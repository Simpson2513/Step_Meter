import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStepsManager {

    StepsManager test = new StepsManager();

    @Test
    public void stepsAdd() {
        test.setDay(1);
        test.add(1, 1000);
        int actual = test.add(1, 1000);
        int expected = 8000;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void stepsAddMinus() {
        test.add(1, -1000);
        int actual = test.add(1, 1000);
        int expected = 9000;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void startSetDay() {
        int actual = test.add(2, 0);
        int expected = 10000;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void stepsAddFourTime() {
        test.add(1, 1000);
        test.add(1, 1000);
        test.add(1, 2000);

        int actual = test.add(1, 1000);
        int expected = 5000;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void stepsAddTwoDayThreeTime() {
        test.add(1, 1000);
        test.add(1, 1000);
        test.add(2, 1000);
        test.add(2, 1000);


        int actual = test.add(1, 1000);
        int expected = 7000;

        Assertions.assertEquals(expected, actual);

    }

}