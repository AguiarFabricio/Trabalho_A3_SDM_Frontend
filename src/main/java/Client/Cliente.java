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
        // Crie o ObjectOutputStream primeiro e faça flush — isso evita deadlocks
        out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        in = new ObjectInputStream(socket.getInputStream());
        System.out.println("Conectado ao servidor em " + host + ":" + porta);
    }

    // Simples: envia apenas o comando (UTF) — útil se você quiser separar etapas
    public void enviarComando(String comando) throws IOException {
        out.writeUTF(comando);
        out.flush();
        System.out.println("Comando enviado: " + comando);
    }

    // Simples: envia um objeto após já ter enviado o comando (ou quando necessário)
    public void enviarObjeto(Object obj) throws IOException {
        out.writeObject(obj);
        out.flush();
        System.out.println("Objeto enviado: " + obj.getClass().getSimpleName());
    }

    // Simples: recebe uma mensagem (UTF) do servidor
    public String receberMensagem() throws IOException {
        String msg = in.readUTF();
        System.out.println("Mensagem recebida: " + msg);
        return msg;
    }

    // Simples: recebe um objeto (usar quando o servidor enviou um objeto)
    public Object receberObjeto() throws IOException, ClassNotFoundException {
        Object o = in.readObject();
        System.out.println("Objeto recebido: " + (o != null ? o.getClass().getSimpleName() : "null"));
        return o;
    }

    /**
     * Conveniência — envia comando, envia objeto (se obj != null) e espera
     * uma resposta UTF do servidor. Retorna a resposta ou lança IOException.
     */
    public String enviarComandoComObjeto(String comando, Object obj) throws IOException {
        enviarComando(comando);
        if (obj != null) enviarObjeto(obj);
        return receberMensagem();
    }

    /**
     * Conveniência — envia comando e espera receber um objeto (ex.: LISTAR_CATEGORIAS).
     * Retorna o objeto recebido (null em erro).
     */
    public Object enviarComandoReceberObjeto(String comando) throws IOException, ClassNotFoundException {
        enviarComando(comando);
        return receberObjeto();
    }

    public void close() {
        try { if (in != null) in.close(); } catch (IOException ignored) {}
        try { if (out != null) out.close(); } catch (IOException ignored) {}
        try { if (socket != null) socket.close(); } catch (IOException ignored) {}
        System.out.println("Conexão encerrada.");
    }

    // Mantive o main só para testes locais se necessário
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("localhost", 1234);
            FrmPrincipal frm = new FrmPrincipal();
            frm.setVisible(true);
            frm.setLocationRelativeTo(null);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível conectar ao servidor.\nVerifique se o backend está rodando.",
                    "Erro de conexão", JOptionPane.ERROR_MESSAGE);
        }
    }
}
