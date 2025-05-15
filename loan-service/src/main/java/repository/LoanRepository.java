package repository;

import entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, BigInteger> {

    @Query("SELECT l FROM Loan l WHERE l.customerId = :customerId" )
    List<Loan> getLoansByCustomerId(@Param("customerId") Long customerId);
}
