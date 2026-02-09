package State;

public class GameCharacter {
    private final String name;
    private int experience;
    private int health;

    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState(); // start state
    }

    // actions (delegate to current state)
    public void train() { state.train(this); state.checkLevelUp(this); }
    public void meditate() { state.meditate(this); state.checkLevelUp(this); }
    public void fight() { state.fight(this); state.checkLevelUp(this); }

    // status helpers
    public String getName() { return name; }
    public int getExperience() { return experience; }
    public int getHealth() { return health; }
    public String getLevel() { return state.getLevelName(); }

    public boolean isMaster() {
        return state instanceof MasterState;
    }

    // state change
    public void setState(CharacterState newState) {
        this.state = newState;
    }

    // update stats
    public void addXP(int amount) {
        experience += amount;
        if (experience < 0) experience = 0;
    }

    public void addHealth(int amount) {
        health += amount;
        if (health > 100) health = 100;
        if (health < 0) health = 0;
    }
}

