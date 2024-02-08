import java.util.ArrayList;
import java.util.List;


class Main{
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Player villager1 = new Villager("Villager1");
        Player villager2 = new Villager("Villager2");
        Player villager3 = new Villager("Villager3");
        Player killer = new Killer("Killer1");
        Player doctor = new Doctor("Doctor1");
        Player detective = new Detective("Detective1");

//        Player unknown = new Detective("Detective2", "Jackass");
        players.add(killer);
        players.add(doctor);
        players.add(villager1);
        players.add(villager2);
        players.add(villager3);
        players.add(detective);
        Coordinator coordinator = new Coordinator(players);
        coordinator.conductGame(players);

    }

}


//import java.util.*;
//
//class Main {
//    public static void main(String[] args) {
//        List<Player> players = new ArrayList<>();
//        players.add(new Killer("Killer1"));
//        players.add(new Doctor("Doctor1"));
//        players.add(new Villager("Villager1"));
//        players.add(new Villager("Villager2"));
//        players.add(new Villager("Villager3"));
//        players.add(new Detective("Detective1"));
//
//        Coordinator coordinator = new Coordinator(players);
//        coordinator.conductGame();
//    }
//}
//
//class Player {
//    protected String name;
//    protected boolean isAlive = true;
//
//    Player(String name) {
//        this.name = name;
//    }
//
//    String getName() {
//        return name;
//    }
//
//    boolean isAlive() {
//        return isAlive;
//    }
//
//    void setAlive(boolean isAlive) {
//        this.isAlive = isAlive;
//    }
//
//    void play(List<Player> players, Coordinator coordinator) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Enter the index Number of the player " + this.getName() + " wants to Suspect:");
//
//            int targetIndex = scanner.nextInt();
//
//            if (targetIndex < 0 || targetIndex >= players.size()) {
//                System.out.println("Invalid index");
//                continue;
//            }
//
//            Player target = players.get(targetIndex);
//
//            if (target.equals(this)) {
//                System.out.println(this.getName() + " cannot Suspect himself");
//                continue;
//            } else {
//                coordinator.incrementSuspectCount(target);
//                System.out.println(this.getName() + " Suspects " + target.getName());
//            }
//            break;
//        }
//    }
//}
//
//class Killer extends Player {
//    Killer(String name) {
//        super(name);
//    }
//
//    @Override
//    void play(List<Player> players, Coordinator coordinator) {
//        // Your existing play method logic for Killer
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("Enter the index Number of the player " + this.getName() + " wants to kill:");
//
//            int targetIndex = scanner.nextInt();
//
//            if (targetIndex < 0 || targetIndex >= players.size()) {
//                System.out.println("Invalid index");
//                continue;
//            }
//
//            Player target = players.get(targetIndex);
//
//            if (target.equals(this)) {
//                System.out.println("I don't commit suicide");
//                continue;
//            } else {
//                target.setAlive(false);
//                System.out.println(this.getName() + " kills " + target.getName());
//            }
//            break;
//        }
//    }
//}
//
//class Doctor extends Player {
//    Doctor(String name) {
//        super(name);
//    }
//
//    @Override
//    void play(List<Player> players, Coordinator coordinator) {
//        // Your existing play method logic for Doctor
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("Enter the index Number of the player " + this.getName() + " wants to heal:");
//
//            int targetIndex = scanner.nextInt();
//
//            if (targetIndex < 0 || targetIndex >= players.size()) {
//                System.out.println("Invalid index");
//                continue;
//            }
//
//            Player target = players.get(targetIndex);
//
//            if (target.equals(this)) {
//                System.out.println(this.getName() + " heals himself");
//            } else {
//                System.out.println(this.getName() + " heals " + target.getName());
//            }
//            target.setAlive(true);
//            super.play(players, coordinator);
//            break;
//        }
//    }
//}
//
//class Villager extends Player {
//    Villager(String name) {
//        super(name);
//    }
//
//    @Override
//    void play(List<Player> players, Coordinator coordinator) {
//        // Your existing play method logic for Villager
//        super.play(players, coordinator);
//    }
//}
//
//class Detective extends Player {
//    Detective(String name) {
//        super(name);
//    }
//
//    @Override
//    void play(List<Player> players, Coordinator coordinator) {
//        // Your existing play method logic for Detective
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("Enter the index Number of the player " + this.getName() + " wants to check if a person is a Killer:");
//
//            int targetIndex = scanner.nextInt();
//
//            if (targetIndex < 0 || targetIndex >= players.size()) {
//                System.out.println("Invalid index");
//                continue;
//            }
//
//            Player target = players.get(targetIndex);
//
//            if (target.equals(this)) {
//                System.out.println(this.getName() + " cannot confirm himself");
//                continue;
//            } else {
//                System.out.println("Checking if " + target.getName() + " is a Killer");
//                Coordinator.confirmSuspect(target);
//            }
//            super.play(players, coordinator);
//            break;
//        }
//    }
//}
//
//class Coordinator {
//    private List<Player> players;
//    private boolean playNextRound = true;
//    private Map<Player, Integer> suspectCounts = new HashMap<>();
//
//    Coordinator(List<Player> players) {
//        this.players = players;
//        initializeSuspectCounts();
//
//    }
//
//    private void initializeSuspectCounts() {
//        for (Player player : players) {
//            suspectCounts.put(player, 0);
//        }
//    }
//
//    public void incrementSuspectCount(Player player) {
//        int count = suspectCounts.get(player);
//        suspectCounts.put(player, count + 1);
//    }
//
//    void eliminatePlayers() {
//        int maxSuspect = suspectCounts.values().stream().mapToInt(Integer::intValue).max().orElse(0);
//
//        players.removeIf(player -> (!player.isAlive() || suspectCounts.get(player) == maxSuspect) && !player.isAlive());
//
//        players.forEach(player -> {
//            player.setAlive(true);
//        });
//    }
//
//    void checkWinner() {
//        if (suspectCounts.keySet().stream().anyMatch(player -> player instanceof Killer)) {
//            if (players.size() <= 2) {
//                System.out.println("Killer wins");
//                playNextRound = false;
//            }
//        } else {
//            System.out.println("Village wins");
//            playNextRound = false;
//        }
//
//        if (!playNextRound) {
//            System.out.println("Game ends");
//        } else {
//            System.out.println("Killer not identified. Next round starts");
//        }
//    }
//
//    static void confirmSuspect(Player suspect) {
//        boolean isKiller = suspect.getName().contains("Killer");
//        System.out.println("Coordinator says - " + suspect.getName() + (isKiller ? " is a Killer" : " is not a Killer"));
//    }
//
//    void printPlayerDetails() {
//        players.forEach(player -> System.out.println(players.indexOf(player) + ". " + player.getName()));
//    }
//
//    void conductGame() {
//        while (playNextRound) {
//            printPlayerDetails();
//            players.forEach(player -> player.play(players, this));
//            eliminatePlayers();
//            checkWinner();
//        }
//    }
//
//
//}
