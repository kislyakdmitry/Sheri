package ru.sheri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sheri.beans.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ShopController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Greeting greeting(@RequestParam(name = "name", defaultValue = "World")
                                   String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
