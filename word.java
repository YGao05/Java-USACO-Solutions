import java.io.*;
import java.util.ArrayList;

public class word {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("word.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        String[] firstLine = f.readLine().split(" ", 2);
        int wordCount = Integer.parseInt(firstLine[0]);
        int maxCharacter = Integer.parseInt(firstLine[1]);
        String[] wordList = f.readLine().split(" ", wordCount);
        ArrayList<String> ans = new ArrayList<>();
        ans.add("");
        int currentIndex = 0;
        for(int i=0; i<wordCount; i++){
            String temp = ans.get(currentIndex);
            //the next few lines just count how many spaces occur in the string to make sure we're only measuring the characters
            String[] tempArray = ans.get(currentIndex).split(" ");
            int spaceCount;
            if(tempArray.length==1){
                spaceCount = 0;
            }
            else{
                spaceCount = tempArray.length-1;
            }
            //this if checks if the size of the arraylist ans at the current index would exceed the character count if this word is added
            if(ans.get(currentIndex).length() + wordList[i].length() - spaceCount <= maxCharacter){
                //if this is the first word in this index
                if(ans.get(currentIndex).length() == 0){
                    ans.set(currentIndex, temp + wordList[i]);
                }
                //if this is not the first word
                else{
                    ans.set(currentIndex, temp + " " + wordList[i]);
                }
            }
            //this word cannot be added in without exceeding the character limit
            else{
                currentIndex++;
                ans.add(wordList[i]);
            }
        }
        //print out the answer
        for (String an : ans) {
            out.println(an);
        }
        out.close();
    }
}
