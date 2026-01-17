package com.osen.sistema_reservas.helpers.mappers;

import com.osen.sistema_reservas.core.hotel.dtos.HotelResponse;
import com.osen.sistema_reservas.core.hotel.model.Hotel;

public class HotelMapper {

    public static HotelResponse toDTO(Hotel hotel) {
        return new HotelResponse(
                hotel.getId(),
                hotel.getNombre(),
                hotel.getDireccion(),
                hotel.getDepartamento(),
                hotel.getHabitaciones().stream().map(HabitacionMapper::toDTO).toList(),
                hotel.getImagenUrl()
        );
    }

}
