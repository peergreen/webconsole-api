package com.peergreen.webconsole.resource;

import org.osgi.framework.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Mohammed Boukada
 */
public interface CssInjectorService {
    void add(Bundle bundle, InputStream is) throws IOException;
    void add(Bundle bundle, String style);
    void remove(Bundle bundle);
}
