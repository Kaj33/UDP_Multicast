/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

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
        
        BufferReader
    }
}