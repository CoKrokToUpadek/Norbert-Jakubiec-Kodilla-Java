package com.kodilla.testing.weather.mock;
import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
@DisplayName("Weather Forecast Suite")
public class WeatherForecastTestSuite {
    @Mock
    private Temperatures temperaturesMock;
    private static Map<String, Double> temperaturesMap;

    @BeforeAll
    public static void setTemperaturesMock(){

        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        temperaturesMap.put("Wąchock", 25.5);
    }


    @BeforeEach
    public void mockSetting(){
        //probably could have been used in constructor but challenge wanted me to do it this way
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        System.out.println("test case start");
    }

    @AfterEach
    public void endComm(){
        System.out.println("test case ends");
    }

    @Test
    void testCalculateForecastWithMock() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(6, quantityOfSensors);
    }

    @Test
    void testAverageTemperatureWithMock(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double manualAverage= (double) Math.round(((25.5+26.2+24.8+25.2+26.1+25.5)/6)*100)/100;

        //Then
        Assertions.assertEquals(manualAverage,weatherForecast.averageTemperature());

    }

    @Test
    void testMedianTemperatureWithMock(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double manualMedian=25.5;

        //Then
        Assertions.assertEquals(manualMedian,weatherForecast.medianTemperature());
    }

}
