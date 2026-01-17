package com.osen.sistema_reservas.core.detalle_reserva.model;


import com.osen.sistema_reservas.core.habitacion.models.Habitacion;
import com.osen.sistema_reservas.core.reserva.models.Reserva;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double precioNoche;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;

}
