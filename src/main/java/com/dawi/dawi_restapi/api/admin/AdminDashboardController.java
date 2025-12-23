package com.dawi.dawi_restapi.api.admin;

import com.dawi.dawi_restapi.core.dashboard.service.DashboardService;
import com.dawi.dawi_restapi.helpers.dtos.DashboardStatsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para el dashboard de administración.
 * Solo maneja requests/responses, toda la lógica está en DashboardService.
 */
@RestController
@RequestMapping("/api/admin/dashboard")
@RequiredArgsConstructor
public class AdminDashboardController {

    private final DashboardService dashboardService;

    /**
     * Obtiene las estadísticas del dashboard
     */
    @GetMapping("/stats")
    public ResponseEntity<DashboardStatsResponse> getStats() {
        DashboardStatsResponse stats = dashboardService.obtenerEstadisticas();
        return ResponseEntity.ok(stats);
    }
}
