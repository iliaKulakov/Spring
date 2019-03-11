package io.github.personal_finance.securityService;

import org.springframework.stereotype.Component;

@Component
public interface SecurityService {
    String createToken(String subject, long ttlMillis);

}
