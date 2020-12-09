import java.io.*;

public class whereami {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        int totalCount = Integer.parseInt(f.readLine());
        String letterList = f.readLine();
        //for loop that goes over each possible length variation
        for(int i=0; i<totalCount;i++){
            boolean check = true;
            //for loop that goes over each start point
            for(int j=0; j<totalCount;j++){
                //this is to make sure there is no out of bounds error when making the substring
                if(j+1+i <= totalCount){
                    String temp = letterList.substring(j, j+i+1);
                    //this if statement checks if this substring is ever repeated in the string
                    if(letterList.indexOf(temp) != letterList.lastIndexOf(temp)){
                        //if this substring repeats, then the check is false and exit to the next length
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                //this is +1 because i originally starts at 0, needs to add 1 to get to the real length
                out.println(i+1);
                out.close();
                System.exit(0);
            }
        }
    }
}
