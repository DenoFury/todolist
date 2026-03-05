package denofury;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

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

    @Override
    public void stop() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new java.io.File("tasks.json"), MainUI.tasks);
            System.out.println("Tasks saved successfully!");
        } catch (IOException e){
            System.out.println("error on writing");
        }
        super.stop();
    }

    public static void main(String[] args) {
            launch(args);
    }
}