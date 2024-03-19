package com.comparus.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConfigPropertiesTest {
    @Autowired
    ConfigProperties configProperties;

    @Test
    void shouldReturnDBproperties() {
        var datasourceList = configProperties.getDatasource();

        assertThat(datasourceList).hasSize(3);

        assertThat(datasourceList.stream().toList())
                .hasSize(3)
                .extracting(Datasource::getUrl)
                .containsExactlyInAnyOrder("jdbc:h2:mem:comparustest", "jdbc:h2:mem:comparustest2", "jdbc:h2:mem:comparustest3");
    }
}