package Network;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
 
public class Server {

    ArrayList<PrintWriter> clientList; // ������ Ŭ���̾�Ʈ�� �����Ҽ� �ִ� ����Ʈ

    public static void main(String[] args) {

        new Server().startServer();
        
    }//main

  
    //---------------------------------------------------------------------------------
    // ���� : ���������� ������ �� Ŭ���̾�Ʈ�κ��� ���ӹ��� �غ� �Ѵ�, Ŭ���̾�Ʈ�� �����ϸ� Ŭ���̾�Ʈ ����Ʈ�� �ְ� �����带 �����Ѵ�.
    //---------------------------------------------------------------------------------
    public void startServer(){

        clientList = new ArrayList<PrintWriter>();

        ServerSocket serverSocket;

        try{

            serverSocket = new ServerSocket(5000); // port 5000���� ������ �� �ִ� �������� ����
            System.out.println("������ �����Ǿ����ϴ�.");
            
        while(true){ // ������ ��� ���� �� �ֵ��� ���ѷ���

            Socket socket = serverSocket.accept(); 
            OutputStream os = socket.getOutputStream(); 
            PrintWriter writer = new PrintWriter(os); 
            clientList.add(writer); // Ŭ���̾�Ʈ ����Ʈ�� �߰�

            Thread thread = new Thread(new ClientHandler(socket, writer)); // ������ ����

            thread.start(); // ������ ����

            System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]�� �����߽��ϴ�."); 	// ������ Ŭ���̾�Ʈ�� IP�� ��Ʈ�� ���
            System.out.println("�� �ο��� "+ clientList.size() +"�� �Դϴ�."); 							// ���� ������ ������ �ο����� ���

        }//while

        }catch(Exception e){

            e.printStackTrace();

        }//try catch

    }

   
    //---------------------------------------------------------------------------------
    // ���� : �����带 ����� �� �ֵ��� Runnable �������̽��� �����, �� Ŭ���̾�Ʈ�� ������� �ٷ��.
    //---------------------------------------------------------------------------------
    public class ClientHandler implements Runnable{

        Socket socket;
        BufferedReader reader;
        PrintWriter pw;
        InputStreamReader isReader;
        String message;
        
        public ClientHandler(Socket socket, PrintWriter pw){

            try{

            this.socket = socket;
            this.pw = pw;
            isReader = new InputStreamReader(this.socket.getInputStream());
            reader = new BufferedReader(isReader);

            }catch(Exception e){

                e.printStackTrace();

            }//try catch

        }

        // �����尡 �����ϸ� ����Ǵ� �κ�
        public void run() {

            try{

            	// Ŭ���̾�Ʈ�κ��� �Է��� �޾Ƽ� ó���ϴ� �κ�
                while((message = reader.readLine()) != null){//�Է��� ����

                	//Ŭ���̾�Ʈ�� 'bye'�� �Է��ϸ� ä���� �����ϰ� ������ ó��
                    if(message.substring(0, 3).equals("bye")){

                        clientList.remove(this.pw); // Ŭ���̾�Ʈ ����Ʈ���� ����

                        tell("["+socket.getInetAddress()+":"+socket.getPort()+"]�� �����߽��ϴ�.");
                        System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]�� �����߽��ϴ�.");
                        System.out.println("�� �ο��� "+ clientList.size() +"�� �Դϴ�.");

                    }
                    //Ŭ���̾�Ʈ�� 'bye'�� �Է����� ������� �ٸ� Ŭ���̾�Ʈ�鿡�� ä���Ѵٰ� ó��
                    else{

                        tell("["+socket.getInetAddress()+":"+socket.getPort()+"] : " + message);
                        System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"] : " + message);

                    }//if else

                }//while

            }catch(Exception e){

                e.printStackTrace();

            }//try catch

        }//run

    }//ClientHandler

    //---------------------------------------------------------------------------------
    // ���� : Ŭ���̾�Ʈ ����Ʈ�� ���Ե� Ŭ���̾�Ʈ�鿡�� ä�� ������ ����
    //---------------------------------------------------------------------------------
    public void tell(String message){

        Iterator<PrintWriter> it = clientList.iterator();

        while(it.hasNext()){

            try {

                PrintWriter writer = (PrintWriter)it.next();
                writer.println(message);
                writer.flush();

            } catch (Exception e) {

                e.printStackTrace();

            }//try catch

        }//while

    }//tell

}