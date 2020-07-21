package 聊天室;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8999);
        Socket accept = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        while(true)
        {
            String s = in.readLine();
            System.out.println("客户端："+s);
            if (s.equals("end"))
            {
                System.out.println("客户端终止连接");
                System.out.println("终止反馈："+in.readLine());//第一次为null，客户端断开连接则无法发送成功
                break;
            }
            System.out.print("反馈内容：");
            String back=br.readLine();
            out.write(back+"\r\n");
            out.flush();
        }
        serverSocket.close();
        br.close();
    }
}
