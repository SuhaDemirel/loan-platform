package controller;

import controller.request.CreateLoanRequest;
import dto.PayLoanResultDto;
import entity.Loan;
import entity.LoanInstallment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.LoanService;

import java.util.List;

@RestController
@RequestMapping(path = "/loans")
public class LoanController {

    @Autowired
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/create")
    public ResponseEntity<Loan> createLoan(@Valid @RequestBody CreateLoanRequest createLoanRequest) {
        return ResponseEntity.ok(loanService.createLoan(createLoanRequest));
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<Loan>> listCustomerLoans(@PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(loanService.getLoansByCustomerId(customerId));
    }


    @GetMapping("/{id}/installments")
    public ResponseEntity<List<LoanInstallment>> listInstallments(@PathVariable("id") Long loanId) {
        return ResponseEntity.ok(loanService.getLoanInstallmentsByLoanId(loanId));
    }

    /*
    @PostMapping("/{id}/pay")
    public ResponseEntity<PayLoanResultDto> createLoan(@PathVariable("id") Long loanId,
                                                       @RequestParam @NotNull @Positive Double amount) {
        // return ResponseEntity.ok(loanService.payLoan(loanId, amount));
    }

     */
}