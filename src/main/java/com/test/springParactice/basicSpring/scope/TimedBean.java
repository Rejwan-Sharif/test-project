package com.test.springParactice.basicSpring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("timed")
public class TimedBean {
}
