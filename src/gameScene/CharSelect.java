package gameScene;

import app.Main;
import card.CharacterCard.*;
import game.GameLogic;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;

public class CharSelect extends VBox {

    private final ArrayList<VBox> selectedCharCards;
    private HBox selectableChar;
    private final HBox selectedChar;
    private VBox assasinBox, bardBox, flameArcherBox, knightBox, mageBox, palladinBox, priestBox;


    public CharSelect() {
        selectedCharCards = new ArrayList<>();
        setPrefWidth(1440);
        setPrefHeight(900);
        setSpacing(50);

        Image textImg = new Image(ClassLoader.getSystemResource("charSelect.png").toString());
        ImageView text = new ImageView(textImg);
        getChildren().add(text);

        Image bg = new Image(ClassLoader.getSystemResource("mainMenubg.png").toString());
        setBackground(new Background(new BackgroundFill(new ImagePattern(bg), CornerRadii.EMPTY, Insets.EMPTY)));

        addSelectableChar();
        getChildren().add(selectableChar);
        addOnMouseClicked();

        selectedChar = new HBox();
        selectedChar.setSpacing(50);
        selectedChar.setPrefHeight(240);
        selectedChar.setPrefWidth(1440);
        getChildren().add(selectedChar);


        HBox btnBar = new HBox();
        btnBar.setPrefWidth(1440);
        btnBar.setSpacing(280);

        Button nextBtn = new Button("Next");
        nextBtn.setPrefHeight(100);
        nextBtn.setPrefWidth(150);
         nextBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (selectedCharCards.size() == 3) {
                    //go to battle scene
                    try {
                        Main.switchToGameBattle();
                    } catch (Exception e) {

                    }
                    for (VBox vb:selectedCharCards){
                        if (assasinBox.equals(vb)) {
                            GameLogic.getInstance().getCharacterCards().get(0).add(new AssassinCard());
                        } else if (bardBox.equals(vb)) {
                            GameLogic.getInstance().getCharacterCards().get(0).add(new BardCard());
                        } else if (flameArcherBox.equals(vb)) {
                            GameLogic.getInstance().getCharacterCards().get(0).add(new FlameArcherCard());
                        } else if (knightBox.equals(vb)) {
                            GameLogic.getInstance().getCharacterCards().get(0).add(new KnightCard());
                        } else if (mageBox.equals(vb)) {
                            GameLogic.getInstance().getCharacterCards().get(0).add(new MageCard());
                        } else if (palladinBox.equals(vb)) {
                            GameLogic.getInstance().getCharacterCards().get(0).add(new PalladinCard());
                        } else if (priestBox.equals(vb)) {
                            GameLogic.getInstance().getCharacterCards().get(0).add(new PriestCard());
                        }
                    }


                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select 3 character cards!!!");
                    alert.show();
                }
            }
        });

        Button resetBtn = new Button("Reset");
        resetBtn.setPrefHeight(100);
        resetBtn.setPrefWidth(150);
        resetBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.charSelect = new CharSelect();
                Main.charSelectScene = new Scene(Main.charSelect);
                Main.stage.setScene(Main.charSelectScene);
            }
        });

        Button returnBtn = new Button("Return");
        returnBtn.setPrefHeight(100);
        returnBtn.setPrefWidth(150);
        returnBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                app.Main.switchToMainMenu();
            }
        });

        Button infoBtn = new Button("info?");
        infoBtn.setPrefHeight(100);
        infoBtn.setPrefWidth(150);
        infoBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "characters info");
                a.show();
            }
        });
        btnBar.getChildren().add(infoBtn);
        btnBar.getChildren().add(returnBtn);
        btnBar.getChildren().add(resetBtn);
        btnBar.getChildren().add(nextBtn);

        getChildren().add(btnBar);

        setAlignment(Pos.CENTER);
    }
    private void addSelectableChar(){
        selectableChar = new HBox();
        selectableChar.setPrefHeight(240);
        selectableChar.setPrefWidth(1440);
        selectableChar.setSpacing(50);
        //1
        ImageView assasin = new ImageView(new Image(ClassLoader.getSystemResource("assasinCard.png").toString()));
        assasinBox = new VBox(assasin);
        //2
        ImageView bard = new ImageView(new Image(ClassLoader.getSystemResource("bardCard.png").toString()));
        bardBox = new VBox(bard);
        //3
        ImageView flameArcher = new ImageView(new Image(ClassLoader.getSystemResource("flameArcherCard.png").toString()));
        flameArcherBox = new VBox(flameArcher);
        //4
        ImageView knight = new ImageView(new Image(ClassLoader.getSystemResource("knightCard.png").toString()));
        knightBox = new VBox(knight);
        //5
        ImageView mage = new ImageView(new Image(ClassLoader.getSystemResource("mageCard.png").toString()));
        mageBox = new VBox(mage);
        //6
        ImageView palladin = new ImageView(new Image(ClassLoader.getSystemResource("palladinCard.png").toString()));
        palladinBox = new VBox(palladin);
        //7
        ImageView priest = new ImageView(new Image(ClassLoader.getSystemResource("priestCard.png").toString()));
        priestBox = new VBox(priest);

        selectableChar.getChildren().addAll(assasinBox, bardBox, flameArcherBox, knightBox, mageBox, palladinBox, priestBox);
    }


    private void addOnMouseClicked() {
        assasinBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addSelectedChar(assasinBox);
            }
        });
        bardBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addSelectedChar(bardBox);
            }
        });
        flameArcherBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addSelectedChar(flameArcherBox);
            }
        });
        knightBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addSelectedChar(knightBox);
            }
        });
        mageBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addSelectedChar(mageBox);
            }
        });
        palladinBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addSelectedChar(palladinBox);
            }
        });
        priestBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addSelectedChar(priestBox);
            }
        });

    }
    private void addSelectedChar(VBox charCard) {
        if (selectedCharCards.size() < 3) {
            selectedCharCards.add(charCard);
            selectedChar.getChildren().add(charCard);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "can not select more than 3 character cards");
            a.show();
        }
    }






}
