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

    ArrayList<PrintWriter> clientList; // 접속한 클라이언트를 관리할수 있는 리스트

    public static void main(String[] args) {

        new Server().startServer();
        
    }//main

  
    //---------------------------------------------------------------------------------
    // 내용 : 서버소켓을 생성한 뒤 클라이언트로부터 접속받을 준비를 한다, 클라이언트가 접속하면 클라이언트 리스트에 넣고 쓰레드를 실행한다.
    //---------------------------------------------------------------------------------
    public void startServer(){

        clientList = new ArrayList<PrintWriter>();

        ServerSocket serverSocket;

        try{

            serverSocket = new ServerSocket(5000); // port 5000으로 접속할 수 있는 서버소켓 생성
            System.out.println("서버가 생성되었습니다.");
            
        while(true){ // 접속을 계속 받을 수 있도록 무한루프

            Socket socket = serverSocket.accept(); 
            OutputStream os = socket.getOutputStream(); 
            PrintWriter writer = new PrintWriter(os); 
            clientList.add(writer); // 클라이언트 리스트에 추가

            Thread thread = new Thread(new ClientHandler(socket, writer)); // 쓰레드 생성

            thread.start(); // 쓰레드 시작

            System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]이 접속했습니다."); 	// 접속한 클라이언트의 IP와 포트를 출력
            System.out.println("총 인원수 "+ clientList.size() +"명 입니다."); 							// 현재 서버에 접속한 인원수를 출력

        }//while

        }catch(Exception e){

            e.printStackTrace();

        }//try catch

    }

   
    //---------------------------------------------------------------------------------
    // 내용 : 쓰레드를 사용할 수 있도록 Runnable 인터페이스를 사용함, 각 클라이언트의 입출력을 다룬다.
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

        // 쓰레드가 시작하면 수행되는 부분
        public void run() {

            try{

            	// 클라이언트로부터 입력을 받아서 처리하는 부분
                while((message = reader.readLine()) != null){//입력이 들어옴

                	//클라이언트가 'bye'를 입력하면 채팅을 종료하고 나가는 처리
                    if(message.substring(0, 3).equals("bye")){

                        clientList.remove(this.pw); // 클라이언트 리스트에서 제거

                        tell("["+socket.getInetAddress()+":"+socket.getPort()+"]이 퇴장했습니다.");
                        System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]이 퇴장했습니다.");
                        System.out.println("총 인원수 "+ clientList.size() +"명 입니다.");

                    }
                    //클라이언트가 'bye'를 입력하지 않은경우 다른 클라이언트들에게 채팅한다고 처리
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
    // 내용 : 클라이언트 리스트에 포함된 클라이어트들에게 채팅 내용을 전달
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