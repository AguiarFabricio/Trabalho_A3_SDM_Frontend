package client;

import java.io.*;
import java.net.Socket;

public class Cliente implements Closeable {

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void conectar(String host, int porta) throws IOException {
        socket = new Socket(host, porta);
        // Ordem correta: out -> flush -> in
        out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        in = new ObjectInputStream(socket.getInputStream());
        System.out.println("Conectado ao servidor em " + host + ":" + porta);
    }

    public void enviarComando(String comando) throws IOException {
        out.writeUTF(comando);
        out.flush();
        System.out.println(" Comando enviado: " + comando);
    }

    public void enviarObjeto(Object obj) throws IOException {
        out.writeObject(obj);
        out.flush();
        System.out.println("Objeto enviado: " + obj.getClass().getSimpleName());
    }

    public String receberMensagem() throws IOException {
        String msg = in.readUTF();
        System.out.println("Mensagem recebida: " + msg);
        return msg;
    }

    public Object receberObjeto() throws IOException, ClassNotFoundException {
        Object obj = in.readObject();
        System.out.println("Objeto recebido: " + obj.getClass().getSimpleName());
        return obj;
    }

    @Override
    public void close() throws IOException {
        try { if (in != null) in.close(); } catch (IOException ignored) {}
        try { if (out != null) out.close(); } catch (IOException ignored) {}
        try { if (socket != null) socket.close(); } catch (IOException ignored) {}
        System.out.println("Conexão encerrada.");
    }
}
