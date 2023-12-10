package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainMenu.MainMenu;

public class Main extends Application{
    public static Stage stage;
    public static MainMenu mainMenu;
    public static Scene mainMenuScene;
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.mainMenu = new MainMenu();
        this.mainMenuScene = new Scene(mainMenu);
        this.stage = primaryStage;
        this.stage.setScene(mainMenuScene);
        this.stage.setTitle("Pecan");
        this.stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
