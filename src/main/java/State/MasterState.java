package State;

public class MasterState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You are Master. The game is already complete!");
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("You are Master. The game is already complete!");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("You are Master. The game is already complete!");
    }

    @Override
    public void checkLevelUp(GameCharacter c) {
        // no next level
    }
}
