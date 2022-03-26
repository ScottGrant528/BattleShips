/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.rgu.battleships;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author inspi-2-in-1
 */
class Peer {

    int port;

    Peer() {

        try {
            System.out.print("Enter port for this Peer  ");
            DataInputStream din = new DataInputStream(System.in);
            port = Integer.parseInt(in.readLine());
        } catch (Exception e) {
            //TODO: handle exception
        }

    }

    class Sender extends Thread {

        Socket s;

        public void run() {

            try {

                DataInputStream in = new DataInputStream(System.in);
                System.out.println("Enter destPort  ");
                int destPort = Integer.parseInt(in.readLine());

                s = new Socket("127.0.0.1", destPort);
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                while (true) {

                    System.out.println("Enter message for another peer  ");
                    String str = in.readLine();
                    dout.writeUTF(str);

                    System.out.println("Message sent");

                    if (str.equalsIgnoreCase("bye")) {

                        din.readUTF();
                        this.run();
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    class Receiver extends Thread {

        int port;
        ServerSocket ss;
        Socket s;
        DataInputStream din;
        DataOutput dout;

        Receiver(int port) {

            this.port = port;
        }

        public void run() {

            try {

                ss = new ServerSocket(port);
                System.out.println("Receiver created!!!");

                s = ss.accept();
                System.out.println("Client connected");

                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());

                while (true) {

                    String str = din.readUTF();
                    System.out.println("Message from Client is " + str);
                    if (str.equalsIgnoreCase("bye")) {

                        System.out.println("Client left");
                        dout.writeUTF(str);
                        s.close();
                        ss.close();
                        this.run();
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void newPeer() throws Exception {

        Sender s = new Sender();
        Receiver r = new Receiver(port);

        s.start();
        r.start();

        s.join();
        r.join();
    }
}
