import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import vehicle.*;

public class RaceRun {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("What is the name of the text file that contains race data?\n");
        String fileName = keyboard.nextLine();
        File file = new File(fileName);
        while (!file.exists()) {
            System.out.printf("Sorry, that file doesn't exist, try again.\n");
            fileName = keyboard.nextLine();
            file = new File(fileName);
        }
        keyboard.close();

        ArrayList<Vehicle> garage = makeGarage(file);

        runRace(garage);

    }

    private static ArrayList<Vehicle> makeGarage(File file) {
        try {
            ArrayList<Vehicle> garage = new ArrayList<Vehicle>();
            final Scanner fileScanner = new Scanner(file);
            fileScanner.useDelimiter("\\s*,\\s*");
            while (fileScanner.hasNextLine()) {

                switch (fileScanner.next()) {
                    case "Motorcycle":
                        garage.add(new Motercycle(fileScanner.next(), fileScanner.next()));
                        if (fileScanner.hasNextLine()) {
                            fileScanner.nextLine();
                        }
                        break;
                    case "Tesla":
                        garage.add(new Tesla(fileScanner.next(), fileScanner.next(), fileScanner.nextBoolean()));
                        if (fileScanner.hasNextLine()) {
                            fileScanner.nextLine();
                        }
                        break;
                    case "Truck":
                        garage.add(new Truck(fileScanner.next(), fileScanner.next(), fileScanner.nextBoolean()));
                        if (fileScanner.hasNextLine()) {
                            fileScanner.nextLine();
                        }
                        break;
                    default: {
                        System.out.println("Error");
                    }
                }

            }
            fileScanner.close();
            return garage;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }


    private static void runRace(ArrayList<Vehicle> garage) {
        //Setting variables
        int rounds = 1;
        Boolean isRaceDone = false;

        //wrapping the race in a while loop to help exit when race is done
        while (isRaceDone == false) {
            //print the "Race Round [#]" line
            System.out.printf("\nRace round [%d]\n\n", rounds);

            //this block creates the track labels "| 1 | 2 | 3 |..."
            System.out.printf("|");
            for (int trackLabel = 1; trackLabel <= garage.size(); trackLabel++) {
                System.out.printf(" %d |", trackLabel);
            }
            System.out.println();

            //
            for (int position = 0; position <= 20; position++) {
                System.out.printf("|");
                for (Vehicle vehicle : garage) {

                    if (vehicle.getPositionInt() == position) {
                        System.out.printf(" %s |", vehicle.getIcon());
                    } else if (position == 20 && vehicle.getPositionInt() >= 20) {
                        System.out.printf(" %s |", vehicle.getIcon());
                    } else {
                        System.out.printf("   |");
                    }

                }
                System.out.printf("|Position: [%d]\n", position);

            }
            for (Vehicle vehicle : garage) {
                if (vehicle.getPositionInt() >= 20) {
                    System.out.println();
                    System.out.printf("The %s %s has won the race!\n\n", vehicle.getColour(), vehicle.getModel());
                    isRaceDone = true;
                } else {
                    vehicle.accelerate();
                    vehicle.move();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            rounds++;
        }
    }
}
