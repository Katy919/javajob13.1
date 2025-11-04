import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    private HashMap<String, Player> players;

    public Game() {
        this.players = new HashMap<>();
    }

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {

        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Player '" + playerName1 + "' is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player '" + playerName2 + "' is not registered");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}

//    public Player findByName(String name) {
//        for (Player player : players) {
//            if (player.getName().equals(name)) {
//                return player;
//            }
//        }
//        return null;
//    }
