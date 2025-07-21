import java.util.Scanner;

/*
Problem Statement

Create a class AutonomousCar with the below attributes:
- carId – int
- brand – String
- noOfTestsConducted – int
- noOfTestsPassed – int
- environment – String
- grade – String

Write getters, setters for the above attributes.
Create constructor which takes parameters in the above sequence except grade.

Create class Solution with main method.
Implement two static methods – findTestPassedByEnv and updateCarGrade in Solution class.

findTestPassedByEnv method:
- This method will take two input parameters:
    - array of AutonomousCar objects
    - string parameter environment
- The method will return the sum of the noOfTestsPassed attribute from AutonomousCar objects
  for the environment passed as parameter.
- If no AutonomousCar with the given environment is present in the array,
  then the method should return 0.

updateCarGrade method:
- This method will take a String parameter brand, along with the array of AutonomousCar objects.
- The method will return the AutonomousCar object, if the input String parameter matches with
  the brand attribute of the AutonomousCar object.
- Before returning the object, the grade should be derived based on the rating calculation mentioned below.
- This grade value should be assigned to the object.
- If any of the above conditions are not met, then the method should return null.
- The grade attribute should be calculated as follows:
    - rating = (noOfTestsPassed * 100) / noOfTestsConducted
    - If the rating >= 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.

The above mentioned static methods should be called from the main method.

For findTestPassedByEnv method:
- The main method should print the totalTestPassed as it is, if the returned value is greater than 0,
  or it should print “There are no tests passed in this particular environment”.

For updateCarGrade method:
- The main method should print the brand and grade of the returned AutonomousCar object.
- The brand and grade should be concatenated with :: while printing.
  eg: Tesla::A1, where Tesla is the brand and A1 is the grade.
- If the returned value is null then it should print “No Car is available with the specified brand”.

Before calling these static methods in main, use Scanner object to read the values of four AutonomousCar objects
(referring attributes in the above mentioned attribute sequence, except grade attribute).
Next, read the value for environment and brand.

Input Example:
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez

Output Example:
1900
Mercedez::B2
*/




public class AutonomousCar {
    private int carId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestsPassed;
    private String environment;
    private String grade;

    
    public AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
        this.carId = carId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }

    
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfTestsConducted() {
        return noOfTestsConducted;
    }

    public void setNoOfTestsConducted(int noOfTestsConducted) {
        this.noOfTestsConducted = noOfTestsConducted;
    }

    public int getNoOfTestsPassed() {
        return noOfTestsPassed;
    }

    public void setNoOfTestsPassed(int noOfTestsPassed) {
        this.noOfTestsPassed = noOfTestsPassed;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    static int findTestPassedByEnv(AutonomousCar[] objs, String environment){
        int ans = 0;
        for (AutonomousCar obj : objs) {
            if(obj.getEnvironment().equalsIgnoreCase(environment)){
                ans += obj.getNoOfTestsPassed();
            }
        }
        return ans;
    }
    static AutonomousCar updateCarGrade(String brand,AutonomousCar[] objs){
       
        for (AutonomousCar obj : objs) {
            if(obj.getBrand().equalsIgnoreCase(brand)){
                int rating = (obj.noOfTestsPassed*100)/obj.noOfTestsConducted;
                String grade = rating >= 80 ? "A1":"B2";
                obj.setGrade(grade);
                return obj;
            }
        }
        return null;
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AutonomousCar[] cars = new AutonomousCar[4];
    for (int i = 0; i < 4; i++) {
        int carId = Integer.parseInt(sc.nextLine());
        String brand = sc.nextLine();
        int noOfTestsConducted = Integer.parseInt(sc.nextLine());
        int noOfTestsPassed = Integer.parseInt(sc.nextLine());
        String environment = sc.nextLine();
        cars[i] = new AutonomousCar(carId, brand, noOfTestsConducted, noOfTestsPassed, environment);
    }
    String env = sc.nextLine();
    String brand = sc.nextLine();

    int totalTestPassed = findTestPassedByEnv(cars, env);
    if (totalTestPassed > 0) {
        System.out.println(totalTestPassed);
    } else {
        System.out.println("There are no tests passed in this particular environment");
    }

    AutonomousCar car = updateCarGrade(brand, cars);
    if (car != null) {
        System.out.println(car.getBrand() + "::" + car.getGrade());
    } else {
        System.out.println("No Car is available with the specified brand");
    }
    sc.close();
}


}
