package ch.demo.gpietro.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@Scope("singleton")
public class SchemaRegistryConfig {

    public final String url;
    public final String basicAuthCredentialsSource;
    public final String basicAuthUserInfo;

    @Autowired
    public SchemaRegistryConfig(
            @Value("${spring.kafka.properties.schema.registry.url}") final String url,
            @Value("${spring.kafka.properties.basic.auth.credentials.source}") final String basicAuthCredentialsSource,
            @Value("${spring.kafka.properties.schema.registry.basic.auth.user.info}") final String basicAuthUserInfo) {
        this.url = url;
        this.basicAuthCredentialsSource = basicAuthCredentialsSource;
        this.basicAuthUserInfo = basicAuthUserInfo;
    }

    public Properties buildProperties() {
        return buildProperties(this);
    }

    public static Properties buildProperties(SchemaRegistryConfig config) {
        final Properties properties = new Properties();
        properties.put("schema.registry.url", config.url);
        properties.put("basic.auth.credentials.source", config.basicAuthCredentialsSource);
        properties.put("schema.registry.basic.auth.user.info", config.basicAuthUserInfo);
        return properties;
    }

    public Map<String, Object> buildPropertiesMap() {
        return buildPropertiesMap(this);
    }

    public static Map<String, Object> buildPropertiesMap(SchemaRegistryConfig config) {
        Map<String, Object> properties = new HashMap<>();
        Properties props = buildProperties(config);
        for (final String name : props.stringPropertyNames())
            properties.put(name, props.getProperty(name));
        return properties;
    }
}
