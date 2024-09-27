package com.example.ENAA__Fil_Rouge.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPerson extends EntityPathBase<Person> {

    private static final long serialVersionUID = -1457242031L;

    public static final QPerson person = new QPerson("person");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final NumberPath<Long> phoneNumber = createNumber("phoneNumber", Long.class);

    public final EnumPath<com.example.ENAA__Fil_Rouge.enums.Erole> role = createEnum("role", com.example.ENAA__Fil_Rouge.enums.Erole.class);

    public final StringPath username = createString("username");

    public QPerson(String variable) {
        super(Person.class, forVariable(variable));
    }

    public QPerson(Path<? extends Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerson(PathMetadata metadata) {
        super(Person.class, metadata);
    }

}

