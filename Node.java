public class Node {
  
  private String value;
  private int nextIndex;

  public Node(String val){
    value = val;
    nextIndex = -1;
  }

  public void setLink(int index) {
    nextIndex = index;
  }

  public int getLink(){
    return nextIndex;
  }

  public String getVal() {
    return value;
  }
}