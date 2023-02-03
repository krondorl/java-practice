public class DogAgeCalculator {
    public static double round(double n) { return Math.round(n); }

    public static double calculateDogAge(byte age) { return 16 * Math.log(age) + 31; }

    public static void main(String[] args) {
        byte[] dogAges = new byte[]{1,5,10};

        System.out.println("Dog Age Calculator");
        System.out.println("***");

        for (byte dogAge : dogAges) {
            double calculatedAge = round(calculateDogAge(dogAge));
            System.out.println("Dog age " + dogAge + " is " + Double.toString(calculatedAge) + " years in human age.");
        }
    }
}
