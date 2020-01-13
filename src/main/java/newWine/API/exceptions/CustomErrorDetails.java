package newWine.API.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class CustomErrorDetails {
        private Date timestamp;
        private String message;
        private String errorDetails;
}
