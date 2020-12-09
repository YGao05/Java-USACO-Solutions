import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lineup {
    static void permute(java.util.List<String> arr, int left, int right, int instructionCount, List<String> val1, List<String> val2, List<String> temp) throws IOException {
        //this if statement serves two purposes, makes sure the recursion keeps running so it can calculate all the permutations, and also runs the check method
        if (left == right && check(arr, instructionCount, val1, val2)) {
            //if this check method is correct, add that permutation into the result arraylist
            temp.add(java.util.Arrays.toString(arr.toArray()));
        }
        //this for loop is the permutation code, it uses recursion to calculate all permutations
        for (int i = left; i < arr.size(); i++) {
            java.util.Collections.swap(arr, i, left);
            permute(arr, left + 1, right, instructionCount, val1, val2, temp);
            java.util.Collections.swap(arr, left, i);

        }

    }

    //this method is used to check if the array meets the requirements given
    static boolean check(java.util.List<String> arr, int instructionCount, java.util.List<String> val1, java.util.List<String> val2) {
        for (int i = 0; i < instructionCount; i++) {
            //checks to see if the right cows are next to each other
            if (arr.indexOf(val1.get(i)) != arr.indexOf(val2.get(i)) - 1 && arr.indexOf(val1.get(i)) != arr.indexOf(val2.get(i)) + 1) {
                return false;
            }
        }
        return true;
    }

    static void print(String temp) throws IOException {
        //makes the output doc
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        //creates an array that holds the name of each of the cows in order
        //Splitting the ", " because by default Arrays.toString separates each value with a comma.
        //Also, the substring ignores the brackets at the beginning and end
        String[] answer = temp.substring(1, temp.length() - 1).split(", ");
        //prints out the array
        for (int i = 0; i < answer.length; i++) {
            out.println(answer[i]);
        }
        //finishes the program
        out.close();
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        //reading the information
        BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
        int instructionCount = Integer.parseInt(f.readLine());
        //creating 2 arrays to store pairs of information about which cow needs to be next to the other
        List<String> array1 = new ArrayList<>();
        List<String> array2 = new ArrayList<>();

        //loops through the input and reads all the requirements about the order
        for (int i = 0; i < instructionCount; i++) {
            //removes the middle text
            String[] temp = f.readLine().split(" must be milked beside ", 2);
            //puts the first cow in the pair in array1 and the second part of the pair at the same index in array2
            array1.add(temp[0]);
            array2.add(temp[1]);
        }
        //the ans arraylist stores all the names of the cows in their original alphabetical order
        List<String> ans = new ArrayList<>();
        ans.add("Beatrice");
        ans.add("Belinda");
        ans.add("Bella");
        ans.add("Bessie");
        ans.add("Betsy");
        ans.add("Blue");
        ans.add("Buttercup");
        ans.add("Sue");
        //this stores all the possible answers that meet the requirements in the permutation method
        ArrayList<String> result = new ArrayList<>();
        //runs the permutation method
        lineup.permute(ans, 0, ans.size(), instructionCount, array1, array2, result);
        //sorts all the possible answers in the result arraylist to find the list that is the most alphabetically earliest
        Collections.sort(result);
        //runs the print method and prints the answer
        print(result.get(0));
    }
}
