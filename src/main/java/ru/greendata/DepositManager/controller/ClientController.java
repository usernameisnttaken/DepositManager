package ru.greendata.DepositManager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.greendata.DepositManager.entity.ClientEntity;
import ru.greendata.DepositManager.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController extends AbstractController<ClientEntity, ClientService> {

    public ClientController(ClientService clientService) {
        super (clientService);
    }

}
