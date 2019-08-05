import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel mySocket = ServerSocketChannel.open();
        InetSocketAddress myAddress = new InetSocketAddress("localhost", 1111);

        mySocket.bind(myAddress);

        mySocket.configureBlocking(false);

        int ops = mySocket.validOps();
        SelectionKey key = mySocket.register(selector, ops, null);

        int i = 0;
        Random rand = new Random(100);
        int random = rand.nextInt(10);
        boolean exit = true;
        while(exit){
            System.out.println("Server has started and waiting for an input! Please enter a number between 0-9:");

            selector.select();

            Set<SelectionKey> myKeys = selector.selectedKeys();
            Iterator<SelectionKey> myIterator = myKeys.iterator();

            while(myIterator.hasNext()){
                SelectionKey myKey = myIterator.next();

                if(myKey.isAcceptable()){
                    SocketChannel clientSocket = mySocket.accept();

                    try {
                        clientSocket.configureBlocking(false);
                        clientSocket.register(selector, SelectionKey.OP_READ);
                        System.out.println("Connection accepted from: " + clientSocket.getLocalAddress());
                    } catch (NullPointerException e){

                    }

                } else if(myKey.isReadable()){
                    SocketChannel clientSocket = (SocketChannel) myKey.channel();
                    ByteBuffer myBuffer = ByteBuffer.allocate(256);
                    clientSocket.read(myBuffer);
                    String result = new String(myBuffer.array()).trim();
                    int int_result = Integer.parseInt(result);

                    if(int_result < random){
                        System.out.println("Higher");
                    } else if(int_result > random){
                        System.out.println("Lower");
                    } else{
                        System.out.println("You found the number!");
                        exit=false;
                    }
                    i++;
                }

                if(i == 3){
                    System.out.println("You have reached to maximum guess count. Terminating the server.");
                    exit=false;
                }
            }
        }
    }
}
