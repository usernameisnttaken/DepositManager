package ru.greendata.DepositManager.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.greendata.DepositManager.entity.BankEntity;
import ru.greendata.DepositManager.service.BankService;

@RestController
@RequestMapping("/banks")
public class BankController extends AbstractController<BankEntity, BankService> {

    public BankController(BankService bankService) {
        super(bankService);
    }

}
