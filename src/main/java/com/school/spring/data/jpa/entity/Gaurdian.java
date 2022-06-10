package com.school.spring.data.jpa.entity;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embeddable;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "gaurdian_name")),
        @AttributeOverride(name = "mobile", column = @Column(name = "gaurdian_mobile")),
        @AttributeOverride(name = "mailId", column = @Column(name = "gaurdian_mail_id"))
})
public class Gaurdian {

    private String name;
    private String mobile;
    private String mailId;

}
