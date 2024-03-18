package com.comparus.common.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Datasource {
    private String url;
    private String username;
    private String password;
    private String migration;
}
