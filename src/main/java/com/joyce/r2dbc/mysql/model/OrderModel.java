package com.joyce.r2dbc.mysql.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.joyce.r2dbc.mysql.util.ZonedDateTimeDeserializer;
import com.joyce.r2dbc.mysql.util.ZonedDateTimeSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Table("t_orders")
//@org.springframework.data.relational.core.mapping.Table("t_orders") // as r2dbc model
@javax.persistence.Table(name = "t_orders") // as JPA model
@Entity // as JPA model
public class OrderModel implements Serializable {

    private static final long serialVersionUID = 5533783016028963563L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    @Column(name = "remark")
    private String remark;

    @Column(name = "create_date_time")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @JsonSerialize(using = ZonedDateTimeSerialize.class)
    private ZonedDateTime createDateTime;

    // follow fields about @EnableR2dbcAuditing

//    @CreatedBy
//    private UserModel createUserModel;

//    @CreatedDate
//    private ZonedDateTime createDateTime;

//    @LastModifiedBy
//    private UserModel modifiedUserModel;

//    @LastModifiedDate
//    private ZonedDateTime modifiedDateTime;

}
