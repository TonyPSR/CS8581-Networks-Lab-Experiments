import java.util.*;
import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args) throws Exception {
        String fileName = new String();
        int port = 9999;
        String fileLine = new String();

        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Client Connected\n");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        fileName = br.readLine();
        System.out.println("RECEIVED FILENAME: " + fileName);

        OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
        PrintWriter out = new PrintWriter(os);

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while ((fileLine = fileReader.readLine()) != null) {
            out.println(fileLine);
            os.flush();
        }
        System.out.println("Connection Terminated");
    }
}