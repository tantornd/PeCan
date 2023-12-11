package card.SupportCard.food.healing;

import card.SupportCard.food.healing.HealingFood;
import javafx.scene.image.Image;

public class Spaghetti extends HealingFood {
    public Spaghetti() {
        super(2, 2);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("Spaghetti.png").toString());
    }
}
