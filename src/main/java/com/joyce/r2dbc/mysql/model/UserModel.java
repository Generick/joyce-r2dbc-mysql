package com.joyce.r2dbc.mysql.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.joyce.r2dbc.mysql.util.ZonedDateTimeDeserializer;
import com.joyce.r2dbc.mysql.util.ZonedDateTimeSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("t_users")
public class UserModel implements Serializable, AuditorAware<AdminModel> {

    private static final long serialVersionUID = 2657328362534343786L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String username;

    private Integer age;

//    @DateTimeFormat(pattern = DatetimeConstant.yyyy_MM_dd_HH_mm_ss)
    @Column(name = "birthday_date_time")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @JsonSerialize(using = ZonedDateTimeSerialize.class)
    private ZonedDateTime birthdayDateTime;

    private String remark;

    @Column(name = "create_date_time")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @JsonSerialize(using = ZonedDateTimeSerialize.class)
    private ZonedDateTime createDateTime;

    static final Random random = new Random();
    public static UserModel getNewInstance() {
        return UserModel.builder()
                .age(random.nextInt(100) + 1)
                .username(UUID.randomUUID().toString())
                .birthdayDateTime(ZonedDateTime.now().minusDays(random.nextInt(40 * 365 - 1)))// 最近的40年的任意一天作为生日
                .remark("" + random.nextInt(10))
                .createDateTime(ZonedDateTime.now())
                .build();
    }

    @Override
    public Optional<AdminModel> getCurrentAuditor() {
        return Optional.of(AdminModel.builder().id(1L).name("joyceAdmin").build());
    }

}
