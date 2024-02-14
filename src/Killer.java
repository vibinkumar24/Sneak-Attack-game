import java.util.List;
import java.util.Scanner;
class Killer extends Player{
    Killer(String name) {
        super(name);
    }
    @Override
    void play(List<Player> players, Coordinator coordinator) {
        while(true) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index Number of the player " + this.getName() + " wants to kill:");
        int targetIndex = scanner.nextInt();
        if (targetIndex < 0 || targetIndex >= players.size()) {
            System.out.println("Invalid index");
            continue;
        }
        Player target = players.get(targetIndex);
        Coordinator.checkEliminatedPlayer(targetIndex,players);
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
