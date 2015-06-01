package chapter10;

import java.io.File;

public class LoadTester
{
    public static void main(String[] args) {
        try {
            SubwayLoader loader = new SubwayLoader();
            Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
            
            System.out.println("Testing stations");
            if (    objectville.hasStation("DRY Drive") &&
                    objectville.hasStation("Weather-O-Rama, Inc.") &&
                    objectville.hasStation("Boards 'R' Us")) {
                System.out.println("... station test passed successfully.");
            }
            else
            {
                System.out.println("...station test FAILED.");
                System.exit(-1);
            }
            
            System.out.println("\nTesting connections...");
            System.out.println("1:"+objectville.hasConnection("DRY Drive", "Head First Theater", "Meyer Line"));
            System.out.println("2:"+objectville.hasConnection("LSP Lane", "JavaBeans Boulevard", "Booch Line"));
            System.out.println("3:"+objectville.hasConnection("OOA&D Oval", "Head First Lounge", "Gamma Line"));
            if (objectville.hasConnection("DRY Drive", "Head First Theater", "Meyer Line") &&
                objectville.hasConnection("LSP Lane", "JavaBeans Boulevard", "Booch Line") &&
                objectville.hasConnection("OOA&D Oval", "Head First Lounge", "Gamma Line")) {
                System.out.println("...connections test passed succesfully.");
            }
            else
            {
                System.out.println("...connections test FAILED");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
