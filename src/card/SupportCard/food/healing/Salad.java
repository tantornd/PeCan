package card.SupportCard.food.healing;

import card.SupportCard.food.healing.HealingFood;
import javafx.scene.image.Image;

public class Salad extends HealingFood {
    public Salad() {
        super(0, 1);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("Salad.png").toString());
    }
}
