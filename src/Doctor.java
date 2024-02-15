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
                target.setAlive(true);
            } else {
                System.out.println(this.getName() + " heals " + target.getName());
                target.setAlive(true);
            }
            System.out.println("Enter the index Number of the player " + this.getName() + " wants to Suspect:");
            Scanner scanner1 = new Scanner(System.in);
            int targetIndex1 = scanner1.nextInt();
            if(targetIndex1 < 0 || targetIndex1 >= players.size()) {
                System.out.println("Invalid index. choose again");
                continue;
            }
            Player target1 = players.get(targetIndex1);
            if(target1.isEliminate()){
                System.out.println("You chose the death player. try again");
                continue;
            }
            if(target1.equals(this)) {
                System.out.println(this.getName() + " cannot Suspects himself");
                continue;
            } else if (target1.equals(target)) {
                System.out.println("Doctor cannot suspect the healed person. try again");
                continue;
            } else {
                coordinator.incrementSuspectCount(targetIndex);
                System.out.println(this.getName() + " Suspects " + target.getName());
            }
            break;
        }
    }
}