package com.dawi.dawi_restapi.helpers.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * DTO para respuesta de estadísticas del dashboard
 */
public record DashboardStatsResponse(
        // Contadores generales
        int totalDepartamentos,
        int totalHoteles,
        long totalHabitaciones,
        int totalReservas,

        // Reservas por estado
        Map<String, Long> reservasPorEstado,

        // Ingresos
        double ingresosTotales,

        // Distribuciones
        Map<String, Long> hotelesPorDepartamento,
        Map<String, Long> reservasPorMes,
        Map<String, Double> ingresosPorMes,

        // Rankings
        List<TopHotel> topHoteles,
        List<ReservaReciente> reservasRecientes
) {
    /**
     * Hotel con más reservas
     */
    public record TopHotel(
            String nombre,
            long reservas
    ) {}

    /**
     * Reserva reciente simplificada
     */
    public record ReservaReciente(
            Long id,
            String cliente,
            String hotel,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            double total,
            String estado
    ) {}
}
