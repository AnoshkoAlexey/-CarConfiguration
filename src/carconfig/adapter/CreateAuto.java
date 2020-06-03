package carconfig.adapter;

import carconfig.exception.AutoException;

/**
 * CreateAuto is the interface that declares methods
 * that allows to build and print automobile
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 */
public interface CreateAuto {

    /**
     * Builds the automobile with specifications that are
     * declared in file with a fileName
     *
     * @param fileName the file name
     *
     */
    public void buildAuto(String fileName) throws AutoException;

    /**
     * Prints the characteristics of the given model of automobile
     *
     * @param modelName the name of the model
     *
     */
    public void printAuto(String modelName);
}