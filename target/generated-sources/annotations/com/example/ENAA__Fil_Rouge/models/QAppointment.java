package com.example.ENAA__Fil_Rouge.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppointment is a Querydsl query type for Appointment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAppointment extends EntityPathBase<Appointment> {

    private static final long serialVersionUID = -190811101L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppointment appointment = new QAppointment("appointment");

    public final EnumPath<com.example.ENAA__Fil_Rouge.enums.AppointmentReason> appointmentReason = createEnum("appointmentReason", com.example.ENAA__Fil_Rouge.enums.AppointmentReason.class);

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath note = createString("note");

    public final BooleanPath notificationEnvoyee = createBoolean("notificationEnvoyee");

    public final QPatient patient;

    public final QHealthProfessional professional;

    public final EnumPath<com.example.ENAA__Fil_Rouge.enums.AppointmentStatus> status = createEnum("status", com.example.ENAA__Fil_Rouge.enums.AppointmentStatus.class);

    public final TimePath<java.time.LocalTime> time = createTime("time", java.time.LocalTime.class);

    public QAppointment(String variable) {
        this(Appointment.class, forVariable(variable), INITS);
    }

    public QAppointment(Path<? extends Appointment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppointment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppointment(PathMetadata metadata, PathInits inits) {
        this(Appointment.class, metadata, inits);
    }

    public QAppointment(Class<? extends Appointment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.patient = inits.isInitialized("patient") ? new QPatient(forProperty("patient")) : null;
        this.professional = inits.isInitialized("professional") ? new QHealthProfessional(forProperty("professional")) : null;
    }

}

