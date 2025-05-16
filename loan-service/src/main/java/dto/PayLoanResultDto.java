package dto;

public record PayLoanResultDto(
    int installmentsPaid,
    double totalPaidAmount,
    boolean loanFullyPaid
) {}
