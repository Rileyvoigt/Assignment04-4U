
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author voigr4865
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create game board
        Board board = new Board(12, 12);

        //random number generator
        int randNum = (int) (0 + Math.random() * (11 - 0 + 1));

        //dalek array
        Dalek[] daleks = new Dalek[3];

        //create daleks
        for (int i = 0; i <= 2; i++) {
            daleks[i] = new Dalek((int) (0 + Math.random() * 12), (int) (0 + Math.random() * 12));
            board.putPeg(Color.BLACK, daleks[i].getRow(), daleks[i].getCol());
        }

        //make doctor
        Doctor doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

        //put a message on the board
        board.displayMessage("Click to move doctor");



        while (true) {

            daleks[0].crash(daleks, board);

            if (daleks[0].hasCrash() == true && daleks[1].hasCrash() == true && daleks[2].hasCrash() == true) {
                board.displayMessage("YOU WIN!");
                break;
            }

            //get click on the board
            if (!doc.hasCrashed()) {
                Coordinate click = board.getClick();

                //remove peg
                board.removePeg(doc.getRow(), doc.getCol());
                //move to where its clicked
                doc.Move(click.getRow(), click.getCol());
                //put the peg back on the board
                board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());
                //otherwise
            } else {
                //put a yellow peg down
                board.putPeg(Color.yellow, doc.getRow(), doc.getCol());
                //display you lose
                board.displayMessage("YOU LOSE!");
                //stop the game
                break;
            }

            for (int i = 0; i <= 2; i++) {

                //if daleks hasnt crashed
                if (daleks[i].hasCrash() == false) {
                    board.removePeg(daleks[i].getRow(), daleks[i].getCol());
                }

                //if they havent crashed
                if (daleks[i].hasCrash() == false) {
                    daleks[i].advanceTowards(doc);
                    board.putPeg(Color.BLACK, daleks[i].getRow(), daleks[i].getCol());

                    //otherwise
                } else {
                    board.putPeg(Color.RED, daleks[i].getRow(), daleks[i].getCol());
                }
            }
            
            //for loop
            for (int i = 0; i <= 2; i++) {
                //if the doctor has crashed
                if (doc.getRow() == daleks[i].getRow() && doc.getCol() == daleks[i].getCol()) {
                    doc.crashed();
                }
            }
        }
    }
}