package Builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i5");
    }

    @Override
    public void buildRAM() {
        computer.setRamSize(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Home");
    }

    @Override
    public void buildAccessories() {
        computer.setAccessories("Wireless Keyboard, Wireless Mouse");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}