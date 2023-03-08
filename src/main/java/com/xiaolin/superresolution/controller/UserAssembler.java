package com.xiaolin.superresolution.controller;

import com.xiaolin.superresolution.model.entity.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @author xlxing
 */
@Component
public class UserAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(@NonNull User entity) {
        return EntityModel.of(entity);
    }
}
