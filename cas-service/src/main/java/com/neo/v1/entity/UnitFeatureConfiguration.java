package com.neo.v1.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unit_feature_configuration")
public class UnitFeatureConfiguration {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQUENCE_UNIT_FEATURE_CONFIGURATION")
    @SequenceGenerator(name = "SEQUENCE_UNIT_FEATURE_CONFIGURATION", sequenceName = "seq_unit_feature_configuration")
    private int id;

    @ManyToOne
    @JoinColumn(name = "feature_configuration_id")
    private FeatureConfiguration featureConfiguration;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

}
