package game;

import card.SupportCard.BaseSupportCard;
import card.SupportCard.event.EventCard;
import card.SupportCard.food.FoodCard;

public class Bot {
    private boolean playedEvent;
    public static void performAction(){
        GameLogic game = GameLogic.getInstance();
        if (game.isHandPlayable(1)){
            if (game.getActiveChara(game.getCharacterCards().get(1)).getHp() <= 3){
                for (BaseSupportCard e: game.getPlayerHands().get(1)){
                    if (e instanceof FoodCard) e.play();
                }
            }
            if (!game.isBotPlayedEvent()){
                for (BaseSupportCard e: game.getPlayerHands().get(1)){
                    if (e instanceof EventCard && e.isPlayable()){
                        e.play();
                        game.setBotPlayedEvent(true);
                        break;
                    }
                }
            }
        }
        if (game.canUseUltimate(1)){
            game.getActiveChara(game.getCharacterCards().get(1)).useUltimate();
        }
        else if (game.canUseSkill(1)){
            game.getActiveChara(game.getCharacterCards().get(1)).useSkill();
        }
        else if (game.canAttack(1)){
            game.getActiveChara(game.getCharacterCards().get(1)).attack();
        }
    }
}
