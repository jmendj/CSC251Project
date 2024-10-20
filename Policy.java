import java.util.Scanner;

/**
 * The Policy class models an insurance policy with attributes
 * for the policyholder's details, and methods to calculate the
 * policyholder's BMI and insurance price.
 */ 
 

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
    /**
     * No-arg constructor that initializes all fields to default values.
     */ 


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
    
    /**
     * Constructor that initializes the Policy object with the provided values.
     *
     * @param policyNumber       The policy number.
     * @param providerName       The insurance provider's name.
     * @param policyholderFirstName  The policyholder's first name.
     * @param policyholderLastName   The policyholder's last name.
     * @param policyholderAge     The policyholder's age.
     * @param smokingStatus       The policyholder's smoking status ("smoker" or "non-smoker").
     * @param policyholderHeight  The policyholder's height in inches.
     * @param policyholderWeight  The policyholder's weight in pounds.
     */

    
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
    
     /**
     * Gets the policy number.
     *
     * @return The policy number.
     */ 

    
    public String getPolicyNumber() {
        return policyNumber;
    }
     /**
     * Sets the policy number.
     *
     * @param policyNumber The policy number.
     */


    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    
    /**
     * Gets the provider's name.
     *
     * @return The provider's name.
     */


    public String getProviderName() {
        return providerName;
    }
    
     /**
     * Sets the provider's name.
     *
     * @param providerName The provider's name.
     */


    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    /**
     * Gets the policyholder's first name.
     *
     * @return The policyholder's first name.
     */ 
 

    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }
    
    /**
     * Sets the policyholder's first name.
     *
     * @param policyholderFirstName The policyholder's first name.
     */


    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }
    
     /**
     * Gets the policyholder's last name.
     *
     * @return The policyholder's last name.
     */


    public String getPolicyholderLastName() {
        return policyholderLastName;
    }
    
     /**
     * Sets the policyholder's last name.
     *
     * @param policyholderLastName The policyholder's last name.
     */ 


    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }
    
    /**
     * Gets the policyholder's age.
     *
     * @return The policyholder's age.
     */ 


    public int getPolicyholderAge() {
        return policyholderAge;
    }
    
     /**
     * Sets the policyholder's age.
     *
     * @param policyholderAge The policyholder's age.
     */ 


    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }
    
     /**
     * Gets the smoking status of the policyholder.
     *
     * @return The smoking status ("smoker" or "non-smoker").
     */ 


    public String getSmokingStatus() {
        return smokingStatus;
    }
    
     /**
     * Sets the smoking status of the policyholder.
     *
     * @param smokingStatus The smoking status ("smoker" or "non-smoker").
     */ 
 

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }
    
     /**
     * Gets the policyholder's height in inches.
     *
     * @return The policyholder's height in inches.
     */ 


    public double getPolicyholderHeight() {
        return policyholderHeight;
    }
    
    /**
     * Sets the policyholder's height.
     *
     * @param policyholderHeight The policyholder's height in inches.
     */ 


    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }
    
    /**
     * Gets the policyholder's weight in pounds.
     *
     * @return The policyholder's weight in pounds.
     */ 


    public double getPolicyholderWeight() {
        return policyholderWeight;
    } 
    
    /**
     * Sets the policyholder's weight.
     *
     * @param policyholderWeight The policyholder's weight in pounds.
     */ 


    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }
   
    /**
     * Calculates the policyholder's Body Mass Index (BMI) based on height and weight.
     *
     * @return The calculated BMI, or 0 if height is 0.
     */


    // Method to calculate BMI
    public double calculateBMI() {
        if (policyholderHeight == 0) {
            return 0;
        }
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }
    
     /**
     * Calculates the insurance price based on the policyholder's age, smoking status, 
     * and BMI. Extra charges apply for smokers, older policyholders, and those with high BMI.
     *
     * @return The calculated insurance price.
     */ 


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
    
    
    /**
     * Main method for user input and testing the Policy class.
     *
     * @param args Command-line arguments (not used).
     */ 

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
