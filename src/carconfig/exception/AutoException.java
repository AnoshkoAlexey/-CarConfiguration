package carconfig.exception;

import carconfig.model.Automobile;

/**
 * AutoException is the class that extends Exception class
 * and helps to handle errors thrown during configuration of
 * car instances
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 */
public class AutoException extends Exception {

    private EnumAutomobileErrors error;
    private String description;
    private Automobile automobile;

    /**
     * Constructs a new AutoException object
     */
    public AutoException() {
        super();
    }

    /**
     * Constructs a new AutoException object
     * @param error Enumerator object that hold code and type of the
     *              AytoException error
     */
    public AutoException(EnumAutomobileErrors error) {
        this(error, "");
    }

    /**
     * Constructs a new AutoException object
     *
     * @param error       Enumerator object that hold code and type of the
     *                    AytoException error
     *
     * @param description Description of the error
     */
    public AutoException(EnumAutomobileErrors error, String description) {
        this.error = error;
        LogJournal.createRecord(error.getErrorCode(), error.getErrorType(), description);
    }

    /**
     * This function tries to define the function that can fix the error
     *
     * @return the object that can be casted to necessary type
     */
    public Object fix() {
        Object object = null;
        Fix1to100 fix1to100 = new Fix1to100();
        switch (error) {
            case WRONG_FILE_NAME: object = fix1to100.fixWrongFileName();
                break;
            case MISSING_MODEL_NAME: object = fix1to100.fixMissingModelName();
                break;
            case MISSING_CAR_PRICE: object = fix1to100.fixMissingCarPrice();
                break;
            default:
                System.out.println("The error could not be fixed! See log file!");
                break;
        }

        return object;
    }
}