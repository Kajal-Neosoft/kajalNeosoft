package com.neo.v1.service;

import com.neo.v1.cas.model.CasConfigurationData;
import com.neo.v1.cas.model.CasResponse;
import com.neo.v1.cas.model.Configuration;
import com.neo.v1.cas.model.Meta;
import com.neo.v1.constant.CasConstant;
import com.neo.v1.entity.FeatureConfiguration;
import com.neo.v1.repository.FeatureConfigurationRepo;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.soap.saaj.support.SaajUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@ToString
@Service
public class CasService {

    @Autowired
    private FeatureConfigurationRepo featureConfigurationRepo;

    @Autowired
    private FeatureConfigurationService featureConfigurationService;


    public CasResponse getConfiguration(String segment, String filterByParameter, String unitName) {
        CasConfigurationData configurations = null;
        Map<String, List<FeatureConfiguration>> unitNameConfigurationMap = featureConfigurationService.getUnitNameConfigurationMap();
        Meta meta = new Meta();
        CasResponse casResponseData = null;
        List<Configuration> configurationObjects = new ArrayList<>();

        List<FeatureConfiguration> featureConfigurations = unitNameConfigurationMap.get(unitName);
        System.out.println("based on unit name getting featureConfiguration: " + featureConfigurations);

        if (segment != null && filterByParameter != null) {
            // featureConfigurations = featureConfigurationRepo.findBySegmentNameOrSegmentNameIsNullOrParam(segment, filterByParameter);
            featureConfigurations = featureConfigurations.stream()
                    .filter(s -> segment.equals(s.getSegmentName()) || s.getSegmentName() == null || filterByParameter.equals(s.getParam()))
                    .collect(Collectors.toList());
        }
        else if (segment != null) {
            // featureConfigurations = featureConfigurationRepo.findBySegmentNameOrSegmentNameIsNull(segment);
            featureConfigurations = featureConfigurations.stream()
                    .filter(s -> segment.equals(s.getSegmentName()) || s.getSegmentName() == null)
                    .collect(Collectors.toList());
        }
        else if (filterByParameter != null && segment == null) {
            // featureConfigurations = featureConfigurationRepo.findByParamOrSegmentNameIsNull(filterByParameter);
            featureConfigurations = featureConfigurations.stream()
                    .filter(s -> filterByParameter.equals(s.getParam()) || s.getSegmentName() == null)
                    .collect(Collectors.toList());
        }
        else {
            //featureConfigurations = featureConfigurationRepo.findBySegmentNameIsNull();
            featureConfigurations = featureConfigurations.stream()
                    .filter(s -> s.getSegmentName() == null)
                    .collect(Collectors.toList());
        }

        for (FeatureConfiguration featureConfiguration : featureConfigurations) {
            Configuration configurationObject = Configuration.builder().value(featureConfiguration.getValue()).type(featureConfiguration.getType()).param(featureConfiguration.getParam()).description(featureConfiguration.getDescription()).build();
            configurationObjects.add(configurationObject);
        }

        meta = Meta.builder().code(CasConstant.CAS).message(CasConstant.CONFIGURATION_HAVE_BEEN_FETCHED_SUCCESSFULLY).build();
        casResponseData = CasResponse.builder()
                .meta(meta)
                .data( CasConfigurationData.builder()
                        .configurations(configurationObjects)
                        .build())
                .build();
        return casResponseData;
    }


}




