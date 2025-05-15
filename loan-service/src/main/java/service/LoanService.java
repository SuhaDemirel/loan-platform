package service;

import controller.request.CreateLoanRequest;
import entity.Customer;
import entity.Loan;
import entity.LoanInstallment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;
import repository.LoanInstallmentRepository;
import repository.LoanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanInstallmentRepository loanInstallmentRepository;

    public Loan createLoan(CreateLoanRequest request) {
       Customer customer = customerRepository.findById(request.customerId()).orElseThrow();
        if (request.amount() > customer.getCreditLimit()-customer.getUsedCreditLimit())
            throw new RuntimeException();
        Double installmentAmount = (request.amount()  * (1 + request.interestRate())) / request.installmentNumber();
        Loan loan = loanRepository.save(loan)
                List<LoanInstallment> installments = new ArrayList<>();
                for(int i = 0; i < request.installmentNumber(); i++ ){
                    LoanInstallment loanInstallment = new LoanInstallment(loan.getId(), installmentAmount);
                    installments.add(loanInstallment);
                }
                loanInstallmentRepository.saveAll(installments);

        return loanRepository.save(c);
    }

    public List<Loan> getLoansByCustomerId(Long customerId) {
        return loanRepository.getLoansByCustomerId(customerId);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public void payLoan(Long customerId, Long LoanId, Double paymentAmount) {
        Loan loan = loanRepository.findById(LoanId).orElseThrow();
        if (paymentAmount<loan.getAmount()/loan.getInstallmentNumber())
            throw new RuntimeException();
        List<LoanInstallment> installments = loanInstallmentRepository.findByLoanId(loan.getId())
    }
}
