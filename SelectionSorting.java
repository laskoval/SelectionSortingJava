//Programmer Lidia Laskova
//Last edit date is 4/28/2022
//The purpose of the program is to read data from the file, sort data and display afer
//Input that you can use is 
//19Numbers.txt
//100Numbers.txt
//1000Numbers.txt
//10000Numbers.txt
package selectionsorting;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SelectionSorting {

private static Scanner input;
private static int[] numbers;

//Main method
public static void main(String[] args) throws FileNotFoundException {
        
  //Call a method to open a file
 openFile();
 //Call a method for selection sort
selectionSort(numbers);

}

//Method to open a file and read a data from there
public static void openFile() throws FileNotFoundException{

//Declare local variables
 int validScore=0;
 int i=0;
 int counter = 0;

 // Declare scanner
 Scanner Input = new Scanner (System.in);

 // Ask a user to enter the name of file
 System.out.print("Please enter name of the file: ");

 // The answer of the user uses to search and find it
 Path fileName = Paths.get(Input.nextLine());

 // A try/catch statement to open a file, if it's not possible, it will catch an error 
try {
input = new Scanner(fileName.getFileName());    //Opening file
} 
catch (IOException ioException)
{

System.err.println("Error opening file. Terminating.");
System.exit(1);

}

// Call a method for invalid data which should be sent to an error file with an appropriate error message
errorFile();

// While loop to go through file and read data
        while (input.hasNext()){
//Try/Catch statement if it's problems with reading data then display an error message
          try{

            i = input.nextInt();
            // If statement in order to check if a number is in the range of 1 - 1000, and then if it is true
            // Then put it into array one more time but now without invalid score
              if (i >= 1 & i <= 1000){
              validScore++;
              }
              else {

                    System.err.print(i + " ");
                }
            } 
          catch (NoSuchElementException e) {

               System.out.println("Invlaid file formating. Terminating");
               System.exit(1);
            }       
        }


 // Set a value to number array but with only valid score
        numbers = new int[validScore];

  // Close a file
        closeFile();

  // Try/catch statements to open file again

        try {
          input = new Scanner(fileName.getFileName());
        } 
        catch (IOException ioException){
        System.err.println("Error opening file. Terminating.");
        System.exit(1);
        }

        // While loop to go through file and read data
        while (input.hasNext()){

            i = input.nextInt();
            // If statement in order to check if a number is in the range of 1 - 1000, and then if it is true
            // Then put it into array one more time but now without invalid score
            if (i >= 1 & i <= 1000){
                    numbers[counter]=i;
                    counter++;
            }
        }
}
//Method for invalid data which should be sent to an error file with an appropriate error message
public static void errorFile () throws FileNotFoundException{

    // Sets what type of print to redirect
    PrintStream notValid = System.err;

    // Create new file
    File file = new File("There is some error in the file for Selection Sort. ");

    // Create stream for output to file created
    FileOutputStream output = new FileOutputStream(file);

    // Print to stream to file created
    PrintStream smth = new PrintStream(output);

    // Set what is being printed to .Err types
    System.setErr(smth);

    // Tell a user which numbers were invalid
    System.err.print("The invalid numbers are: ");
        
    }

//Close a file
 public static void closeFile(){
      if (input != null){
            input.close();
      }
    }
            
        
   //Method for sorting
public static void selectionSort(int[] array){ 
        //Declare local vriables
        int comparison = 0;

        // For loop to go through all of array length
        for (int i = 0; i < array.length - 1; i++) {  
            int index = i;  

            // For loop to go through each array element
            for (int j = i + 1; j < array.length; j++){ 

                // If the first number is smaller than next then assign it to the smallest
                if (array[j] < array[index]){  
                    index = j;
                }  
                comparison = comparison +1;
            }  


            // It finds smaller number and updates a value 
            int smallerNumber = array[index];   
            array[index] = array[i];  
            array[i] = smallerNumber;  
            
        }

        // Print an updated sorted array using loop
        for(int i:array){  
            System.out.printf(i+" ");  
        }
       
        System.out.println("");
        System.out.println("Number of comparisons is " + comparison);  // Print number of comparisons 
    }
}



 


