package carconfig.adapter;


/**
 * UpdateAuto is the interface that declares methods that allow
 * to update option set name and update option price
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 */
public interface UpdateAuto {

    /**
     * Updates name of the option set for automobile with a given model name
     *
     * @param modelName            the name of the model
     * @param optionSetName        old name of the option set
     * @param newOptionSetName     new name of the option set
     *
     */
    public void updateOptionSetName(String modelName, String optionSetName, String newOptionSetName);

    /**
     * Updates option price in the given option set name
     *
     * @param modelName        a name of the model of automobile
     * @param optionSetName    a name of the option set
     * @param optionName       a name of the option
     * @param newPrice         a new price of the option
     */
    public void updateOptionPrice(String modelName, String optionSetName, String optionName, double newPrice);
}