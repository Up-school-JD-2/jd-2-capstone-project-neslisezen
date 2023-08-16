package com.neslisezen.neslifly.dto.request;

import com.neslisezen.neslifly.entity.Airport;
import com.neslisezen.neslifly.entity.Flight;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSaveRequest
{
    private String airport_arr;
    private String airport_des;

}
