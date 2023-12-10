package mainMenu;

import app.Main;
import audio.Audio;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class MainMenu extends StackPane {
    private static ImageView titleText;

    public MainMenu() {
        setPrefWidth(1280);
        setPrefHeight(890);
        setAlignment(Pos.CENTER);

        Image bg = new Image(ClassLoader.getSystemResource("test.gif").toString());
        javafx.scene.image.ImageView bgv = new javafx.scene.image.ImageView(bg);
        bgv.setFitWidth(1280);
        bgv.setFitHeight(890);
        getChildren().add(bgv);

        StackPane startBorder = new StackPane();
        startBorder.setMaxWidth(400);
        startBorder.setMaxHeight(600);

        Image tt = new Image(ClassLoader.getSystemResource("titleText.png").toString());
        this.titleText = new javafx.scene.image.ImageView(tt);

        Font font = Font.loadFont(ClassLoader.getSystemResourceAsStream("fonts/MINECRAFT_FONT.ttf"), 80);
        Text startText = new Text("START");
        startText.setFill(Color.WHITE);
        startText.setFont(font);

        startBorder.getChildren().add(startText);
        startBorder.getChildren().add(titleText);

        StackPane.setAlignment(startText, Pos.BOTTOM_CENTER);
        startText.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                // TODO Auto-generated method stub
                //Main.switchToCharSelect();
                System.out.println("ok");

            }

        });
        this.getChildren().add(startBorder);
    }
}
