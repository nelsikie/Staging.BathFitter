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
    private static int US_CAD_NR;
    private int intHour = 24, intMinute = 60;
    // Contact info
    private String salutation, language;
    private int randomSalutationNR, randomLanguageNR;

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
}