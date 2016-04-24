/**
 * 
 */
package com.wordpress.yross.cdi.qualifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com - http://yross.wordpress.com)
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(value={
		ElementType.TYPE, 
		ElementType.METHOD,
		ElementType.FIELD,
		ElementType.PARAMETER})
public @interface Simples {

	
}
