package gameScene;

import card.CharacterCard.AssassinCard;
import card.CharacterCard.BardCard;
import card.CharacterCard.BaseCharacterCard;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;

public class CharSelect extends StackPane {
    private ArrayList<BaseCharacterCard> selectedChar;
    private HBox selectableChar;


    public CharSelect() {
        setPrefWidth(1440);
        setPrefHeight(900);
        setAlignment(Pos.CENTER);
        Image textImg = new Image(ClassLoader.getSystemResource("heroesSelectText.png").toString());
        ImageView text = new ImageView(textImg);
        getChildren().add(text);

        setAlignment(text, Pos.TOP_CENTER);
        Image bg = new Image(ClassLoader.getSystemResource("charSelectBG.png").toString());
        setBackground(new Background(new BackgroundFill(new ImagePattern(bg), CornerRadii.EMPTY, Insets.EMPTY)));

        addSelectableChar();
        getChildren().add(selectableChar);
    }
    private void addSelectableChar(){
        selectableChar = new HBox();
        selectableChar.setSpacing(30);
        //1
        VBox a = new VBox();
        a.setPrefWidth(180);
        a.setPrefHeight(350);
        a.setSpacing(30);
        Button a1 = new Button();
        a1.setPrefWidth(180);
        a1.setPrefHeight(40);
        a1.setText("select");
        a1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                selectedChar.add(new AssassinCard());
                a1.setText("Selected");
            }
        });
        ImageView a2 = new ImageView(new Image(ClassLoader.getSystemResource("cardSample.png").toString()));
        a.getChildren().add(a2);
        a.getChildren().add(a1);
        selectableChar.getChildren().add(a);
        //2
        VBox b = new VBox();
        b.setPrefWidth(180);
        b.setPrefHeight(350);
        b.setSpacing(30);
        Button b1 = new Button();
        b1.setPrefWidth(180);
        b1.setPrefHeight(40);
        b1.setText("select");
        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                selectedChar.add(new BardCard());
                b1.setText("Selected");
            }
        });
        ImageView b2 = new ImageView(new Image(ClassLoader.getSystemResource("cardSample.png").toString()));
        b.getChildren().add(b2);
        b.getChildren().add(b1);
        selectableChar.getChildren().add(b);
    }



}
