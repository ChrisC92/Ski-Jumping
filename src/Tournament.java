import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Scanner;

public class Tournament {
    private ArrayList<Jumper> jumpers = new ArrayList<Jumper>();
    private int roundNumber = 0;
    
    public void start(Scanner reader){
        System.out.println("Kumpula ski jumping week \n");
        addJumpers(reader);
        System.out.println("\nThe tournament begins!");
        jumpOrQuit(reader); 
    }
    
    private void addJumpers(Scanner reader){
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        String jumperName;
        while(true){
            System.out.print("  Participant name: ");
            jumperName = reader.nextLine();
            if(jumperName.isEmpty()){
                break;
            }
            Jumper jumper = new Jumper(jumperName);
            jumpers.add(jumper);
        }
            Collections.sort(jumpers);
    }
    
    private void printJumpers(){
        int i = 1;
        for(Jumper jumper : jumpers){
            System.out.println("  " +i + ". " + jumper);
            i++;
        }
    }
    
    private void jump(Scanner reader){
        System.out.println("\nRound "  + roundNumber);
        System.out.println("\nJumping order:");
        Collections.sort(jumpers);
        printJumpers();
        System.out.println("\nResults of round " + roundNumber);
        for (Jumper jumper: jumpers) {
            Score score = new Score();
            ArrayList<Integer> judgeScore = score.returnJudgeScores();
            System.out.println("  " + jumper.getName());
            int lengthJump = score.returnLength();
           jumper.addLength(lengthJump);
            System.out.println("    length: " + lengthJump);
            
            System.out.print("    judge votes: [");
            score.printScores(judgeScore);
            int calcScore = score.calculateScore(judgeScore, lengthJump);
            jumper.addScore(calcScore);
        }
        jumpOrQuit(reader);
    }
    
    private void result(){
        Collections.sort(jumpers, new sortScore());
        int i = 1;
        System.out.println("\nThanks!");
        System.out.println("\nTournament results:");
        System.out.println("Position    Name");
        for(Jumper jumper : jumpers){
            System.out.println(i + "           " + jumper);
            System.out.print("            jump lengths: ");
            jumper.printLengths();
            i++;
         }
     }
        
    
    
    private void jumpOrQuit(Scanner reader){
        System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
        String input = reader.nextLine();
        if(input.equals("jump")){
            roundNumber++;
            jump(reader);
        } else {
            result();
        }
    }
   
}
