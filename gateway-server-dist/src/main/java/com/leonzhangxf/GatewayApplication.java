package com.leonzhangxf;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Client
@EnableZuulProxy
@Import({
    ZuulSwaggerConfiguration.class,
})
@Controller
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

    @RequestMapping("/login")
    public String login() {
        return "redirect:/";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
        System.out.println(String.format("User is: %s", user));
        return user;
    }
}
