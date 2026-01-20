package rpg_map_generator;



public interface Tile {
    char getCharacter();
    String getType();

    // Not used in this assignment, but required by the diagram
    void action();
}

