package Bridge;

import Bridge.devices.Device;
import Bridge.devices.Radio;
import Bridge.devices.SmartSpeaker;
import Bridge.devices.Tv;
import Bridge.remotes.AdvancedRemote;
import Bridge.remotes.BasicRemote;
import Bridge.remotes.SmartRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
        testSmartSpeakerWithSmartRemote(new SmartSpeaker());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void testSmartSpeakerWithSmartRemote(SmartSpeaker smartSpeaker) {
        System.out.println("Tests with SmartSpeaker and SmartRemote.");

        SmartRemote smartRemote = new SmartRemote(smartSpeaker);

        smartRemote.voiceControl("power on");
        smartRemote.voiceControl("volume up");
        smartRemote.voiceControl("channel up");
        smartRemote.voiceControl("play Shape of You");
        smartSpeaker.printStatus();

        smartRemote.voiceControl("volume down");
        smartRemote.voiceControl("play Believer");
        smartSpeaker.printStatus();

        smartRemote.voiceControl("power off");
        smartSpeaker.printStatus();
    }
}