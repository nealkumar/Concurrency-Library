/**
 * 
 */
package org.jbrew.jni;

import static java.lang.annotation.ElementType.PACKAGE;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@Documented
@Target(PACKAGE)
/**
 * A package annotated <code>NotPortable</code> is one that violates Java's principle of platform independence through native
 * interfaces. In other words, such packages should <i>not</i> be considered portable between various systems, including 
 * different machines sharing the same operating system. As such, great care and extensive testing must be adhered to when
 * using <code>NotPortable</code> packages in production servers.
 *   
 * @author Neal Kumar
 *
 */
public @interface NotPortable {}
