package space.nyuki.lncommon.factory;

import space.nyuki.lncommon.pojo.question.InquiryType;

public class InquiryTypeFactory {
    public static InquiryType getInstance(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        InquiryType inquiryType = (InquiryType) Class.forName("space.nyuki.lncommon.pojo.question.impl." + name).newInstance();
        return inquiryType;
    }
}
