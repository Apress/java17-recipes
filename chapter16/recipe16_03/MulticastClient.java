package org.java17recipes.chapter16.recipe16_03;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.MembershipKey;

public class MulticastClient {

   public MulticastClient() {
   }

   public static void main(String[] args) {
       try {
           // Obtain Supported network Interface
           NetworkInterface networkInterface = null;
           java.util.Enumeration<NetworkInterface> enumNI = NetworkInterface.getNetworkInterfaces();
           java.util.Enumeration<InetAddress> enumIA;
           NetworkInterface ni;
           InetAddress ia;
           ILOOP:
           while (enumNI.hasMoreElements()) {
               ni = enumNI.nextElement();
               enumIA = ni.getInetAddresses();
               while (enumIA.hasMoreElements()) {
                   ia = enumIA.nextElement();
                   if (ni.isUp() && ni.supportsMulticast()
                           && !ni.isVirtual() && !ni.isLoopback()
                           && !ia.isSiteLocalAddress()) {
                       networkInterface = ni;
                       break ILOOP;
                   }
               }
           }


           // Address within range
           int port = 5239;
           InetAddress group = InetAddress.getByName("226.18.84.25");

           final DatagramChannel client = DatagramChannel.open(StandardProtocolFamily.INET);

           client.setOption(StandardSocketOptions.SO_REUSEADDR, true);
           client.bind(new InetSocketAddress(port));
           client.setOption(StandardSocketOptions.IP_MULTICAST_IF, networkInterface);

           System.out.println("Joining group: " + group + " with network interface " + networkInterface);
           // Multicasting join
           MembershipKey key = client.join(group, networkInterface);
           client.open();

           // receive message as a client
           final ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
           buffer.clear();
           System.out.println("Waiting to receive message");
           // Configure client to be passive and non.blocking
           // client.configureBlocking(false);
           client.receive(buffer);
           System.out.println("Client Received Message:");
           buffer.flip();
           byte[] arr = new byte[buffer.remaining()];
           buffer.get(arr, 0, arr.length);

           System.out.println(new String(arr));
           System.out.println("Disconnecting...performing a single test pass only");
           client.disconnect();
       } catch (IOException ex) {
           ex.printStackTrace();
       }
   }
}

