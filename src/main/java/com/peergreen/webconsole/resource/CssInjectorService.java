package com.peergreen.webconsole.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Css contribution service
 * @author Mohammed Boukada
 */
public interface CssInjectorService {
    /**
     * Inject css
     * @param is css input stream
     * @return Css handler
     * @throws IOException
     */
    CssHandle inject(InputStream is) throws IOException;

    /**
     * Inject css
     * @param cssContent css content
     * @return css handler
     */
    CssHandle inject(String cssContent);
}
