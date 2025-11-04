import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Petya", 200);
    Player player2 = new Player(2, "Kate", 100);
    Player player3 = new Player(3, "Oly", 300);
    Player player4 = new Player(4, "Max", 300);

    @Test
    void shouldWhenFirstPlayerWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Petya", "Kate");
        Assertions.assertEquals(expected, actual); // Alice wins
    }

    @Test
    void shouldWhenSecondPlayerWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);

        int expected = 2;
        int actual = game.round("Petya", "Oly");
        Assertions.assertEquals(expected, actual); // Alice wins
    }

    @Test
    void shouldWhenPlayerNobodyWin() {
        Game game = new Game();
        game.register(player3);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Oly", "Max");
        Assertions.assertEquals(expected, actual); // Alice wins
    }

    @Test
    public void shouldNotRegisteredException() {
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Petya", "Kate");
        });
    }

    @Test
    public void shouldNobodyRegisteredException() {
        Game game = new Game();
        game.register(player2);
        
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Petya", "Kate");
        });
    }

    @Test
    void shouldReturnCorrectId() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 1;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }
}
