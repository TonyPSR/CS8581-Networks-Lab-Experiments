import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws Exception {
        int port = 9999;
        String str = new String();
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Client Connected\n");

        do {

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            str = br.readLine();

            OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(str);
            os.flush();

        } while (!str.equals("bye"));

        System.out.println("Connection Terminated");
    }
}