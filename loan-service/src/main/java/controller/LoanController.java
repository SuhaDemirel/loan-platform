package controller;

import entity.Loan;
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
}