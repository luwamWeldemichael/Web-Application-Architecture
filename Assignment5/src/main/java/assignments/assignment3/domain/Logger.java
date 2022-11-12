package assignments.assignment3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Table()
public class Logger {
    @Id
            @Column(length = 12)
            @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long transactionId;
    LocalDate date;
    int time;
    String principle;
    String operation;
}
