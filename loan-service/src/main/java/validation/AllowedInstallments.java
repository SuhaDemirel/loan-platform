package validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AllowedInstallmentsValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowedInstallments {
    String message() default "Installment number must be one of 6, 9, 12, or 24";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
