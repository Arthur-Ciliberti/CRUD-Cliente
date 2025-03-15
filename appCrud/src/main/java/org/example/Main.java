package org.example;

import org.example.dao.ClienteSetDAO;
import org.example.dao.IClienteDAO;
import org.example.domain.Cliente;

import javax.swing.*;

public class Main {
    private static IClienteDAO clienteDAO = new ClienteSetDAO();

    public static void main(String[] args) {
        while (true) {
            String input = JOptionPane.showInputDialog("Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair");
            if (input == null || input.equals("5")) {
                break;
            }
            switch (input) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    consultarCliente();
                    break;
                case "3":
                    excluirCliente();
                    break;
                case "4":
                    alterarCliente();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog("Nome:");
        String cpf = JOptionPane.showInputDialog("CPF:");
        String telefone = JOptionPane.showInputDialog("Telefone:");
        String estado = JOptionPane.showInputDialog("Estado:");
        String cidade = JOptionPane.showInputDialog("Cidade:");
        clienteDAO.cadastrar(new Cliente(nome, cpf, telefone, estado, cidade));
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }

    private static void consultarCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente:");
        Cliente cliente = clienteDAO.consultar(cpf);
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }

    private static void excluirCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente:");
        boolean clienteRemovido = clienteDAO.excluir(cpf);
        if (clienteRemovido) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }

    private static void alterarCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente:");
        Cliente cliente = clienteDAO.consultar(cpf);
        if (cliente != null) {
            cliente.setNome(JOptionPane.showInputDialog("Nome:", cliente.getNome()));
            cliente.setTelefone(JOptionPane.showInputDialog("Telefone:", cliente.getTelefone()));
            cliente.setEstado(JOptionPane.showInputDialog("Estado:", cliente.getEstado()));
            cliente.setCidade(JOptionPane.showInputDialog("Cidade:", cliente.getCidade()));
            clienteDAO.alterar(cliente);
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }
}
