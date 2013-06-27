package com.peergreen.webconsole;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.StaticServiceProperty;

/**
 * Peergreen Administration BaseConsole
 * @author Mohammed Boukada
 */
@Component
@Provides(properties = {@StaticServiceProperty(name = Constants.CONSOLE_NAME, type = "java.lang.String", mandatory = true),
                        @StaticServiceProperty(name = Constants.CONSOLE_ALIAS, type = "java.lang.String", mandatory = true),
                        @StaticServiceProperty(name = Constants.ENABLE_SECURITY, type = "boolean", mandatory = true)})
public class BaseConsole implements IConsole {
}
