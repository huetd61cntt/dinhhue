package hue_61133694;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
	public class BaiDichSo {


private static ServerSocket serverSocket = null;

public static void main(String[] args) throws IOException{

// TODO code application logic here



    DataOutputStream dos = null;

    DataInputStream dis=null;

    try {

        serverSocket = new ServerSocket(8000);

        System.out.print("Server đã được mở \n" );

        Socket clientSocket = null;

        clientSocket = serverSocket.accept();

        dos=new DataOutputStream(clientSocket.getOutputStream());

        dis=new DataInputStream(clientSocket.getInputStream());

        String inline="";

        while(true)

        {

         