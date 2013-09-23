package com.peergreen.webconsole.security;

import javax.security.auth.Subject;

/**
 * @author Mohammed Boukada
 */
public interface AuthenticateService {
    Subject authenticate(String username, String password);
}
