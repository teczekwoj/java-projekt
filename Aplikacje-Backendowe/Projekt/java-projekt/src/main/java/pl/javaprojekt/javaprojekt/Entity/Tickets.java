package pl.javaprojekt.javaprojekt.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tickets {
    private Integer id;
    private String ticketNo;
    private String object;
    private String product;
    private String description;
    private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfRealization;
   // private String ticketStatus;
}
