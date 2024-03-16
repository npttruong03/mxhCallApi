package com.example.mxhfullstack.model;



import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Mail extends BaseEntity{
    private String email;
    private String code;
}
