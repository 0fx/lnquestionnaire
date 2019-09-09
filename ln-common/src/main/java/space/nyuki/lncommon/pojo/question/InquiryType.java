package space.nyuki.lncommon.pojo.question;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import space.nyuki.lncommon.pojo.question.impl.Choice;
import space.nyuki.lncommon.pojo.question.impl.Comment;
import space.nyuki.lncommon.pojo.question.impl.InquiryDate;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Choice.class, name = "choice"),
        @JsonSubTypes.Type(value = Comment.class, name = "comment"),
        @JsonSubTypes.Type(value = InquiryDate.class,name = "date")
})
public interface InquiryType {
}
