package carconfig.adapter;

import carconfig.exception.AutoException;
import carconfig.model.*;
import carconfig.autoutil.FileIO;

/**
 * ProxyAutomobile is the class that contains implementation of methods
 * declared in the interfaces CreateAuto and UpdateAuto
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 */
public abstract class ProxyAutomobile implements CreateAuto, UpdateAuto, FixAuto  {
    private static Automobile car;

    /**
     * Builds the automobile with specifications that are
     * declared in file with a fileName
     *
     * @param fileName the file name
     *
     */
    @Override
    public void buildAuto(String fileName) throws AutoException {
        car = new FileIO().readFile(fileName);
    }

    /**
     * Prints the characteristics of the given model of automobile
     *
     * @param modelName the name of the model
     *
     */
    @Override
    public void printAuto(String modelName) {
        System.out.println(car);
    }

    /**
     * Updates name of the option set for automobile with a given model name
     *
     * @param modelName            the name of the model
     * @param optionSetName        old name of the option set
     * @param newOptionSetName     new name of the option set
     *
     */
    @Override
    public void updateOptionSetName(String modelName, String optionSetName, String newOptionSetName) {
        car.updateOptionSet(optionSetName, newOptionSetName);
    }

    /**
     * Updates option price in the given option set name
     *
     * @param modelName        a name of the model of automobile
     * @param optionSetName    a name of the option set
     * @param optionName       a name of the option
     * @param newPrice         a new price of the option
     */
    @Override
    public void updateOptionPrice(String modelName, String optionSetName, String optionName, double newPrice) {
        car.updateOptionPrice(optionSetName, optionName, newPrice);
    }

}