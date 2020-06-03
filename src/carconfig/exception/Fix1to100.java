package carconfig.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Fix1to100 is the class that handles exceptions with
 * codes from 1 to 100 (inclusively) and try to fix them
 * if it is possible
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 */
public class Fix1to100 {

    /**
     * Fixes the missing base price error
     *
     * @return base price
     */
    protected double fixMissingCarPrice() {
        System.out.println("Base price is missing in the file");
        System.out.println("Please enter base price");
        Scanner scanner = new Scanner(System.in);
        Double carPrice = scanner.nextDouble();
        return carPrice;
    }

    /**
     * Fixes the missing model name error
     *
     * @return model name
     */
    protected String fixMissingModelName() {
        System.out.println("Model name is missing in the file");
        System.out.println("Please enter model name");
        Scanner scanner = new Scanner(System.in);
        String modelName = scanner.nextLine();
        return modelName;
    }

    /**
     * Fixes the wrong file name error
     *
     * @return file name
     */
    protected String fixWrongFileName() {

        String fileName = null;
        System.out.println("Please enter valid file name");
        Scanner scanner = new Scanner(System.in);
        fileName = scanner.nextLine().trim();
        return fileName;
    }
}
