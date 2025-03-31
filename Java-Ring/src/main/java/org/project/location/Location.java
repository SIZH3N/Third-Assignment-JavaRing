package org.project.location;

import org.project.entity.enemies.Dragon;
import org.project.entity.enemies.Enemy;
import org.project.entity.enemies.Goblin;
import org.project.entity.enemies.Skeleton;

import java.util.ArrayList;
import java.util.Random;

public class Location {
    private String name;
    private int locModel;
    private String locDescription;

    //    private ArrayList<Location> locations;
    private ArrayList<Enemy> enemies;

//    public Location(ArrayList<Location> locations, ArrayList<Enemy> enemies) {
//        this.locations = locations;
//        this.enemies = enemies;
//    }

    public Location() {
        Random rand = new Random();
        this.locModel = (rand.nextInt(6)) + 1;
        enemies = new ArrayList<>();


        createEnemies();
        this.name = choseLocName(locModel);
        this.locDescription = choseLocDescription(locModel);

        System.out.println("\n" + toString());
//        slowPrint("\n"+toString(), 5);

        System.out.println("\n  ******* Your enemy(s):   ");
        int dragonsCount = 0, skeletonsCount = 0, goblinsCount = 0;
        for (Enemy e : enemies) {
            if (e instanceof Dragon) {
                dragonsCount++;
            } else if (e instanceof Skeleton) {
                skeletonsCount++;
            } else goblinsCount++;
            //System.out.print(e.toString() + " ");
        }
        if (dragonsCount != 0)
            System.out.println("  *******               " + dragonsCount + "X Dragons           damage=12   Hp=40");
        if (skeletonsCount != 0)
            System.out.println("  *******               " + skeletonsCount + "X Skeletons       damage=2    Hp=20");
        if (goblinsCount != 0)
            System.out.println("  *******               " + goblinsCount + "x Goblins           damage=2    Hp=10");
    }

    /*
    TODO: (BONUS) RESET EACH LOCATION AFTER PLAYER LEAVES
    */

    private void createEnemies() {
        Random rand = new Random();
        boolean dragonExists = false;
        int numberOfEnemies = rand.nextInt(3);
        for (int i = 0; i <= numberOfEnemies; i++) {
            Enemy enemy = enemySelect(dragonExists);
            if (enemy instanceof Dragon) {
                dragonExists = true;
            }
            enemies.add(enemy);
        }
    }

    private static Enemy enemySelect(boolean dragonExists) {
        Enemy enemy = null;
        int dragonIndex = 0;
        if (dragonExists) {
            dragonIndex = 1;
        }
        Random rand = new Random();
        int rand_int1 = rand.nextInt(3 - dragonIndex);
        switch (rand_int1) {
            case 0:
                enemy = new Skeleton();
                break;
            case 1:
                enemy = new Goblin();
                break;
            case 2:
                enemy = new Dragon();
                break;
            default:
                break;
        }
        return enemy;
    }

    private static String choseLocDescription(int locModel) {
        String mapDesc = null;
        Random rand = new Random();
        int discNumber = rand.nextInt(2);
        switch (locModel) {
            case 1:
                if (discNumber == 0) {
                    mapDesc = "The dense canopy above blocks most of the sunlight, leaving the forest floor covered in a dim, perpetual twilight. The air smells of damp earth, and you can hear the distant rustle of unseen creatures.\n";
                } else {
                    mapDesc = "A sudden gust of wind whispers through the ancient trees, carrying faint echoes of voices—too soft to understand but chilling nonetheless.\n";
                }
                mapDesc = mapDesc.concat("  The undergrowth suddenly bursts apart as snarling beasts with glowing eyes emerge, their low growls reverberating through the still air");
                break;
            case 2:
                if (discNumber == 0) {
                    mapDesc = "The village square is alive with the chatter of merchants and the clinking of tools. Smoke rises from chimneys, carrying the scent of freshly baked bread mingled with the tang of livestock.\n";
                } else {
                    mapDesc = "Children dart between stalls, their laughter ringing out as the villagers nod politely in your direction, their eyes lingering just a second too long.\n";
                }
                mapDesc = mapDesc.concat("  A figure lunges from the shadows, knocking over a merchant's stall as bystanders scream and scatter in all directions.");
                break;
            case 3:
                if (discNumber == 0) {
                    mapDesc = "Shattered pillars and crumbling walls stand as silent witnesses to a forgotten past. A chilling wind whistles through the ruins, carrying with it the faint stench of decay.\n";
                } else {
                    mapDesc = "The air grows cold as you step into the ruins, and the eerie silence is broken only by the unsettling sound of your own footsteps.\n";
                }
                mapDesc = mapDesc.concat("  The air becomes icy as spectral forms coalesce from the shadows, their unearthly wails piercing the silence.");
                break;
            case 4:
                if (discNumber == 0) {
                    mapDesc = "After endless miles of sand dunes, the shimmering mirage finally solidifies into a lush sanctuary. The gentle babble of water and the rustle of palm fronds offer a fleeting moment of respite.\n";
                } else {
                    mapDesc = "The oasis is a jewel in the desert's crown, with clear waters reflecting the sun's relentless glare. Yet, even this paradise feels watchful, as if the desert itself disapproves of your intrusion.\n";
                }
                mapDesc = mapDesc.concat("  Out of nowhere, the sands swirl violently, and a group of hostile figures materialize, their blades glinting menacingly in the sunlight.");
                break;
            case 5:
                if (discNumber == 0) {
                    mapDesc = "The caverns stretch out before you, an endless labyrinth of jagged rock and echoing darkness. Water drips rhythmically in the distance, a sound that feels both comforting and ominous.\n";
                } else {
                    mapDesc = "Bioluminescent fungi cast an eerie blue glow across the damp walls, revealing strange symbols etched into the stone.\n";
                }
                mapDesc = mapDesc.concat("  The ground trembles as monstrous shapes slither out from the cavern's depths, their guttural roars echoing ominously.");
                break;
            case 6:
                if (discNumber == 0) {
                    mapDesc = "The grand hall is adorned with shimmering tapestries and golden chandeliers, but the weight of countless eyes—some friendly, some not—follows your every move.\n";
                } else {
                    mapDesc = "Polished marble floors reflect the flickering torchlight as armored guards stand silent and imposing, their faces unreadable beneath their helms.\n";
                }
                mapDesc = mapDesc.concat("  The guards unsheathe their weapons with precision, their leader barking an order to detain—or eliminate—you immediately.");
                break;
            default:
                mapDesc = " -- Error on choosing a location description";
        }
        return mapDesc;
    }

    private static String choseLocName(int locModel) {
        String locName = "";
        switch (locModel) {
            case 1:
                locName = "Mysterious Forest";
                break;
            case 2:
                locName = "Bustling Village";
                break;
            case 3:
                locName = "Cursed Ruins";
                break;
            case 4:
                locName = "Desert Oasis";
                break;
            case 5:
                locName = "Underground Caverns";
                break;
            case 6:
                locName = "Royal Castle";
                break;
            default:
                locName = " -- Error on choosing a location name";
        }
        return locName;
    }

    public String getName() {
        return name;
    }

//    public ArrayList<Location> getLocations() {
//        return locations;
//    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public boolean locIsDead() {
        int sum = 0;
        for (Enemy e : enemies) {
            if (!e.isAlive())
                sum++;
        }
        return sum == enemies.size();
    }

    @Override
    public String toString() {
        return " ____" + name + "____ \n" + locDescription;
    }
}
