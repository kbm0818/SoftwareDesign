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
    // ���� : ������ �����Ͽ� ������ ����
    //---------------------------------------------------------------------------------
    private void connectServer(){

        try {

            socket = new Socket("localhost",5000); // 5000��Ʈ�� �����ϴ� ���� ����
            streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            pw = new PrintWriter(socket.getOutputStream());
            
            readerThread = new Thread(new IncomingReader());
            readerThread.start();
            
            System.out.println("���� ���� ����");

            
        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }//connectServer

    
    //---------------------------------------------------------------------------------
    // ���� : ä���� ������ �Է¹޾� ������ �����Ѵ�.
    //---------------------------------------------------------------------------------
    public void tell(){


        InputStreamReader inputStrimReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStrimReader);

        String message="";

        while(!message.equals("bye")){ // 'bye'�� �Է��Ͽ� ä���� �����ϱ� �� ���� ����ؼ� �Է¹��� ������ ������ ����

            try {

                message = bufferedReader.readLine();
                pw.println(message);
                pw.flush();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }//while

        System.out.println("�����߽��ϴ�.");

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
    // ���� : �������� �ٸ� Ŭ���̾�Ʈ��  �Է��� ������ ����Ѵ�.
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