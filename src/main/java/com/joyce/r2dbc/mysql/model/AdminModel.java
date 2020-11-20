package com.joyce.r2dbc.mysql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;

/**
 https://docs.spring.io/spring-data/r2dbc/docs/1.2.1/reference/html/#r2dbc.auditing

 The following example shows an implementation of the interface that uses Spring Security’s Authentication object:
 class SpringSecurityAuditorAware implements AuditorAware<User> {

@Override
public Optional<User> getCurrentAuditor() {

    return Optional.ofNullable(SecurityContextHolder.getContext())
    .map(SecurityContext::getAuthentication)
    .filter(Authentication::isAuthenticated)
    .map(Authentication::getPrincipal)
    .map(User.class::cast);
    }
}

 * @author: Joyce Zhu
 * @date: 2020/11/20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("t_admin")
public class AdminModel {

    private Long id;

    private String name;

}
