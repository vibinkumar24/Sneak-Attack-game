import java.util.List;
import java.util.Scanner;
class Killer extends Player{
    Killer(String name) {
        super(name);
    }
    @Override
    void play(List<Player> players, Coordinator coordinator) {
        System.out.println("Enter the index Number of the player " + this.getName() + " wants to kill:");
        while(true) {
        Scanner scanner = new Scanner(System.in);
        int targetIndex = scanner.nextInt();
        if (targetIndex < 0 || targetIndex >= players.size()) {
            System.out.println("Invalid index. choose again");
            continue;
        }
        Player target = players.get(targetIndex);
            if(target.isEliminate()){
                System.out.println("You chose the death player. try again");
                continue;
            }
        if (target.equals(this)) {
            System.out.println("I don't commit suicide");
            play(players,coordinator);
        } else {
//            target.setDead(true);
            target.setAlive(false);
            System.out.println(this.getName() + " kills " + target.getName());
        }
            break;
        }
    }
}
