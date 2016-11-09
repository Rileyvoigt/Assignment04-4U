/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author voigr4865
 */
public class Doctor {

    //ionstance variables
    private int row;
    private int col;
    private boolean crash = false;

    
    /**
     * the col and row that the doctor is on
     * @param row row that the doctor is on
     * @param col col that the doctor is on
     */
    public Doctor(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * code that moves the doctor
     * @param newRow the row the doctor will be on after moving
     * @param newCol the col the doctor will be on after moving
     */
    public void Move(int newRow, int newCol) {
        if((newRow == row || newRow == row + 1 || newRow == row - 1) && (newCol == col || newCol == col + 1 || newCol == col - 1)){
            this.col = newCol;
            this.row = newRow;
        }else{
            this.col = (int) (0 + Math.random() * 12);
            this.row = (int) (0 + Math.random() * 12);
        }
        
    }
    
    /**
     * gets the doctors row
     * @return the doctors row
     */
    public int getRow(){
        return this.row;
    }
    /**
     * gets the doctors col
     * @return the doctors col 
     */
    public int getCol(){
        return this.col;
    }
    
    /**
     * find if the doctor has crashed
     * @return if the doctor has crashed
     */
    public boolean hasCrashed(){
        return crash;
    }
    /**
     * a method for crashing
     */
     public void crashed(){
        this.crash = true;
    }
}