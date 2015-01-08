package loadbalancing.client;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

/**
 * This class represents the client who will make requests to the
 * load balancer.
 *
 * @author Gary Ye
 */
public class Client {
    private String url;

    public Client(String url) {
        this.url = url;
    }

    public String call(String request) {
        // http://ws.apache.org/xmlrpc/client.html
        try {
            XmlRpcClient client = new XmlRpcClient(url);

            Vector v = new Vector();
            v.add(request);

            return (String) client.execute("Server.call", v);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("usage: java client.Client <url> <request>");
            System.exit(1);
        }

        System.out.println(new Client(args[0]).call(args[1]));
    }
}
