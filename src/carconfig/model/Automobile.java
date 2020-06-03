package carconfig.model;

import java.io.Serializable;

/**
 * Automotive is the class for holding data and methods that help work with
 * automotive configuration
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 * @see java.io.Serializable
 */
public class Automobile implements Serializable {

    private String name;
    private double basePrice;
    private OptionSet optionSets[];
    private static final long serialVersionUID = 420042353490064604L;

    //Constructors

    /**
     * Constructs a new Autotomotive object
     * @param name              the model of Automotive
     * @param basePrice         the base price of Automotive
     * @param optionSetSize     the size of the array with options
     */
    public Automobile(String name, double basePrice, int optionSetSize) {
        this.name = name;
        this.basePrice = basePrice;
        this.optionSets = new OptionSet[optionSetSize];
    }

    /**
     * Initializes a newly created Automotive object so that it represent
     * an empty Automotive
     */
    public Automobile() {
    }

    // Getters

    /**
     * Returns a model of Automotive
     * @return the name of Automotive
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a base price of Automotive
     * @return the base price of Automotive
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Returns the option set of Automotive with given index
     * @param index the index of the option set
     * @return      the option set of Automotive
     */
    public OptionSet getOptionSet(int index) {
        return optionSets[index];
    }

    // Searches

    /**
     * Searches the option set with a given name
     * @param optionSetName the option set name
     * @return              the option set of Automotive if found, null in opposite case
     */
    public OptionSet findOptionSet(String optionSetName) {
        for (OptionSet val : this.optionSets)
            if (val.getName().equals(optionSetName))
                return val;
        return null;
    }

    /**
     * Searches the option with a given name
     * @param optionName the option name
     * @return           the first option set of Automotive with an option's name
     *                   equal to the parameter optionName. Null if such option's name was not found.
     */
    public OptionSet findOption(String optionName) {
        for (OptionSet val : this.optionSets) {
            OptionSet.Option[] curOptions = val.getOpt();
            for (OptionSet.Option option : curOptions)
                if (option.getName().equals(optionName))
                    return val;
        }
        return null;
    }

    // Setters

    /**
     * Sets the name of Automotive
     * @param name the name of Automotive
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the base price of Automotive
     * @param price the base price of Automotive
     */
    public void setBasePrice(double price) {
        this.basePrice = price;
    }

    /**
     * Sets the name of option set with a given index in the array of option sets and
     * initializes the size of options array
     * @param optionSetName the name of the option set that will be set
     * @param nOptions      the size of the array with options
     * @param index         the index of the option set in option set array
     */
    public void setOptionSet(String optionSetName, int nOptions, int index) {
        optionSets[index] = new OptionSet(optionSetName, nOptions);
    }

    /**
     * Sets the parameters of the option with the given index in the array of options
     * in the given option set
     * @param optionSet the option set which option should be set
     * @param value     the value of the option
     * @param price     the price of the option
     * @param index     the index of the option in the array of options
     */
    public void setOption(OptionSet optionSet, String value, double price, int index) {
        optionSet.setOption(value, price, index);
    }

    // Deletions

    /**
     * Deletes option set (sets the value of the option set reference with the given index to null)
     * @param index the index of option set in the array of option sets
     */
    public void deleteOptionSet(int index) {
        if (index < optionSets.length && index >= 0)
            optionSets[index] = null;
    }

    /**
     * Deletes the option in the given option set
     * (sets the value of the option reference with the given index to null)
     * @param
     */
    public void deleteOption(OptionSet optionSet, int index) {
        optionSet.getOpt()[index] = null;
    }

    // Updates

    /**
     * Finds the option set with the given name and sets the new name
     * @param optionSetName     the old name of the option set
     * @param newOptionSetName  the new name of the option set
     */
    public void updateOptionSet(String optionSetName, String newOptionSetName ) {
        findOptionSet(optionSetName).setName(newOptionSetName);
    }

    /**
     * Finds the option in the given option set and set it new price
     * @param
     */
    public void updateOptionPrice(String optionSetName, String optionName, double newPrice) {
        findOptionSet(optionSetName).findOption(optionName).setPrice(newPrice);
    }


    /**
     * Finds the option in the given option set and set it new name and price
     * @param
     */
    public void updateOptions(OptionSet optionSet) {

    }

    /**
     * Returns a string representing the Option object
     * @return the string representing the Option object
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Name:");
        sb.append(name);
        sb.append('\n');
        sb.append("Base price:").append(basePrice).append('\n');
        sb.append("Options:\n");
        if (optionSets != null)
            for (int i = 0; i < optionSets.length; i++)
               if (optionSets[i] != null)
                   sb.append(optionSets[i].toString());
        return sb.toString();
    }
}