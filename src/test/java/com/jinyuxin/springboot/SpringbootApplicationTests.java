package com.jinyuxin.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

  Logger logger = LoggerFactory.getLogger(getClass());

  @Test
  void contextLoads() {
    //日志级别，由低到高
    //trace<debug<info<warn<error
    //可以调整日志的输出级别。日志只会在该级别以及以后的高级别生效。
    logger.trace("This is trace");
    logger.debug("This is debug");
    //SpringBoot默认的日志级别是info
    logger.info("This is info");
    logger.warn("This is warn");
    logger.error("This is error");
  }

}
