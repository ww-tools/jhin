package org.willwin.jhin;

import org.springframework.boot.SpringApplication;

public class TestJhinApplication
{

    public static void main(String[] args)
    {
        SpringApplication.from(JhinApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
