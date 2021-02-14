package com.kodilla.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfiguration {

    @Bean
    public LibraryManager libraryManager() {
        return new LibraryManager();
    }

    @Bean public User user(){
        return new User();
    }

}
