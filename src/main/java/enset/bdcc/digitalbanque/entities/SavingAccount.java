package enset.bdcc.digitalbanque.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
//@DiscriminatorValue("SA")
@Data @NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class SavingAccount extends BankAccount{
    private  double interestRate;
}
