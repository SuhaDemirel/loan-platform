package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "credit_limit", nullable = true)
    private Double creditLimit;

    @Column(name = "used_credit_limit", nullable = true)
    private Double usedCreditLimit;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "last_updated_by", nullable = true)
    private Long lastUpdatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double credit_limit) {
        this.creditLimit = credit_limit;
    }

    public Double getUsedCreditLimit() {
        return usedCreditLimit;
    }

    public void setUsedCreditLimit(Double used_credit_limit) {
        this.usedCreditLimit = used_credit_limit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.createdAt = created_at;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updated_at) {
        this.updatedAt = updated_at;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long last_updated_by) {
        this.lastUpdatedBy = last_updated_by;
    }

    public Double getAvailableCreditLimit() {
        return getCreditLimit() - getUsedCreditLimit();
    }
}
