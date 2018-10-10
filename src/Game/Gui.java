package Game;

import Parser.Commands;
import Parser.ShowTimeCommand;
import Parser.VerbCommand;
import SaveOperations.Load;
import SaveOperations.Save;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dito on 10/5/2017.
 */

public class Gui  extends Application implements EventHandler<ActionEvent> ,Serializable {
    StackPane layout;
    Scene scene;

    List<String> commandsList = new ArrayList<>();
    String input;
    Player player = new Player();

    TextField nameTextField;
    TextArea outputTextArea;
    TextField inputTextField;

    Label nameLabel;
    Label commandLabel;
    Label showTimeLabel;

    Button submitNameButton;
    Button exitGameButton;
    Button saveGameButton;
    Button loadGameButton;
    Button showTimeButton;
    Button showCommandsButton;

    Commands commands;
    String playerInput[];
    VerbCommand command;


    @Override
    public void handle(ActionEvent event) {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        player = new Player();
        initializeComponents();
        primaryStage.setScene(scene);
        primaryStage.show();
        commands = new Commands();
    }

    EventHandler submitNameEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            newPlayerName();
            outputTextArea.clear();
            showIntroduction();
        }
    };

    EventHandler exitGameEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            System.exit(0);
        }
    };

    EventHandler saveGameEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            Save save = new Save();
            try {
                save.saveGame(input,player);
                printToPlayer("Save completed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    EventHandler loadGameEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            Load load = new Load();
            Player loadPlayer = new Player();
            try {
                loadPlayer = load.loadGame();
                int seconds = Integer.parseInt(load.loadTime());
                load.setPlayerValues(player,loadPlayer,seconds);
                changeComponentsState(player.getName());
                outputTextArea.clear();
                printToPlayer("Load completed");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    };

    EventHandler showTimeEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            command = new ShowTimeCommand();
        printToPlayer(command.exec(player,playerInput));
        }
    };

    EventHandler showCommandsEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            showCommands();
        }
    };

    EventHandler inputTextEvent = new EventHandler() {
        @Override
        public void handle(Event event) {
            enterPressed();
            printToPlayer(command.exec(player,playerInput));
        }
    };

    public void printToPlayer(String output) {
        if (output.contains("hours")){
            showTimeLabel.setVisible(true);
            showTimeLabel.setText(output);
        }
        else
        outputTextArea.setText(outputTextArea.getText()  + output + "\n");
        outputTextArea.selectPositionCaret(outputTextArea.getLength()+1);
        outputTextArea.deselect();
    }

    public void showIntroduction() {
        String output = "Its about 3 months now your brother is in prison for a murder he didnt commit.\n"
                + "In 10 days he will face a death penalty.\n"
                + "You are currently in your apartment and its a rainy day";
        printToPlayer(output);
    }

    public void newPlayerName() {
        input = nameTextField.getText();
        player.setName(input);
        changeComponentsState(input);
    }

    public void changeComponentsState(String input){
        nameTextField.clear();
        nameLabel.setText("Player name: " + input);
        nameLabel.setTranslateX(-240.0);
        nameLabel.setTranslateY(-180.0);
        nameLabel.setMaxSize(300.0, 20.0);
        nameTextField.setVisible(false);
        submitNameButton.setVisible(false);
        showTimeButton.setVisible(true);
        showCommandsButton.setVisible(true);
        commandLabel.setVisible(true);
        inputTextField.setVisible(true);
        saveGameButton.setVisible(true);
    }

    public void enterPressed(){
        input = inputTextField.getText().toLowerCase();
        commandsList.add(input);
        if ("quit".equals(input)){
            printToPlayer("You quited game");
            System.exit(0);
        }
        else {
            playerInput = input.split(" ");
            command = commands.getInstance(playerInput[0]);
        }
        if(showTimeLabel.isVisible() == true) {
            showTimeLabel.setVisible(false);
            showTimeLabel.setText("Time is ");
        }
        inputTextField.clear();
    }

    public void showCommands(){
        String commands = "";
        outputTextArea.setText("Your commands are:");
        for(int i=0;i<commandsList.size();i++){
            commands += "\n" +  commandsList.get(i);
        }
        printToPlayer(commands);
    }

    public void initializeComponents(){
        layout = new StackPane();
        layout.setPrefSize(800, 400);

        scene = new Scene(layout, 800, 400);

        nameLabel = new Label();
        nameLabel.setText("Enter name:");
        nameLabel.setTranslateX(-320.0);
        nameLabel.setTranslateY(-180.0);
        nameLabel.setMaxSize(150.0, 20.0);

        nameTextField = new TextField();
        nameTextField.setTranslateX(-200.0);
        nameTextField.setTranslateY(-180.0);
        nameTextField.setMaxSize(200.0, 20.0);

        submitNameButton = new Button("Submit");
        submitNameButton.setTranslateX(-30.0);
        submitNameButton.setTranslateY(-180.0);
        submitNameButton.setMaxSize(100.0, 20.0);
        submitNameButton.setOnAction(submitNameEvent);

        exitGameButton = new Button("Exit Game");
        exitGameButton.setTranslateX(85.0);
        exitGameButton.setTranslateY(-180.0);
        exitGameButton.setMaxSize(100.0, 20.0);
        exitGameButton.setOnAction(exitGameEvent);

        saveGameButton = new Button("Save game");
        saveGameButton.setTranslateX(200.0);
        saveGameButton.setTranslateY(-180.0);
        saveGameButton.setMaxSize(100.0, 20.0);
        saveGameButton.setOnAction(saveGameEvent);
        saveGameButton.setVisible(false);

        loadGameButton = new Button("Load game");
        loadGameButton.setTranslateX(315.0);
        loadGameButton.setTranslateY(-180.0);
        loadGameButton.setMaxSize(100.0, 20.0);
        loadGameButton.setOnAction(loadGameEvent);

        layout.getChildren().addAll(nameLabel, nameTextField, submitNameButton, exitGameButton, saveGameButton, loadGameButton); //okButton);

        outputTextArea = new TextArea("Welcome to prison break text adventure game.\nGive a name to continue. ");
        outputTextArea.setTranslateX(0.0);
        outputTextArea.setTranslateY(-55.0);
        outputTextArea.setMaxSize(760.0, 200.0);
        outputTextArea.setEditable(false);

        inputTextField = new TextField();
        inputTextField.setTranslateX(-200.0);
        inputTextField.setTranslateY(125.0);
        inputTextField.setMaxSize(350.0, 60.0);
        inputTextField.setVisible(false);
        inputTextField.setOnAction(inputTextEvent);

        commandLabel = new Label();
        commandLabel.setText("Give command >>");
        commandLabel.setTranslateX(-300.0);
        commandLabel.setTranslateY(80.0);
        commandLabel.setMaxSize(150.0, 20.0);
        commandLabel.setVisible(false);

        showTimeLabel = new Label();
        showTimeLabel.setText("Time is ");
        showTimeLabel.setTranslateX( 240.0);
        showTimeLabel.setTranslateY(120.0);
        showTimeLabel.setMaxSize(250.0, 20.0);
        showTimeLabel.setVisible(false);

        showTimeButton = new Button("Show time");
        showTimeButton.setTranslateX(340.0);
        showTimeButton.setTranslateY(80.0);
        showTimeButton.setMaxSize(100.0, 20.0);
        showTimeButton.setOnAction(showTimeEvent);
        showTimeButton.setVisible(false);

        showCommandsButton = new Button("Show commands");
        showCommandsButton.setTranslateX(200.0);
        showCommandsButton.setTranslateY(80.0);
        showCommandsButton.setMaxSize(150.0,20.0);
        showCommandsButton.setOnAction(showCommandsEvent);
        showCommandsButton.setVisible(false);

        layout.getChildren().addAll(outputTextArea, inputTextField, commandLabel,showTimeButton,showTimeLabel,showCommandsButton);
    }

}
