package ru.greendata.DepositManager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "deposits")
public class DepositEntity extends AbstractEntity {

    // ID клиента
    @Column(name = "client_id")
    private String clientId;
    // ID банка
    @Column(name = "bank_id")
    private String bankId;
    // Дата открытия
    @Column(name = "opening_date")
    private String openingDate;
    // Процент
    @Column(name = "percent")
    private byte percent;
    // Срок в месяцах
    @Column(name = "period")
    private String period;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public byte getPercent() {
        return percent;
    }

    public void setPercent(byte percent) {
        this.percent = percent;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

}
