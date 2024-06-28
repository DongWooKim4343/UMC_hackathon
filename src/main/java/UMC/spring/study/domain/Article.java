package UMC.spring.study.domain;

import UMC.spring.study.domain.common.BaseEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int user_id;

    private int category_id;

    private String name;

    private String title;

    private String body;

    private int articlePrice;

}
