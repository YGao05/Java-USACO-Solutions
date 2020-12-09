import java.io.*;

public class digits {
    public static void main(String[] args) throws IOException {
        //this is DEFINITELY NOT the most efficient way of writing the code (probably one of the worst ways)
        //But, brute forcing this problem was really easy to write and saved me a lot of time
        BufferedReader f = new BufferedReader(new FileReader("digits.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("digits.out")));
        //all the basic reading information, etc
        String baseTwo = f.readLine();
        String baseThree = f.readLine();
        //basically this code just tries every single possible variation until one of them match
        //this is slow and ineffective, but given the parameters of this problem it will always 100% work
        for (int i = 0; i < baseTwo.length(); i++) {
            //the answer in base 2
            String ansTwo;
            //the answer in base 3
            String ansThree;
            //turning both these into char arrays to make it easier to work with
            char[] tempTwo = baseTwo.toCharArray();
            char[] tempThree = baseThree.toCharArray();
            //for the base two number the character is always either 0 or 1, so we just switch the number and try
            if (tempTwo[i] == '0') {
                tempTwo[i] = '1';
            } else {
                tempTwo[i] = '0';
            }
            //these for loops have the same concept, but since there are 3 possibilities it's just a bit longer
            for (int j = 0; j < baseThree.length(); j++) {
                //could've written a method for everything, but I was too lazy and inexperienced at java back when I did this
                if (tempThree[j] == '0') {
                    //if the number is 0, try replacing it with 1
                    tempThree[j] = '1';
                    ansTwo = String.valueOf(tempTwo);
                    ansThree = String.valueOf(tempThree);
                    //if the numbers are the same, then this is the answer and finish the program
                    if (Integer.parseInt(ansTwo, 2) == Integer.parseInt(ansThree, 3)) {
                        out.print(Integer.parseInt(ansTwo, 2));
                        out.close();
                    }
                    //if the number is 0 and 1 doesn't work, try replacing it with 2
                    tempThree[j] = '2';
                    ansThree = String.valueOf(tempThree);
                    if (Integer.parseInt(ansTwo, 2) == Integer.parseInt(ansThree, 3)) {
                        out.print(Integer.parseInt(ansTwo, 2));
                        out.close();
                    }
                }
                //the rest of the code is just me copy and pasting the last bit while changing a few numbers
                else if (tempThree[j] == '1') {
                    tempThree[j] = '0';
                    ansTwo = String.valueOf(tempTwo);
                    ansThree = String.valueOf(tempThree);
                    if (Integer.parseInt(ansTwo, 2) == Integer.parseInt(ansThree, 3)) {
                        out.print(Integer.parseInt(ansTwo, 2));
                        out.close();
                    }
                    tempThree[j] = '2';
                    ansThree = String.valueOf(tempThree);
                    if (Integer.parseInt(ansTwo, 2) == Integer.parseInt(ansThree, 3)) {
                        out.print(Integer.parseInt(ansTwo, 2));
                        out.close();
                    }
                } else {
                    tempThree[j] = '0';
                    ansTwo = String.valueOf(tempTwo);
                    ansThree = String.valueOf(tempThree);
                    if (Integer.parseInt(ansTwo, 2) == Integer.parseInt(ansThree, 3)) {
                        out.print(Integer.parseInt(ansTwo, 2));
                        out.close();
                    }
                    tempThree[j] = '1';
                    ansThree = String.valueOf(tempThree);
                    if (Integer.parseInt(ansTwo, 2) == Integer.parseInt(ansThree, 3)) {
                        out.print(Integer.parseInt(ansTwo, 2));
                        out.close();
                    }
                }
            }
        }
    }
}
