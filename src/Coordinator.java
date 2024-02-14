import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



class Coordinator {
    private final List<Player> players;
    boolean playNextRound = true;
    int[] suspectCount;
    int activePlayerCount;
    public Coordinator(List<Player> players) {
        this.players = players;
        this.suspectCount = new int[6];
        this.activePlayerCount= players.size();
    }

    void incrementSuspectCount(int targetIndex) {
        this.suspectCount[targetIndex]++;
    }
    int getSuspectCount(int playerIndex) {
        return this.suspectCount[playerIndex];
    }
void eliminatePlayers() {
    int maxSuspect = players.stream()
            .mapToInt(player -> getSuspectCount(players.indexOf(player)))
            .max()
            .orElse(0);
    List<Player> playersToEliminate = players.stream()
            .filter(player -> !player.alive()||getSuspectCount(players.indexOf(player))==maxSuspect)
            .peek(player -> {
                player.setAlive(false);
                activePlayerCount--;
            })
            .collect(Collectors.toList());
    System.out.println("The Players eliminated in this round: " +
            playersToEliminate.stream().map(Player::getName).collect(Collectors.joining(", ")));
    players.forEach(player -> {
        Arrays.fill(suspectCount, 0);
    });
}


void checkWinner(List<Player> players) {
    for(Player player : players) {
        if(player.getName().contains("Killer")) {
            if(!player.alive()) {
                System.out.println("Village wins");
                playNextRound = false;
            }
            else if(activePlayerCount <= 2) {
                System.out.println("Killer wins");
                playNextRound = false;
            }
        }
    }
    System.out.println(playNextRound ? "Killer not identified. Next round starts" : "Game ends");
}


    static void confirmSuspect(Player suspect) {
        boolean isKiller = suspect.getName().contains("Killer");
        System.out.println("Coordinator says - " + suspect.getName() + (isKiller ? " is a Killer" : " is not a Killer"));
    }

    // Find a better java way to do this.
//    static void printPlayerDetails(List<Player> players) {
//        for (int i = 0; i < players.size(); i++) {
//            System.out.println(i + ". " + players.get(i).getName());
//        }
//    }

    public static void printPlayerDetails(List<Player> players) {
        IntStream.range(0, players.size())
                .filter(i -> players.get(i).alive())
                .forEach(i -> System.out.println("P"+i + " : " + players.get(i).getName()));
    }

    public static boolean  checkEliminatedPlayer(int targetIndex, List<Player> players) {
        Player targetPlayer = players.get(targetIndex);
        if (targetPlayer.alive()) {
            return true;
        }else {
            System.out.println("Invalid index try again");
            return false;
        }
    }


    void conductGame(List<Player> players, Coordinator coordinator) {
        while (playNextRound) {
            Coordinator.printPlayerDetails(players);
            players.stream()
                    .filter(player -> player.alive())
                    .forEach(player -> player.play(players,coordinator));

            eliminatePlayers();
            checkWinner(players);
        }
    }
}