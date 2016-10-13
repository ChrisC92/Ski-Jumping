import java.util.ArrayList;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private int score;
    private ArrayList<Integer> lengths = new ArrayList<Integer>();
    
    
    public Jumper(String name){
        this.name = name;
        this.score = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public int getScore(){
        return score;
    }
    
    public void addScore(int score){
        this.score += score;
    }
    
    @Override
    public String toString(){
        return name + " (" + score + " points)";
    }
    
    @Override
    public int compareTo(Jumper jumper){
        return this.getScore() - jumper.getScore();
    }
    
    public void addLength(Integer length){
        lengths.add(length);
    }
    
    public void printLengths() {
        for(int i=0; i<lengths.size()-1; i++){
            System.out.print(lengths.get(i) + " m, ");
        }
        System.out.println(lengths.get(lengths.size()-1) + " m");
    }
}

