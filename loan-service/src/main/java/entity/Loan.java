package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @Column(nullable = false, columnDefinition = "BIGINT")
    private BigInteger id;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
