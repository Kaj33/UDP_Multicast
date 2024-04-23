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

class UDP_Client {
    public static void main(String args[]) throws Exception {
        int portaMulticast = 6789; // Porta multicast
        InetAddress gruppoMulticast = InetAddress.getByName("230.0.0.1"); // Indirizzo IP multicast

        byte[] bufferOUT = new byte[1024];
        byte[] bufferIN = new byte[1024];

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // Creo il socket e lo configuro per l'indirizzo multicast
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.setBroadcast(true);

        System.out.println("Inserisci i dati da inviare");

        // Preparo il messaggio da inviare
        String daSpedire = input.readLine();
        bufferOUT = daSpedire.getBytes();

        // Invio in corso
        DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, gruppoMulticast, portaMulticast);
        clientSocket.send(sendPacket);

        // Ricezione del messaggio
        DatagramPacket receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
        clientSocket.receive(receivePacket);
        String ricevuto = new String(receivePacket.getData());

        // Elaborazione dati ricevuti
        int numCaratteri = receivePacket.getLength();
        ricevuto = ricevuto.substring(0, numCaratteri); // Cancella i caratteri in più
        System.out.println("Dal server: " + ricevuto);

        // Termine trasmissione
        clientSocket.close();
    }
}
