
public class Server implements Comparable<Server>{

  public int id;
  public int slots;
  public int capacity;
  public int row;
  public int left_col;
  public static final int UNSET = -1;


  public Server(int id, int slots, int capacity, int row, int left_col){
    this.id = id;
    this.slots = slots;
    this.capacity = capacity;
    this.row = row;
    this.left_col = left_col;
  }

  public Server(int id, int slots, int capacity){
    this(id, slots, capacity, UNSET, UNSET);
  }

  @Override
  public int compareTo(Server s){
    // compareTo should return < 0 if this is supposed to be
    // less than other, > 0 if this is supposed to be greater than
    // other and 0 if they are supposed to be equal
    int e1 = capacity * s.slots;
    int e2 = s.capacity * slots;
    if(e1 > e2) return -1; // This slot is more efficient
    if(e1 == e2) return 0;
    else return 1;
  }
}
