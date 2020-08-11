/**
 * Pakuri class that creates the Pakuri species identified
 * by the user. Creates stats (attack, defense, speed) for
 * each Pakuri based on the character length of the String
 * name
 * @author Brandon Grunes
 * @version 1.0
 */
public class Pakuri extends Pakudex {

    // Private member fields
    final private String species;
    private int attack, defense, speed;

    /**
     * Constructor that sets the name of the Pakuri and provides the stats
     * based on the length of the name
     * @param species Name of the new Pakuri, used to create the stats for this species
     */
    public Pakuri (String species) {
        this.species = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    /**
     * Accessor that returns the name of the Pakuri
     * @return String variable value/name
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Accessor that returns the attack integer value of the Pakuri
     * @return int variable value/attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Accessor that returns the defense integer value of the Pakuri
     * @return int variable value/defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Accessor that returns the speed integer value of the Pakuri
     * @return int variable value/speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Mutator that sets the attack stat of specified Pakuri to
     * value set by user or by program
     * @param newAttack new attack stat value
     */
    public void setAttack(int newAttack) {
        attack = newAttack;
    }

    /**
     * Mutator that sets all stats of specified Pakuri to new values:
     * Double attack
     * Quadruple defense
     * Triple speed
     * @see "Pakudex.evolveSpecies()"
     */
    public void evolve() {
        attack = attack * 2;
        defense = defense * 4;
        speed = speed * 3;
    }
}
