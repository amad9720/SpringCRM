package com.webapp.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by owner on 18-04-07.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.webapp.aopdemo")
public class DemoConfig  {
}
