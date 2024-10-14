package com.ecommerce.demo.controller;

import com.ecommerce.demo.dto.AccountDto;
import com.ecommerce.demo.dto.CreateAccountRequest;
import com.ecommerce.demo.model.Account;
import com.ecommerce.demo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public String index()
    {
        return "hello";
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> store(@RequestBody CreateAccountRequest request)
    {
        return ResponseEntity.ok(accountService.createAccount(request));
    }


}
