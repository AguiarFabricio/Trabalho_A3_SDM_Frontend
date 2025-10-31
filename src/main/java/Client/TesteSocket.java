/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import client.Cliente;

public class TesteSocket {
    public static void main(String[] args) {
        try (Cliente cliente = new Cliente()) {
            cliente.conectar("localhost", 1234);
            System.out.println("✅ Conectado ao servidor!");

            // envia comando para listar categorias
            cliente.enviarComando("LISTAR_CATEGORIAS");
            Object resposta = cliente.receberObjeto();

            System.out.println("⬅️ Resposta do servidor: " + resposta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
