package 聊天室;
/*
 *Version 1
 * 搭建客户端和服务器的基础连接
 *
 */
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket localhost = new Socket("localhost", 8999);//绑定服务器的地址和端口号
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));//从键盘获取输入信息
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(localhost.getOutputStream()));//向服务器端口发送
        BufferedReader in = new BufferedReader(new InputStreamReader(localhost.getInputStream()));//从服务器端口获取
        while(true)
        {
            String message=bis.readLine();//键盘读入
            out.write(message+"\r\n");//写到输出流，\n是使服务器读取时，防阻塞
            out.flush();//刷新流
            if (message.equals("end"))  //如果输入end，则终止
                break;
            System.out.println("服务器反馈："+in.readLine());//服务器反馈
        }
        bis.close();//关闭流
        localhost.close();//关闭流
    }
}