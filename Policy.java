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
    private PolicyHolder policyHolder;

    // Static field to keep track of the number of Policy objects created
    private static int policyCount = 0;

    // No-arg constructor (default values)
    /**
     * No-arg constructor that initializes all fields to default values.
     */ 
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.policyHolder = new PolicyHolder();
        policyCount++;
    }

    // Constructor that accepts arguments
    /**
     * Constructor that initializes the Policy object with the provided values.
     *
     * @param policyNumber       The policy number.
     * @param providerName       The insurance provider's name.
     * @param policyHolder       The policyholder object.
     */
    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        policyCount++;
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
     * Gets the policyholder object.
     *
     * @return The policyholder object.
     */
    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    /**
     * Sets the policyholder object.
     *
     * @param policyHolder The policyholder object.
     */
    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
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
        if (policyHolder.getAge() > 50) {
            price += 75;
        }

        // Additional fee for smoking
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100;
        }

        // Additional fee for high BMI
        double bmi = policyHolder.calculateBMI();
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

        // Counters for smokers and non-smokers
        int smokerCount = 0;
        int nonSmokerCount = 0;

        // Get input from the user
        System.out.print("Enter the Policy Number: ");
        String policyNumber = scanner.nextLine();

        System.out.print("Enter the Provider Name: ");
        String providerName = scanner.nextLine();

        System.out.print("Enter the Policyholder's First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the Policyholder's Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the Policyholder's Age: ");
        int age = scanner.nextInt();

        scanner.nextLine();  // Consume newline

        System.out.print("Enter the Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();

        System.out.print("Enter the Policyholder's Height (in inches): ");
        double height = scanner.nextDouble();

        System.out.print("Enter the Policyholder's Weight (in pounds): ");
        double weight = scanner.nextDouble();

        // Create a PolicyHolder object using user input
        PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);

        // Create a Policy object using user input
        Policy policy = new Policy(policyNumber, providerName, policyHolder);

        // Update smoker/non-smoker count
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            smokerCount++;
        } else {
            nonSmokerCount++;
        }

        // Display policy details using toString method
        System.out.println("\nPolicy Details:");
        System.out.println(policy);

        // Display BMI and Insurance Price
        System.out.printf("BMI: %.2f\n", policyHolder.calculateBMI());
        System.out.printf("Insurance Price: $%.2f\n", policy.calculateInsurancePrice());

        // Display the number of Policy objects created
        System.out.println("Number of Policy objects created: " + Policy.getPolicyCount());

        // Display the number of smokers and non-smokers
        System.out.println("Number of Policyholders that are smokers: " + smokerCount);
        System.out.println("Number of Policyholders that are non-smokers: " + nonSmokerCount);

        // Close the scanner
        scanner.close();
    }

    // Static method to get the policy count
    public static int getPolicyCount() {
        return policyCount;
    }

    // toString method
    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", providerName='" + providerName + '\'' +
                ", policyHolder=" + policyHolder +
                '}';
    }
}
