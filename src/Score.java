import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Score  {
    
    private final Random r = new Random();
    
    public int returnLength(){        
        
        return r.nextInt(120-61)+60;
    }
    
    public ArrayList<Integer> returnJudgeScores() {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        
        for(int i=0; i<5; i++){
            Integer value = r.nextInt(20-11)+10;
            scores.add(value);
        }
        return scores;
    }
    
    public void printScores(ArrayList<Integer> scores) {
            for(int i=0; i<scores.size()-1; i++){
            System.out.print(scores.get(i) + ", ");
            }
            System.out.print(scores.get(scores.size() -1) + "]");
        }
    
    public int calculateScore(ArrayList<Integer> scores, int length){
        Collections.sort(scores);
        scores.remove(0);
        scores.remove(3);
        System.out.println("");
        return scores.get(0) + scores.get(1) + scores.get(2) + length;
    }
}
