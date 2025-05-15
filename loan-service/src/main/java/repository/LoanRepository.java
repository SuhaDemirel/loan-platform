package repository;

import entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface LoanRepository extends JpaRepository<Loan, BigInteger> {

}
