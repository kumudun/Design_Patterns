package Observer;

public class Display implements WeatherObserver {
    private final String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(int temp) {
        System.out.println(name + ": temperature is now " + temp + "°C");
    }
}

