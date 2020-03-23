package ru.greendata.DepositManager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.greendata.DepositManager.entity.DepositEntity;
import ru.greendata.DepositManager.service.DepositService;

@RestController
@RequestMapping("/deposits")
public class DepositController extends AbstractController<DepositEntity, DepositService> {

    public DepositController(DepositService depositService) {
        super(depositService);
    }

}
