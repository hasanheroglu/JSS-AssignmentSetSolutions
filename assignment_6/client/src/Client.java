import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        InetSocketAddress myAddress = new InetSocketAddress("localhost", 1111);
        SocketChannel mySocket = SocketChannel.open(myAddress);

        if(mySocket == null){
            System.out.println("Could not connect to the server!");
            return;
        }

        System.out.println("Connecting to the server on port 1111...");
        Scanner input = new Scanner(System.in);

        int guess;

        System.out.println("Please enter a number between 0-9:");

        while(input.hasNext()){
            System.out.println("Please enter a number between 0-9:");

            if(!mySocket.isOpen()){
                System.out.println("Could not connect to the server!");
                return;
            }

            guess = input.nextInt();

            byte[] message = Integer.toString(guess).getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            mySocket.write(buffer);

            System.out.println("sending: " + guess);
            buffer.clear();

            Thread.sleep(2000);
        }
    }
}
