package com.joyce.r2dbc.mysql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
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
@Table("t_orders")
public class OrderModel implements Serializable, AuditorAware<AdminModel> {

    private static final long serialVersionUID = 5533783016028963563L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "description")
    private String description;

    @CreatedBy
    private UserModel createUserModel;

    @CreatedDate
    private ZonedDateTime createDateTime;

    @LastModifiedBy
    private UserModel modifiedUserModel;

    @LastModifiedDate
    private ZonedDateTime modifiedDateTime;

    @Override
    public Optional<AdminModel> getCurrentAuditor() {
        return Optional.of(AdminModel.builder().id(1L).name("joyceAdmin").build());
    }
}
