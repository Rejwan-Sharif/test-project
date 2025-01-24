package com.test.springParactice.basicSpring.applicationEventPublisher;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class UserLoginEvent extends ApplicationEvent {
    public UserLoginEvent() {
        super("source");
    }
}
