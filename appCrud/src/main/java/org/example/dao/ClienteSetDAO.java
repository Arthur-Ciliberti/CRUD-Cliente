package org.example.dao;

import org.example.domain.Cliente;

import java.util.HashSet;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO {
    private Set<Cliente> clientes = new HashSet<>();

    @Override
    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente consultar(String cpf) {
        return clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    @Override
    public boolean excluir(String cpf) {
        return clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }

    @Override
    public void alterar(Cliente cliente) {
        excluir(cliente.getCpf());
        cadastrar(cliente);
    }
}
