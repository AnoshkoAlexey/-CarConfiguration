package carconfig.model;

import java.io.Serializable;

/**
 * OptionSet is the class for holding data and methods that help work with
 * option sets
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 * @see java.io.Serializable
 */
public class OptionSet implements Serializable {

    private Option opt[];
    private String name;
    private static final long serialVersionUID = 7048581374397240990L;

    /**
     * Constructs a new OptionSet object
     * @param optionSetName the name of the option set
     * @param size          the size of the array with options
     */
    protected OptionSet(String optionSetName, int size) {
        opt = new Option[size];
        name = optionSetName;
    }

    /**
     * Sets the name of the option set
     * @param name the name of the option set
     */
    protected void setName(String name){
        this.name = name;
    }

    /**
     * Returns the name of the option set
     * @return the name of the option set
     */
    protected String getName() {
        return name;
    }

    /**
     * Creates new option object (if it was not created before) and sets its values
     * @param name  the name of the option
     * @param price the price of the option
     * @param index the index of the option in the array of options
     */
    protected void setOption(String name, double price, int index) {
        if (opt[index] == null)
            opt[index] = new Option(name, price);
        else
            opt[index].setName(name);
            opt[index].setPrice(price);
    }

    /**
     * Searches an option object with the given name
     * @param optionName the name of the option
     * @return Option object with the given name
     *
     */
    protected Option findOption(String optionName) {
        for (Option val : this.opt)
            if (val.getName().equals(optionName))
                return val;
        return null;
    }

    /**
     * Returns the array of options
     * @return the array of options
     */
    protected Option[] getOpt() {
        return opt;
    }

    /**
     * Update the price of the option object
     * @param option the option object
     * @param price  the price of the option
     *
     */
    protected void setOptionName(Option option, double price) {
        option.setPrice(price);
    }

    /**
     * Returns a string representing the OptionSet object
     * @return the string representing the OptionSet object
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(name);
        sb.append('\n');
        for (int i = 0; i < opt.length; i++) {
            if (opt[i] != null)
                sb.append('\t')
                  .append(opt[i].toString())
                        .append('\n');
        }
        return sb.toString();
    }

    /**
     * Option is the class for holding data and methods that help work with options in option set
     *
     * @author alexey
     * @version %I%, %G%
     * @see java.io.Serializable
     */
    class Option implements Serializable {
        private String name;
        private double price;
        private static final long serialVersionUID = 7017233482317506986L;

        /**
         * Constructs a new option object
         */
        protected Option(){}

        /**
         * Constructs a new option object with initialized parameters
         * @param name  the name of the option
         * @param price the price of the option
         */
        protected Option(String name, double price) {
            this.name = name;
            this.price = price;
        }

        /**
         * Returns the name of the option
         * @return the name of the option
         */
        protected String getName() {
            return name;
        }

        /**
         * Returns the price of the option
         * @return the price of the option
         */
        protected double getPrice() {
            return price;
        }

        /**
         * Sets the name of the option
         * @param name the name of the option
         */
        protected void setName(String name) {
            this.name = name;
        }

        /**
         * Sets the price of the option
         * @param price the price of the option
         */
        protected void setPrice(double price) {
            this.price = price;
        }

        /**
         * Returns a string representing the Option object
         * @return the string representing the Option object
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(name);
            sb.append(" $")
              .append(price);
            return sb.toString();
        }
    }
}