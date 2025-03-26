package org.project;

import org.project.entity.enemies.Enemy;
import org.project.entity.players.Assassin;
import org.project.entity.players.Knight;
import org.project.entity.players.Player;
import org.project.entity.players.Wizard;
import org.project.location.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//    private Player player;

    static List<Location> locations ;
    public static void main(String[] args) {
        // TODO: ADD SOME LOCATIONS TO YOUR GAME
        locations = new ArrayList<>();
        //Enemy enemy = null;
        Player player = null;
//wizard
        player = VariablesPrep.definePlayer(player);
        do {
            Location loc = new Location();

            player.repairArmor();
            player.resetConsumables();

            while (player.isAlive() && !loc.locIsDead()) {
                Enemy firstToFight = ChooseAnEnemyToFight(loc.getEnemies());
                if (firstToFight != null) {
                    boolean run=playerAction(player, firstToFight, loc);
                    if (run) {
                        break;
                    }
                }
                for (Enemy e : loc.getEnemies()) {
                    if (player.isAlive() && e.isAlive()) {
                        e.attack(player);
                    } else {
                        if (!e.isAlive()) {
                            System.out.println(e.toString() + " is dead *****");
                        }
                    }
                }
//                player.attack(enemy);
//                if (enemy.isAlive()) {
//                    enemy.attack(player);
//                } else {
//                    System.out.println(enemy.toString() + " is dead");
//                }
            }
            locations.add(loc);

            // todo: after killing a land and before going into another player get some reward such as a weapon or better armor or ((another companion))
        } while (player.isAlive());

        endGame(locations);

    }
//        while (player.isAlive() && enemy.isAlive()) {
//            player.attack(enemy);
//            if (enemy.isAlive()) {
//                enemy.attack(player);
//            } else {
//                System.out.println(enemy.toString()+" is dead");
//            }
//        }

//        for (Location loc : locations) {
//            final ArrayList<Enemy> listOfEnemies = loc.getEnemies();
//        }
    // TODO: IMPLEMENT GAMEPLAY

    private static Enemy ChooseAnEnemyToFight(ArrayList<Enemy> enemies) {
        for (Enemy e : enemies) { // it goes through the enemy lists and pick the first one that is alive
            if (e.isAlive()) {
                return e;
            }
        }
        return null;
    }

    private static boolean playerAction(Player player, Enemy enemy , Location loc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n -choose an action: \n Heal \n Attack \n Defend \n Run");
        String action = scanner.next();
        player.getArmor().setISdefencing(false);
        switch (action.toLowerCase()) {
            case "heal":
                player.useConsumable();
                break;
            case "attack":
                player.attack(enemy , loc.getEnemies());
                break;
            case "defend":
                player.defend();
                break;
            case "run":
                player.takeDamage(player.getHp() / 5);
                System.out.println(player.toString() + " got damage through the escape. remaining hp: " + player.getHp());
                return true;
            default:
                System.out.println("Invalid action");
                break;
        }
        return false;
    } // todo: make this method so that it can report a boolean that show if the player runs or not



    private static void endGame(List<Location> locations) {
        System.out.println("\n you are dead \n The lands you entered:");
        for (Location loc : locations) {
            System.out.println(" ___" + loc.getName());
        }
    }




}