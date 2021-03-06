import java.io.*;

public class Assign5 {
  public static void main(String[] args) {
    if (args.length != 2) {
      //This is the format the program should be used in
      System.out.println("Usage: java Assign4 <input> <output>");
      System.exit(0);
    }

    //initializing the data members that are used in this test
    String inputfile = args[0].toLowerCase();
    String output1 = args[1].toLowerCase();
    //These are the printwritters and the IO classes used
    PrintWriter printWriter1 = null;
    BufferedReader bufferedreader = null;

    try{
      //This try block will attempt to read from the file line by line
      FileOutputStream file1 = new FileOutputStream(output1);
      FileReader input = new FileReader(inputfile);
      bufferedreader = new BufferedReader(input);
      printWriter1 = new PrintWriter(file1);

      //while loop that will traverse through the text file
      String lineCombined = "";
      String line;
      int count = 0;
      //Creating String arrays to keep all the data
      //Runs while the input file has more lines to read
      while((line = bufferedreader.readLine()) != null) {
        //This is for the actual matrix
        lineCombined += line;
        lineCombined += "\n";
        count++;
      }
      String[] allTheWords = lineCombined.split("\n");
      //Multiplying the count by 1.4 to initalize more space for the hash table
      count *= 1.4;
      Linear hashTable = new Linear(count);
      for(int i = 0; i < allTheWords.length; i ++){
        hashTable.insert(allTheWords[i]);
      }

      hashTable.print(printWriter1);

      for(int i = 0; i < allTheWords.length; i ++){
        hashTable.search(allTheWords[i]);
      }
      System.out.println(Linear.searchCounter);
      System.out.println(Linear.totalNumberOfReads);

      printWriter1.close();
    }
    //This is how we catch the errors
    catch (IOException e) {
      e.getMessage();
    }
  }
}