import java.util.*;
import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = new String();
        int port = 9999;
        String ip = "localhost";
        Socket socket = new Socket(ip, port);

        System.out.println("Enter the file name:");
        fileName = sc.nextLine();

        OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
        PrintWriter out = new PrintWriter(os);
        out.println(fileName);
        os.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String fileLine;
        System.out.println("\nCONTENTS OF " + fileName + ":");
        while ((fileLine = br.readLine()) != null) {
            System.out.println(fileLine);
        }
        System.out.println("Connection Terminated");
    }
}