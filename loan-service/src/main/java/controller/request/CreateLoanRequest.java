package controller.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import validation.AllowedInstallments;


public record CreateLoanRequest(

        @NotNull
        @Positive
        Long customerId,

        @NotNull
        @Positive
        Double amount,

        @DecimalMin("0.1")
        @DecimalMax("0.5")
        Double interestRate,

        @AllowedInstallments
        Integer installmentNumber

) {
}
