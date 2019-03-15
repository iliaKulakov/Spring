package io.github.personal_finance.controller;

import io.github.personal_finance.domainSecurity.dtoSecurity.TokenSecurityTable;
import io.github.personal_finance.repository.TokenRepository;
import io.github.personal_finance.securityService.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class TokenController {

    public TokenController(SecurityService securityService, TokenRepository tokenRepository) {
        this.securityService = securityService;
        this.tokenRepository = tokenRepository;
    }

    SecurityService securityService;
    TokenRepository tokenRepository;

    @ResponseBody
    @RequestMapping("/security/generate/token")
    public Map<String, Object> generateToken(@RequestParam(value="subject")
                                                     String subject){
        String token = securityService.createToken(subject, (2 * 1000 * 60));
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", token);

        var tokenSecurityTable = new TokenSecurityTable();
        tokenSecurityTable.setTokens(token);
        tokenRepository.save(tokenSecurityTable);

        return map;
    }

    @ResponseBody
    @RequestMapping("/security/get/subject")
    public Map<String, Object> getSubject(@RequestParam(value="token") String
                                                  token){
        String subject = securityService.getSubject(token);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", subject);
        return map;
    }

}
