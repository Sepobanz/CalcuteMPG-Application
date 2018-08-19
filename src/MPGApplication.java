import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MPGApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane(); // creates variable for GUI
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setVgap(10);
        
        Label miles = new Label ("Miles:"); //creates label with reference variable.
        grid.add (miles,0,0);               //(variable,column,row)
        TextField milesF = new TextField();
        grid.add(milesF,300,0);
        
        grid.add(new Label("Gallons"),0,1); //creates label without a reference variable.
        TextField gallonsF = new TextField();
        grid.add(gallonsF,300,1);
        
        Label mpg = new Label ("MPG:");
        grid.add (mpg,0,2);
        TextField mpgF = new TextField();
        grid.add(mpgF,300,2);
        mpgF.setEditable(false);
        
        Button calc = new Button("Calculate");
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(calc);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 0, 3, 2, 1);

        
        calc.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                double m = Double.parseDouble(milesF.getText()); //gets info
                double g = Double.parseDouble(gallonsF.getText()); //gets info
                
                double total = m/g; //calculates
                
                mpgF.setText(Double.toString(total));
            }
        });
        
        Scene scene = new Scene(grid, 300, 250); //sets size of gridVar
        
        primaryStage.setTitle("GUI App"); // sets title name seen at top of GUI
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
