
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author voigr4865
 */
public class Dalek {
    
    //insance variables
    private int row;
    private int col;
    private boolean crash = false;
    
    /**
     * gets the position of the daleks
     * @param row the row of the dalek
     * @param col the col of the dalek
     */
     public Dalek(int row, int col) {
         this.row = row;
         this.col = col;
    }
     
    
     /**
      * moves the daleks
      * @param newRow the row it is on after it moves
      * @param newCol the col it is on after it moves
      */
     public void Move(int newRow, int newCol){
         
              this.col = newCol;
              this.row = newRow;
          
     }
     /**
      * has the daleks move towards the doctor
      * @param doc the place that the daleks are moving towards
      */
     public void advanceTowards(Doctor doc){
         int docRow = doc.getRow();
         int docCol = doc.getCol();
         
         if(docCol > this.col){
             this.col += 1;  
         }
         if(docCol < this.col){
             this.col -= 1;  
         }
         if(docRow > row){
             this.row += 1;  
         }
         if(docRow < row){
             this.row -= 1;  
         }
         if(docRow == row){
             
         }
          
    
     }

     /**
      * gets the row
      * @return the row
      */
     public int getRow(){
        return this.row;
    }
     /**
      * gets the col
      * @return the col
      */
    public int getCol(){
        return this.col;
    }
    /**
     * find if the daleks crash
     * @return if its crashed
     */
    public boolean hasCrash(){
        return crash;
    }
    /**
     * a void for crashing
     */
     public void crashed(){
        this.crash = true;
    }
     /**
      * the crash code for the 3 daleks
      * @param daleks the dalek array that has crashed
      * @param board the board that we are on
      */
    public void crash(Dalek daleks[], Board board){
        if(daleks[0].getCol() == daleks[1].getCol()
                && daleks[0].getRow() == daleks[1].getRow()){
            board.putPeg(Color.RED, daleks[1].getRow(), daleks[1].getCol());
            daleks[0].crashed();
            daleks[1].crashed();
            
        }
        if(daleks[0].getCol() == daleks[2].getCol()
                && daleks[0].getRow() == daleks[2].getRow()){
            board.putPeg(Color.RED, daleks[0].getRow(), daleks[0].getCol());
            daleks[0].crashed();
            daleks[2].crashed();
            
        }
        if(daleks[1].getCol() == daleks[2].getCol()
                && daleks[1].getRow() == daleks[2].getRow()){
            board.putPeg(Color.RED, daleks[1].getRow(), daleks[1].getCol());
            daleks[1].crashed();
            daleks[2].crashed();
              
        }
    }
}
