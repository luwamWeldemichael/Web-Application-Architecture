package assignments.assignment3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyException {
    @Id
    long transactionId;
    LocalDate date;
    int time;
    String principle;
    String operation;
    String exceptionType;
}
