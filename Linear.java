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
    char[] eachChar = key.split("(?!^)");
    int returnInt = 0;
    for(int i = 0; i < eachChar.length - 1; i++){
      returnInt += Character.getNumbericValue(eachChar[i]);
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
      while(nodes[temp].getLink() != -1){
        temp = nodes[temp].getLink();
      }
      
    }
    
    do{
      if (keys[i] == null) {
        keys[i] = key;
        vals[i] = val;
        currentSize++;
        return;
      }
      if (keys[i].equals(key)) {
        vals[i] = val;
        return;
      }
      i = (i + 1) %maxSize;
      
    }while(i != temp);
  }


  public boolean contains(String key)
  {
    return get(key)!=null;
  }

  public void remove(String key)
  {
    if(!contains(key))
    {
      return;
    }
    int i=hash(key);
    while(!key.equals(key[i]))
      i=(i+1)%maxSize;
    key[i]=val[i]=null
    for(i=(i+1)% maxSize; keys[i]!=null; i=(i+1)%maxSize)
    {
      String tmp1=keys[i],temp2=vals[i];
      keys[i]=vals[i]=null;
      currentSize--;
      insert(tmp1,temp2);
    }
    currentSize--;
  }