package State;

public class NoviceState implements CharacterState {
    private static final int NEXT_LEVEL_XP = 100;

    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public void train(GameCharacter c) {
        c.addXP(20);
        System.out.println("You trained. +20 XP");
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("Novice can't meditate. Train first!");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("Novice can't fight. Train first!");
    }

    @Override
    public void checkLevelUp(GameCharacter c) {
        if (c.getExperience() >= NEXT_LEVEL_XP) {
            c.setState(new IntermediateState());
            System.out.println("Level up! You are now INTERMEDIATE.");
        }
    }
}
