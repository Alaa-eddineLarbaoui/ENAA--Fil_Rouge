package com.example.ENAA__Fil_Rouge.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHealthProfessional is a Querydsl query type for HealthProfessional
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHealthProfessional extends EntityPathBase<HealthProfessional> {

    private static final long serialVersionUID = -936290913L;

    public static final QHealthProfessional healthProfessional = new QHealthProfessional("healthProfessional");

    public final QPerson _super = new QPerson(this);

    public final ListPath<Availability, QAvailability> availabilities = this.<Availability, QAvailability>createList("availabilities", Availability.class, QAvailability.class, PathInits.DIRECT2);

    public final StringPath bio = createString("bio");

    public final StringPath clinicAddress = createString("clinicAddress");

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    //inherited
    public final StringPath password = _super.password;

    //inherited
    public final NumberPath<Long> phoneNumber = _super.phoneNumber;

    public final StringPath registrationNumber = createString("registrationNumber");

    //inherited
    public final EnumPath<com.example.ENAA__Fil_Rouge.enums.Erole> role = _super.role;

    public final EnumPath<com.example.ENAA__Fil_Rouge.enums.Speciality> specialty = createEnum("specialty", com.example.ENAA__Fil_Rouge.enums.Speciality.class);

    //inherited
    public final StringPath username = _super.username;

    public QHealthProfessional(String variable) {
        super(HealthProfessional.class, forVariable(variable));
    }

    public QHealthProfessional(Path<? extends HealthProfessional> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHealthProfessional(PathMetadata metadata) {
        super(HealthProfessional.class, metadata);
    }

}

