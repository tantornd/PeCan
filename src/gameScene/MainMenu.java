package gameScene;

import app.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class MainMenu extends StackPane {
    private static ImageView titleText;

    public MainMenu() {
        setPrefWidth(1440);
        setPrefHeight(900);
        setAlignment(Pos.CENTER);

        Image bg = new Image(ClassLoader.getSystemResource("mainMenuBG.png").toString());
        javafx.scene.image.ImageView bgv = new javafx.scene.image.ImageView(bg);
        bgv.setFitWidth(1440);
        bgv.setFitHeight(900);
        getChildren().add(bgv);

        VBox startBorder = new VBox();
        startBorder.setMaxWidth(600);
        startBorder.setMaxHeight(900);
        startBorder.setSpacing(450);

        Image tt = new Image(ClassLoader.getSystemResource("titleText.png").toString());
        this.titleText = new javafx.scene.image.ImageView(tt);

        ImageView playBtn = new ImageView(new Image(ClassLoader.getSystemResource("playBtn.png").toString()));

        startBorder.getChildren().add(titleText);
        startBorder.getChildren().add(playBtn);
        startBorder.setAlignment(Pos.CENTER);


        StackPane.setAlignment(titleText, Pos.TOP_CENTER);
        playBtn.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                // TODO Auto-generated method stub
                Main.switchToCharSelect();

            }

        });
        this.getChildren().add(startBorder);
    }
}
