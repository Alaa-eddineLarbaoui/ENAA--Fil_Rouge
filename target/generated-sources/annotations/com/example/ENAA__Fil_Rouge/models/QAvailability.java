package com.example.ENAA__Fil_Rouge.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAvailability is a Querydsl query type for Availability
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAvailability extends EntityPathBase<Availability> {

    private static final long serialVersionUID = -1142420137L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAvailability availability = new QAvailability("availability");

    public final BooleanPath available = createBoolean("available");

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final TimePath<java.time.LocalTime> endTime = createTime("endTime", java.time.LocalTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QHealthProfessional professional;

    public final TimePath<java.time.LocalTime> startTime = createTime("startTime", java.time.LocalTime.class);

    public QAvailability(String variable) {
        this(Availability.class, forVariable(variable), INITS);
    }

    public QAvailability(Path<? extends Availability> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAvailability(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAvailability(PathMetadata metadata, PathInits inits) {
        this(Availability.class, metadata, inits);
    }

    public QAvailability(Class<? extends Availability> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.professional = inits.isInitialized("professional") ? new QHealthProfessional(forProperty("professional")) : null;
    }

}

