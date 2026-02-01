package Observer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation station = new WeatherStation(-10, 35);

        Display d1 = new Display("Observer A");
        Display d2 = new Display("Observer B");
        Display d3 = new Display("Observer C");

        station.addObserver(d1);
        station.addObserver(d2);
        station.addObserver(d3);

        station.start();

        // run for a while
        Thread.sleep(10000);

        // remove one observer
        System.out.println("\n--- Removing Observer B ---\n");
        station.removeObserver(d2);

        // keep running to prove B is gone
        Thread.sleep(10000);

        // stop program (simple way)
        station.interrupt();
    }
}

