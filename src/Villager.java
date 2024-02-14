import java.util.List;
class Villager extends Player{
    Villager(String name) {
        super(name);
    }
    @Override
    void play(List<Player> players, Coordinator coordinator) {
        super.play(players ,coordinator);
    }
}