// A Java program for a Client
import java.io.*;
import java.net.*;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private BufferedReader input = null;
    private DataInputStream serverReturn = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port
    public Client(String address, int port)
    {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new BufferedReader(new InputStreamReader(System.in));

            // sends output to the socket
            out = new DataOutputStream(
                    socket.getOutputStream());

            serverReturn = new DataInputStream(socket.getInputStream());
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }

        // string to read message from input
        String inputLine = "";
        String returnLine;

        // keep reading until "Over" is input
        while (!inputLine.equals("Over")) {
            try {
                inputLine = input.readLine();
                out.writeUTF(inputLine);
                returnLine = serverReturn.readUTF();
                System.out.println(returnLine);
            }
            catch (IOException i) {
                System.out.println(i);
            }
        }

        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 6000);
    }
}