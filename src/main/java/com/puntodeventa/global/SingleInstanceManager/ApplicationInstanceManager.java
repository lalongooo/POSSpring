/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.SingleInstanceManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.ParamHelper;

public class ApplicationInstanceManager {

    private static final LogHelper objLog = new LogHelper("ApplicationInstanceManager");
    private static ApplicationInstanceListener subListener;
    /**
     * Randomly chosen, but static, high socket number
     */
    public static final int SINGLE_INSTANCE_NETWORK_SOCKET = Integer.parseInt(ParamHelper.getParam("single_instance_sckt_port_number").toString());
    /**
     * Must end with newline
     */
    public static final String SINGLE_INSTANCE_SHARED_KEY = ParamHelper.getParam("single_instance_shared_key").toString();

    /**
     * Registers this instance of the application.
     *
     * @return true if first instance, false if not.
     */
    public static boolean registerInstance() {
        // returnValueOnError should be true if lenient (allows app to run on network error) or false if strict.
        boolean returnValueOnError = true;
        // try to open network socket
        // if success, listen to socket for new instance message, return true
        // if unable to open, connect to existing and send new instance message, return false
        try {
            final ServerSocket socket = new ServerSocket(SINGLE_INSTANCE_NETWORK_SOCKET, 10, InetAddress.getLocalHost());
            objLog.Log("Listening for application instances on socket " + SINGLE_INSTANCE_NETWORK_SOCKET);
            Thread instanceListenerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean socketClosed = false;
                    while (!socketClosed) {
                        if (socket.isClosed()) {
                            socketClosed = true;
                        } else {
                            try {
                                try (Socket client = socket.accept();
                                        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                                    String message = in.readLine();
                                    if (SINGLE_INSTANCE_SHARED_KEY.trim().equals(message.trim())) {
                                        objLog.Log("Shared key matched - new application instance found");
                                        fireNewInstance();
                                    }
                                }
                            } catch (IOException e) {
                                socketClosed = true;
                            }
                        }
                    }
                }
            });
            instanceListenerThread.start();
            // listen
        } catch (UnknownHostException e) {
            objLog.Log("UnknownHostException." + e.getMessage());
            return returnValueOnError;
        } catch (IOException e) {
            objLog.Log("Port is already taken.  Notifying first instance.");
            try {
                try (
                        Socket clientSocket = new Socket(InetAddress.getLocalHost(), SINGLE_INSTANCE_NETWORK_SOCKET);
                        OutputStream out = clientSocket.getOutputStream()) {
                    out.write(SINGLE_INSTANCE_SHARED_KEY.getBytes());
                }
                objLog.Log("Successfully notified first instance.");
                System.out.println();
                return false;
            } catch (UnknownHostException e1) {
                objLog.Log("UnknownHostException." + e1.getMessage());
                return returnValueOnError;
            } catch (IOException e1) {
                objLog.Log("Error connecting to local port for single instance notification." + e1.getMessage());
                return returnValueOnError;
            }

        }
        return true;
    }

    public static void setApplicationInstanceListener(ApplicationInstanceListener listener) {
        subListener = listener;
    }

    private static void fireNewInstance() {
        if (subListener != null) {
            subListener.newInstanceCreated();
        }
    }
}