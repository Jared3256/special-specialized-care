package com.shan_infosystem.special_specialized_care;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(
        setDates = true,
        auditorAwareRef = "AuditorAwareImpl"
)
public class SpecialSpecializedCareApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpecialSpecializedCareApplication.class, args);
    }

}
