package com.minhaempresa.spring.infrastructure.models.pks;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/*
    Esta classe representa a chave composta do modelo da entidade

    Deve:

        - Implementar a interface Serializable;
        - Ter os atributos da chave (pk) da entidade que representa;
        - Ter construtores;
        - Ter métodos Gettters e Setters;
        - Ter métodos hascode e equals;
        - Colocar as anotações para definir a pk da entidade;
 */
@Embeddable
public class CustomerPk implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "telephone", length = 11)
    private String telephone;

    @Column(name = "cpf", length = 11)
    private String cpf;

    public CustomerPk() {
    }

    public CustomerPk(String telephone, String cpf) {
        this.telephone = telephone;
        this.cpf = cpf;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerPk that = (CustomerPk) o;
        return Objects.equals(telephone, that.telephone) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telephone, cpf);
    }

}
