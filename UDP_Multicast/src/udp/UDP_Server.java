/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author kaj33
 */
public class UDP_Server {
    public static void main (String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket (6789);
        boolean attivo = true; //Serve per la ripetizione del servizio
        byte[] bufferIN = new byte[1024];
        byte[] bufferOUT = new byte [1024];
        
        System.out.println("Server avviato");
        while (attivo){
            //Definisco il Datagram Packet
            DatagramPacket receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
              serverSocket.receive(receivePacket); //Attesa ricezione messaggio
              //Controllo del Datagram Packet
               String ricevuto = new String (receivePacket.getData());
               int numCaratteri = receivePacket.getLength();
        ricevuto=ricevuto.substring(0,numCaratteri);
        System.out.println("Ricevuto:" + ricevuto);
        
        //Acquisizione dei paramentri del socket del client
        InetAddress IPClient = receivePacket.getAddress();
        int portaClient = receivePacket.getPort();
        
        //Preparazione del messaggio da inviare
        String daSpedire = ricevuto.toUpperCase();
        bufferOUT = daSpedire.getBytes();
        
        //Invio del messaggio
        DatagramPacket sendPacket = new DatagramPacket (bufferOUT, bufferOUT.length, IPClient, portaClient);
        serverSocket.send(sendPacket);
          
        if (ricevuto.equals("fine"))
        {
            System.out.println("Il server si sta chiudendo");
            attivo=false;         
        }
       serverSocket.close();
       } 
    }
}


