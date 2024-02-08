import java.util.List;
import java.util.Scanner;

class Killer extends Player{

    Killer(String name) {
        super(name);
    }


    @Override
    void play(List<Player> players) {
        while(true)
        {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the index Number of the player " + this.getName() + " wants to kill:");


        int targetIndex = scanner.nextInt();

        if (targetIndex < 0 || targetIndex >= players.size()) {
            System.out.println("Invalid index");
            continue;

        }

        Player target = players.get(targetIndex);

        if (target.equals(this)) {
            System.out.println("I don't commit suicide");
            play(players);
        } else {
            target.setKilledByKiller(true);
            System.out.println(this.getName() + " kills " + target.getName());
        }
            break;
        }
    }
}
