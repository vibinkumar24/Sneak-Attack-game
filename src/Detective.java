import java.util.List;
import java.util.Scanner;
class Detective extends Player{
    Detective(String name) {
        super(name);
    }
    @Override
    void play(List<Player> players, Coordinator coordinator) {
        System.out.println("Enter the index Number of the player " + this.getName() + " wants to  check if a person is a Killer:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int targetIndex = scanner.nextInt();
            if (targetIndex < 0 || targetIndex >= players.size()) {
                System.out.println("Invalid index.choose again");
                continue;
            }
            Player target = players.get(targetIndex);
            if(target.isEliminate()){
                System.out.println("You chose the death player. try again");
                continue;
            }
            if (target.equals(this)) {
                System.out.println(this.getName() + " cannot confirm himself");
                play(players, coordinator);
            } else {
                System.out.println("check " + target.getName());
                Coordinator.confirmSuspect(target);
            }
            super.play(players, coordinator);
            break;
        }
    }
}