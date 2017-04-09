import java.io.*;

public class Linear {
  private int currentSize, maxSize;
  public static int highestCount = 0;
  public static int searchCounter = 0;
  public static int c = 0;
  
  private Node[] nodes;
  
  public Linear (int c) {
    currentSize = 0;
    maxSize = c;
    nodes = new Node[c];
  }
  
  public int getSize() {
    return this.currentSize;
  }
  
  private int hash(String key) {
    int length = key.length();
    char[] eachChar = new char[length];
    for (int i = 0; i < length ; i++) {
      eachChar[i] = new Character(key.charAt(i));
    }
    int returnInt = 0;
    for(int i = 0; i < eachChar.length - 1; i++){
      int temp = Character.getNumericValue(eachChar[i]);
      returnInt = (temp + (128*returnInt));
      returnInt %= maxSize;
    }
    return returnInt;
  }
  
  public void insert (String key) {
    int temp = hash(key);
    int counter = 0; 

    if(nodes[temp] == null) {
      nodes[temp] = new Node(key);
      return;
    }
    else{
      int previousTemp = temp;
      System.out.println("original hash " + temp);
      while(nodes[temp].getLink() != -1){
        System.out.println("link " + nodes[temp].getLink());
        counter ++;
        temp = nodes[temp].getLink();
        previousTemp = temp;
      }
      while(nodes[temp] != null){
        counter++;
        if(temp == 0) {
          temp = maxSize;
        }
        temp --;
      }
      if(counter > highestCount){
        highestCount = counter;
      }
      System.out.println(previousTemp);
      System.out.println(temp);
      nodes[temp] = new Node(key);
      nodes[previousTemp].setLink(temp);
      System.out.println("");
    }
  }

  public void search(String searchKey) {
    int counter = 0;
    int temp = this.hash(searchKey);
    // while(!(nodes[temp].getVal().equals(searchKey))){
    //   if(nodes[temp].getLink() == -1){
    //   }
    // }
    if(counter > searchCounter) {
      searchCounter = counter;
    }
  }

  public void print(PrintWriter printer){
    for(int i = 0; i < maxSize; i++){
      if(nodes[i] != null) {
        if(nodes[i].getLink() != -1){
          printer.write(nodes[nodes[i].getLink()].getVal() + " df ");
        }
        printer.write(nodes[i].getVal() + "\n");
      }
    }
  }
}

  // public void remove(String key)
  // {
  //   if(!contains(key))
  //   {
  //     return;
  //   }
  //   int i=hash(key);
  //   while(!key.equals(key[i])) {
  //     i=(i+1)%maxSize;
  //   }
  //   key[i]=val[i]=null;
  //   for(i=(i+1)% maxSize; keys[i]!=null; i=(i+1)%maxSize)
  //   {
  //     String tmp1=keys[i],temp2=vals[i];
  //     keys[i]=vals[i]=null;
  //     currentSize--;
  //     insert(tmp1,temp2);
  //   }
  //   currentSize--;
  // }