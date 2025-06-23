package com.menglang.teacher.config;


import com.menglang.teacher.model.audit.AuditAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditorConfig  {

    @Bean
    public AuditorAware<String> AuditAwareBean(){
        return new AuditAwareImpl();
    }
}
