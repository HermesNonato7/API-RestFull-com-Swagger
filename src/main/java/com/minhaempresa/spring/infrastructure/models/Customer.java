package com.minhaempresa.spring.infrastructure.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minhaempresa.spring.infrastructure.models.pks.CustomerPk;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    Esta classe representa o modelo da entidade

    O modelo de entidade deve:

        - Implementar a interface Serializable;
        - Ter os atributos da entidade que representa;
        - Ter construtores;
        - Ter métodos Gettters e Setters;
        - Ter métodos hascode e equals;
        - Ter o método toString;
        - Colocar as anotações para definir a entidade, as colunas e os relacionamentos se tiver;
 */
@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CustomerPk id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Request> requests = new ArrayList<>();

    public Customer() {
    }

    public Customer(CustomerPk id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public CustomerPk getId() {
        return id;
    }

    public void setId(CustomerPk id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Request> getRequests() {
        return requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", requests=" + requests +
                '}';
    }
}