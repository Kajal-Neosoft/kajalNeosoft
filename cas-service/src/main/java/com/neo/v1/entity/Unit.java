package com.neo.v1.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQUENCE_UNIT")
    @SequenceGenerator(name = "SEQUENCE_UNIT", sequenceName = "seq_unit")
    private int id;

    @Column(name = "code",length = 50)
    private String code;

    @Column(name = "unit_name",length = 255)
    private String unit_name;

    @Column(name = "currency", length = 50)
    private String currency;

    @Column(name = "currency_decimal_places",length = 50)
    private String currencyDecimalPlaces;

    @Column(name = "default_language",length = 50)
    private String defaultLanguage;
//
//    @Column(name = "time_zone", length = 100)
//    private String timeZone;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "unit")
    private List<UnitFeatureConfiguration> unitFeatureConfigurations;

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", unit_name='" + unit_name + '\'' +
                ", currency='" + currency + '\'' +
                ", currencyDecimalPlaces='" + currencyDecimalPlaces + '\'' +
                ", defaultLanguage='" + defaultLanguage + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", deleteDate=" + deleteDate +
                '}';
    }
}

//
//    @ManyToMany
//    @JoinTable(name = "unit_feature_configuration",joinColumns = {
//            @JoinColumn(name="unit_id")},inverseJoinColumns = {@JoinColumn(name = "feature_configuration_id")
//    })
//    private List<FeatureConfiguration> featureConfigurations;

