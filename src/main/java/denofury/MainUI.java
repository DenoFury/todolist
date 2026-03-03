package denofury;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.skin.DatePickerSkin;

public class MainUI extends BorderPane {
    private TextField titleField;
    private TextArea descriptionField;
    private VBox taskListContainer;
    private VBox leftPane;
    private ScrollPane centerPane;
    private GridPane inputArea;

    public MainUI(){
        leftPane = new VBox();
        centerPane = new ScrollPane();
        inputArea = new GridPane();
        leftPane.setSpacing(10);
        centerPane.setPadding(new Insets(15));
        inputArea.setPadding(new Insets(15));


        leftPane.setPrefWidth(250);

        taskListContainer = new VBox();
        centerPane.setContent(taskListContainer);
        centerPane.setFitToWidth(true);

        inputArea.setHgap(10);
        inputArea.setVgap(10);

        this.setLeft(leftPane);
        this.setCenter(centerPane);
        this.setBottom(inputArea);

        titleField = new TextField();
        titleField.setPromptText("Enter a title for your task");

        titleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() > 100) {
                titleField.setText(oldValue);
            }
        });

        descriptionField = new TextArea();
        descriptionField.setPromptText("Enter a description for your task");
        descriptionField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() > 250){
                descriptionField.setText(oldValue);
            }
        });

        inputArea.add(new Label("Title:"), 0 ,0);
        inputArea.add(titleField, 1, 0);
        inputArea.add(new Label("Notes"), 0, 1);
        inputArea.add(descriptionField, 1,1);
        inputArea.add(createAddButton(),1,2);


        DatePicker datePicker = new DatePicker(java.time.LocalDate.now());
        DatePickerSkin datePickerSkin = new DatePickerSkin(datePicker);
        javafx.scene.Node calendarVisual = datePickerSkin.getPopupContent();
        leftPane.getChildren().add(calendarVisual);
    }

    private Button createAddButton() {
        Button addButton = new Button("Add Task");
        addButton.setOnAction(e ->{
            String title = titleField.getText();
            String description = descriptionField.getText();

            if(!title.isEmpty()){
                Task task = new Task(title,description);
                Label taskLabel = new Label(task.getTitle());
                taskListContainer.getChildren().add(taskLabel);
                titleField.clear();
                descriptionField.clear();
            }
        });


        return addButton;
    }

}
