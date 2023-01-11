package rsoi.lab2.flight.api.response.error;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class ValidationErrorResponse {
    String message;
    List<ErrorDescription> errors;
}
