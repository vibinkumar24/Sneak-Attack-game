import java.util.List;
import java.util.Scanner;
public class Player{
    private String name;
     private boolean alive =true;
    Player(String name){
        this.name = name;
    }
     public String getName() {
        return name;
    }
    public boolean alive(){
        return this.alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    void play(List<Player> players, Coordinator coordinator) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the index Number of the player " + this.getName() + " wants to Suspect:");
            int targetIndex = scanner.nextInt();
            if(targetIndex < 0 || targetIndex >= players.size()) {
                System.out.println("Invalid index");
                continue;
            }
            Player target = players.get(targetIndex);
            Coordinator.checkEliminatedPlayer(targetIndex,players);
            if(target.equals(this)) {
                System.out.println(this.getName() + " cannot Suspects himself");
                continue;
            }
            else {
                coordinator.incrementSuspectCount(targetIndex);
                System.out.println(this.getName() + " Suspects " + target.getName());
            }
            break;
        }
    }
}
