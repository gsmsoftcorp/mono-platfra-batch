package com.gsm.platfra.common.repository;

import com.gsm.platfra.common.dto.FeatureViewCountDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.gsm.platfra.api.data.platfra.QTPlatfraContent.tPlatfraContent;


@Repository
@RequiredArgsConstructor
public class PlatfraContentQueryRepository {
    private final JPAQueryFactory queryFactory;
    
    public void updateCount(FeatureViewCountDto dto){
        queryFactory
                .update(tPlatfraContent)
                .set(tPlatfraContent.view, tPlatfraContent.view.add(dto.getCount()))
                .where(tPlatfraContent.contentSeq.eq(dto.getContentsSeq()))
                .execute();
    }
}























