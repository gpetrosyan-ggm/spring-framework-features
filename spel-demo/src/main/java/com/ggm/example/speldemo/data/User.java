package com.ggm.example.speldemo.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("user")
public class User {

    @Value("#{'John Doe'}")
    private String name;

    @Value("#{30}")
    private int age;

    private String country;

    private String language;

    private String timeZone;

    public User(@Value("#{systemProperties['user.country']}") String country,
                @Value("#{systemProperties['user.language']}") String language) {
        this.country = country;
        this.language = language;
    }

    @Value("#{systemProperties['user.timezone']}")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

}
