package denofury;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainUI root = new MainUI();
        Scene scene = new Scene(root, 900, 700);

        primaryStage.setTitle("DenoFury To-Do List");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    public static void main(String[] args) {
            launch(args);
    }
}