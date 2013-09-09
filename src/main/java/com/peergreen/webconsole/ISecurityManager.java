package com.peergreen.webconsole;

import java.util.List;

/**
 * Web console security manager
 *
 * @author Mohammed Boukada
 */
public interface ISecurityManager {

    /**
     * Whether the logged in user has the role
     *
     * @param role given role
     * @return True is user has the given role, false otherwise.
     */
    boolean isUserInRole(String role);

    /**
     * Whether the logged in user has the roles
     *
     * @param roles given roles
     * @return True is user the given roles, false otherwise.
     */
    boolean isUserInRoles(List<String> roles);

    /**
     * Get logged in user name
     *
     * @return user name
     */
    String getUserName();

    // FIXME useless?
    boolean isUserLogged();
}
