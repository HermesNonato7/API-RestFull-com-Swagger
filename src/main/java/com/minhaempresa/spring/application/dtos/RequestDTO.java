package com.minhaempresa.spring.application.dtos;

import java.util.List;

/*
Padrão de projeto: DTO – Data Transfer Object (Objeto de Transferência de Dados)
é um padrão de arquitetura de objetos que agregam e encapsulam dados para transferência.

Basicamente é uma classe com atributos simples que é utilizada para
otimizar a comunicação entre o client e o servidor.
*/
public class RequestDTO {
    private Double price;
    private List<Long> pizzasId;
    private String telephone;
    private String cpf;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Long> getPizzasId() {
        return pizzasId;
    }

    public void setPizzasId(List<Long> pizzasId) {
        this.pizzasId = pizzasId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
