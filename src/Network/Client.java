package Network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

    Socket socket;
    BufferedReader reader;
    PrintWriter pw;
    InputStreamReader streamReader;
    Thread readerThread;
 
    public static void main(String[] args) {

        new Client().connectServer();

    }

    //---------------------------------------------------------------------------------
    // 내용 : 소켓을 생성하여 서버로 접속
    //---------------------------------------------------------------------------------
    private void connectServer(){

        try {

            socket = new Socket("localhost",5000); // 5000포트로 접속하는 소켓 생성
            streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            pw = new PrintWriter(socket.getOutputStream());
            
            readerThread = new Thread(new IncomingReader());
            readerThread.start();
            
            System.out.println("서버 접속 성공");

            
        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }//connectServer

    
    //---------------------------------------------------------------------------------
    // 내용 : 채팅할 내용을 입력받아 서버로 전송한다.
    //---------------------------------------------------------------------------------
    public void tell(){


        InputStreamReader inputStrimReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStrimReader);

        String message="";

        while(!message.equals("bye")){ // 'bye'를 입력하여 채팅을 종료하기 전 까지 계속해서 입력받은 내용을 서버로 전송

            try {

                message = bufferedReader.readLine();
                pw.println(message);
                pw.flush();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }//while

        System.out.println("퇴장했습니다.");

            try {

                bufferedReader.close();
                inputStrimReader.close();
                socket.close();
                reader.close();
                readerThread.interrupt();
                pw.close();
                streamReader.close();

                System.exit(0);

            } catch (IOException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

    }//tell end

    
    //---------------------------------------------------------------------------------
    // 내용 : 서버에서 다른 클라이언트가  입력한 내용을 출력한다.
    //---------------------------------------------------------------------------------
     public class IncomingReader implements Runnable {

          public void run() {

           String message;

           try {

            while ((message = reader.readLine()) != null) {

                System.out.println(message);

            }    

           } catch (Exception e) {e.printStackTrace();}

          }

         }//IncomingReader end

}//SimpleChatClient end