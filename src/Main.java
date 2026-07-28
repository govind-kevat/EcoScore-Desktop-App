import java.util.Scanner;

class CarbonCalculator {

    public double calculateEmailImpact(int emailsSent) {
        return emailsSent * 0.004;
    }

    public double calculateCloudImpact(double gbStored) {
        return gbStored * 0.02;
    }

    public double calculateStreamingImpact(double streamingHours) {
        return streamingHours * 0.05;
    }

    public double calculateDeviceImpact(double deviceHours) {
        return deviceHours * 0.01;
    }
}

class EcoScoreEngine {

    public int calculateEcoScore(double totalCarbonKg) {
        double maxCarbon = 100.0;

        double score = 100 - ((totalCarbonKg / maxCarbon) * 100);

        return (int) Math.max(0, Math.min(100, score));
    }

    public String getCategory(int ecoScore) {
        if (ecoScore >= 90) {
            return "Excellent 🌱";
        } else if (ecoScore >= 70) {
            return "Good ✅";
        } else if (ecoScore >= 50) {
            return "Average ⚠️";
        } else {
            return "Poor ❌";
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       EcoScore AI System");
        System.out.println("=================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Number of emails sent: ");
        int emails = sc.nextInt();

        System.out.print("Cloud storage used (GB): ");
        double storage = sc.nextDouble();

        System.out.print("Video streaming hours per month: ");
        double streamingHours = sc.nextDouble();

        System.out.print("Device usage hours per day: ");
        double deviceHours = sc.nextDouble();

        CarbonCalculator calculator = new CarbonCalculator();

        double emailImpact =
                calculator.calculateEmailImpact(emails);

        double cloudImpact =
                calculator.calculateCloudImpact(storage);

        double streamingImpact =
                calculator.calculateStreamingImpact(streamingHours);

        double deviceImpact =
                calculator.calculateDeviceImpact(deviceHours);

        double totalCarbon =
                emailImpact +
                        cloudImpact +
                        streamingImpact +
                        deviceImpact;

        EcoScoreEngine engine = new EcoScoreEngine();

        int ecoScore = engine.calculateEcoScore(totalCarbon);

        String category = engine.getCategory(ecoScore);

        System.out.println("\n========== REPORT ==========");
        System.out.println("User Name          : " + name);
        System.out.println("Email Impact       : " + emailImpact + " kg CO2");
        System.out.println("Cloud Impact       : " + cloudImpact + " kg CO2");
        System.out.println("Streaming Impact   : " + streamingImpact + " kg CO2");
        System.out.println("Device Impact      : " + deviceImpact + " kg CO2");
        System.out.println("--------------------------------");
        System.out.println("Total Carbon Footprint : "
                + totalCarbon + " kg CO2");
        System.out.println("EcoScore               : "
                + ecoScore + "%");
        System.out.println("Category               : "
                + category);

        System.out.println("\nSuggestions:");

        if (ecoScore < 90) {
            System.out.println("- Reduce unnecessary emails.");
            System.out.println("- Delete unused cloud files.");
            System.out.println("- Stream videos at lower quality.");
            System.out.println("- Turn off devices when not in use.");
        } else {
            System.out.println("- Great job! Keep following green digital habits.");
        }

        System.out.println("============================");

        sc.close();
    }
}