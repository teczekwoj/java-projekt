package pl.javaprojekt.javaprojekt.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    private Integer id;
    private String ticketStatus;

}