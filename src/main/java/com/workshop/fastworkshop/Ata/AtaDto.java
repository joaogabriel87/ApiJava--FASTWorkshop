package com.workshop.fastworkshop.Ata;


import java.util.List;

public record AtaDto(
        Long workshopId,
        List<Long> colaboradoresIds
) {
}
