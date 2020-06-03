package carconfig.driver;

import carconfig.adapter.*;
import carconfig.autoutil.FileIO;
import carconfig.exception.AutoException;
import carconfig.model.Automobile;

/**
 * DriverLab1 is the class for testing purposes
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 */
public class DriverLab1 {

    /**
     * Runs the program
     * @param args  the arguments of command line
     */
    public static void main(String[] args) {
        FileIO newFileIO  = new FileIO();
        // Build Automobile Object from a file
        Automobile FordZTW = null;
        try {
            FordZTW = newFileIO.readFile("FordZTW.txt");
        } catch (AutoException e) {

        }
        // Print attributes before serialization
        System.out.println(FordZTW);
        // Serialize the object
        newFileIO.serializeAuto(FordZTW, "auto.ser");
        // Deserialize the object and read it into memory
        Automobile newFordZTW = newFileIO.deserializeAuto("auto.ser");
        // Print new attributes.
        System.out.println(newFordZTW);

        //I've made a little GUI for test purposes,
        // and for more practice with inner classes
        // It allows to read text file, serialize and deserialize objects
        // I want to improve it in the future

        carconfig.gui.GUI newGui = new carconfig.gui.GUI();
        newGui.go();

    }

}