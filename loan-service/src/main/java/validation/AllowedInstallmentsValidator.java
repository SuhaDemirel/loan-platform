package validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class AllowedInstallmentsValidator implements ConstraintValidator<AllowedInstallments, Integer> {

    private static final Set<Integer> ALLOWED_VALUES = Set.of(6, 9, 12, 24);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && ALLOWED_VALUES.contains(value);
    }
}
