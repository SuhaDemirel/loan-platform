package service;

import controller.request.CreateLoanRequest;
import entity.Customer;
import entity.Loan;
import entity.LoanInstallment;
import exception.CustomerNotFoundException;
import exception.InsufficientAvailableLimitException;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;
import repository.LoanInstallmentRepository;
import repository.LoanRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;

@Service
public class LoanService {


    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;
    private final LoanInstallmentRepository loanInstallmentRepository;

    public LoanService(LoanRepository loanRepository, CustomerRepository customerRepository, LoanInstallmentRepository loanInstallmentRepository) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
        this.loanInstallmentRepository = loanInstallmentRepository;
    }

    public Loan createLoan(CreateLoanRequest request) {
        Customer customer = customerRepository.findById(request.customerId()).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        if (request.amount() > customer.getAvailableCreditLimit()) {
            throw new InsufficientAvailableLimitException("The amount of credit limit exceeded");
        }
        Double finalTotalAmount = calculateFinalPaymentAmount(request.amount(), request.interestRate());
        Double installmentAmount = calculateInstallmentAmount(request, finalTotalAmount);

        Loan loan = new Loan();
        loan.setCustomerId(request.customerId());
        loan.setAmount(request.amount());
        loan.setInstallmentNumber(request.installmentNumber());
        loan.setIsPaid(FALSE);
        loan.setCreatedAt(LocalDateTime.now());
        loan.setUpdatedAt(LocalDateTime.now());

        loanRepository.save(loan);

        List<LoanInstallment> installments = new ArrayList<>();
        for (int i = 0; i < request.installmentNumber(); i++) {
            LoanInstallment loanInstallment = new LoanInstallment();
            loanInstallment.setLoanId(loan.getId());
            loanInstallment.setAmount(installmentAmount);
            loanInstallment.setPaidAmount(0.0);
            loanInstallment.setIsPaid(FALSE);
            // fix
            loanInstallment.setDueDate(LocalDate.now());
            loan.setCreatedAt(LocalDateTime.now());
            loan.setUpdatedAt(LocalDateTime.now());

            installments.add(loanInstallment);
        }
        loanInstallmentRepository.saveAll(installments);

        return loan;
    }

    public List<Loan> getLoansByCustomerId(Long customerId) {
        return loanRepository.getLoansByCustomerId(customerId);
    }

    public List<LoanInstallment> getLoanInstallmentsByLoanId(Long loanId) {
        return loanInstallmentRepository.getLoanInstallmentsByLoanId(loanId);
    }


    /*
    public void payLoan(Long customerId, Long LoanId, Double paymentAmount) {
        Loan loan = loanRepository.findById(LoanId).orElseThrow();
        if (paymentAmount < loan.getAmount() / loan.getInstallmentNumber())
            throw new RuntimeException();
        List<LoanInstallment> installments = loanInstallmentRepository.findByLoanId(loan.getId())
    }*/

    private static Double calculateFinalPaymentAmount(Double requestedAmount, Double interestRate) {
        double result = requestedAmount * (1 + interestRate);
        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private static double calculateInstallmentAmount(CreateLoanRequest request, Double finalTotalAmount) {
        return new BigDecimal(finalTotalAmount / request.installmentNumber()).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
