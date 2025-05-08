package onlineBank.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Client extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bankAccount_id")
    private Long bankAccountId;

    @OneToOne
    @JoinColumn(name= "bank_account_id")
    private BankAccount bankAccount;

    public Client(String name, String dni, String email, Role role, BankAccount bankAccount) {
        super(name, dni, email, role);
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "bankAccountId=" + bankAccountId +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
