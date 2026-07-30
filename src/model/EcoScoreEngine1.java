package model;

public class EcoScoreEngine1 {

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
}
