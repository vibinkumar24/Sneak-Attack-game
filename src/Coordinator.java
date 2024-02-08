import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Coordinator {
    List<Player> players;

    boolean playNextRound = true;

    public Coordinator(List<Player> players) {
        this.players = players;
    }


void eliminatePlayers() {
    int maxSuspect = players.stream().mapToInt(Player::getSuspectCount).max().orElse(0);

    List<Player> playersToEliminate = players.stream()
            .filter(player -> (player.isKilledByKiller() || player.getSuspectCount() == maxSuspect) && !player.isHealedByHealer())
            .collect(Collectors.toList());

    players.removeAll(playersToEliminate);

    System.out.println("The Players eliminated in this round: " +
            playersToEliminate.stream().map(Player::getName).collect(Collectors.joining(", ")));

    players.forEach(player -> {
        player.setKilledByKiller(false);
        player.setHealedByHealer(false);
    });
}



//    void eliminatePlayers() {
//        //Dont use string to capture names of eliminated player
//        String eliminatedPlayers = "";
//        int maxSuspect = 0;
//        for (Player player : players) {
//            if (player.getSuspectCount() > maxSuspect) {
//                maxSuspect = player.getSuspectCount();
//            }
//        }
//
//        // Use the streaming API to select active players and select dead players
//        for (int i = 0; i < players.size(); i++) {
//            if ((players.get(i).isKilledByKiller() || players.get(i).getSuspectCount() == maxSuspect) && !players.get(i).isHealedByHealer()) {
//
//                System.out.println(players.get(i).getName()+ " is eliminated");
//                players.remove(players.get(i));
//            }
//
//        }
//        for (Player player : players) {
//            player.setKilledByKiller(false);
//            player.setHealedByHealer(false);
//        }
//    }



void checkWinner(List<Player> players) {
    boolean isKillerPresent = players.stream().anyMatch(player -> player.getName().equals("Killer1"));
    if (isKillerPresent) {
        if (players.size() <= 2) {
            System.out.println("Killer wins");
            System.exit(0);
        }
    }
    else {
        System.out.println("Village wins");
        System.exit(0);
    }
    playNextRound = !isKillerPresent || players.size() > 2;
    System.out.println(playNextRound ? "Killer not identified. Next round starts" : "Game ends");
}



/*    void checkWinner(List<Player> players) {
        // Change to write in 5 lines.
        boolean isKillerisPresent = false;
        for (Player player : players) {
            if (player.getName().equals("Killer1")) {
                isKillerisPresent = true;
            }
        }
        if (isKillerisPresent) {
            if (players.size() <= 2) {
                System.out.println("Killer wins");
                playNextRound = false;
            }
        }
        else {
            System.out.println("Village wins");
            playNextRound = false;
        }
        if (!playNextRound) {
            System.out.println("Game ends");
        }
        else {
            System.out.println("Killer not identified. Next round starts");
        }
    }

 */


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
    static void printPlayerDetails(List<Player> players) {
        IntStream.range(0, players.size())
                .forEach(i -> System.out.println(i + ". " + players.get(i).getName()));
    }

    void conductGame(List<Player> players) {
        while (playNextRound) {
            Coordinator.printPlayerDetails(players);
            for (Player player : this.players) {
                player.play(players);
            }
            eliminatePlayers();
            checkWinner(players);
        }
    }
}