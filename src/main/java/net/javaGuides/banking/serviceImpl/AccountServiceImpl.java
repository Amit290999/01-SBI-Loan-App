package net.javaGuides.banking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaGuides.banking.dto.AccountDto;
import net.javaGuides.banking.entity.Account;
import net.javaGuides.banking.mapper.AccountMapper;
import net.javaGuides.banking.repository.AccountRepository;
import net.javaGuides.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
	Account account = AccountMapper.mapToAccount(accountDto);
	Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	
}
