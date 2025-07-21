/* 
## Problem Statement

Create class Associate with below attributes:
id - int
name - String
technology - String
experienceInYears - int

Create class Solution and implement static method "associatesForGivenTechnology" in the Solution class.
This method will take array of Associate objects and a searchTechnology String as parameters.
And will return another array of Associate objects where the searchTechnology String matches with the original array of Associate object's technology attribute (case insensitive search) and experienceInYears attribute should be multiples of 5.

Write necessary getters and setters.

Before calling "associatesForGivenTechnology" method in the main method, read values for five associate objects referring the attributes in above sequence along with a String searchTechnology.
Then call the "associatesForGivenTechnology" method and write the logic to print the id's in the main method.

## Input

    101
    Alex
    Java
    15
    102
    Albert
    Unix
    20
    103
    Alferd
    Testing
    13
    104
    Alfa
    Java
    15
    105
    Almas
    Java
    29
    Java

## Output

    101
    104
*/

import java.util.Scanner;

public class AssociateForGivenTechnology {

    private int id;
    private String name;
    private String technology;
    private int experienceInYears;

    public AssociateForGivenTechnology(int id, String name, String technology, int experienceInYears) {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.experienceInYears = experienceInYears;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    static AssociateForGivenTechnology[] associatesForGivenTechnology(AssociateForGivenTechnology[] objs,String searchTechnology){
        int cnt=0;
        
        for (AssociateForGivenTechnology obj : objs) {
            if(obj.technology.equalsIgnoreCase(searchTechnology) && obj.experienceInYears%5==0)
                cnt++;
        }
        AssociateForGivenTechnology[] arr = new AssociateForGivenTechnology[cnt];
        int index=0;
        for (AssociateForGivenTechnology obj : objs) {
            if(obj.technology.equalsIgnoreCase(searchTechnology) && obj.experienceInYears%5==0){
                arr[index]=obj;
                index++;
            }     
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AssociateForGivenTechnology[] arr = new AssociateForGivenTechnology[5];

        for(int i=0;i<5;i++){
            int id = sc.nextInt();
            sc.nextLine(); 
            String name = sc.nextLine();
            String technology = sc.nextLine();
            int experienceInYears = sc.nextInt();

            arr[i]= new AssociateForGivenTechnology(id, name, technology, experienceInYears);
            sc.nextLine();
        }
        String searchTechnology = sc.nextLine();

        AssociateForGivenTechnology[] ans = AssociateForGivenTechnology.associatesForGivenTechnology(arr, searchTechnology);

        for (AssociateForGivenTechnology obj : ans) {
            System.out.println(obj.id);
        }
    }
}