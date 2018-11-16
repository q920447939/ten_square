package cn.withmes.common.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * DESC: 金额小数点保留两位
 * @DATE 2016年5月11日下午5:07:28
 * @version 0.1.0
 * 
 */
public class JsonBigDecimalSerializer extends JsonSerializer<BigDecimal> {

    DecimalFormat decimalFormat = new DecimalFormat("###0.00");

    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        if (value != null) {
            String formattedDate = decimalFormat.format(value);
            jgen.writeString(formattedDate);
        }

    }
}
