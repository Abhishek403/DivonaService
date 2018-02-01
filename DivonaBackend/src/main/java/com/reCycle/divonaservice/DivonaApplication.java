package com.reCycle.divonaservice;

import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.reCycle.divonaservice.configuration.DivonaConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import java.text.SimpleDateFormat;

/**
 * @author dasabhi
 */
public class DivonaApplication extends Application<DivonaConfiguration> {

    public static void main(String[] args) throws Exception {
        new DivonaApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap bootstrap) {

        DivonaModule module = new DivonaModule(bootstrap.getMetricRegistry());
        GuiceBundle<DivonaConfiguration> guiceBundle = GuiceBundle.<DivonaConfiguration>newBuilder()
                .setConfigClass(DivonaConfiguration.class)
                .enableAutoConfig(getClass().getPackage().getName())
                .addModule(module)
                .build(Stage.DEVELOPMENT);

        bootstrap.addBundle(guiceBundle);

        bootstrap.addBundle(new SwaggerBundle<DivonaConfiguration>() {
            @Override
            public SwaggerBundleConfiguration getSwaggerBundleConfiguration(DivonaConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        });
        bootstrap.getObjectMapper().registerModule(new JodaModule());
        bootstrap.getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS"));
    }

    @Override public void run(DivonaConfiguration configuration, Environment environment) throws Exception {
    }
}
