import java.util.Comparator;

public class sortScore implements Comparator<Jumper>{
    
    
@Override
    public int compare(Jumper jumper1, Jumper jumper2){
        return jumper2.getScore() - jumper1.getScore();
    }
}
