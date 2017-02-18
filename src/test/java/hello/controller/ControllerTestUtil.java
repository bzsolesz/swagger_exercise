package hello.controller;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

/**
 * Created by zsolt_balogh on 29/12/2016.
 */
public class ControllerTestUtil {

    static final MediaType JSON_UTF8_CONTENT_TYPE =
            new MediaType(
                    MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype(),
                    Charset.forName("utf8"));
}
