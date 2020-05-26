package dds;

import java.util.List;
import java.util.Map;

public class AccuProveedorDelClima implements ProveedorDelClima {

    AccuWeatherAPI apiAccuWeather = new AccuWeatherAPI();


    private List<Map<String, Object>> condicionesClimaticas(String ciudad) {
        return apiAccuWeather.getWeather(ciudad);
    }

    @Override
    public double getTemperaturaCelcius(String ciudad) {
        return (getTemperaturaFarenheit(ciudad) - 32.0 )*(5.0/9.0);
    }

    @Override
    public double getTemperaturaFarenheit(String ciudad) {
        return (double) (int) ((Map<String, Object>) condicionesClimaticas(ciudad).get(0).get("Temperature")).get("Value");
    }

    @Override
    public double getProbabilidadDePrecipitaciones(String ciudad) {
        return (double) condicionesClimaticas(ciudad).get(0).get("PrecipitationProbability");
    }
}
