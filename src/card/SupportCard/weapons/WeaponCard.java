package card.SupportCard.weapons;

import card.CharacterCard.BaseCharacterCard;
import card.SupportCard.BaseSupportCard;
import game.GameLogic;

public abstract class WeaponCard extends BaseSupportCard {
    public WeaponCard() {
        super(2);
    }
    @Override
    public abstract void play();

    @Override
    public abstract boolean isPlayable();
}
