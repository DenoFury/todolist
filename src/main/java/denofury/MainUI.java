package denofury;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.DatePicker;
import javafx.scene.control.skin.DatePickerSkin;

public class MainUI extends BorderPane {
    private TextField titleField;
    private TextArea descriptionField;
    private VBox taskListContainer;
    private VBox leftPane;
    private ScrollPane centerPane;
    private GridPane inputArea;
    private DatePicker datePicker = new DatePicker(java.time.LocalDate.now());

    public MainUI(){
        leftPane = new VBox();
        centerPane = new ScrollPane();
        inputArea = new GridPane();
        leftPane.setSpacing(10);
        centerPane.setPadding(new Insets(15));
        inputArea.setPadding(new Insets(15));


        leftPane.setPrefWidth(250);

        taskListContainer = new VBox();
        taskListContainer.setSpacing(10);
        taskListContainer.setAlignment(Pos.TOP_LEFT);
        taskListContainer.setPadding(new Insets(10));
        centerPane.setContent(taskListContainer);
        centerPane.setFitToWidth(true);

        inputArea.setHgap(10);
        inputArea.setVgap(10);

        this.setLeft(leftPane);
        this.setCenter(centerPane);
        this.setBottom(inputArea);

        // new task section

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

        // calendar


        DatePickerSkin datePickerSkin = new DatePickerSkin(datePicker);
        javafx.scene.Node calendarVisual = datePickerSkin.getPopupContent();
        leftPane.getChildren().add(calendarVisual);

        // Date listener for the calendar

        datePicker.valueProperty().addListener((observable, oldDate, newDate)-> {
            System.out.println("listener added: " + newDate);

            // future use for task filtering
        });


    }

    private Button createAddButton() {
        Button addButton = new Button("Add Task");
        addButton.setOnAction(e ->{
            java.time.LocalDate date = datePicker.getValue();
            String title = titleField.getText();
            String description = descriptionField.getText();

            if(!title.isEmpty()){
                HBox taskRow = new HBox(15);
                taskRow.setFocusTraversable(true);
                taskRow.setPadding(new Insets(5));
                Task task = new Task(title,description, date);

                VBox textData = new VBox(2);
                Label taskLabel = new Label(task.getTitle() + "[" + task.getDate() + "]");
                textData.getChildren().add(taskLabel);


                Region spacer = new Region();
                HBox.setHgrow(spacer, Priority.ALWAYS);

                Button removeButton = new Button("Delete");
                removeButton.setOnAction(event -> {
                    taskListContainer.getChildren().remove(taskRow);
                });
                taskRow.getChildren().addAll(textData,spacer,removeButton);
                taskListContainer.getChildren().add(taskRow);

                removeButton.setVisible(false);
                removeButton.setFocusTraversable(false);
                taskRow.setFocusTraversable(true);
                taskRow.setOnMouseClicked(event -> {taskRow.requestFocus();});
                taskRow.focusedProperty().addListener((observable, wasFocused, nowFocus)-> {
                    if(nowFocus){
                        removeButton.setVisible(true);
                    }else{
                        removeButton.setVisible(false);
                    }
                });

                titleField.clear();
                descriptionField.clear();
            }
        });


        return addButton;
    }

}
