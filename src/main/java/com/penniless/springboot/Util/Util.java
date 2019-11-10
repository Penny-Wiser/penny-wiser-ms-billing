package com.penniless.springboot.Util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Instant;

public class Util {

  public static String genExternalId() {
    int now = (int) Instant.now().toEpochMilli();
    return String.format("BL-%s", Integer.toString(now, 16).toUpperCase());
  }

//  public static String extractTokenFromRequest() {
//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    if (auth == null) {
//
//    }
//  }
}
