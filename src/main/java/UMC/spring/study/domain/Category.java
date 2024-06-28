package UMC.spring.study.domain;

import UMC.spring.study.domain.common.BaseEntity;
import jakarta.persistence.*;

public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'PARTS'")
    private UMC.spring.study.domain.enums.Category name;
}
