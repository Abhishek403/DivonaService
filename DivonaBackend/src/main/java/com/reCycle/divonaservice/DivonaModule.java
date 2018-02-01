package com.reCycle.divonaservice;

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.reCycle.divonaservice.configuration.DivonaConfiguration;
import com.reCycle.divonaservice.dao.ICycleDao;
import com.reCycle.divonaservice.dao.IDockDao;
import com.reCycle.divonaservice.dao.IReservationDao;
import com.reCycle.divonaservice.dao.IUserDao;
import com.reCycle.divonaservice.dao.impl.CycleDao;
import com.reCycle.divonaservice.dao.impl.DockDao;
import com.reCycle.divonaservice.dao.impl.ReservationDao;
import com.reCycle.divonaservice.dao.impl.UserDao;
import com.reCycle.divonaservice.service.ICycleService;
import com.reCycle.divonaservice.service.IDockService;
import com.reCycle.divonaservice.service.IReservationService;
import com.reCycle.divonaservice.service.IUserService;
import com.reCycle.divonaservice.service.impl.CycleService;
import com.reCycle.divonaservice.service.impl.DockService;
import com.reCycle.divonaservice.service.impl.ReservationService;
import com.reCycle.divonaservice.service.impl.UserService;

/**
 * @author dasabhi
 */
public class DivonaModule extends AbstractModule {

    private final MetricRegistry metricRegistry;

    public DivonaModule(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }

    @Override protected void configure() {
        //Dao
        bind(IUserDao.class).to(UserDao.class);
        bind(IDockDao.class).to(DockDao.class);
        bind(ICycleDao.class).to(CycleDao.class);
        bind(IReservationDao.class).to(ReservationDao.class);

        //Service
        bind(IUserService.class).to(UserService.class);
        bind(IDockService.class).to(DockService.class);
        bind(ICycleService.class).to(CycleService.class);
        bind(IReservationService.class).to(ReservationService.class);
    }

    @Provides
    @Singleton
    public ObjectMapper getObjectMapper(DivonaConfiguration divonaConfiguration) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    @Provides
    @Named("reservationMinInterval")
    @Singleton
    public long getReservationMinInterval(DivonaConfiguration divonaConfiguration) {
        return divonaConfiguration.getReservationMinInterval();
    }

    @Provides
    @Named("reservationTimeout")
    @Singleton
    public long getReservationTimeout(DivonaConfiguration divonaConfiguration) {
        return divonaConfiguration.getReservationTimeout();
    }
}
