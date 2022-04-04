package hue_61133694;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class BaiDichSo {
 
    public final static int SERVER_PORT = 9;
 
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client accepted: " + socket);
 
                    OutputStream os = socket.getOutputStream();
                    InputStream is = socket.getInputStream();
                    int ch = 0;
                    while (true) {
                        ch = is.read(); // Receive data from client
                        if (ch == -1) {
                            break;
                        }
                        os.write(ch); // Send the results to client
