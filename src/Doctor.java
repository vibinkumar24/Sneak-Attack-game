import java.util.List;
import java.util.Scanner;
class Doctor extends Player{
    Doctor(String name ) {
        super(name);
    }
    @Override
     void play(List<Player> players, Coordinator coordinator) {
        System.out.println("Enter the index Number of the player " + this.getName() + " want to heal:");
        while (true) {
            // Move common code to super class with specific visibility
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
                System.out.println(this.getName() + " heals himself");
            } else {
                System.out.println(this.getName() + " heals " + target.getName());
            }
            target.setAlive(true);
            super.play(players, coordinator);
            break;
        }
    }
}