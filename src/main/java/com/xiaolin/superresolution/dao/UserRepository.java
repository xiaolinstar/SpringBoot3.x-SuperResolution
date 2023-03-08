package com.xiaolin.superresolution.dao;

import com.xiaolin.superresolution.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xlxing
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
