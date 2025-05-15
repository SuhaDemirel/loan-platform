package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
public class LoanInstallment {

    @Id
    private Long id;

    private Long loan_id;
    private Double amount;
    private Integer paid_amount;
    private Boolean isPaid;
    private LocalDateTime due_date;
    private LocalDateTime payment_date;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Long last_updated_by;


}
