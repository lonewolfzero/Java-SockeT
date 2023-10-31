/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientapp;
import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket client = null;        
        InputStream in = null;
        OutputStream out = null;
        byte[] receiveMsg =  new byte[64];
        try {
            client = new Socket("akur", 8881);
            in = client.getInputStream();
            out = client.getOutputStream();
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        String fromServer;
        String fromUser;
        in.read(receiveMsg);
        fromServer = new String(receiveMsg);
        System.out.println("Server: " + fromServer);

        fromUser = "Salam dari client";
        System.out.println("Kirim ke server: " + fromUser);
        out.write(fromUser.getBytes());
        fromUser = "Ini data dari client";
        System.out.println("Kirim ke server: " + fromUser);
        out.write(fromUser.getBytes());

        fromUser = "Keluar";
        out.write(fromUser.getBytes());
        System.out.println("Kirim ke server: " + fromUser);
            
        out.close();
        in.close();
        client.close();
    }
}
