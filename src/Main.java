import java.util.ArrayList;
import java.util.List;
class Main{
    public static void main(String[] args) {
        Player villager1 = new Villager("Villager1");
        Player villager2 = new Villager("Villager2");
        Player villager3 = new Villager("Villager3");
        Player killer = new Killer("Killer1");
        Player doctor = new Doctor("Doctor1");
        Player detective = new Detective("Detective1");
        List<Player> players = new ArrayList<>();
        players.add(killer);
        players.add(doctor);
        players.add(villager1);
        players.add(villager2);
        players.add(villager3);
        players.add(detective);
        Coordinator coordinator = new Coordinator(players);
        coordinator.conductGame(players, coordinator);
    }
}