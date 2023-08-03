//package com.neo.v1.configuration;
//
//import com.neo.v1.entity.FeatureConfiguration;
//import com.neo.v1.entity.Unit;
//import com.neo.v1.repository.FeatureConfigurationRepo;
//import com.neo.v1.repository.UnitRepo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
////TODO: CHANGE TO POSTCONSTRUCT
//@Component
//@Slf4j
//public class PreLoadDataEvent implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private FeatureConfigurationRepo featureConfigurationRepo;
//
//    @Autowired
//    private UnitRepo unitRepo;
//
//
//    @Transactional
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//
//        List<FeatureConfiguration> featureConfigurationsData =  featureConfigurationRepo.findAll();
//        log.info("featureConfiguration data {} "+ featureConfigurationsData);
//    }
//}
