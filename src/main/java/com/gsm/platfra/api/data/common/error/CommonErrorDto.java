package com.gsm.platfra.api.data.common.error;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonErrorDto {
    private Long errorSeq;
    private String url;
    private String location;
    private String reqData;
    private String errorMsg;
    private String resData;

    public static TCommonError toEntity(CommonErrorDto dto) {
        return TCommonError.builder()
                .url(dto.url)
                .location(dto.location)
                .reqData(dto.reqData)
                .errorMsg(dto.errorMsg)
                .resData(dto.resData)
                .build();
    }
}
