import example.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class HelloWorldClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/WebService_war_exploded3/services/HelloWorld?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://localhost:8080/WebService_war_exploded3/services/", "HelloWorld");
        Service service = Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);
        hello.sayHelloWorldFrom("This is me!");
    }
}

