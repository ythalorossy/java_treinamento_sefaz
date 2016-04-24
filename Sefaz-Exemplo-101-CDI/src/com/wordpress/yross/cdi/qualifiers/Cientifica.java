package com.wordpress.yross.cdi.qualifiers;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ TYPE, METHOD, FIELD, PARAMETER })
public @interface Cientifica {

}
