/**
 * 
 */
package org.jbrew.core.annotations;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@Documented
@Target(METHOD)
/**
 * The current method is under development while its full range of uses-cases is 
 * being investigated.
 * @author nealk
 *
 */
public @interface UnderDevelopmentInvestigation{}
