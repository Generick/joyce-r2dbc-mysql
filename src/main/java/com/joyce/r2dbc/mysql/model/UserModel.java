package com.joyce.r2dbc.mysql.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.joyce.r2dbc.mysql.util.ZonedDateTimeDeserializer;
import com.joyce.r2dbc.mysql.util.ZonedDateTimeSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("t_users")
@Entity
public class UserModel implements Serializable {

    private static final long serialVersionUID = 2657328362534343786L;
    @Id
    @Column(name = "user_id")
    private Long userId;

    private String username;

    private Integer age;

    @Column(name = "birthday_date_time")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @JsonSerialize(using = ZonedDateTimeSerialize.class)
    private ZonedDateTime birthdayDateTime;

    private String remark;

    @Column(name = "create_date_time")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @JsonSerialize(using = ZonedDateTimeSerialize.class)
    private ZonedDateTime createDateTime;

}
