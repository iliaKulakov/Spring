package io.github.personal_finance.securityService;

public interface SecurityService {
    String createToken(String subject, long ttlMillis);

}
