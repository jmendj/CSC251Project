import java.util.Scanner;

public class Policy {
    // Fields (attributes)
    private String policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double policyholderHeight; // in inches
    private double policyholderWeight; // in pounds

    // No-arg constructor (default values)
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.policyholderFirstName = "";
        this.policyholderLastName = "";
        this.policyholderAge = 0;
        this.smokingStatus = "non-smoker";
        this.policyholderHeight = 0;
        this.policyholderWeight = 0;
    }

    // Constructor that accepts arguments
    public Policy(String policyNumber, String providerName, String policyholderFirstName,
                  String policyholderLastName, int policyholderAge, String smokingStatus,
                  double policyholderHeight, double policyholderWeight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.smokingStatus = smokingStatus;
        this.policyholderHeight = policyholderHeight;
        this.policyholderWeight = policyholderWeight;
    }

    // Getters and setters (accessors and mutators)
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    public int getPolicyholderAge() {
        return policyholderAge;
    }

    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }

    public double getPolicyholderWeight() {
        return policyholderWeight;
    }

    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }

    // Method to calculate BMI
    public double calculateBMI() {
        if (policyholderHeight == 0) {
            return 0;
        }
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    // Method to calculate the insurance price
    public double calculateInsurancePrice() {
        double price = 600; // Base fee

        // Additional fee for age
        if (policyholderAge > 50) {
            price += 75;
        }

        // Additional fee for smoking
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100;
        }

        // Additional fee for high BMI
        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }

    // Main method for user input and testing the Policy class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the Policy Number: ");
        String policyNumber = scanner.nextLine();

        System.out.print("Enter the Provider Name: ");
        String providerName = scanner.nextLine();

        System.out.print("Enter the Policyholder's First Name: ");
        String policyholderFirstName = scanner.nextLine();

        System.out.print("Enter the Policyholder's Last Name: ");
        String policyholderLastName = scanner.nextLine();

        System.out.print("Enter the Policyholder's Age: ");
        int policyholderAge = scanner.nextInt();

        scanner.nextLine();  // Consume newline

        System.out.print("Enter the Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();

        System.out.print("Enter the Policyholder's Height (in inches): ");
        double policyholderHeight = scanner.nextDouble();

        System.out.print("Enter the Policyholder's Weight (in pounds): ");
        double policyholderWeight = scanner.nextDouble();

        // Create a Policy object using user input
        Policy policy = new Policy(policyNumber, providerName, policyholderFirstName, policyholderLastName, 
                                   policyholderAge, smokingStatus, policyholderHeight, policyholderWeight);

        // Display policy details
        System.out.println("\nPolicy Details:");
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder Name: " + policy.getPolicyholderFirstName() + " " + policy.getPolicyholderLastName());
        System.out.println("Age: " + policy.getPolicyholderAge());
        System.out.println("Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Height: " + policy.getPolicyholderHeight() + " inches");
        System.out.println("Weight: " + policy.getPolicyholderWeight() + " pounds");

        // Display BMI and Insurance Price
        System.out.printf("BMI: %.2f\n", policy.calculateBMI());
        System.out.printf("Insurance Price: $%.2f\n", policy.calculateInsurancePrice());

        // Close the scanner
        scanner.close();
    }
}
