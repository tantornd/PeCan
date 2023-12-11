package card.SupportCard.food.shielding;

import javafx.scene.image.Image;

public class BananaShake extends ShieldingFood {
    public BananaShake(){
        super(1, 2);
    }

    @Override
    public Image getImage() {
        return new Image(ClassLoader.getSystemResource("BananaShake.png").toString());
    }
}
