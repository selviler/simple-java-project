package com.ecommerce.demo.service;

import com.ecommerce.demo.dto.AccountDto;
import com.ecommerce.demo.dto.CreateAccountRequest;
import com.ecommerce.demo.mapper.AccountDtoMapper;
import com.ecommerce.demo.model.Account;
import com.ecommerce.demo.model.Customer;
import com.ecommerce.demo.model.Transaction;
import com.ecommerce.demo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoMapper accountDtoMapper;

    public AccountService(
            AccountRepository accountRepository,
            CustomerService customerService,
            TransactionService transactionService,
            AccountDtoMapper accountDtoMapper
    ) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.accountDtoMapper = accountDtoMapper;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest)
    {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit()
        );

        Transaction transaction = transactionService.initiateMoney(account, createAccountRequest.getInitialCredit());

        account.getTransaction().add(transaction);

        return accountDtoMapper.convert(accountRepository.save(account));
    }
}
