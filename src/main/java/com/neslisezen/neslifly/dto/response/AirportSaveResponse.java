package com.neslisezen.neslifly.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportSaveResponse
{
    private int id;

    private String name;

    private String city;
    //assumption: every city has just one airport***

    private String abbr;
    private Boolean is_active;
}
