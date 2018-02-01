package com.reCycle.divonaservice.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author dasabhi
 */
@Data
public class DivonaConfiguration extends Configuration {

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @NotEmpty
    @JsonProperty
    private String name;

    @NotEmpty
    @JsonProperty
    private String hostname;

    @JsonProperty("reservationTimeout")
    private long reservationTimeout;

    @JsonProperty("reservationMinInterval")
    private long reservationMinInterval;
}
