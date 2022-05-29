/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import java.util.Scanner;

/**
 * RPS class: Provides basics of RPS game and the main method
 * to excecute the gameplay.
 */
public class RPS extends RPSAbstract {
    
    /**
     * Class constructor of RPS
     * @param moves - move of the player
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    /**
     * Takes the user move, the CPU move, and determines who wins.
     * @param playerMove - move of the player
     * @param cpuMove - move of the CPU
     * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
     */
    public int determineWinner(String playerMove, String cpuMove)
    {
        //If input invalid, print invalid outcome
        if(!super.isValidMove(playerMove) || !super.isValidMove(cpuMove)) {
            return INVALID_INPUT_OUTCOME;
        }
        //Iterate through possibleMoves
        for(int i = 0; i<super.possibleMoves.length; i++){
            //Set case for one move equals last element of possibleMoves
            //the other one equals first element.
            if(i == super.possibleMoves.length-1) {
                if(playerMove.equals(super.possibleMoves[i])
                && cpuMove.equals(super.possibleMoves[0])){
                    return PLAYER_WIN_OUTCOME;
                }
                else if (playerMove.equals(super.possibleMoves[0])
                && cpuMove.equals(super.possibleMoves[i])) {
                    return CPU_WIN_OUTCOME;
                }
            }
            //Set all other cases 
            else if(playerMove.equals(super.possibleMoves[i])
             && cpuMove.equals(super.possibleMoves[i+1])){
                 return PLAYER_WIN_OUTCOME;
            }
            else if(playerMove.equals(super.possibleMoves[i+1])
             && cpuMove.equals(super.possibleMoves[i])){
                 return CPU_WIN_OUTCOME;
            }
        }
        //Set other cases as tie
        return TIE_OUTCOME;

    }

    /**
     * Main method that reads user input, generates cpu move, and plays game
     * 
     * @param args - arguments passed in from command line in String form
     */
    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);
        
        
        System.out.println(PROMPT_MOVE);
        //Continue game if has nextline
        while(in.hasNextLine()){
            //Scan the input
            String scan = in.nextLine();
            //If "q" then end game
            if(scan.equals(QUIT)){
                break;
            }
            //Call play
            game.play(scan, game.genCPUMove());
            System.out.println(PROMPT_MOVE);
        }
        in.close();
        //Display end game stat
        game.end();
    }
}
