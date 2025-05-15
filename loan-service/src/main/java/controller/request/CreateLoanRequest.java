package controller.request;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import validation.AllowedInstallments;

import java.time.LocalDateTime;


public record CreateLoanRequest(

        @Nonnull
        Long customerId,

        Double amount,

        @DecimalMin("0.1")
        @DecimalMax("0.5")
        Double interestRate,

        @AllowedInstallments
        Integer installmentNumber

) {
}
