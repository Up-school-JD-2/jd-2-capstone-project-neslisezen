package com.neslisezen.neslifly.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirlineSaveResponse
{
    private int id;

    private String name;
}
