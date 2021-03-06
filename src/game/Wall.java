package game;

import java.util.ArrayList;
//
//import javafx.scene.control.Label;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.text.TextAlignment;
//
//import java.util.Random;
//
//public class Wall {
////    int frequency;
////    Point Position;
////    int Length;
//
//    Block(AnchorPane _blockPane, double[] xs, int xsi) {
//        _block = new Label();
//        Random rand = new Random();
//        int hex = rand.nextInt(15);
//        _block.setTextAlignment(TextAlignment.CENTER);
//        _block.setStyle("-fx-background-color:" + hexcodes[hex] + "; -fx-background-radius: 4px; -fx-border-color: BLACK; -fx-border-width: 2px; -fx-font-family:'CENTURY GOTHIC'; -fx-font-size: 30; -fx-text-fill: WHITE;  -fx-alignment: CENTER;  -fx-border-radius: 4px");
//        _block.setText(String.valueOf(value));
//        _block.setMinSize(52.5, 52.5);
//        _block.setMaxSize(52.5, 52.5);
//        _block.setPrefSize(52.5, 52.5);
//        _block.setLayoutX(xs[xsi]);
//        _block.setLayoutY(-52.5);
//        _blockPane.getChildren().add(_block);
//    }
//
//}
import javafx.scene.layout.AnchorPane;
import java.lang.Math;
import javafx.scene.control.Label;
import javafx.scene.Group;
//provide random numbers for direction of particle
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;


/**
 * The Class Wall.
 */
public class Wall {
    
    /** The random. */
    Random random = new Random();
    
    /** The initial steps. */
    double initialSteps = 100;//number of steps until removed
    
    /** The delta Y. */
    //    double deltaX;//change in x location per step
    double deltaY;//change in y location per step
    
    /** The particle. */
    //    @FXML
    Label _particle;
    
    /** The particles. */
    ArrayList<Label> _particles;
    
    /** The r. */
    Random r;
    
    /** The x. */
    double x;
    
    /** The xs. */
    double xs;
    
    /** The ys. */
    double ys;
    
    /** The y. */
    double y;

    /**
     * Instantiates a new wall.
     *
     * @param _blockPane the block pane
     * @param X the x
     * @param Y the y
     * @param hex the hex
     * @param hexcodes the hexcodes
     */
    Wall(AnchorPane _blockPane, double X, double Y, int hex, String[] hexcodes) {
        r = new Random();
        _particles=new ArrayList<Label>();
        for (int i = 0; i < 20; i++) {
            _particle = new Label();
            _particles.add(_particle);
            int h=r.nextInt(hex+1);
            _particle.setStyle("-fx-background-color: "+hexcodes[h]+/*; -fx-background-radius: 10*/"; -fx-background-size: 10; -fx-pref-width: 5; -fx-pref-height: 5; -fx-font-size: 1");
//            System.out.println(X + " " + Y);
            _particle.setLayoutX(X + 26);
            _particle.setLayoutY(Y + 26);
            _blockPane.getChildren().add(_particle);

            TranslateTransition translate = new TranslateTransition();

            //shifting the X coordinate of the centre of the circle by 400

            x = r.nextDouble();
            y = r.nextDouble();
            xs = r.nextInt(2);

            xs = x * 30 * (double) (Math.pow(-1, (int) xs));
            ys = r.nextInt(2);
            ys = y * 30 * (double) (Math.pow(-1, (int) ys));
            System.out.println(xs + " " + ys);
            translate.setByX(xs);
            translate.setByY(ys);

            //setting the duration for the Translate transition
            translate.setDuration(Duration.millis(1000));

            //setting cycle count for the Translate transition
//            translate.setCycleCount(50);

            //setting Circle as the node onto which the transition will be applied
            translate.setNode(_particle);

            //playing the transition
            translate.play();
            System.out.println(translate.getStatus());
            while (translate.getStatus().equals(toString().equals("RUNNING"))) {

            }
        }

//            for (Label _particle : _particles) {
//                _blockPane.getChildren().remove(_particle);
//            }
//            translate.setOnFinished(_blockPane.getChildren().remove(_particle));
//        _particle.setTranslateX(25);
//        _particle.setTranslateY(25);
            //Set radnom direction, squere technique.
//        deltaX = 1.0 - random.nextFloat()*2.0;
//        deltaY = 1.0 - random.nextFloat()*2.0;

    }
}