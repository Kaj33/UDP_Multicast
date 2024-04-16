/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author kaj33
 */
class UDP_Client
{
    public static void main(String args[]) throws Exception
    {
        int portaServer = 6789; //porta del server impostato anche nel UDP_Server
        InetAddress IPServer = InetAddress.getByName("localhost");
        
        byte[] bufferOUT = new byte [1024];
        byte[] bufferIN = new byte [1024];
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        //Creo il socket
        DatagramSocket clientSocket = new DatagramSocket();
        System.out.println("Inserisci i dati da inviare");
        
        //Preparo il messaggio da inviare
        String daSpedire = input.readLine();
        bufferOUT = daSpedire.getBytes();
        
        //Invio in corso
        DatagramPacket sendPacket = new DatagramPacket (bufferOUT, bufferOUT.length, IPServer, portaServer);
        clientSocket.send(sendPacket);
        
        //Ricezione del messaggio
        DatagramPacket receivePacket = new DatagramPacket (bufferIN, bufferIN.length );
        clientSocket.receive(sendPacket);
        String ricevuto = new String(receivePacket.getData());
        
        //Elaborazione dati ricevuti
        int numCaratteri = receivePacket.getLength();
        ricevuto = ricevuto.substring(0, numCaratteri); //cancella i caratteri in più
        System.out.println("Dal server" + ricevuto);
        
        //Termine trasmissione
        clientSocket.close();
    } 
}