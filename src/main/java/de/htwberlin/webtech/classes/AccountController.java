package de.htwberlin.webtech.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/account")
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082"})
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping(path = "{accountId}")
    public Account getAccountById(@PathVariable("accountId") Integer id) {
        return accountService.getAccountById(id)
                .orElseThrow(() -> new IllegalStateException("Account with id " + id + " does not exist"));
    }

    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account newAccount = accountService.addAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        Account updatedAccount = accountService.updateAccount(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @DeleteMapping(path = "{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("accountId") Integer id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Void> login(@RequestBody Account account) {
        Account existingAccount = accountService.getAccountByName(account.getName());

        if (existingAccount != null && existingAccount.getPasswordHash().equals(account.getPasswordHash())) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}