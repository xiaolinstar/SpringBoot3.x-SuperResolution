package com.xiaolin.superresolution.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author xlxing
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private static final String IMAGE_DIR = "./upload-images";

    private @Id @GeneratedValue Long id;
    private String name;
    @Transient
    private String base64;
    private String base64Path;
    private int scale;
    @Transient
    private String superBase64;
    private String superBase64Path;
}
