package com.gsm.platfra.common.repository;

import com.gsm.platfra.common.dto.FeatureViewCountDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import static com.gsm.platfra.api.data.platfraboard.QTPlatfraBoardContent.tPlatfraBoardContent;


@Repository
@RequiredArgsConstructor
public class PlatfraBoardContentQueryRepository {
  private final JPAQueryFactory queryFactory;

    public void updateCount(FeatureViewCountDto dto){
        queryFactory
                .update(tPlatfraBoardContent)
                .set(tPlatfraBoardContent.view, tPlatfraBoardContent.view.add(dto.getCount()))
                .where(tPlatfraBoardContent.contentSeq.eq(dto.getContentsSeq()))
                .execute();
    }
}
