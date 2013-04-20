package org.ipchina.qqbaby.validation;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-24
 * Time: 下午11:13
 */
public class ValidateLongRangeValidator implements ConstraintValidator<ValidateLongRange, Object> {

    private long min;
    private long max;
    private long defaultValue;

    @Override
    public void initialize(ValidateLongRange constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        defaultValue = constraintAnnotation.defaultValue();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
//            String minValue = BeanUtils.getProperty(value, "min"); 当value是类的时候使用这个
        /*if (value.getClass().equals(Integer.class)) {
            long longValue = (Long)value;
        }else if (value.getClass().equals(Long.class)) {
        }*/

//        String strValue = value.toString();
        try {
            String strValue = BeanUtils.getProperty(value, "value");
            long longValue = Long.parseLong(strValue);
            if (longValue > min && longValue < max) {
                return true;
            } else if (defaultValue!=0) {
                BeanUtils.setProperty(value,"value",15);
                return true;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return true;
    }
}
