package com.ecommerce.demo.mapper;

import com.ecommerce.demo.dto.AccountDto;
import com.ecommerce.demo.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoMapper {

    public AccountDto convert(Account account)
    {
        return new AccountDto(
                account.getId()
        );
    }
}
