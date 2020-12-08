
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class gymnastics {
    public static void main(String[] args) throws IOException {
        //reading in the information given in the input
        BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        String[] firstLine = f.readLine().split(" ", 2);
        int columnCount = Integer.parseInt(firstLine[0]) ;
        int cowCount = Integer.parseInt(firstLine[1]) ;
        //creating a matrix (2d array) to store all the information given
        int[][] data = new int[columnCount][cowCount];
        for(int i=0; i< columnCount; i++){
            String[] currentLine = f.readLine().split(" ", cowCount);
            for(int j=0; j<cowCount;j++){
                data[i][j] = Integer.parseInt(currentLine[j]);
            }
        }
        //this ansCount is what's going to keep track of the amount of pairs there are
        int ansCount = 0;
            //this first for loop uses j as the first number in the pair
            for(int j = cowCount; j>0; j--){
            //this second for loop uses z as the second number in the pair
                for(int z=cowCount; z>0; z--){
                    boolean check1 = true;
                    //this third for loop is used to check if one number is before the other in all of the other columns
                    for(int i=0; i<columnCount;i++) {
                        if (!compareOrder(data, j, z, i, cowCount)) {
                            //if in one column, the first number is not before the second, the boolean value is set as false and the for loop is exited
                            check1 = false;
                            break;
                        }
                    }
                    //if the check is proven to be true for all of the columns, then that means the two cows are a pair and the ansCount increases by one
                    if(check1){
                        ansCount++;
                    }
                }
            }
        //finally, print out the answer
        out.println(ansCount);
        out.close();
    }
    //this method checks if the first number is before the other in the "data" matrix
    static boolean compareOrder(int[][] data, int cow1, int cow2, int columnCount, int cowCount){
        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<cowCount;i++){
            temp.add(data[columnCount][i]);
        }
        return temp.indexOf(cow1) < temp.indexOf(cow2);
    }
}
