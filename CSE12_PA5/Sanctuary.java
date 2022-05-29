
/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is the Sanctuary class. 
 * It contains all methods and variables of a Sanctuary
 */
import java.util.HashMap;
import java.util.Set;

/**
 * This class contains all methods and variables of Sanctuary class
 */

public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    /**
     * This is the constructor of Sanctuary
     * @param maxAnimals maximum number of animal
     * @param maxSpecies maximum number of species
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {
        //Check if number is less than 0
        if(maxAnimals < 0 || maxSpecies < 0){
            throw new IllegalArgumentException();
        }
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
        this.sanctuary = new HashMap<String, Integer>();
    }

    /**
     * This method get the total number of animals for 
     * one species in Sanctuary
     * @param species 
     * @return
     */
    public int getNum(String species) {
        //check if species is null
        if(species ==  null){
            throw new IllegalArgumentException();
        }
        //check if species exist in the sanctuary
        if(sanctuary.containsKey(species) == false){
            return 0;
        }
        return sanctuary.get(species);
    }
    /**
     * This method return total number of animal in the sanctuary
     * @return total number of animal
     */
    public int getTotalAnimals() {
        int total = 0;
        //Get all keys
        Object[] keys = sanctuary.keySet().toArray();
        //Add numbers of all keys
        for(int i = 0; i<keys.length; i++){
            total += sanctuary.get(keys[i]);
        }
        return total;
    }
    
    /**
     * This method return total number of species in the sanctuary
     * @return total number of species
     */
    public int getTotalSpecies() {
        return sanctuary.size();

    }

    /**
     * This method add num animsl to sanctuary
     * @param species
     * @param num
     * @return number of animals that could not be rescued
     */
    public int rescue(String species, int num) {
        //Check if num<=0 pr species is null
        if(num <= 0 || species == null){
            throw new IllegalArgumentException();
        }

        int spots = maxAnimals - this.getTotalAnimals();
        if(spots <= 0){
            return num;
        }
        //Check if species are already in sanctuary
        else if(sanctuary.containsKey(species)){
            int orig = sanctuary.get(species);
            if(num > spots){
                sanctuary.put(species, orig + spots);
                return num - spots;
            }
            else{
                sanctuary.put(species,orig + num);
                return 0;
            }
        }
        //Check if max species is reached for new speces added
        else if(this.getTotalSpecies() >= maxSpecies){
            return num;
        }
        //Check if num exceeds limit
        else if(num > spots){
            sanctuary.put(species, spots);
            return num - spots;
        }
        else{
            sanctuary.put(species,num);
            return 0;
        }
    }

    /**
     * This method removed num animals of species 
     * from the sanctuary
     * @param species species to be removed
     * @param num num to be removed
     */
    public void release(String species, int num) {
        //Check for illegal arguments
        if(num <= 0 || num > sanctuary.get(species) 
        || species  == null || sanctuary.containsKey(species) == false){
            throw new IllegalArgumentException();
        }
        int numLeft = sanctuary.get(species) - num;
        //Remove species
        sanctuary.remove(species);
        //If there is left, put back in
        if(numLeft > 0){
            sanctuary.put(species, numLeft);
        }
    }

    public static void main(String[] args) {
        
    }
}
