/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jpa.converters;

import static java.lang.Byte.toUnsignedInt;
import java.time.Duration;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import oracle.sql.INTERVALDS;

/**
 *
 * @author Radu
 */
@Converter
public class DurationConverter implements AttributeConverter<Duration, INTERVALDS> {
    
    @Override
    public INTERVALDS convertToDatabaseColumn(Duration attribute)
    {
        long hours = attribute.toHoursPart();
        long minutes = attribute.toMinutesPart();
        INTERVALDS solution = new INTERVALDS("0 " + hours + ":" + minutes + ":0.0");
        return solution;
    }

    @Override
    public Duration convertToEntityAttribute(INTERVALDS duration) {
        int hours = toUnsignedInt(duration.getBytes()[4]) - 60;
        int minutes = toUnsignedInt(duration.getBytes()[5]) - 60;
        return Duration.parse("PT" + hours + "H" + minutes + "M");
    }
    
}
