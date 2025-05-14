package in.athenaeum.springlocalizationi18n;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("api/v1/sample")
public class SampleApi {
    private final MessageSource messageSource;

    public SampleApi(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    @GetMapping
    public ResponseEntity<String> get(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(messageSource.getMessage("greeting.hello", null, locale));
    }
}
