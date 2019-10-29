package com.example.my_cars_sqlite.pojo;


import java.io.Serializable;

// POJO - Plain Old Java Objects
public class Carro implements Serializable {
    private int id;
    private String modelo;
    private String ano;
    private String cor;


    /**
     * Método construtor vazio
     * */


    public Carro() {
    }
    /**
     * Método construtor da classe com assinatura
     * * @param modelo
     * * @param ano
     * * @param cor
     */
    public Carro(String modelo, String ano,String cor) {

        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;

    }
    public Carro(int id, String modelo,String ano,String cor){
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;

    }

    public Carro(int anInt, String string, String string1, String string2, String string3) {

    }


    // Getters and Setters

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo;}

    public String getAno() { return ano;}

    public void setAno(String ano) { this.ano = ano;}

    public String getCor() {return cor;}

    public void setCor(String cor) {this.cor = cor;}


    @Override
    public String toString() {
          return modelo;
    }

    /**
     * Método que retorna todos os dados de uma só vez
     *
     * @return
     */
    public String getDados() {
        return "ID: " + id + "\n" +
                "Modelo " + modelo + "\n" +
                "Ano: " + ano + "\n" +
                "Cor: " + cor;

    }
}
