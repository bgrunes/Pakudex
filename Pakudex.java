/**
 * Pakudex class that stores and sorts each Pakuri in pakudex[]
 * @author Brandon Grunes
 * @version 1.0
 */

import java.util.*;
import java.lang.*;

public class Pakudex {
    final private Pakuri[] pakudex;

    /**
     * Default constructor Pakudex, sets capacity of pakudex[] to 20
     */
    public Pakudex() {
        pakudex = new Pakuri[20];
    }

    /**
     * Constructor Pakudex, sets capacity of pakudex[] to user-defined value
     * @param capacity int variable storing the user-defined value
     */
    public Pakudex(int capacity) {
        pakudex = new Pakuri[capacity];
    }

    /**
     * Public member method getSize(), calculates the number of Pakuri in pakudex[]
     * @return int # of Pakuri in pakudex[]
     */
    public int getSize() {
        int i;
        int j = 0;

        for (i = 0; i < pakudex.length; ++i) {
            if (pakudex[i] != null) {
                j = j + 1;
            }
        }
        return j;
    }

    /**
     * Public member method getCapacity(), returns the max Pakuri
     * allowed in pakudex[]
     * @return pakudex.length: length of the array
     */
    public int getCapacity() {
        return pakudex.length;
    }

    /**
     * public member method getSpeciesArray(), creates a String array
     * speciesList to hold the String names of the Pakuri
     * @return String array speciesList
     */
    public String[] getSpeciesArray() {
        String[] speciesList = new String[getSize()];

        if (pakudex[0] != null) {
            for (int i = 0; i < speciesList.length; ++i) {
                speciesList[i] = pakudex[i].getSpecies();
            }

            return speciesList;
        }

        return null;
    }

    /**
     * public member method getStats(), provides the statistics of
     * specified Pakuri
     * @param species name of the user-specified Pakuri
     * @return int array stats to transfer values to main()
     */
    public int[] getStats(String species) {
        int[] stats = new int[3];

        for (int i = 0; i < pakudex.length; ++i) {
            if ((pakudex[i] != null) && (pakudex[i].getSpecies().equals(species))) {
                stats[0] = pakudex[i].getAttack();
                stats[1] = pakudex[i].getDefense();
                stats[2] = pakudex[i].getSpeed();
                return stats;
            }
        }
        return null;
    }

    /**
     * public member method sortPakuri(), sorts pakudex[] in lexicographical order
     */
    public void sortPakuri() {
        Pakuri temp;
        int j;

        for (int i = 1; i < getSize(); ++i) {
            j = i;
            while(j > 0 && pakudex[j].getSpecies().compareTo(pakudex[j - 1].getSpecies()) < 0) {
                temp = pakudex[j];
                pakudex[j] = pakudex[j - 1];
                pakudex[j - 1] = temp;
                --j;
            }
        }
    }

    /**
     * Public member method addPakuri(), checks if user-specified String name is not
     * already used, and creates new Pakuri if returns true.
     * @param species user-specified Pakuri
     * @return boolean; True if Pakuri can be/is added/False if already exists/cannot be added
     */
    public boolean addPakuri(String species) {
        for (int i = 0; i < pakudex.length; ++i) {
            if ((pakudex[i] != null) && (pakudex[i].getSpecies().equals(species))) {
                break;
            }
            else if ((pakudex[i] != null) && (!pakudex[i].getSpecies().equals(species))) {
                continue;
            }
            else if ((pakudex[i] == null)) {
                pakudex[i] = new Pakuri(species);
                return true;
            }
        }
        return false;
    }

    /**
     * Public member method evolveSpecies(), checks to see if user-specified Pakuri
     * exists and changes set stats using evolve()
     * @param species user-defined Pakuri
     * @return boolean; True if Pakuri can be evolved/False if Pakuri does not exist
     */
    public boolean evolveSpecies(String species) {
        try {
            for (int i = 0; i < pakudex.length; ++i) {
                if (pakudex[i].getSpecies().equals(species)) {
                    pakudex[i].evolve();
                    return true;
                }
            }
        } catch (NullPointerException except) {
            return false;
        }
        return false;

    }

}
