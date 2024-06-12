package Animations;

import javafx.animation.TranslateTransition;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

    public Shake(TextField node){
        tt = new TranslateTransition(Duration.millis(80),  node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3); //Количество трясок
        tt.setAutoReverse(true);
    }

    public void playAnim(){
        tt.playFromStart();;
    }
}
