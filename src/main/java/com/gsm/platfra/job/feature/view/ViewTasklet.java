package com.gsm.platfra.job.feature.view;

import com.gsm.platfra.common.dto.FeatureViewCountDto;
import com.gsm.platfra.common.repository.CommonCodeQueryRepository;
import com.gsm.platfra.common.repository.FeatureViewQueryRepository;
import com.gsm.platfra.common.repository.PlatfraBoardContentQueryRepository;
import com.gsm.platfra.common.repository.PlatfraContentQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@StepScope
@Component
@RequiredArgsConstructor
public class ViewTasklet implements Tasklet {
    private final CommonCodeQueryRepository commonCodeQueryRepository;
    private final FeatureViewQueryRepository featureViewQueryRepository;
    private final PlatfraContentQueryRepository platfraContentQueryRepository;
    private final PlatfraBoardContentQueryRepository platfraBoardContentQueryRepository;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("tasklet start");
        List<String> contentList = commonCodeQueryRepository.getContentsInfo();
        contentList.forEach(contentCd -> {
            List<FeatureViewCountDto> viewCountDtoList = featureViewQueryRepository.getAddViewList(contentCd);
            // 컨텐츠별 조회수 증가
            updateCount(viewCountDtoList, contentCd);
        });
        return RepeatStatus.FINISHED;
    }
    private void updateCount(List<FeatureViewCountDto> viewCountDtoList, String contentCd) {
        switch (contentCd) {
            case "PLATFRA_CONTENT" -> viewCountDtoList.forEach(platfraContentQueryRepository::updateCount);
            case "BOARD_CONTENT" -> viewCountDtoList.forEach(platfraBoardContentQueryRepository::updateCount);
            default -> log.error("업데이트 대상 Code가 아님.");
        }
    }
}
