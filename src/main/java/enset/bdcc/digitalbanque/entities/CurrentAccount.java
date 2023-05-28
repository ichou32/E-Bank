package enset.bdcc.digitalbanque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CurrentAccount extends BankAccount{
    private double overtDraft;
}
