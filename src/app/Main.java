package app;

import gameScene.CharSelect;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gameScene.MainMenu;

public class Main extends Application{
    public static Stage stage;
    public static MainMenu mainMenu;
    public static CharSelect charSelect;
    public static Scene mainMenuScene, charSelectScene;
    @Override
    public void start(Stage primaryStage) throws Exception {

        mainMenu = new MainMenu();
        charSelect = new CharSelect();

        mainMenuScene = new Scene(mainMenu);
        charSelectScene = new Scene(charSelect);
        stage = primaryStage;
        stage.setScene(mainMenuScene);
        stage.setTitle("Pecan");
        stage.show();
    }
    public static void switchToCharSelect() {
        stage.setScene(charSelectScene);
    }
    public static void switchToMainMenu() {
        stage.setScene(mainMenuScene);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
