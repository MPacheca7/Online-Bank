package onlineBank.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Client extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankAccount_id;

    @OneToOne
    @JoinColumn(name= "bank_account_id")
    private BankAccount bankAccount;

    public Client(String name, String dni, String email, Role role, BankAccount bankAccount) {
        super(name, dni, email, role);
        this.bankAccount = bankAccount;
    }

    public Long getBankAccount_id() {
        return bankAccount_id;
    }

    public void setBankAccount_id(Long bankAccount_id) {
        this.bankAccount_id = bankAccount_id;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "bankAccount_id=" + bankAccount_id +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
