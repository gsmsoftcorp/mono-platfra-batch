package com.gsm.platfra.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.gsm.platfra.api.data.common.code.QTCommonCode.tCommonCode;


/**
 *
 */
@Repository
@RequiredArgsConstructor
public class CommonCodeQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<String> getContentsInfo() {
        return queryFactory
                .select(
                    tCommonCode.commonCd
                )
                .from(tCommonCode)
                .where(
                        tCommonCode.commonCd.contains("CONTENT")
                ).fetch();
    }
}























