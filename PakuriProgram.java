/**
 * Main program for the Pakudex indexing system that stores and organizes
 * all the Pakuri and their statistics that the user enters in.
 * @author Brandon Grunes
 * @version 1.0
 */

import java.util.*;

public class PakuriProgram {

    public static void main(String[] args) {
	    Scanner scnr = new Scanner(System.in);
	    int pakMax;
	    int userInput;
	    String name;
	    String input;

	    // Welcome message
	    System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");

	    // Asks for max capacity of Pakudex and checks if value is an integer greater than 0
	    while (true) {
			try {
				System.out.print("Enter max capacity of the Pakudex: ");
				input = scnr.next();

				pakMax = Integer.parseInt(input);

				if (pakMax <= 0) {
					throw new Exception("Please enter a valid size.");
				}
				break;
			} catch (NumberFormatException excpt) {
				System.out.println("Please enter a valid size.");
			}
			catch (Exception excpt) {
				System.out.println(excpt.getMessage());
			}
		}


	    Pakudex pakudex = new Pakudex(pakMax);

		System.out.println("The Pakudex can hold " + pakudex.getCapacity() + " species of Pakuri.");

		while (true) {
			System.out.println();
			System.out.println("Pakudex Main Menu");
			System.out.println("-----------------");
			System.out.println("1. List Pakuri");
			System.out.println("2. Show Pakuri");
			System.out.println("3. Add Pakuri");
			System.out.println("4. Evolve Pakuri");
			System.out.println("5. Sort Pakuri");
			System.out.println("6. Exit");
			System.out.println();

			// Asks for menu selection and checks if menu selection is possible
			try {
				System.out.print("What would you like to do? ");
				input = scnr.next();

				userInput = Integer.parseInt(input);
			} catch (NumberFormatException excpt) {
				System.out.println("Unrecognized menu selection!");
				continue;
			}

			switch (userInput) {
				// lists the pakuri stored in the pakudex. If none, will display error message
				case 1:
					String[] speciesList = pakudex.getSpeciesArray();

					if (speciesList == null) {
						System.out.println("No Pakuri in Pakudex yet!");
					}
					else {
						System.out.println("Pakuri In Pakudex:");

						for (int i = 0; i < speciesList.length; ++i) {
							System.out.println((i + 1) + ". " + speciesList[i]);
						}
					}

					break;
				// shows selected pakuri's stats. If pakuri DNE, then display error message
				case 2:
					System.out.print("Enter the name of the species to display: ");
					name = scnr.next();

					int[] stats = pakudex.getStats(name);

					if (stats == null) {
						System.out.println("Error: No such Pakuri!");
					}
					else {
						System.out.println();
						System.out.println("Species: " + name);
						System.out.println("Attack: " + stats[0]);
						System.out.println("Defense: " + stats[1]);
						System.out.println("Speed: " + stats[2]);
					}

					break;
				// checks if the user's inputted name exists. Otherwise, display error message
				case 3:
					if (pakudex.getSize() < pakudex.getCapacity()) {
						System.out.print("Enter the name of the species to add: ");
						name = scnr.next();
						if (!pakudex.addPakuri(name)) {
							System.out.println("Error: Pakudex already contains this species!");
						} else {
							System.out.println("Pakuri species " + name + " successfully added!");
						}
					}
					else {
						System.out.println("Error: Pakudex is full!");
					}

					break;
				// checks if the user's inputted name exists and can evolve. Otherwise, display error message
				case 4:
					System.out.print("Enter the name of the species to evolve: ");
					name = scnr.next();

					if (pakudex.evolveSpecies(name)) {
						System.out.println(name + " has evolved!");
					}
					else {
						System.out.println("Error: No such Pakuri!");
					}
					break;
				// sorts the pakudex array in alphabetical order
				case 5:
					pakudex.sortPakuri();
					System.out.println("Pakuri have been sorted!");
					break;
				// displays goodbye message, terminates program
				case 6:
					System.out.println("Thanks for using Pakudex! Bye!");
					System.exit(0);
				default:
					System.out.println("Unrecognized menu selection!");
			}
		}
    }
}
