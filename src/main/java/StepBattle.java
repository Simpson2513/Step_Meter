public class StepBattle {
    private StepsManager manager1;
    private StepsManager manager2;

    public StepBattle(StepsManager manager1, StepsManager manager2){
        this.manager1 = manager1;
        this.manager2 = manager2;
    }

    public void addSteps(int user, int day, int steps){
        if(user != 1 && user != 2){
            return;
        }
        StepsManager manager = user == 1 ? manager1 : manager2;
        manager.add(day,steps);
    }

    public int winner(){
        int stepsUser1 = 0;
        int stepsUser2 = 0;
        for (int i : manager1.getDaysList()){
            stepsUser1 += i;
        }
        for (int i : manager2.getDaysList()){
            stepsUser2 += i;
        }
        return stepsUser1 == stepsUser2 ? 0 : (stepsUser1 > stepsUser2 ? 1 : 2);
    }
}
