package org.ipchina.qqbaby.validation;

import org.ipchina.qqbaby.Address;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-30
 * Time: ����1:01
 */
public class AddressPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.equalsIgnoreCase("")) {
            throw new IllegalArgumentException();
        }

        Address value = new Address();
        String[] ss = text.split("::", 3);
        value.setZip(ss[0]);
        value.setCity(ss[1]);
        value.setStreet(ss[2]);

        setValue(value);                                // super.setValue()Ҳ�ǹ���˼�����֪�����Ǹ�ʲô��
    }

    @Override
    public String getAsText() {
        Address address = (Address) getValue();         // super.getValue() ����˼�壬�õ�����Ҫת�����Ǹ�����
        return new StringBuilder().append(address.getZip() + ",").append(address.getCity() + ",").append(address.getStreet()).toString();
    }
}
