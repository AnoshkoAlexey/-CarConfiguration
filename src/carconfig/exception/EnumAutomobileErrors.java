package carconfig.exception;

/**
 * An EnumAutomobileErrors provides a set of errors that can appear
 * during exploitation of the car configuration program
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 */
public enum EnumAutomobileErrors {

    MISSING_MODEL_NAME(1, "Missing model name"),
    MISSING_CAR_PRICE(2, "Missing base car price"),
    MISSING_NUMBER_OPTION_SET(3, "Missing number of options sets"),
    MISSING_OPTION_SET_NAME(4, "Missing option set name"),
    MISSING_OPTION_NAME(5, "Missing option name"),
    WRONG_FILE_NAME(6, "Wrong file name"),
    WRONG_CAR_PRICE(7,"Wrong car price"),
    WRONG_NUMBER_OPTION_SET(8, "Wrong number option set"),
    MISSING_NUMBER_OPTIONS(9, "Missing number options"),
    WRONG_NUMBER_OPTIONS(10, "Wrong number options"),
    MISSING_OPTION_PRICE(11,"Missing option price"),
    WRONG_OPTION_PRICE(12, "Wrong option price");

    private int errorCode;
    private String errorType;

    /**
     * Constructs a new enumerator EnumAutomobileErrors
     * @param errorCode         a code of the error
     * @param errorType  a description of the error
     *
     */
    EnumAutomobileErrors(int errorCode, String errorType) {
        this.errorCode = errorCode;
        this.errorType = errorType;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorType() {
        return errorType;
    }
}