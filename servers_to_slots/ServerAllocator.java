import java.util.*;
import java.io.*;

/**
* This class gets
*/
public class ServerAllocator{

    public int number_rows;
    public int number_slots;
    public int number_pools;
    public int unavailable_slots;
    public int number_servers;
    public int[][] layout;

    public static final int UNAVAILABLE = -1;
    public static final int AVAILABLE = 0;

    public ArrayList<Server> server_list;

    /**
    *
    */
    public ServerAllocator(int number_rows, int number_slots){
        this.number_rows = number_rows;
        this.number_slots = number_slots;
        this.layout = new int[number_rows][number_slots];
        this.ArrayList<Server> = new ArrayList<Server>();
    }

    

    public static void main(String[] args){




    }
}
