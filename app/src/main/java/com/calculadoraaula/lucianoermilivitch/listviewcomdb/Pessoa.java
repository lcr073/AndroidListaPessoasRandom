package com.calculadoraaula.lucianoermilivitch.listviewcomdb;

// Define uma classe com as caracteristicas de uma pessoa
public class Pessoa {
    private String nome;
    private String sobrenome;
    private String sexo;
    private String email;
    private String urlFoto;

    public Pessoa(String nome, String sobrenome, String sexo, String email, String urlFoto){
        this.setNome(nome);
        this.setSobrenome(sobrenome);
        this.setSexo(sexo);
        this.setEmail(email);
        this.setUrlFoto(urlFoto);
    }


    @Override
    public String toString(){
        return "Nome:" + this.getNome() + "Sobrenome:" + this.getSobrenome() + "email:" + this.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
