package com.example.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 19-4-3 下午5:52
 */

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ZlwAno {
    int value();
}
