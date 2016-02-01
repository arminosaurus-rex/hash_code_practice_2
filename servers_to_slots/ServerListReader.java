import java.io.*;
import java.util.*;

public class ServerListReader{

  public Scanner filescanner;
  public String filename;

  public int R;
  public int S;
  public int U;
  public int P;
  public int M;

    public ServerListReader(String filename){
    this.filename = filename;
  }


    public ServerAllocator create_ServerAllocator() throws FileNotFoundException{
        filescanner = new Scanner(new FileReader(filename));
        // Read the first line
        R = filescanner.nextInt();
        S = filescanner.nextInt();
        U = filescanner.nextInt();
        P = filescanner.nextInt();
        M = filescanner.nextInt();

        ServerAllocator allocator = new ServerAllocator(R, S);

        // Read unavailable slots
        for(int i=0; i<U; i++){
            int r = filescanner.nextInt();
            int s = filescanner.nextInt();
            // Indices are zero based
            allocator.layout[r][s] = ServerAllocator.UNAVAILABLE;
        }

        // Read Servers
        for(int i=1; i<=M; i++){
            int s = filescanner.nextInt();
            int cap = filescanner.nextInt();
            allocator.server_list.add(new Server(i, s, cap));
        }

        return allocator;
      }
}