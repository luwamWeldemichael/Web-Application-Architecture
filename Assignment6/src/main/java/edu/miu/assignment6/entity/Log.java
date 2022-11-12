package edu.miu.assignment6.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "logs")

public class Log {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
    private String principal;
    private String operation;
    private String endPoint;
    private String method;
    private LocalDateTime requestTime;
}
