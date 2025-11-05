package client;

import java.io.*;
import java.net.Socket;
import javax.swing.JOptionPane;
import view.frmprincipal.FrmPrincipal;

public class Cliente {

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void conectar(String host, int porta) throws IOException {
        socket = new Socket(host, porta);
        out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        in = new ObjectInputStream(socket.getInputStream());
        System.out.println("Conectado ao servidor em " + host + ":" + porta);

        abrirInterfacePrincipal();
    }

    public void enviarComando(String comando) throws IOException {
        out.writeUTF(comando);
        out.flush();
        System.out.println("Comando enviado: " + comando);
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

    public void close() {
        try { if (in != null) in.close(); } catch (IOException ignored) {}
        try { if (out != null) out.close(); } catch (IOException ignored) {}
        try { if (socket != null) socket.close(); } catch (IOException ignored) {}
        System.out.println("Conexão encerrada.");
    }

    private void abrirInterfacePrincipal() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                FrmPrincipal frm = new FrmPrincipal();
                frm.setVisible(true);
                frm.setLocationRelativeTo(null);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao abrir a interface principal:\n" + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("localhost", 1234);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível conectar ao servidor.\nVerifique se o backend está rodando.",
                    "Erro de conexão", JOptionPane.ERROR_MESSAGE);
        }
    }
}
