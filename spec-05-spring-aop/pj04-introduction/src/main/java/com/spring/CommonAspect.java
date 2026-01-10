package com.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.annotation.Configuration;

import com.spring.introduction.ExtraFunctions;
import com.spring.introduction.ExtraFunctionsImpl;

@Configuration
@Aspect
public class CommonAspect {

	@DeclareParents(value = "com.spring.introduction.MyService+", defaultImpl = ExtraFunctionsImpl.class)
	static ExtraFunctions extra;

}
