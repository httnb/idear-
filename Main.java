package com.company;
import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        Socket csocket=null;
        BufferedReader sin;
        PrintWriter csockOut;
        String s1;
        try {
            csocket=new Socket("127.0.0.1",8888);
            System.out.println("正在连接服务端...");
            System.out.println();
            System.out.println("服务端连接成功！");
            sin=new BufferedReader(new InputStreamReader(System.in));
            csockOut=new PrintWriter(csocket.getOutputStream());
            do {
                s1=sin.readLine();
                csockOut.println(s1);
                csockOut.flush();
            }
            while (!s1.equals("bye"));
            System.out.println("Client ends!");
            csockOut.close();
            sin.close();
            csocket.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
