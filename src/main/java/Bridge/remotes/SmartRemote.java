package Bridge.remotes;

import Bridge.devices.Device;
import Bridge.devices.SmartSpeaker;

public class SmartRemote extends BasicRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("SmartRemote voice command received: " + command);

        String normalized = command.toLowerCase();

        if (normalized.equals("power on")) {
            if (!device.isEnabled()) {
                device.enable();
            } else {
                System.out.println("Device is already ON.");
            }
        } else if (normalized.equals("power off")) {
            if (device.isEnabled()) {
                device.disable();
            } else {
                System.out.println("Device is already OFF.");
            }
        } else if (normalized.equals("volume up")) {
            volumeUp();
        } else if (normalized.equals("volume down")) {
            volumeDown();
        } else if (normalized.equals("channel up")) {
            channelUp();
        } else if (normalized.equals("channel down")) {
            channelDown();
        } else if (normalized.startsWith("play ") && device instanceof SmartSpeaker) {
            String song = command.substring(5);
            ((SmartSpeaker) device).playMusic(song);
        } else {
            System.out.println("Command not recognized.");
        }
    }
}