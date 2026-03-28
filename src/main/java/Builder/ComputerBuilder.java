package Builder;

public interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    void buildAccessories();

    Computer getComputer();
}
