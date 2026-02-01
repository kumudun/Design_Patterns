package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private final Random rnd = new Random();

    private final int MIN;
    private final int MAX;

    private int temp;

    public WeatherStation(int min, int max) {
        this.MIN = min;
        this.MAX = max;
        this.temp = min + rnd.nextInt(max - min + 1); // initial random temp
    }

    public void addObserver(WeatherObserver o) {
        observers.add(o);
    }

    public void removeObserver(WeatherObserver o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        for (WeatherObserver o : observers) {
            o.update(temp);
        }
    }

    @Override
    public void run() {
        while (true) {
            // change temp by +1 or -1
            temp += rnd.nextBoolean() ? 1 : -1;

            // keep within bounds
            if (temp < MIN) temp = MIN;
            if (temp > MAX) temp = MAX;

            // notify after each update
            notifyObservers();

            // random delay 1–5 seconds
            try {
                Thread.sleep((1 + rnd.nextInt(5)) * 1000L);
            } catch (InterruptedException e) {
                break; // stop if interrupted
            }
        }
    }
}

