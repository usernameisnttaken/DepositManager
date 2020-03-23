package ru.greendata.DepositManager.service;

import org.springframework.stereotype.Service;
import ru.greendata.DepositManager.entity.BankEntity;
import ru.greendata.DepositManager.repository.BankRepository;

@Service
public class BankService extends AbstractService<BankEntity, BankRepository> {

    public BankService(BankRepository bankRepository) {
        super(bankRepository);
    }

}
