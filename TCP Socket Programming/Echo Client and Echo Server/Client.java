import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        String ip = "localhost";
        int port = 9999;
        Socket socket = new Socket(ip, port);

        do {

            System.out.print("\nEnter the Message:");
            str = sc.nextLine();

            OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(str);
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            str = br.readLine();
            System.out.println("SERVER REPLY:" + str);

        } while (!str.equals("bye"));

        System.out.println("Connection Terminated");
    }
}