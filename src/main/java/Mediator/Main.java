package Mediator;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatRoomMediator();

        List<String> users = Arrays.asList("Asela", "Oshane", "Wathsuka");

        ChatClientController alice = new ChatClientController("Asela", mediator, users);
        ChatClientController bob = new ChatClientController("Oshane", mediator, users);
        ChatClientController charlie = new ChatClientController("Wathsuka", mediator, users);

        mediator.registerClient(alice);
        mediator.registerClient(bob);
        mediator.registerClient(charlie);

        primaryStage.hide(); // no main window needed
    }

    public static void main(String[] args) {
        launch(args);
    }
}
