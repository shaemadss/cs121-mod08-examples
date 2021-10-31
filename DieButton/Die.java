/**
 * Basic Die class that implements the Comparable interface. This class was
 *    developed during the lecture on class design.
 * @author Luke Hindman
 */
import java.util.Random;

public class Die implements Comparable<Die>{
    /* 1. Instance Variables */
    private int faceValue;
    private int numSides;

    /* 2. Constructor(s) */
    public Die() {
        faceValue = 1;
        numSides = 6;
    }

    public Die(int numSides) {
        faceValue = 1;
        this.numSides = numSides;
    }
    /* 3. Other methods */

    public int roll() {
        Random gen = new Random();
        this.faceValue = gen.nextInt(this.numSides) + 1;
        return this.faceValue;
    }

    public int getFaceValue() {
        return this.faceValue;
    }

    public void setFaceValue(int faceValue) {
        if (faceValue > 0 && faceValue <= this.numSides){
            this.faceValue = faceValue;
        }
    }

    public String toString() {
        String output  = "";

        output += "The value of my beautiful " + this.numSides + " sided die is: " + this.faceValue;

        return output;
    }

    /* Static methods */
    public static Die max(Die d1, Die d2) {
        if (d1.getFaceValue() >= d2.getFaceValue()) {
            return d1;
        } else {
            return d2;
        }
    }

    /* Comparable Interface Methods*/
    @Override
    public int compareTo(Die arg0) {
        // if (this.getFaceValue() > arg0.getFaceValue()) {
        //     return 1;
        // } else if (this.getFaceValue() < arg0.getFaceValue()) {
        //     return -1;
        // } else {
        //     return 0;
        // }
        return this.getFaceValue() - arg0.getFaceValue();
    }

    
}
