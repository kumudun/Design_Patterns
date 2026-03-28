package Builder;

public class Computer {
    private String processor;
    private int ramSize;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private String accessories;

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return "Computer Configuration:\n" +
                "Processor       : " + processor + "\n" +
                "RAM Size        : " + ramSize + " GB\n" +
                "Hard Drive      : " + hardDrive + "\n" +
                "Graphics Card   : " + graphicsCard + "\n" +
                "Operating System: " + operatingSystem + "\n" +
                "Accessories     : " + accessories + "\n";
    }
}
