package client;

import java.io.*;
import java.net.Socket;
import javax.swing.JOptionPane;
import view.frmprincipal.FrmPrincipal;

/**
 * Classe responsável pela comunicação do cliente com o servidor via sockets.
 * <p>
 * Essa classe implementa métodos para conectar, enviar comandos e objetos,
 * receber respostas e encerrar a conexão de forma segura.
 * </p>
 *
 * <p>
 * Utiliza {@link ObjectOutputStream} e {@link ObjectInputStream} para serializar objetos e
 * strings entre cliente e servidor.
 * </p>
 *
 * <p><b>Exemplo de uso:</b></p>
 * <pre>{@code
 * Cliente cliente = new Cliente();
 * cliente.conectar("localhost", 1234);
 * String resposta = cliente.enviar("INSERIR_PRODUTO", produto);
 * cliente.close();
 * }</pre>
 *
 * @author Luiz
 * @version 1.0
 * @since 2025
 */
public class Cliente {

    /** Socket usado para comunicação com o servidor. */
    private Socket socket;

    /** Canal de saída de dados (envio de comandos e objetos). */
    private ObjectOutputStream out;

    /** Canal de entrada de dados (recebimento de mensagens e objetos). */
    private ObjectInputStream in;

    /**
     * Estabelece a conexão com o servidor no endereço e porta especificados.
     *
     * @param host endereço do servidor (exemplo: "localhost")
     * @param porta número da porta usada na conexão
     * @throws IOException se ocorrer erro ao conectar ao servidor
     */
    public void conectar(String host, int porta) throws IOException {
        socket = new Socket(host, porta);
        // Crie o ObjectOutputStream primeiro e faça flush — isso evita deadlocks
        out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        in = new ObjectInputStream(socket.getInputStream());
        System.out.println("Conectado ao servidor em " + host + ":" + porta);
    }

    /**
     * Envia apenas um comando textual (UTF) para o servidor.
     *
     * @param comando comando a ser enviado
     * @throws IOException se ocorrer erro no envio
     */
    public void enviarComando(String comando) throws IOException {
        out.writeUTF(comando);
        out.flush();
        System.out.println("Comando enviado: " + comando);
    }

    /**
     * Envia um objeto serializável ao servidor.
     * <p>O comando pode ser enviado antes, se necessário.</p>
     *
     * @param obj objeto a ser enviado
     * @throws IOException se ocorrer erro no envio
     */
    public void enviarObjeto(Object obj) throws IOException {
        out.writeObject(obj);
        out.flush();
        System.out.println("Objeto enviado: " + obj.getClass().getSimpleName());
    }

    /**
     * Recebe uma mensagem textual (UTF) enviada pelo servidor.
     *
     * @return mensagem recebida
     * @throws IOException se ocorrer erro na leitura
     */
    public String receberMensagem() throws IOException {
        String msg = in.readUTF();
        System.out.println("Mensagem recebida: " + msg);
        return msg;
    }

    /**
     * Recebe um objeto serializado enviado pelo servidor.
     *
     * @return objeto recebido
     * @throws IOException se ocorrer erro de comunicação
     * @throws ClassNotFoundException se a classe do objeto não for encontrada
     */
    public Object receberObjeto() throws IOException, ClassNotFoundException {
        Object o = in.readObject();
        System.out.println("Objeto recebido: " + (o != null ? o.getClass().getSimpleName() : "null"));
        return o;
    }

    /**
     * Envia um comando e um objeto ao servidor, e aguarda uma resposta textual.
     *
     * @param comando comando a ser enviado
     * @param obj objeto associado ao comando
     * @return resposta do servidor
     * @throws IOException se ocorrer erro de comunicação
     */
    public String enviarComandoComObjeto(String comando, Object obj) throws IOException {
        enviarComando(comando);
        if (obj != null) {
            enviarObjeto(obj);
        }
        return receberMensagem();
    }

    /**
     * Envia um comando ao servidor e aguarda o recebimento de um objeto.
     *
     * @param comando comando a ser enviado
     * @return objeto retornado pelo servidor
     * @throws IOException se ocorrer erro de comunicação
     * @throws ClassNotFoundException se a classe do objeto recebido não for encontrada
     */
    public Object enviarComandoReceberObjeto(String comando) throws IOException, ClassNotFoundException {
        enviarComando(comando);
        return receberObjeto();
    }

    /**
     * Envia um comando e um objeto ao servidor, retornando a resposta textual.
     * <p>
     * Método compatível com chamadas simplificadas como:
     * {@code cliente.enviar("ALTERAR_PRODUTO", produto);}
     * </p>
     *
     * @param comando comando a ser enviado
     * @param obj objeto a ser enviado
     * @return resposta textual do servidor ou "ERRO" em caso de falha
     */
    public String enviar(String comando, Object obj) {
        try {
            return enviarComandoComObjeto(comando, obj);
        } catch (IOException e) {
            System.err.println("Erro ao enviar comando/objeto: " + e.getMessage());
            return "ERRO";
        }
    }

    /**
     * Fecha todos os recursos de I/O e encerra a conexão com o servidor.
     * <p>Ignora erros durante o fechamento dos streams.</p>
     */
    public void close() {
        try {
            if (in != null) in.close();
        } catch (IOException ignored) {}
        try {
            if (out != null) out.close();
        } catch (IOException ignored) {}
        try {
            if (socket != null) socket.close();
        } catch (IOException ignored) {}
        System.out.println("Conexão encerrada.");
    }

    /**
     * Método principal apenas para testes locais da conexão com o servidor.
     * <p>
     * Tenta se conectar ao servidor local na porta 1234 e abrir a janela principal da aplicação.
     * </p>
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
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
