package com.peergreen.webconsole.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mohammed Boukada
 */
public interface CssInjectorService {
    /**
     * Inject css
     * @param is css input stream
     * @return Css handler
     * @throws IOException
     */
    CssHandler inject(InputStream is) throws IOException;

    /**
     * Inject css
     * @param cssContent css content
     * @return css handler
     */
    CssHandler inject(String cssContent);

    /**
     * Remove css
     * @param cssHandler
     */
    void remove(CssHandler cssHandler);
}
