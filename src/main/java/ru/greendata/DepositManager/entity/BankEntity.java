package ru.greendata.DepositManager.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "banks")
public class BankEntity extends AbstractEntity {

    // Наименование
    @Column(name = "name")
    @NotBlank
    private String name;
    // БИК
    @Column(name = "bic")
    @Length(min = 9, max = 9)
    private String bic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

}
