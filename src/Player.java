import java.util.List;
import java.util.Scanner;
public class Player{
    private String name;
     private boolean alive =true;
    private boolean isEliminate = false;
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
    public boolean isEliminate() {
        return isEliminate;
    }
    public void setEliminate(boolean eliminate) {
        isEliminate = eliminate;
    }
    void play(List<Player> players, Coordinator coordinator) {
        System.out.println("Enter the index Number of the player " + this.getName() + " wants to Suspect:");
        while(true) {
            Scanner scanner = new Scanner(System.in);
            int targetIndex = scanner.nextInt();
            if(targetIndex < 0 || targetIndex >= players.size()) {
                System.out.println("Invalid index. choose again");
                continue;
            }
            Player target = players.get(targetIndex);
           if(target.isEliminate()){
               System.out.println("You chose the death player. try again");
               continue;
           }
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
