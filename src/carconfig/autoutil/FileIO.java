package carconfig.autoutil;

import java.io.*;

import carconfig.exception.AutoException;
import carconfig.exception.EnumAutomobileErrors;
import carconfig.model.Automobile;
import carconfig.model.OptionSet;

/**
 * FileIO is the class for different input/output operations
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 * @see java.io.Serializable
 */
public class FileIO {

    /**
     * Serializes an Automotive object in a file
     *
     * @param car      the Automotive object
     * @param fileName the file name where object will be saved
     */
    public void serializeAuto(Automobile car, String fileName) {

        try {
            File outputFile = new File(fileName);
            FileOutputStream fos = new FileOutputStream(outputFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(car);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Deserializes an Automotive object from a file
     *
     * @param fileName the file name
     * @return the Automotive object that was deserialize
     */
    public Automobile deserializeAuto(String fileName) {

        Automobile car = null;
        try {
            File inputFile = new File(fileName);
            FileInputStream fis = new FileInputStream(inputFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            car = (Automobile) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File was not found!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class was not found!");
            ex.printStackTrace();
        }

        return car;
    }

    /**
     * Reads the automotive configuration from a text file
     * and creates Automotive object with the configuration's values
     *
     * @param fileName the name of the file with automotive configuration
     * @return the Automotive object
     */
    public Automobile readFile(String fileName) throws AutoException {

        Automobile car = null;

        try {
            FileReader fileReader = createFileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;

            String name;
            double basePrice;
            int nOptions = 0;

            line = reader.readLine();
            name = parseModelName(line);

            line = reader.readLine();
            basePrice = parseBasePrice(line);

            line = reader.readLine();
            nOptions = parseNOptionSet(line);

            car = new Automobile(name, basePrice, nOptions);

            for (int i = 0; i < nOptions; i++) {
                reader.readLine();

                line = reader.readLine();
                String optionName = parseOptionSetName(line);

                line = reader.readLine();
                int nValues = parseNOptions(line);

                car.setOptionSet(optionName, nValues, i);
                OptionSet optSet = car.getOptionSet(i);

                for (int j = 0; j < nValues; j++) {
                    line = reader.readLine();
                    String optionParam[] = line.split(",");
                    String value = parseOptionName(optionParam[0].trim());
                    double price = parseOptionPrice(optionParam[1].trim());
                    car.setOption(optSet, value, price, j);
                }
            }
            reader.close();
        } catch (IOException ex) {

        }

        return car;
    }

    /**
     * Creates file reader
     * @param inputFileName name of the input file
     * @return              object that allow to read data from the file
     */
    private FileReader createFileReader(String inputFileName) {

        FileReader fileReader = null;

        do {
            try {
                File inputFile = new File(inputFileName);
                fileReader = new FileReader(inputFile);
            } catch (FileNotFoundException ex) {
                AutoException e = new AutoException(EnumAutomobileErrors.WRONG_FILE_NAME);
                inputFileName = (String) e.fix();
            }
        } while (fileReader == null);

        return fileReader;
    }

    /**
     * Parses the line that has model name
     *
     * @param line a line from the file
     * @return     model name
     */
    private String parseModelName(String line) {

        String modelName;

        try {
            if ("".equals(line.trim()) ||
                    line.indexOf(":") == -1 ||
                    "".equals(modelName = line.substring(line.indexOf(":") + 1).trim()))
                throw new AutoException(EnumAutomobileErrors.MISSING_MODEL_NAME);
        } catch (AutoException ex) {
            modelName = (String) ex.fix();
        }

        return modelName;
    }

    /**
     * Parses the line that has base price
     *
     * @param line  a line from the file
     * @return      a base price of an automobile
     */
    private double parseBasePrice(String line) {

        Double basePrice = -1d;

        try {
            if ("".equals(line.trim()) ||
                    line.indexOf(":") == -1 ||
                    "".equals(line.substring(line.indexOf(":") + 1).trim()))
                throw new AutoException(EnumAutomobileErrors.MISSING_CAR_PRICE);
            else
                try {
                    basePrice = Double.valueOf(line.substring(line.indexOf(":") + 1).trim());
                } catch (NumberFormatException ex) {
                    throw new AutoException(EnumAutomobileErrors.WRONG_CAR_PRICE);
                }
        } catch (AutoException ex) {
            basePrice = (double) ex.fix();
        }

        return basePrice;
    }

    /**
     * Parses the line that has number of option sets
     *
     * @param line  a line from the file
     * @return      a number of option sets
     */
    private int parseNOptionSet(String line) {

        int nOptionSets = -1;

        try {
            if ("".equals(line.trim()) ||
                    line.indexOf(":") == -1 ||
                    "".equals(line.substring(line.indexOf(":") + 1).trim()))
                throw new AutoException(EnumAutomobileErrors.MISSING_NUMBER_OPTION_SET);
            else
                try {
                    nOptionSets = Integer.valueOf(line.substring(line.indexOf(":") + 1).trim());
                } catch (NumberFormatException ex) {
                    throw new AutoException(EnumAutomobileErrors.WRONG_NUMBER_OPTION_SET);
                }
        } catch (AutoException ex) {
            Object object = ex.fix();
            if (object != null)
                nOptionSets = (int) object;
        }

        return nOptionSets;
    }

    /**
     * Parses the line that has name of an option set
     * @param line a line from the file
     * @return     an option set name
     */
    private String parseOptionSetName(String line) {

        String optionSetName = null;

        try {
            if ("".equals(line.trim()) ||
                    line.indexOf(":") == -1 ||
                    "".equals(optionSetName = line.substring(line.indexOf(":") + 1).trim()))
                throw new AutoException(EnumAutomobileErrors.MISSING_OPTION_SET_NAME);
        } catch (AutoException ex) {
            Object object = ex.fix();
            if (object != null)
                optionSetName = (String) ex.fix();
        }

        return optionSetName;
    }

    /**
     * Parses the line that has number of options
     * @param line  a line from the file
     * @return      a number of options
     */
    private int parseNOptions(String line) {

        int nOptions = -1;

        try {
            if ("".equals(line.trim()) ||
                    line.indexOf(":") == -1 ||
                    "".equals(line.substring(line.indexOf(":") + 1).trim()))
                throw new AutoException(EnumAutomobileErrors.MISSING_NUMBER_OPTIONS);
            else
                try {
                    nOptions = Integer.valueOf(line.substring(line.indexOf(":") + 1).trim());
                } catch (NumberFormatException ex) {
                    throw new AutoException(EnumAutomobileErrors.WRONG_NUMBER_OPTIONS);
                }
        } catch (AutoException ex) {
            Object object = ex.fix();
            if (object != null)
                nOptions = (int) ex.fix();
        }

        return nOptions;

    }

    /**
     * Parses the line that has name of an option
     * @param line  a line from the file
     * @return      a name of the option
     */
    private String parseOptionName(String line) {

        String optionName = null;

        try {
            if ("".equals(optionName = line.trim()))
                throw new AutoException(EnumAutomobileErrors.MISSING_OPTION_NAME);
        } catch (AutoException ex) {
            Object object = ex.fix();
            if (object != null)
                optionName = (String) object;
        }

        return optionName;

    }

    /**
     * Parses the line that has price of the option
     * @param line a line from the file
     * @return     a price of the option
     */
    private double parseOptionPrice(String line) {

        Double optionPrice = -1d;

        try {
            if ("".equals(line.trim()))
                throw new AutoException(EnumAutomobileErrors.MISSING_OPTION_PRICE);
            else
                try {
                    optionPrice = Double.valueOf(line.substring(line.indexOf(":") + 1).trim());
                } catch (NumberFormatException ex) {
                    throw new AutoException(EnumAutomobileErrors.WRONG_OPTION_PRICE);
                }
        } catch (AutoException ex) {
            Object object = ex.fix();
            if (object != null)
                optionPrice = (double) object;
        }

        return optionPrice;

    }
}