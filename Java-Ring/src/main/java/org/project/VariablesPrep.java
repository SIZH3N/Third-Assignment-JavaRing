package org.project;

import org.project.entity.enemies.Enemy;
import org.project.entity.enemies.Skeleton;
import org.project.entity.players.Assassin;
import org.project.entity.players.Knight;
import org.project.entity.players.Player;
import org.project.entity.players.Wizard;

import java.util.Scanner;
import java.util.Random;


public class VariablesPrep {
    public VariablesPrep(){

    }

    public static Player definePlayer(Player player) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("\n\nPlease enter your name: ");
        String playerName = myObj.nextLine().toLowerCase();

        while (true) {
            System.out.println("Type your character arch: " +
                    "\n--Assassin    dagger: damage=3 mana cost=3" + printPlayerDisc(30,25,3) +
                    "\n--Wizard      wand: damage=7 mana cost=7" + printPlayerDisc(20,40,5) +
                    "\n--Knight      sword: damage=10 mana cost=7" + printPlayerDisc(40,20,3) +
                    "\n");
            String playerType = myObj.next().toLowerCase();

            if (playerType.equals("assassin")) {
                player = new Assassin(playerName);
                System.out.println("you are an Assassin");
                break;
            } else if (playerType.equals("wizard")) {
                player = new Wizard(playerName);
                System.out.println("you are a Wizard");
                break;
            } else if (playerType.equals("knight")) {
                player = new Knight(playerName);
                System.out.println("you are a Knight");
                break;
            } else {
                System.out.println("Invalid character arch");
            }
        }
        return player;
    }

    public static String printPlayerDisc(int hp , int mp ,int manaregen){
        return( "\n           Max Hp: " + hp+
                "\n           Max Mana:" + mp+
                "\n           Mana regeneration: " + manaregen);
    }




}
