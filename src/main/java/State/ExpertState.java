package State;

public class ExpertState implements CharacterState {
    private static final int NEXT_LEVEL_XP = 500;

    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public void train(GameCharacter c) {
        c.addXP(30);
        System.out.println("You trained hard. +30 XP");
    }

    @Override
    public void meditate(GameCharacter c) {
        c.addHealth(10);
        System.out.println("You meditated. +10 HP");
    }

    @Override
    public void fight(GameCharacter c) {
        if (c.getHealth() <= 10) {
            System.out.println("Too weak to fight. Meditate first!");
            return;
        }
        c.addHealth(-10);
        c.addXP(40);
        System.out.println("You fought! -10 HP, +40 XP");
    }

    @Override
    public void checkLevelUp(GameCharacter c) {
        if (c.getExperience() >= NEXT_LEVEL_XP) {
            c.setState(new MasterState());
            System.out.println("Level up! You reached MASTER. Game ends!");
        }
    }
}
