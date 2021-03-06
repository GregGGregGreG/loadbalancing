package loadbalancing.loadbalancer;

import loadbalancing.slave.SlaveServer;

public class XMLRPCTest {
    private ServerReference serverReference;
    private SlaveServer slaveServer;

    @org.junit.Before
    public void setUp() throws Exception {
        serverReference = new ServerReference("http://localhost:6000/xmlrpc");
        slaveServer = new SlaveServer(6000);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        slaveServer = null;
        serverReference = null;
    }

    @org.junit.Test
    public void testServerReferenceToSlaveServerCall() throws Exception {
        slaveServer.start();
        Thread.sleep(1000); // Give the web server some time to start
        System.out.println(serverReference.call("test:Hey!"));
    }

}