public class Linear {
  private int currentSize, maxSize;
  
  private Node[] nodes;
  
  Linear (int c) {
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
      returnInt += Character.getNumericValue(eachChar[i]);
    }
    returnInt = returnInt%maxSize;
    return returnInt;
  }
  
  public void insert (String key) {
    int temp = hash(key);
    
    int i = temp; 

    if(nodes[temp] == null) {
      nodes[temp] = new Node(key);
      return;
    }
    else{
      int previousTemp = -1;
      while(nodes[temp].getLink() != -1){
        previousTemp = temp;
        temp = nodes[temp].getLink();
      }
      while(nodes[temp] != null){
        temp -= 1;
      }
      nodes[temp] = new Node(key);
      nodes[previousTemp].setLink(temp);
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