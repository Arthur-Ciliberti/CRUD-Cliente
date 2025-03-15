package org.example.domain;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String estado;
    private String cidade;

    public Cliente(String nome, String cpf, String telefone, String estado, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone + "\nEstado: " + estado + "\nCidade: " + cidade;
    }
}
