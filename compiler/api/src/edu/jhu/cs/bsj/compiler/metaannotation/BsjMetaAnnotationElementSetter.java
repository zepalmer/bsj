package edu.jhu.cs.bsj.compiler.metaannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to annotate methods of {@link BsjMetaAnnotation}s which serve as element value setters.
 * @author Zachary Palmer
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BsjMetaAnnotationElementSetter
{
}
