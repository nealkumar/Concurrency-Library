package org.jbrew.concurrent.serializable;

import java.io.Serializable;

import org.jbrew.concurrent.Task;

/**
 * <p>
 * A POJO Serializable implementation of a {@link org.jbrew.concurrent.Task}.
 * </p>
 * 
 * @author nealk
 *
 * @param <T>
 */
public interface SerializableTask<T> extends Task<T>, Serializable{

}
