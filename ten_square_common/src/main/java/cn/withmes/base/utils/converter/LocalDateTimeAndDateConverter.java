package cn.withmes.base.utils.converter;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class LocalDateTimeAndDateConverter extends BidirectionalConverter<LocalDateTime,Date> {

    @Override
    public Date convertTo(LocalDateTime source, Type<Date> destinationType, MappingContext mappingContext) {
        Date date = null;
        if(source != null) {
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = source.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
            date = Date.from(zdt.toInstant());
        }
        return date;
    }

    @Override
    public LocalDateTime convertFrom(Date source, Type<LocalDateTime> destinationType, MappingContext mappingContext) {
        LocalDateTime localDateTime = null;
        if(source != null) {
            Instant instant = source.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
            ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
            localDateTime = instant.atZone(zoneId).toLocalDateTime();
        }
        return localDateTime;
    }
}
