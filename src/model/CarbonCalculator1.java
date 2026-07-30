package model;

public class CarbonCalculator1 {

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