package enset.bdcc.digitalbanque.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
//@DiscriminatorValue("CA")
@Data @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class CurrentAccount extends BankAccount{
    private double overtDraft;
}
