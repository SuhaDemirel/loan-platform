package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private Long id;

    private String first_name;
    private String last_name;
    private Double credit_limit;
    private Double used_credit_limit;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Long last_updated_by;
}
