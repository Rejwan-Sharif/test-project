package com.test.customInterceptor;

import lombok.Data;

@Data
public class InfoDto {

   private String ip;
   private String method;
   private String path;
   private String pageName;
   private String thread;
   private Long consumedTime;
   private String time;
}
