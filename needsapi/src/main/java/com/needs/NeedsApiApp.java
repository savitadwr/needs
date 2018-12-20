package com.needs;

import com.needs.rs.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NeedsApiApp extends Application<Config> {
    public static void main(String[] args) throws Exception {
        new NeedsApiApp().run(args);
    }

    @Override
    public String getName() {
        return "needs-api";
    }

    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(Config configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        final NeedsHealthCheck healthCheck =
                new NeedsHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
