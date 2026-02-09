package State;

public class IntermediateState implements CharacterState {
    private static final int NEXT_LEVEL_XP = 250;

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public void train(GameCharacter c) {
        c.addXP(25);
        System.out.println("You trained. +25 XP");
    }

    @Override
    public void meditate(GameCharacter c) {
        c.addHealth(15);
        System.out.println("You meditated. +15 HP");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("Intermediate can't fight yet. Train more!");
    }

    @Override
    public void checkLevelUp(GameCharacter c) {
        if (c.getExperience() >= NEXT_LEVEL_XP) {
            c.setState(new ExpertState());
            System.out.println("Level up! You are now EXPERT.");
        }
    }
}
