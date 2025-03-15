package org.example.dao;

import org.example.domain.Cliente;

public interface IClienteDAO {
    void cadastrar(Cliente cliente);
    Cliente consultar(String cpf);
    boolean excluir(String cpf);
    void alterar(Cliente cliente);
}
