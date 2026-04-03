package Bridge.devices;


public class SmartSpeaker implements Device {
    private boolean on = false;
    private int volume = 40;
    private int channel = 1;
    private String currentSong = "No song selected";

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("SmartSpeaker is now ON.");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("SmartSpeaker is now OFF.");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        if (channel < 1) {
            this.channel = 1;
        } else {
            this.channel = channel;
        }
    }

    public void playMusic(String song) {
        if (!on) {
            System.out.println("SmartSpeaker is OFF. Please turn it on first.");
            return;
        }
        currentSong = song;
        System.out.println("SmartSpeaker is playing: " + currentSong);
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a smart speaker.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current playlist/channel is " + channel);
        System.out.println("| Current song is: " + currentSong);
        System.out.println("------------------------------------\n");
    }
}

