package com.pb.antipov.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class ClientApp extends JFrame {
    private JPanel clientAppPanel;
    private JTextField msgField;
    private JButton sendBtn;
    private JTextArea msgLog;

    public ClientApp(String title) throws Exception {
        super(title);
        setContentPane(clientAppPanel);
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        msgLog.setForeground(Color.BLUE);

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logClientMsg(msgField.getText());
                try {
                    startServ(msgField.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                msgField.setText("");
            }
        });

        msgField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == 10) {
                    logClientMsg(msgField.getText());
                    try {
                        startServ(msgField.getText());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    msgField.setText("");
                }
            }
        });

    }

    public void startServ(String dataFromUser) throws IOException {
        String serverIp = "127.0.0.1";
        int serverPort = 1234;
        Socket server = new Socket(serverIp, serverPort);
        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);

            String dataFromServer;

            // Основной цикл отправки сообщений серверу
                outServer.println(dataFromUser);
                dataFromServer = inServer.readLine();
                logServerMsg(dataFromServer);


            outServer.close();
            inServer.close();
            outServer.close();
            server.close();

    }

    public void logClientMsg (String s) {
        msgLog.setLineWrap(true);
        msgLog.setText(msgLog.getText() + "\r\n" + "Client: " + s);
    }

    public void logServerMsg (String s) {
        msgLog.setText(msgLog.getText() + "\r\n" + "Server: " + s);
    }

    public static void main(String[] args) throws Exception {
        JFrame jf = new ClientApp("Client app");
    }

}
