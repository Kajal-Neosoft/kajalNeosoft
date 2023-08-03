package com.neo.v1.repository;

import com.neo.v1.entity.FeatureConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeatureConfigurationRepo extends JpaRepository<FeatureConfiguration,Integer> {


   // @Query("Select fc from feature_configuration fc where (fc.segmentName=:segment OR fc.segmentName IS NULL) or (fc.param=:filterByParameter)")
    List<FeatureConfiguration> findBySegmentNameOrSegmentNameIsNullOrParam(@Param("segment") String segment, @Param("filterByParameter") String filterByParameter);
    List<FeatureConfiguration> findBySegmentNameOrSegmentNameIsNull(@Param("segment") String segment);
    List<FeatureConfiguration> findBySegmentNameIsNull();
    List<FeatureConfiguration> findByParamOrSegmentNameIsNull(@Param("filterByParameter") String filterByParameter);

}
