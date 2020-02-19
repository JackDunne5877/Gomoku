import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.control.Button;


/* Gomoku game class. Main method takes arguments[rows, columns, numInArow]
 */
public class Gomoku extends Application {
  private static int rows;
  private static int columns;
  private static int numInArow;
  private Button button;
  private int[] player1rows;
  private int[] player1columns;
  private int[] player2rows;
  private int[] player2columns;
  private int clickCounter;
  public static GridPane gridPane = new GridPane();
  private static Stage primaryStage;
  

  public void start(Stage primaryStage) {
    Scene scene = new Scene(gridPane);
    this.primaryStage = primaryStage;
    primaryStage.setScene(scene);
    primaryStage.show();
    
    /* loop & nested loop to fill the gridPane with buttons */
    Button[][] buttonContainer = new Button[rows][columns];
     for (int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        Button myButton = new Button();
        buttonContainer[i][j] = myButton;
        myButton.setOnAction(new ButtonAction());
        buttonContainer[i][j].setStyle("-fx-background-color: #80D4FF; ");
        gridPane.add(buttonContainer[i][j], i, j);
      }
    }
  }  
  public static void main(String[] args) {
    rows = Integer.parseInt(args[0]);
    columns = Integer.parseInt(args[1]);
    numInArow = Integer.parseInt(args[2]);
    Application.launch(args);

  }
  
     /*loop to fill player arrays with 0s to keep track of placement */
 /* private void arrayFiller() {
    for(int i = 0; i < rows; i ++){
      player1rows[i] = 0;
      player2rows[i] = 0;
    }
    for(int j = 0; j < columns; j ++){
      player1columns[j] = 0;
      player2columns[j] = 0;
    }
  } */
  
      /** Event Listener that operates the rules of the game when a button is clicked.
        * Black & white pieces are played accordingly, and buttons that have been played get disabled
      * @param e  information about the button click event that occurred  */
  private class ButtonAction implements EventHandler<ActionEvent>{
    public void handle(ActionEvent e){
      Button b = (Button) e.getSource();  //the specific button that was pressed;
      b.setDisable(true);
      int rowClicked = gridPane.getRowIndex(b);
      int columnClicked = gridPane.getColumnIndex(b);
      clickCounter += 1;
      if(clickCounter % 2 == 0){ //if the clickCounter is even
        b.setStyle("-fx-background-color: #FFFFFF; ");
        player1rows[rowClicked] = 1;
        player1columns[columnClicked] = 1;
      }
      else{
        b.setStyle("-fx-background-color: #000000; ");
        player2rows[rowClicked] = 1;
        player2columns[columnClicked] = 1;
      }
      winnerCheck();

 }
   
}
       /*method that checks if a player has won
        * checks every time a button is clicked
        */
    public void winnerCheck() {
      int inArow = 0;
      //player 1 row check
      for(int i = 0; i < player1rows.length; i ++){
        if(player1rows[i] == 1){
          inArow += 1;
        if(player1rows[i + 1] == 0){
          inArow = 0;
        }
        else{
        ;
        }
      }
      else {
          ;
        }
       while(i < player1rows.length){
        if(inArow >= numInArow){
          primaryStage.close();
          System.out.println("Player 1 wins!");
        }
        else{
        ;
        }
      }
      }
   
    
        //player 1 column check
    int inArow2 = 0;
    for(int i = 0; i < player1columns.length; i ++){
      if(player1columns[i] == 1){
        inArow2 += 1;
        if(player1columns[i + 1] == 0){
          inArow2 = 0;
        }
        else{
        ;
        }
      }
      else {
          ;
        }
        while(i < player1columns.length) {
        if(inArow2 >= numInArow){
          primaryStage.close();
          System.out.println("Player 1 wins!");
        }
        else{
        ;
        }
    }

      }
    
        //player 2 row check
    int inArow3 = 0;
    for(int i = 0; i < player2rows.length; i ++){
      if(player2rows[i] == 1){
        inArow3 += 1;
        if(player2rows[i + 1] == 0){
          inArow3 = 0;
        }
        else{
        ;
        }
      }
      else {
          ;
        }
        while(i < player2rows.length){
        if(inArow3 >= numInArow){
          primaryStage.close();
          System.out.println("Player 1 wins!");
        }
        else{
        ;
        }
      }
    }

    
        //player 2 column check
    int inArow4 = 0;
    for(int i = 0; i < player2columns.length; i ++){
      if(player2columns[i] == 1){
        inArow4 += 1;
        if(player2columns[i + 1] == 0){
          inArow4 = 0;
        }
        else{
        ;
        }
       while(i < player2columns.length){
        if(inArow4 >= numInArow){
          primaryStage.close();
          System.out.println("Player 1 wins!");
        }
         else{
         ;
         }
       }
      }
      else {
          ;
        }
    }

     }
   }
