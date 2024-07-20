package com.NetWestExample.NetWestAPi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OutputRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String outfield1;
    private String outfield2;
    private String outfield3;
    private BigDecimal outfield4;
    private BigDecimal outfield5;
}
