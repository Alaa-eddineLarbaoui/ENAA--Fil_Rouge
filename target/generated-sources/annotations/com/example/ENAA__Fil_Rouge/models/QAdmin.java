package com.example.ENAA__Fil_Rouge.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdmin is a Querydsl query type for Admin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdmin extends EntityPathBase<Admin> {

    private static final long serialVersionUID = -60895533L;

    public static final QAdmin admin = new QAdmin("admin");

    public final QPerson _super = new QPerson(this);

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath password = _super.password;

    //inherited
    public final NumberPath<Long> phoneNumber = _super.phoneNumber;

    //inherited
    public final EnumPath<com.example.ENAA__Fil_Rouge.enums.Erole> role = _super.role;

    //inherited
    public final StringPath username = _super.username;

    public QAdmin(String variable) {
        super(Admin.class, forVariable(variable));
    }

    public QAdmin(Path<? extends Admin> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdmin(PathMetadata metadata) {
        super(Admin.class, metadata);
    }

}

