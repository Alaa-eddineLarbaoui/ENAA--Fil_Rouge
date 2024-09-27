package com.example.ENAA__Fil_Rouge.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPatient is a Querydsl query type for Patient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPatient extends EntityPathBase<Patient> {

    private static final long serialVersionUID = 1957160329L;

    public static final QPatient patient = new QPatient("patient");

    public final QPerson _super = new QPerson(this);

    public final StringPath address = createString("address");

    public final DateTimePath<java.util.Date> birthDate = createDateTime("birthDate", java.util.Date.class);

    //inherited
    public final StringPath email = _super.email;

    public final StringPath gender = createString("gender");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<Notification, QNotification> notifications = this.<Notification, QNotification>createSet("notifications", Notification.class, QNotification.class, PathInits.DIRECT2);

    //inherited
    public final StringPath password = _super.password;

    //inherited
    public final NumberPath<Long> phoneNumber = _super.phoneNumber;

    //inherited
    public final EnumPath<com.example.ENAA__Fil_Rouge.enums.Erole> role = _super.role;

    //inherited
    public final StringPath username = _super.username;

    public QPatient(String variable) {
        super(Patient.class, forVariable(variable));
    }

    public QPatient(Path<? extends Patient> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPatient(PathMetadata metadata) {
        super(Patient.class, metadata);
    }

}

