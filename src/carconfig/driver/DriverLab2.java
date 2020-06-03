package carconfig.driver;

import carconfig.adapter.*;
import carconfig.exception.AutoException;

/**
 * DriverLab2 is the class for testing purposes (Interfaces, Abstract Classes, Exceptions)
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 */
public class DriverLab2 {

    /**
     * Runs the program
     *
     * @param args the arguments of command line
     */
    public static void main(String[] args) {

        testInterfaceAndAbstractClass();
        try {
           testAutoExceptionAndLogs();
        } catch(AutoException ex) {

        }
    }

    /**
     * Tests interface and abstract classes in the program
     */
    static void testInterfaceAndAbstractClass() {

        String fileName = "FordZTW.txt";
        String modelName = "FordWagonZTW";
        String optionSetName = "Color";
        String newOptionSetName = "Colors and Tones";

        CreateAuto newAuto = new AutomobileBuilder();
        try {
            newAuto.buildAuto(fileName);
        } catch(AutoException ex) {

        }

        newAuto.printAuto(modelName);

        UpdateAuto newAuto2 = new AutomobileBuilder();
        newAuto2.updateOptionSetName(modelName, optionSetName, newOptionSetName);
        newAuto.printAuto(modelName);

        optionSetName = "Brakes/Traction Control";
        String optionName = "ABS";
        double newPrice = 100.45;
        newAuto2.updateOptionPrice(modelName, optionSetName, optionName, newPrice);
        newAuto.printAuto(modelName);
    }

    /**
     * Tests AutoException exception and Logs
     * @throws AutoException
     */
    static void testAutoExceptionAndLogs() throws AutoException {

        String modelName = "FordWagonZTW";
        String fileName;

        // wrong file name
        fileName = "wrongFileName.txt";
        CreateAuto newAuto = new AutomobileBuilder();
        try {
            newAuto.buildAuto(fileName);
            newAuto.printAuto(modelName);
        } catch (AutoException ex) {
            ex.fix();
        }

        fileName = "FordZTW_corrupt.txt";  // missing model and missing base price
        newAuto = new AutomobileBuilder();
        try {
            newAuto.buildAuto(fileName);
            newAuto.printAuto(modelName);
        } catch (AutoException ex) {

        }

    }
}

/************************

*******************************************
 TEST INTERFACES AND ABSTRACT CLASSES
*******************************************
 Name:Focus Wagon ZTW
 Base price:18445.0
 Options:
 Color
 Fort Knox Gold Clearcoat Metallic $0.0
 Liquid Grey Clearcoat Metallic $0.0
 Infra-Red Clearcoat $0.0
 Grabber Green Clearcoat $0.0
 Metallic $0.0
 Sangria Red Clearcoat Metallic $0.0
 French Blue Clearcoat Metallic $0.0
 Twilight Blue Clearcoat Metallic $0.0
 CD Silver Clearcoat Metallic $0.0
 Pitch Black Clearcoat $0.0
 Cloud 9 White Clearcoat $0.0
 Transmission
 Automatic $0.0
 Standard $-815.0
 Brakes/Traction Control
 Standard $0.0
 ABS $400.0
 ABS with Advance Trac $1625.0
 Side Impact Air Bags
 Side Impact Air Bags $350.0
 Power Moonroof
 Power Moonroof $595.0

 Name:Focus Wagon ZTW
 Base price:18445.0
 Options:
 Colors and Tones
 Fort Knox Gold Clearcoat Metallic $0.0
 Liquid Grey Clearcoat Metallic $0.0
 Infra-Red Clearcoat $0.0
 Grabber Green Clearcoat $0.0
 Metallic $0.0
 Sangria Red Clearcoat Metallic $0.0
 French Blue Clearcoat Metallic $0.0
 Twilight Blue Clearcoat Metallic $0.0
 CD Silver Clearcoat Metallic $0.0
 Pitch Black Clearcoat $0.0
 Cloud 9 White Clearcoat $0.0
 Transmission
 Automatic $0.0
 Standard $-815.0
 Brakes/Traction Control
 Standard $0.0
 ABS $400.0
 ABS with Advance Trac $1625.0
 Side Impact Air Bags
 Side Impact Air Bags $350.0
 Power Moonroof
 Power Moonroof $595.0

 Name:Focus Wagon ZTW
 Base price:18445.0
 Options:
 Colors and Tones
 Fort Knox Gold Clearcoat Metallic $0.0
 Liquid Grey Clearcoat Metallic $0.0
 Infra-Red Clearcoat $0.0
 Grabber Green Clearcoat $0.0
 Metallic $0.0
 Sangria Red Clearcoat Metallic $0.0
 French Blue Clearcoat Metallic $0.0
 Twilight Blue Clearcoat Metallic $0.0
 CD Silver Clearcoat Metallic $0.0
 Pitch Black Clearcoat $0.0
 Cloud 9 White Clearcoat $0.0
 Transmission
 Automatic $0.0
 Standard $-815.0
 Brakes/Traction Control
 Standard $0.0
 ABS $100.45
 ABS with Advance Trac $1625.0
 Side Impact Air Bags
 Side Impact Air Bags $350.0
 Power Moonroof
 Power Moonroof $595.0

 Process finished with exit code 0

 *******************************************
           TEST EXCEPTIONS AND LOGS
 *******************************************
 Please enter valid file name
 FordZTW.txt
 Name:Focus Wagon ZTW
 Base price:18445.0
 Options:
 Color
 Fort Knox Gold Clearcoat Metallic $0.0
 Liquid Grey Clearcoat Metallic $0.0
 Infra-Red Clearcoat $0.0
 Grabber Green Clearcoat $0.0
 Metallic $0.0
 Sangria Red Clearcoat Metallic $0.0
 French Blue Clearcoat Metallic $0.0
 Twilight Blue Clearcoat Metallic $0.0
 CD Silver Clearcoat Metallic $0.0
 Pitch Black Clearcoat $0.0
 Cloud 9 White Clearcoat $0.0
 Transmission
 Automatic $0.0
 Standard $-815.0
 Brakes/Traction Control
 Standard $0.0
 ABS $400.0
 ABS with Advance Trac $1625.0
 Side Impact Air Bags
 Side Impact Air Bags $350.0
 Power Moonroof
 Power Moonroof $595.0

 Model name is missing in the file
 Please enter model name
 Volvo
 Base price is missing in the file
 Please enter base price
 44000
 Name:Volvo
 Base price:44000.0
 Options:
 Color
 Fort Knox Gold Clearcoat Metallic $0.0
 Liquid Grey Clearcoat Metallic $0.0
 Infra-Red Clearcoat $0.0
 Grabber Green Clearcoat $0.0
 Metallic $0.0
 Sangria Red Clearcoat Metallic $0.0
 French Blue Clearcoat Metallic $0.0
 Twilight Blue Clearcoat Metallic $0.0
 CD Silver Clearcoat Metallic $0.0
 Pitch Black Clearcoat $0.0
 Cloud 9 White Clearcoat $0.0
 Transmission
 Automatic $0.0
 Standard $-815.0
 Brakes/Traction Control
 Standard $0.0
 ABS $400.0
 ABS with Advance Trac $1625.0
 Side Impact Air Bags
 Side Impact Air Bags $350.0
 Power Moonroof
 Power Moonroof $595.0

 /****************************************/

