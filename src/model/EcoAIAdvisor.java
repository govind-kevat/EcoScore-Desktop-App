package model;

public class EcoAIAdvisor {

    public String generateSuggestion(int emails,
                                     double storage,
                                     double streaming,
                                     double device,
                                     int ecoScore) {

        double email = emails * 0.004;
        double cloud = storage * 0.02;
        double stream = streaming * 0.05;
        double devices = device * 0.01;

        double total = email + cloud + stream + devices;

        if (total == 0) {
            return """
                    🤖 EcoScore AI Assistant

                    No digital activity detected.

                    Excellent! Your digital carbon footprint is almost zero.

                    🌱 Keep following sustainable digital habits.
                    """;
        }

        double emailPercent = (email / total) * 100;
        double cloudPercent = (cloud / total) * 100;
        double streamPercent = (stream / total) * 100;
        double devicePercent = (devices / total) * 100;

        String source = "Emails";
        double max = emailPercent;

        if (cloudPercent > max) {
            max = cloudPercent;
            source = "Cloud Storage";
        }

        if (streamPercent > max) {
            max = streamPercent;
            source = "Video Streaming";
        }

        if (devicePercent > max) {
            max = devicePercent;
            source = "Device Usage";
        }

        StringBuilder ai = new StringBuilder();

        ai.append("🤖 EcoScore AI Assistant\n");
        ai.append("====================================\n\n");

        ai.append("EcoScore : ").append(ecoScore).append("/100\n");

        if (ecoScore >= 90)
            ai.append("Rating : 🌟 Excellent\n\n");
        else if (ecoScore >= 75)
            ai.append("Rating : ✅ Good\n\n");
        else if (ecoScore >= 50)
            ai.append("Rating : ⚠ Average\n\n");
        else
            ai.append("Rating : ❌ Poor\n\n");

        ai.append("📊 Carbon Contribution\n\n");

        ai.append(String.format("📧 Emails          : %.1f%%\n", emailPercent));
        ai.append(String.format("☁ Cloud Storage   : %.1f%%\n", cloudPercent));
        ai.append(String.format("🎬 Streaming      : %.1f%%\n", streamPercent));
        ai.append(String.format("💻 Device Usage   : %.1f%%\n\n", devicePercent));

        ai.append("🔥 Highest Carbon Source\n");
        ai.append(source).append("\n\n");

        ai.append("💡 Personalized Suggestions\n\n");

        switch (source) {

            case "Emails":
                ai.append("✔ Delete promotional emails\n");
                ai.append("✔ Compress large attachments\n");
                ai.append("✔ Unsubscribe from spam newsletters\n");
                ai.append("✔ Empty trash folder regularly\n");
                break;

            case "Cloud Storage":
                ai.append("✔ Delete duplicate files\n");
                ai.append("✔ Remove unnecessary backups\n");
                ai.append("✔ Archive old projects offline\n");
                ai.append("✔ Clean cloud storage every month\n");
                break;

            case "Video Streaming":
                ai.append("✔ Watch videos at 1080p instead of 4K\n");
                ai.append("✔ Reduce streaming hours\n");
                ai.append("✔ Turn off autoplay\n");
                ai.append("✔ Download frequently watched videos\n");
                break;

            case "Device Usage":
                ai.append("✔ Enable power saving mode\n");
                ai.append("✔ Reduce screen brightness\n");
                ai.append("✔ Shut down devices overnight\n");
                ai.append("✔ Turn off Bluetooth/Wi-Fi when unused\n");
                break;
        }

        ai.append("\n");

        double saving = total * 0.25;

        ai.append(String.format("🌱 Estimated CO₂ Saving : %.2f kg/month\n", saving));

        int futureScore = Math.min(100, ecoScore + 10);

        ai.append("⭐ Expected EcoScore : ")
                .append(futureScore)
                .append("/100\n\n");

        ai.append("💚 Green Tip of the Day\n");
        ai.append("Small digital habit changes every day can significantly reduce your yearly carbon footprint.\n\n");

        ai.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        ai.append("Thank you for choosing a greener digital lifestyle 🌍");

        return ai.toString();
    }
}