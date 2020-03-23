package ru.greendata.DepositManager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "clients")
public class ClientEntity extends AbstractEntity {

    // Наименование
    @Column(name = "name")
    @NotBlank
    private String name;
    // Краткое наименование
    @Column(name = "short_name")
    @NotBlank
    private String shortName;
    // Адрес
    @Column(name = "address")
    @NotBlank
    private String address;
    // Организационно-правовая форма
    @Column(name = "legal_form")
    @NotBlank
    private String legalForm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

}
