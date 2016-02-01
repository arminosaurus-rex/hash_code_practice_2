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
        this.server_list = new ArrayList<Server>();
    }


    /**
     *
     * @return
     */
    public ArrayList<Server> greedyAllocation(){
        int[] capacity = new int[number_rows];

        // Sort by decreasing capacity per slots
        Collections.sort(server_list);
        for(Server serv: server_list){
            //find row with minimum capacity
            ArrayList<RowCapacity> roworder = new ArrayList<RowCapacity>();
            for(int i=0; i<number_rows; i++){
                roworder.add(new RowCapacity(capacity[i], i));
            }

            Collections.sort(roworder);

            bool placed = false;
            // Check whether we can place the server in
            for(RowCapacity rc: roworder) {
                for (int i = 0; i < number_rows; i++) {
                    if (can_place(serv, rc.row, i)) {
                        place(serv, rc.row, i);
                        capacity[rc.row] += rc.capacity;
                        placed = true;
                        break;
                    }
                }
                if (placed) break;
            }
        }
    }

    public boolean can_place(Server serv, int row, int left_pos){
        int slots = serv.slots;

        if(left_pos < 0) return false;
        if(left_pos + slots >= number_slots) return false;

        if(row < 0) return false;
        if(row >= number_rows) return false;

        for(int i=0; i<slots; i++){
            if(layout[row][left_pos + i] != AVAILABLE) return false;
        }

        return true;
    }

    public boolean place(Server serv, int row, int left_pos){
        if(!can_place(serv, row, left_pos)) return false;
        for(int i=0; i<slots; i++){
            layout[row][left_pos+i] = serv.id;
        }
        return true;
    }




    class RowCapacity implements Comparable<RowCapacity>{

        public int capacity;
        public int row;

        public RowCapacity(int capacity, int row){
            this.capacity = capacity;
            this.row = row;
        }

        @Override
        public int compareTo(RowCapacity rc){
            return Integer.compareTo(capacity, rc.capacity);
        }
    }



    public static void main(String[] args){




    }
}
