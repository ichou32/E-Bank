package enset.bdcc.digitalbanque;

import enset.bdcc.digitalbanque.entities.CurrentAccount;
import enset.bdcc.digitalbanque.entities.Customer;
import enset.bdcc.digitalbanque.entities.SavingAccount;
import enset.bdcc.digitalbanque.enums.AccountStatus;
import enset.bdcc.digitalbanque.repositories.AccountOperationRepository;
import enset.bdcc.digitalbanque.repositories.BankAccountRepository;
import enset.bdcc.digitalbanque.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBanqueApplication.class, args);
    }

    CommandLineRunner start(CustomerRepository customerRepository,
                            BankAccountRepository bankAccountRepository,
                            AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Ichou", "Youssef", "Hassan").forEach(name ->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer ->{
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setBalance(Math.random()*9000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setAccountStatus(AccountStatus.CREATED);
                currentAccount.setOvertDraft(9000);
                currentAccount.setCustomer(customer);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setBalance(Math.random()*9000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setAccountStatus(AccountStatus.CREATED);
                savingAccount.setInterestRate(5.5);
                savingAccount.setCustomer(customer);
                bankAccountRepository.save(savingAccount);
            });
        };
    }
}
