package TableTopGames;

public class Test {
    public static void main(String[] args) {

        System.out.println("player 1\n");
        YahtzeePlayer player1 = new YahtzeePlayer("player 1", "red", 14);
        player1.getDice(5, 6);
        player1.dice.get(0).value = 5; // was displaying full house 3 times as possible score
        player1.dice.get(1).value = 3;
        player1.dice.get(2).value = 3;
        player1.dice.get(3).value = 5;
        player1.dice.get(4).value = 3;
        Display.dice(player1);
        Score.addYahtzee(player1);
        Display.score(player1);

//        player1.dice[0].number = 1;
//        player1.dice[1].number = 3;
//        player1.dice[2].number = 2;
//        player1.dice[3].number = 4;
//        player1.dice[4].number = 1;
//        Display.dice(player1);
//        Score.add(player1);
//        Display.score(player1);

//        player1.dice[0].number = 4;
//        player1.dice[1].number = 3;
//        player1.dice[2].number = 2;
//        player1.dice[3].number = 1;
//        player1.dice[4].number = 3;
//        Display.dice(player1);
//        Score.add(player1);
//        Display.score(player1);

//        player1.dice[0].number = 6;
//        player1.dice[1].number = 6;
//        player1.dice[2].number = 3;
//        player1.dice[3].number = 6;
//        player1.dice[4].number = 3;
//        Display.dice(player1);
//        Score.add(player1);
//        Display.score(player1);


//        System.out.println("\nplayer 2\n");
//        Player player2 = new Player("player 2", "blue");
//        player2.getDice();
//        player2.dice[0].number = 6;
//        player2.dice[1].number = 6;
//        player2.dice[2].number = 5;
//        player2.dice[3].number = 5;
//        player2.dice[4].number = 6;
//        Display.dice(player2);
//        Display.possibleScores(player2);
    }
}
