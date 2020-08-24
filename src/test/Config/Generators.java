package Config;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Generators {

    public static int length;
    static Random rn = new Random();
    private static int random;
    private static String timeStamp = new SimpleDateFormat("yyyy_MMMMM_dd_HH.mm.ss.SSSS").format(new Date());
    private static String timeStampShort = new SimpleDateFormat("ddMMyy_kkmm").format(new Date());
    private static String todaysDate = new SimpleDateFormat("M/dd/yyyy").format(new Date());
    private static int US_CAD_NR;
    private int intHour = 24, intMinute = 60;
    // Contact info
    private String salutation, language;
    private int randomSalutationNR, randomLanguageNR;
    private String repairProd;
    public Generators() {
        random = 0;
        length = 255;
        US_CAD_NR = 888;
    }

    public static String phoneNumberGenerator() {
        int num2 = rn.nextInt(743);
        int num3 = rn.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String phoneNumber = "-" + df3.format(num2) + "-" + df4.format(num3);

        return phoneNumber;
    }
    public String getTodaysDate() { return todaysDate; }

    public String phoneNR() {
        return US_CAD_NR + phoneNumberGenerator();
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String timeStampShort() {
        return timeStampShort;
    }

    public String salutation() {
        randomSalutationNR = rn.nextInt(4 - 0);
        switch (randomSalutationNR) {
            case 0:
                salutation = "";
                break;
            case 1:
                salutation = "Dr";
                break;
            case 2:
                salutation = "Mr";
                break;
            case 3:
                salutation = "Mrs";
                break;
            case 4:
                salutation = "Ms";
                break;
            default:
                salutation = "Dr";
                break;
        }
        return salutation;
    }

    public String language() {
        randomLanguageNR = rn.nextInt(2 - 0); // Probably could be just a default int that is always used for random number generating
        switch (randomLanguageNR) {
            case 0:
                language = "English";
                break;
            case 1:
                language = "French";
                break;
            case 2:
                language = "Spanish";
                break;
        }
        return language;
    }

    public String firstNameGenerator() {
        String[] firstName = {"Bob", "Jill", "Tom", "Brandon", "Bryan", "Alain", "Jennifer", "Johanne", "Louis",
                "Nick", "Benoit", "Irene", "Neo", "Luke", "Kit", "Wilfred", "Sherwin", "Daniel", "Andrew", "Cassius"};
        int selection = rn.nextInt(firstName.length);
        return firstName[selection];
    }

    public String lastNameGenerator() {
        String[] lastName = {"Smith", "Jones", "Taylor", "Burke", "Williams", "Brown", "Davies", "Evans", "Wilson",
                "Baker", "Bell", "Wood", "Pedro", "Gordon", "Dixon", "Harper", "Gordon", "King", "Lee", "Clarke"};
        int selection = rn.nextInt(lastName.length);
        return lastName[selection];
    }

    public String repairProduct() {
        String[] repairProduct = {"Accessories", "Ceiling", "Doors", "Molding", "Plumbing", "Shower", "Silicone",
                "Skirt", "Tile Wall", "Tub", "Wainscoting", "Wall", "BFInsight Other"};
        repairProd = repairProduct[rn.nextInt(repairProduct.length)];
        System.out.println("THIS IS THE REPAIR PROD: "  +repairProd);
        return repairProd;
    }

    public String atFault() {
        String[] atFault = {"Customer Related", "Product Related", "Installer", "Installer & Plumber",
        "Plumber", "Poor Appearance", "Scratched"};
        return atFault[rn.nextInt(atFault.length)];
    }

    // Depending on the "Repair Product" the "Nature" can be different
    public String nature() {
        switch(repairProd) {
            case "Accessories":
                String[] natureAccessories = {"Damage to the Home", "Broken", "Cracked", "Damaged", "Discolored", "Falling Off",
                        "Poor Appearance", "Wrong Position"};
                return natureAccessories[rn.nextInt(natureAccessories.length)];
            case "Ceiling":
                String[] natureCeiling = {"Damage to the Home", "Cracked", "Discolored", "Falling Off", "Poor Appearance", "Scratched"};
                return natureCeiling[rn.nextInt(natureCeiling.length)];
            case "Doors":
                String[] natureProductRelated = {"Damage to the Home", "Broken", "Discolored", "Door Guide", "Finish Peeling/Scratched", "Glass Chipped/Shattered",
                        "Hardware Issue", "Leaking", "Not Closing/Opening", "Uneven",};
                return natureProductRelated[rn.nextInt(natureProductRelated.length)];
            case "Molding":
                String[] natureMolding = {"Damage to the Home", "Cracked", "Discolored", "Falling Off", "Has Gaps", "Not Straight", "Peeling", "Scratched", "Too Wide"};
                return natureMolding[rn.nextInt(natureMolding.length)];
            case "Plumbing":
                String[] naturePlumbing = {"Damage to the Home", "Broken", "Discolored", "Drain Clogged", "Faucet Loose/Dripping", "Faucet/Fixtures Wrong Position",
                "Hardware Issue", "Hot/Cold Reversed", "Leaking", "No hot water", "No Pressure", "No Water/Pressure", "Noise"};
                return naturePlumbing[rn.nextInt(naturePlumbing.length)];
            case "Shower":
                String[] natureShower = {"Damage to the Home", "Anti-Skid", "Cracked", "Discolored", "Drain not Centered", "Pooling", "Popping", "Scratched", "Water underneath"};
                return natureShower[rn.nextInt(natureShower.length)];
            case "Silicone":
                String[] natureSilicone = {"Damage to the Home", "Appearance", "Discolored", "Has Gaps", "Maintenance", "Mold", "Peeling"};
                return natureSilicone[rn.nextInt(natureSilicone.length)];
            case "Skirt":
                String[] natureSkirt = {"Damage to the Home", "Bowing/Loose", "Cracked", "Not Straight", "Scratched"};
                return natureSkirt[rn.nextInt(natureSkirt.length)];
            case "Tile Wall":
                String[] natureTileWall = {"Damage to the Home", "Bowing/Loose", "Cracked", "Discolored", "Not Straight", "Poor Appearance", "Scratched"};
                return natureTileWall[rn.nextInt(natureTileWall.length)];
            case "Tub":
                String[] natureTub = {"Damage to the Home", "Anti-Skid", "Cracked", "Discolored", "Drain not Centered", "Pooling", "Popping", "Scratched", "Water underneath"};
                return natureTub[rn.nextInt(natureTub.length)];
            case "Wainscoting":
                String[] natureWainScoting = {"Damage to the Home", "Bowing/Loose", "Cracked", "Discolored", "Not Straight", "Poor Appearance", "Scratched"};
                return natureWainScoting[rn.nextInt(natureWainScoting.length)];
            case "Wall":
                String[] natureWall = {"Damage to the Home", "Bowing/Loose", "Cracked", "Discolored", "Not Straight", "Poor Appearance", "Scratched"};
                return natureWall[rn.nextInt(natureWall.length)];
            case "BFInsight Other":
                String[] natureBFInsightOther = {"Damage to the Home", "BFInsight Other"};
                return natureBFInsightOther[rn.nextInt(natureBFInsightOther.length)];
            default:
                return "FUCKED UP";
        }
//
//        String[] nature = {"Broken", "Damage to the Home", "Bowing/Loose", "Cracked", "Discolored", "Not Straight",
//        "Scratched", "Poor Appearance"};
//        return nature[rn.nextInt(nature.length)];
    }

    public String responsible() {
        String[] responsbile = {"193 INST1", "193 INST2"};
        return responsbile[rn.nextInt(responsbile.length)];
    }

    public String outCome() {
        String[] outCome = {"Customer refuse solution", "Repaired", "Replaced", "Non-BF Issue"};
        return outCome[rn.nextInt(outCome.length)];
    }

    public String warrantyReason() {
        String[] warrantyReason = {"Branch Warranty", "Head Office Warranty"};
        return warrantyReason[rn.nextInt(warrantyReason.length)];
    }
}