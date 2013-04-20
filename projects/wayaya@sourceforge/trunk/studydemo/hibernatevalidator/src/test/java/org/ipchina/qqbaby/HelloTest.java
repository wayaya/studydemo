package org.ipchina.qqbaby;


import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.ServletRequestDataBinder;

import javax.xml.stream.FactoryConfigurationError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-24
 * Time: ����10:44
 */
public class HelloTest {

    @Test
    public void testMap2Object() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "abc");
        map.put("age", "def");
        map.put("salary", Long.toString(100));

        Person bindData=new Person();
        ServletRequestDataBinder servletRequestDataBinder = new ServletRequestDataBinder(bindData, "bindData");

//        servletRequestDataBinder.setConversionService(new DefaultFormattingConversionService());

        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues(map);


        servletRequestDataBinder.bind(mutablePropertyValues);//�ؼ����� map�������ת��


   BindingResult bindingResult = servletRequestDataBinder.getBindingResult();//��ȡת�����

//        CreateUserRequest createUserRequest = (CreateUserRequest) bindingResult.getTarget();


//        System.out.println(createUserRequest.getUserName());
//        System.out.println(createUserRequest.getSalary());
    }

    @Test
    public void testSpring() {

        try {
            String confFile = "D:\\Mydocuments\\projects\\wayaya@sourceforge\\trunk\\studydemo\\hibernatevalidator\\src\\main\\resources\\META-INF\\spring\\spring.xml";
            ApplicationContext applicationContext = new FileSystemXmlApplicationContext(confFile);//��ȡSpring������

            Person person = (Person) applicationContext.getBean("person");
            System.out.println(person.getAddress().getCity());
        } catch (FactoryConfigurationError factoryConfigurationError) {
        } catch (BeansException e) {
        }

    }


    @Test
    public void test() {
        Person bindData = BeanUtils.instantiateClass(Person.class);//�������ͣ�����ʵ��
        ServletRequestDataBinder servletRequestDataBinder = new ServletRequestDataBinder(bindData, "bindData");//�󶨶���

        servletRequestDataBinder.setConversionService(new DefaultFormattingConversionService());

        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "abc");
        map.put("age", "14");
//        map.put("level", "20");
//        map.put("level", "20");

        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues(map);
        servletRequestDataBinder.bind(mutablePropertyValues);//�ؼ����� map�������ת��
        BindingResult bindingResult = servletRequestDataBinder.getBindingResult();//��ȡת�����

        Person person = (Person) bindingResult.getTarget();


        System.out.println(person.getUsername());
        System.out.println(person.getPassword());
        System.out.println(person.getAge());
        System.out.println(person.getLevel().getValue());


        //������֤�� ������֤
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        servletRequestDataBinder.setValidator(localValidatorFactoryBean);


        servletRequestDataBinder.validate();
        bindingResult = servletRequestDataBinder.getBindingResult();//��ȡ��֤���
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        System.out.println(allErrors.size());

        for (ObjectError p : allErrors) {
            FieldError pp = (FieldError) p;
            System.out.println(pp.getField() + "," + pp.getDefaultMessage());
        }
    }
}
