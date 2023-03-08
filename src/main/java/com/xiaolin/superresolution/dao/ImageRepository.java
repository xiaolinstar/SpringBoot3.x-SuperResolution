package com.xiaolin.superresolution.dao;

import com.xiaolin.superresolution.model.entity.Image;
import com.xiaolin.superresolution.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xlxing
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
}
