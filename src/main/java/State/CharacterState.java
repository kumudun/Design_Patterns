package State;

public interface CharacterState {
    String getLevelName();

    void train(GameCharacter c);
    void meditate(GameCharacter c);
    void fight(GameCharacter c);

    // used to decide when to move to next level
    void checkLevelUp(GameCharacter c);
}
