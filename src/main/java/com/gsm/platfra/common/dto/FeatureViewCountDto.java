package com.gsm.platfra.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeatureViewCountDto {

    private String contentsCd;
    private Long contentsSeq;
    private Long count;
}