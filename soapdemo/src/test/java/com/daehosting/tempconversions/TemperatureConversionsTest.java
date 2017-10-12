package com.daehosting.tempconversions;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by sarah on 10/10/2017.
 */
public class TemperatureConversionsTest {
    @Test
    public void testGetTemperatureConversionsSoap12() throws Exception {
        TemperatureConversionsSoapType service = new TemperatureConversions().getTemperatureConversionsSoap12();
        BigDecimal cToFResult = service.celsiusToFahrenheit(BigDecimal.valueOf(0.0));

        Assert.assertEquals("C to F Conversion Failed", cToFResult, BigDecimal.valueOf(32));
    }

    @Test
    public void testGetTemperatureConversionsSoap12FtoC() throws Exception {
        TemperatureConversionsSoapType service = new TemperatureConversions().getTemperatureConversionsSoap12();
        BigDecimal fToCResult = service.fahrenheitToCelsius(BigDecimal.valueOf(32));

        Assert.assertEquals("F to C Conversion Failed", fToCResult, BigDecimal.valueOf(0));
    }

    @Test
    public void testGetTemperatureConversionsSoap12FWindChill() throws Exception {
        TemperatureConversionsSoapType service = new TemperatureConversions().getTemperatureConversionsSoap12();
        BigDecimal fWindChillResult = service.windChillInFahrenheit(BigDecimal.valueOf(32), BigDecimal.valueOf(10));

        Assert.assertEquals("F wind chill Conversion Failed", fWindChillResult, BigDecimal.valueOf(15.854));
    }

    @Test
    public void testGetTemperatureConversionsSoap12CWindChill() throws Exception {
        TemperatureConversionsSoapType service = new TemperatureConversions().getTemperatureConversionsSoap12();
        BigDecimal cWindChillResult = service.windChillInFahrenheit(BigDecimal.valueOf(0.0), BigDecimal.valueOf(10));

        Assert.assertEquals("C wind chill Conversion Failed", cWindChillResult.round(new MathContext(4)), BigDecimal.valueOf(-21.43));
    }
}
