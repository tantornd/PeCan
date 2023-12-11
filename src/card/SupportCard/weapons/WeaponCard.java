package card.SupportCard.weapons;

import card.SupportCard.BaseSupportCard;
import javafx.scene.image.Image;

public abstract class WeaponCard extends BaseSupportCard{
    public WeaponCard() {
        super(2);
    }
    @Override
    public abstract void play();

    @Override
    public abstract boolean isPlayable();


    public abstract Image getImage();
}
