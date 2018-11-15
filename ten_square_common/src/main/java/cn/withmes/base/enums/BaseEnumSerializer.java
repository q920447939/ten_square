package cn.withmes.base.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @Description:枚举序列化
 * @param:
 * @return:
 * @auther: liming
 * @date: 2018/5/19 11:10
 */
public class BaseEnumSerializer extends JsonSerializer<BaseEnum> {


	@Override
	@SuppressWarnings("all")
	public void serialize(BaseEnum viewEnum, JsonGenerator jsonGenerator, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("code");
        jsonGenerator.writeObject(viewEnum.getCode());
        jsonGenerator.writeFieldName("desc");
        jsonGenerator.writeString(viewEnum.getDesc());
        jsonGenerator.writeEndObject();
	}
}
