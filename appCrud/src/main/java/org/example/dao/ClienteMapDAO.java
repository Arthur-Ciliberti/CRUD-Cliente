package org.example.dao;

import org.example.domain.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO {
    private Map<String, Cliente> clientes = new HashMap<>();

    @Override
    public void cadastrar(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    @Override
    public Cliente consultar(String cpf) {
        return clientes.get(cpf);
    }

    @Override
    public boolean excluir(String cpf) {
        return clientes.remove(cpf) != null;
    }

    @Override
    public void alterar(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }
}
