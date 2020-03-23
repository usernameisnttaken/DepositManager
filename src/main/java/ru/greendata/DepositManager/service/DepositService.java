package ru.greendata.DepositManager.service;

import org.springframework.stereotype.Service;
import ru.greendata.DepositManager.entity.DepositEntity;
import ru.greendata.DepositManager.repository.DepositRepository;

@Service
public class DepositService extends AbstractService<DepositEntity, DepositRepository> {

    public DepositService(DepositRepository depositRepository) {
        super(depositRepository);
    }

}
