package TableTopGames;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Score {
    public static void add(Player player) {
        Scanner scan = new Scanner(System.in);
        Display.possibleScores(player);
        System.out.println("When done looking at possible scores enter \"done\".");
        String nice = scan.next();
        if (nice.equalsIgnoreCase("nice")) {
            System.out.println(nice);
        }
        System.out.println("These are available scores to add or erase");
        Display.availableScores(player);
        System.out.println("Which score would you like to add? enter index");
        int index = scan.nextInt();
        scan.nextLine();
        if (player.scoreSheet[index] != 5) {
            player.scoreSheet[index] = 5;
            switch (index) {
                case 0:
                    Score.ones(player);
                    break;
                case 1:
                    Score.twos(player);
                    break;
                case 2:
                    Score.threes(player);
                    break;
                case 3:
                    Score.fours(player);
                    break;
                case 4:
                    Score.fives(player);
                    break;
                case 5:
                    Score.sixes(player);
                    break;
                case 6:
                    Score.threeOAK(player);
                    break;
                case 7:
                    Score.fourOAK(player);
                    break;
                case 8:
                    Score.fullHouse(player);
                    break;
                case 9:
                    Score.smStraight(player);
                    break;
                case 10:
                    Score.lgStraight(player);
                    break;
                case 11:
                    Score.fiveOAK(player);
                    break;
                case 12:
                    Score.chance(player);
                    break;
            }
        } else {
            Score.add(player);
        }
//        scan.close();
    }

    public static void ones(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 1) {
                total++;
            }
        }
        if (total != 0) {
            System.out.println("Ones = " + total);
            player.score += total;
        }
    }

    public static void twos(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 2) {
                total += 2;
            }
        }
        if (total != 0) {
            System.out.println("Twos = " + total);
            player.score += total;
        }
    }

    public static void threes(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 3) {
                total += 3;
            }
        }
        if (total != 0) {
            System.out.println("Threes = " + total);
            player.score += total;
        }
    }

    public static void fours(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 4) {
                total += 4;
            }
        }
        if (total != 0) {
            System.out.println("Fours = " + total);
            player.score += total;
        }
    }

    public static void fives(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 5) {
                total += 5;
            }
        }
        if (total != 0) {
            System.out.println("Fives = " + total);
            player.score += total;
        }
    }

    public static void sixes(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 6) {
                total += 6;
            }
        }
        if (total != 0) {
            System.out.println("Sixes = " + total);
            player.score += total;
        }
    }

    public static void threeOAK(Player player) {
        for (int i = 0; i < player.dice.length; i++) {
            int count = 0;
            int total = 0;
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number) {
                    count++;
                    total += player.dice[i].number;
                }
            }
//            System.out.println("count " + count);
            if (count == 3) {
                System.out.println("Three of a Kind = ");
                player.score += total;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void fourOAK(Player player) {
        for (int i = 0; i < player.dice.length; i++) {
            int count = 0;
            int total = 0;
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number) {
                    count++;
                    total += player.dice[i].number;
                }
            }
//            System.out.println("count " + count);
            if (count == 4) {
                System.out.println("Four of a Kind = ");
                player.score += total;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void fullHouse(Player player) {
        for (int i = 0; i < player.dice.length; i++) {
            int count1 = 0;
            int count2 = 0;
            int threeOAK = 0;
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number) {
                    count1++;
                }
            }
            if (count1 == 3) {
                threeOAK = player.dice[i].number;
            }
//            System.out.println("count2 " + count2);

            for (int k = 0; k < player.dice.length; k++) {
                for (int l = 0; l < player.dice.length; l++)
                    if (player.dice[k].number != threeOAK && player.dice[k].number == player.dice[l].number) {
                        count2++;
                    }
            }
//            System.out.println("count2 " + count2);

            if (count2 % 2 == 0 && threeOAK != 0) {
                System.out.println("Full House = 25");
                player.score += 25;
                break;
            }
        }
    }

    public static void smStraight(Player player) {
        int count = 0;
        int duplicateCount = 0;
        for (int i = 0; i < player.dice.length; i++) {
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number && j != i) {
                    duplicateCount++;
                }
                if (player.dice[i].number == player.dice[j].number + 1) {
                    count++;
                }
            }
        }
        if (count == 3 && duplicateCount == 0) {
            System.out.println("Small Straight = 30");
            player.score += 30;
        } else if (count == 4 && duplicateCount == 2) {
            System.out.println("Small Straight = 30");
            player.score += 30;
        }
    }

    public static void lgStraight(Player player) {
//        Arrays.sort(player.dice);
        int count = 0;
        int duplicateCount = 0;
        for (int i = 0; i < player.dice.length; i++) {
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number && j != i) {
                    duplicateCount++;
                }
                if (player.dice[i].number == player.dice[j].number + 1) {
                    count++;
                }
            }
        }
        if (count == 4 && duplicateCount == 0) {
            System.out.println("Large Straight = 40");
            player.score += 40;
        }
    }

    public static void fiveOAK(Player player) {
        for (int i = 0; i < player.dice.length; i++) {
            int count = 0;
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number) {
                    count++;
                }
            }
//            System.out.println("count " + count);
            if (count == 5) {
                System.out.println("Yahtzee! = 50");
                player.score += 50;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void chance(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            total += player.dice[i].number;
        }
        System.out.println("Chance = " + total);
        player.score += total;
    }
}
