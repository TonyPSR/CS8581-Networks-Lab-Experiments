import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int port = 9999;
        String str = new String();
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Client Connected\n");

        do {

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            str = br.readLine();

            System.out.println("CLIENT REPLY:" + str);

            System.out.print("ENTER SERVER MESSAGE:");
            str = sc.nextLine();

            OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(str);
            os.flush();

        } while (!str.equals("bye"));

        System.out.println("Connection Terminated");
    }
}