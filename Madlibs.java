/*
 * @author Jaclyn Kordus CSCI-180-01 at 9am MWF 
 *
 * This code is a prototype for a madlibs game. 
 * The person reads off the type of word the person needs, and records it 
 * in the box. 
 *
 * The output recognizes when the answers are saved and then thanks the
 * player when they submit their answers.
 *
 *This specific madlib was taken from:
 *http://www.madlibs.com/content/uploads/2016/04/VacationFun_ML_2009_pg15.pdf
 * 
 * Java API and Oracle Examples were used to help form this code.
 */
package madlibs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.stage.Stage;


public class Madlibs extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        Pane root = new Pane();

        //add fun circles
        for (int i = 0; i < 20; i++) {
            ColorChangingCircles c = makeCircle();
            root.getChildren().add(c);
        }
        Button colorbtn = new Button();
        colorbtn.setText("Change Colors");
        colorbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < 30; i++) {
                    ColorChangingCircles c = (ColorChangingCircles) root.getChildren().get(i);
                    c.setFill();
                }
            }
        });
        VBox allItems = new VBox();
        allItems.getChildren().addAll(root, colorbtn);

        //submit button
        Button btn = new Button();
        btn.setText("Submit");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Thank you for playing!");
            }
        });
        root.getChildren().add(btn);
        btn.setTranslateX(500);
        btn.setTranslateY(550);

        //logo image
        FileInputStream in = new FileInputStream("madlibs.png");
        Image image = new Image(in);
        ImageView logo = new ImageView();
        logo.setImage(image);
        root.getChildren().add(logo);
        logo.setTranslateX(400);
        logo.setTranslateY(10);

        //text box 1
        TextField textField1 = new TextField();
        Label label1 = new Label("1. adj.");
        label1.setTranslateX(670);
        label1.setTranslateY(185);
        HBox hbox = new HBox(textField1);
        textField1.setTranslateX(720);
        textField1.setTranslateY(180);
        root.getChildren().addAll(label1, hbox);
        textField1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Received 1");
            }
        });

        //text box 2
        Label label2 = new Label("2. adj.");
        label2.setTranslateX(475);
        label2.setTranslateY(220);
        TextField textField2 = new TextField();
        HBox hbox2 = new HBox(textField2);
        textField2.setTranslateX(520);
        textField2.setTranslateY(220);
        root.getChildren().addAll(label2, hbox2);
        textField2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Received 2");
            }
        });

        //text box 3
        Label label3 = new Label("3. adj.");
        label3.setTranslateX(876);
        label3.setTranslateY(255);
        TextField textField3 = new TextField();
        HBox hbox3 = new HBox(textField3);
        textField3.setTranslateX(922);
        textField3.setTranslateY(250);
        root.getChildren().addAll(label3, hbox3);
        textField3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Received 3");
            }
        });

        //text box 4
        Label label4 = new Label("4. number.");
        label4.setTranslateX(587);
        label4.setTranslateY(295);
        TextField textField4 = new TextField();
        HBox hbox4 = new HBox(textField4);
        textField4.setTranslateX(665);
        textField4.setTranslateY(290);
        root.getChildren().addAll(label4, hbox4);
        textField4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Received 4");
            }
        });

        //text box 5
        Label label5 = new Label("5. plural noun.");
        label5.setTranslateX(645);
        label5.setTranslateY(325);
        TextField textField5 = new TextField();
        HBox hbox5 = new HBox(textField5);
        textField5.setTranslateX(737);
        textField5.setTranslateY(322);
        root.getChildren().addAll(label5, hbox5);
        textField5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Received 5");
            }
        });


        
        //Background
        root.setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(allItems, 1300, 600, Color.LAVENDERBLUSH);

        //window title
        primaryStage.setTitle("Welcome to the MadLibs!");
        primaryStage.setScene(scene);
        primaryStage.show();

        //intro
        Text intro = new Text();
        intro.setText("Welcome to MadLibs! Please press tab and then enter your answer. To save your answer, press enter. "
                + "\n"
                + "Press the submit button when completed.");
        intro.setTranslateX(300);
        intro.setTranslateY(158);
        intro.setFont(new Font(13));
        intro.setWrappingWidth(1000);
        intro.setTextAlignment(TextAlignment.JUSTIFY);
        root.getChildren().add(intro);

        //madlib
        Text lib = new Text();
        lib.setText("A vacation is when you take a trip to some\n"
                + "\n"
                + "place with your                                                                                family.\n"
                + "\n"
                + "Parents need vacations more than kids because parents are always very\n"
                + "\n"
                + "and because they have to work \n"
                + "\n"
                + "hours every day all year making enough \n"
                + "\n"
                + "to pay for the vacation.");
        lib.setTranslateX(360);
        lib.setTranslateY(200);
        lib.setFont(new Font(15));
        lib.setWrappingWidth(1000);
        lib.setTextAlignment(TextAlignment.JUSTIFY);
        root.getChildren().add(lib);

    }

    //main  
    public static void main(String[] args) {
        launch(args);
    }

    public static ColorChangingCircles makeCircle() {
        int x = (int) (Math.random() * 200);
        int y = (int) (Math.random() * 600);
        int r = (int) (Math.random() * 30 + 10);
        ColorChangingCircles myCircle = new ColorChangingCircles(x, y, r);
        return myCircle;
    }

//    public static ColorChangingCircles makeCircle2() {
//        int j = (int) (Math.random() * 700);
//        int k = (int) (Math.random() * 600);
//        int m = (int) (Math.random() * 30 + 10);
//        ColorChangingCircles myCircle2 = new ColorChangingCircles(j, k, m);
//    }
}
