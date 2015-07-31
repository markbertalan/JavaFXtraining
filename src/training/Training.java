/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Márk
 */
public class Training extends Application {

    Stage window;
    Scene scene1, scene2, scene3;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Label label = new Label("Welcome to the first scene");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label, button1);
        scene1 = new Scene(layout1, 200, 200);

        //Button 2
        Button button2 = new Button("Go back to scene one");
        button2.setOnAction(e -> window.setScene(scene1));
        Button button3 = new Button("Alert");
        button3.setOnAction(e -> AlertBox.display("Title of window", "Wow this alert box is awesome"));
        Button button4 = new Button("Send naked pics");
        button4.setOnAction(e -> {
            boolean result = ConfirmBox.display("Naked pics", "Are you sure you want to send pics to your ex");
            System.out.println(result);
        });
        Button button5 = new Button("Close this program!");
        button5.setOnAction(e -> {

            closeProgram();
        }
        );
        Button button6 = new Button("BorderPane");
        Button button7 = new Button("Gridpane");
        Button button8 = new Button("Extracting scene");
        Button button9 = new Button("CheckBox scene");
        Button button10 = new Button("ChoiceBox scene");
        Button button11 = new Button("ComboBox scene");
        Button button12 = new Button("List view");

        //Layout 2
        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12);
        scene2 = new Scene(layout2, 900, 600);

        //Layout 3 BorderPane
        HBox topmenu = new HBox();
        Button buttonA = new Button("File");
        Button buttonB = new Button("Edit");
        Button buttonC = new Button("View");
        topmenu.getChildren().addAll(buttonA, buttonB, buttonC);

        VBox leftmenu = new VBox();
        Button buttonD = new Button("1");
        Button buttonE = new Button("2");
        Button buttonF = new Button("3");
        leftmenu.getChildren().addAll(buttonD, buttonE, buttonF);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topmenu);
        borderPane.setLeft(leftmenu);
        scene3 = new Scene(borderPane, 300, 300);
        button6.setOnAction(e -> window.setScene(scene3));

        // Layout 6 GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username:");
        nameLabel.setId("bold-label");
        grid.setConstraints(nameLabel, 0, 0);

        TextField nameInput = new TextField();
        grid.setConstraints(nameInput, 1, 0);

        Label passLabel = new Label("Password:");
        grid.setConstraints(passLabel, 0, 1);

        TextField passInput = new TextField();
        passInput.setPromptText("password");
        grid.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Log In");
        grid.setConstraints(loginButton, 1, 2);
        
        Button signupButton = new Button("Sign up");
        signupButton.getStyleClass().add("button-blue");
        grid.setConstraints(signupButton, 1, 3);
        
        
        

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signupButton);

        Scene scene4 = new Scene(grid, 300, 200);
        scene4.getStylesheets().add(this.getClass().getResource("Hello.css").toExternalForm());
        button7.setOnAction(e -> window.setScene(scene4));

        //Extracting Data
        VBox exLayout = new VBox();
        exLayout.setPadding(new Insets(20, 20, 20, 20));
        TextField exField = new TextField();
        exField.setPromptText("Write your string here");
        Button exButton = new Button("Extract");
        exLayout.getChildren().addAll(exField, exButton);
        Scene scene5 = new Scene(exLayout);
        button8.setOnAction(e -> window.setScene(scene5));
        exButton.setOnAction(e -> isInt(exField, exField.getText()));

        //CheckBox
        VBox checkLayout = new VBox();
        checkLayout.setPadding(new Insets(20, 20, 20, 20));
        Button OrderNow = new Button("Order Now");

        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);
        CheckBox box3 = new CheckBox("Shit");

        checkLayout.getChildren().addAll(box1, box2, box3, OrderNow);
        Scene scene6 = new Scene(checkLayout);
        button9.setOnAction(e -> window.setScene(scene6));
        OrderNow.setOnAction(e -> handleOptions(box1, box2, box3));

        // ChoiceBox
        VBox choiceLayout = new VBox();
        choiceLayout.setPadding(new Insets(20, 20, 20, 20));
        Button chooseNow = new Button("Choose Now");
        Label chooseLabel = new Label("Select your favourite fruit!");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().add("Banana");
        choiceBox.getItems().add("Pineapple");
        choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs");

        //Adding a listener for choosing items
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue));

        choiceLayout.getChildren().addAll(chooseLabel, choiceBox, chooseNow);
        Scene scene7 = new Scene(choiceLayout);
        button10.setOnAction(e -> window.setScene(scene7));

        // Extracting the data
        chooseNow.setOnAction(e -> System.out.println("Your favourite fruit is: " + choiceBox.getValue().toString()));

        //ComboBox
        VBox comboLayout = new VBox();
        comboLayout.setPadding(new Insets(20, 20, 20, 20));
        Button comboNow = new Button("Choose Now");
        Label comboLabel = new Label("Select your favourite fruit!");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().add("Apple");
        comboBox.getItems().add("Banana");
        comboBox.getItems().add("Pineapple");
        comboBox.getItems().addAll("Bacon", "Ham", "Meatballs");
        comboBox.setPromptText("What is your favourite fruit?");
        comboNow.setOnAction(e -> System.out.println("User submitted: " + comboBox.getValue().toString()));
        
        //It triggers it its own action
        comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));
        
        // You can actually edit it on your own
        comboBox.setEditable(true);

        comboLayout.getChildren().addAll(comboLabel, comboBox, comboNow);
        Scene scene8 = new Scene(comboLayout);
        button11.setOnAction(e -> window.setScene(scene8));

        //ListView
        
        VBox listLayout = new VBox();
        listLayout.setPadding(new Insets(20,20,20,20));
        Button listSubmit = new Button("Submit");
        
        ListView<String> list = new ListView<>();
        list.getItems().addAll("Iron Man ", "Hulk " , "Thor ", "Spiderman ");
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        listSubmit.setOnAction(e -> {
                 String listMessage="";
                 ObservableList<String> heroes;
                 heroes = list.getSelectionModel().getSelectedItems();
                 for(int i=0; i< heroes.size(); i++)
                        {
                            listMessage += heroes.get(i).toString();
                            
            
                        }
                 System.out.println("Your favourite heroes: " + listMessage);
        
                                      });
        
        
        
        listLayout.getChildren().addAll(list,listSubmit);
        
        Scene scene9 = new Scene(listLayout);
        button12.setOnAction(e -> window.setScene(scene9));
        
        
        window.setScene(scene1);
        window.setTitle("Title");
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Alert", "Are you sure u want to exit?");
        if (answer) {
            window.close();
        }
    }

    private boolean isInt(TextField input, String message) {
        try {
            int age = Integer.parseInt(input.getText());
            System.out.println("User is " + age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + "is not a number");
            return false;
        }

    }

    private void handleOptions(CheckBox box1, CheckBox box2, CheckBox box3) {
        String message = "Orders are: ";
        if (box1.isSelected()) {
            message += "Bacon, ";
        }
        if (box2.isSelected()) {
            message += "Tuna, ";
        }
        if (box3.isSelected()) {
            message += "Shit, ";
        }

        System.out.println(message);
    }

}
