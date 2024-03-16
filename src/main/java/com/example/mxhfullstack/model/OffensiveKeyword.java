package com.example.mxhfullstack.model;

import javax.persistence.Column;
import javax.persistence.Entity;


import lombok.Data;

@Entity
@Data
public class OffensiveKeyword {
    private Long id;
    private String keyword;

    public OffensiveKeyword(String keyword) {
        this.keyword = keyword;
    }

    public OffensiveKeyword() {

    }
}
