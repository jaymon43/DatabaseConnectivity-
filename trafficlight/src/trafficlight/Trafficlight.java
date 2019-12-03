/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlight;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author jfurl
 */
public class Trafficlight extends Application implements Runnable {
     Circle red = new Circle();
    Circle green = new Circle();
    Circle yellow = new Circle();
    Button b1 = new Button();
   
@Override
public void start(Stage stage) {
    //Drawing a Rectangle 
    Rectangle rectangle = new Rectangle();


    //grid layout
    GridPane grid = new GridPane();
    grid.setHgap(5);
    grid.setVgap(20);
//buttons
    HBox hbButtons = new HBox();

    Button buttonStart = new Button("Start");
    Button buttonStop = new Button("Stop");
  buttonStart.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
        green.setFill(Color.YELLOW);
}
    });
   buttonStop.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
   Trafficlight tl=new Trafficlight();
   Thread t1=new Thread((Runnable) tl);
   t1.start();
       }
    });
    //labels and textfeilds
    Label lblGreen = new Label("Green");
    TextField tfGreen = new TextField("3");
    Label lblYellow = new Label("Yellow");
    TextField tfYellow = new TextField("4");
    Label lblRed = new Label("Red");
    TextField tfRed = new TextField("5");

    grid.add(lblGreen, 0, 0);
    grid.add(tfGreen, 1, 0);
    grid.add(lblYellow, 0, 1);
    grid.add(tfYellow, 1, 1);
    grid.add(lblRed, 0, 2);
    grid.add(tfRed, 1, 2);
    grid.setPadding(new Insets(320, 5, 30, 40));


    hbButtons.getChildren().addAll(buttonStart, buttonStop);
    hbButtons.setAlignment(Pos.BOTTOM_CENTER);
    //Setting the properties of the rectangle 
    rectangle.setX(150);
    rectangle.setY(75);
    rectangle.setWidth(400);
    rectangle.setHeight(200);

    rectangle.setArcHeight(50);
    rectangle.setArcWidth(50);
    Color c = Color.web("#404040");
    Color color1 = Color.web("#404040");
    Color color2 = Color.web("#808080");
    Color greenColor = Color.web("#00FF00");

    rectangle.setFill(c);
    //setting circle properties

    green.setCenterX(230);
    green.setCenterY(170);
    green.setRadius(50);
    green.setFill(greenColor);

    yellow.setCenterX(345);
    yellow.setCenterY(170);
    yellow.setRadius(50);
    yellow.setFill(color2);
    red.setCenterX(465);
    red.setCenterY(170);
    red.setRadius(50);
    red.setFill(color2);
    hbButtons.setPadding(new Insets(15, 12, 15, 12));
    hbButtons.setSpacing(10);   // Gap between nodes
    //Creating a Group object  
    StackPane rootPane = new StackPane();
    Pane p1 = new Pane(red, green, yellow);
    Pane p2 = new Pane(rectangle);
    grid.add(hbButtons, 2, 2, 2, 1);
    //  grid.add(grid, 2, 0, 0, 0);

    rootPane.getChildren().addAll(p2, p1, grid);
    //Creating a scene object 
    Scene scene = new Scene(rootPane, 600, 500);

    //Setting title to the Stage 
    stage.setTitle("Traffic lights");

    //Adding scene to the stage 
    stage.setScene(scene);

    //Displaying the contents of the stage 
    stage.show();
}

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}
           
