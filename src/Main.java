import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Tournament tournament = new Tournament();
        Scanner reader = new Scanner(System.in);
        
        tournament.start(reader);
        
    }
}
