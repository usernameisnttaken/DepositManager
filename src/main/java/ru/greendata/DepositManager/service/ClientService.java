package ru.greendata.DepositManager.service;

import org.springframework.stereotype.Service;
import ru.greendata.DepositManager.entity.ClientEntity;
import ru.greendata.DepositManager.repository.ClientRepository;

@Service
public class ClientService extends AbstractService<ClientEntity, ClientRepository> {

    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
    }

}
