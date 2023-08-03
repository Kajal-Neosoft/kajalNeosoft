package com.neo.v1.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feature_configuration")
public class FeatureConfiguration {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQUENCE_FEATURE_CONFIGURATION")
    @SequenceGenerator(name = "SEQUENCE_FEATURE_CONFIGURATION", sequenceName = "seq_feature_configuration")
    private int id;

    @Column(name = "segment_name",length = 255)
    private String segmentName;

    @Column(name = "param", length = 255)
    private String param;

    @Column(name = "value", length = 255)
    private String value;

    @Column(name = "type" , length = 100)
    private String type;

    @Column(name = "description", length = 500)
    private String description;

//    @Column(name = "app_version", length = 255)
//    private String appVersion;

    @Column(name = "platform", length = 40)
    private String platform;

//    @Column(name = "time_zone", length = 100)
//    private String timeZone;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "featureConfiguration")
    private List<UnitFeatureConfiguration> unitFeatureConfigurations;

}



//
//    @ManyToMany(mappedBy = "featureConfigurations",fetch = FetchType.EAGER)
//    private List<Unit> units;