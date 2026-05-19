package dev.lazy.CadastroDeNinjas;

import jakarta.persistence.*;

// Entity transforma uma classe em entidade do Banco de Dados
// JPA = Java Persistence API
@Entity
@Table(name = "td_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome, email;
    private int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade, String email) {
        setNome(nome);
        setEmail(email);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome Inválido");
        }

        String nomeTratado = nome.trim();

        if (nomeTratado.matches("^[\\p{L} ]+$")){
            this.nome = nomeTratado;
        }else{
            throw new IllegalArgumentException("Nome Inválido");
        }
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        if (email == null || email.isBlank()){
            this.email = null;
            return;
        }

        String emailTratado = email.trim();

        if (emailTratado.matches("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$")){
            this.email = emailTratado;
        }else {
            throw new IllegalArgumentException("Email Inválido");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0){
            throw new IllegalArgumentException("Idade Inválida");
        }

        this.idade = idade;
    }

    public Long getId() {
        return id;
    }
}
