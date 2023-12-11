package app;

import game.GameLogic;
import gameScene.Battle;
import gameScene.CharSelect;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import gameScene.MainMenu;

public class Main extends Application{
    public static Stage stage;
    public static MainMenu mainMenu;
    public static CharSelect charSelect;
    public static Scene mainMenuScene, charSelectScene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        AudioClip music = new AudioClip(ClassLoader.getSystemResource("dramatic-flute-140505.mp3").toString());
        music.setVolume(0.5);
        music.setCycleCount(Timeline.INDEFINITE);
        music.play();

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
    public static void switchToGameBattle() throws InterruptedException {
        GameLogic.getInstance().initGame();
        ImageView imageView = new ImageView(new Image(ClassLoader.getSystemResource("GameStart.png").toString()));
        StackPane stp = new StackPane(imageView);
        stage.setScene(new Scene(stp));
        Thread.sleep(500);
        Battle battle = new Battle();
        stage.setScene(new Scene(battle));

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
