package com.fatura.apiFatura.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="faturas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = "\\d{16}", message = "O número do cartão deve conter exatamente 16 dígitos numéricos")
    private String numeroCartao;

    @NotNull
    @Size(min = 3, max = 100, message = "O nome do titular deve ter entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull
    @DecimalMin(value = "10.00", message = "O valor mínimo é 10.00")
    @DecimalMax(value = "5000.00", message = "O valor máximo é 5000.00")
    private Double valor;

    @NotNull
    @FutureOrPresent(message = "A data de pagamento deve ser presente ou futura")
    private LocalDate dataPagamento;

    @NotNull
    @Email(message = "O e-mail de contato deve ser válido")
    private String emailContato;
}
