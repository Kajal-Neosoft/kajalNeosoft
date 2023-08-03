package com.neo.v1.service;

import com.neo.v1.entity.FeatureConfiguration;
import com.neo.v1.entity.Unit;
import com.neo.v1.entity.UnitFeatureConfiguration;
import com.neo.v1.repository.UnitRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FeatureConfigurationService {

    private final UnitRepo unitRepo;

    private static Map<String, List<FeatureConfiguration>> unitNameConfigurationMap=new HashMap<>();

    @PostConstruct
    @Transactional(readOnly = true)
    @Scheduled(fixedDelay = 300000)
    public void getEventOnLoadAppliction()
    {
        List<Unit> units = unitRepo.findAll();
        System.out.println("all unit data: "+units);

        for(Unit unit: units)
        {
            List<FeatureConfiguration> featureConfigurations = unit.getUnitFeatureConfigurations()
                    .stream().map(UnitFeatureConfiguration::getFeatureConfiguration)
                    .collect(Collectors.toList());
            System.out.println("Feature Configurations for Unit " + unit.getId() + ": " + featureConfigurations);

            unitNameConfigurationMap.put(unit.getCode(),featureConfigurations);
        }
        System.out.println("mapped data :"+unitNameConfigurationMap);
    }
    public Map<String, List<FeatureConfiguration>> getUnitNameConfigurationMap() {
        return unitNameConfigurationMap;
    }
}
