import java.util.List;
import java.util.Scanner;

//How to restrict object creation of this class? As player cannot be instantiated by itself.
public class Player{

    // Where are the access restrictions? - for both variables and methods
    String name;
    // If role is not used, remove it out.

    // Do you need these two variables? isKilledByKiller and isHealedByHealer
    boolean isKilledByKiller = false;
    boolean isHealedByHealer = false;
    // Is this the right place for this attribute?

    int[] suspectCount;
    Player(String name){
        this.name = name;
        suspectCount = new int[]{0};

    }
     String getName() {
        return name;
    }
    boolean isKilledByKiller()
    {
        return this.isKilledByKiller;
    }

    void setKilledByKiller(boolean isKilledByKiller)
    {
        this.isKilledByKiller = isKilledByKiller;
    }
    boolean isHealedByHealer()
    {
        return this.isHealedByHealer;
    }

    void setHealedByHealer(boolean ishealedByHealer)
    {
        this.isHealedByHealer = ishealedByHealer;
    }
    void increamentSuspectCount() {
        this.suspectCount[0]++;
    }

    int getSuspectCount() {
        return this.suspectCount[0];
    }




    void play(List<Player> players) {
        while(true)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the index Number of the player " + this.getName() + " wants to Suspect:");

            int targetIndex = scanner.nextInt();

            if(targetIndex < 0 || targetIndex >= players.size()) {
                System.out.println("Invalid index");
                continue;
            }

            Player target = players.get(targetIndex);

            if(target.equals(this)) {
                System.out.println(this.getName() + " cannot Suspects himself");
                continue;
            }
            else {
                target.increamentSuspectCount();
                System.out.println(this.getName() + " Suspects " + target.getName());
            }
            break;
        }
    }


}
