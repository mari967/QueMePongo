package dds;

import dds.AccuWeatherAPI;
import dds.ProveedorDelClima;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class AccuProveedorDelClima implements ProveedorDelClima {

    private AccuWeatherAPI apiAccuWeather = new AccuWeatherAPI();
    private Duration periodoValidezHoras;
    private LocalDateTime proximaExpiracion;
    private List<Map<String, Object>> ultimaCondicionClimatica;

    public AccuProveedorDelClima(Duration horasDeValidez) {
        this.periodoValidezHoras = horasDeValidez;
        proximaExpiracion = LocalDateTime.now().plus(this.periodoValidezHoras);
    }

    private List<Map<String, Object>> condicionesClimaticas(String ciudad) {

        if(expirado(proximaExpiracion) || ultimaCondicionClimatica == null)
        {
            ultimaCondicionClimatica = apiAccuWeather.getWeather(ciudad);
            proximaExpiracion = LocalDateTime.now().plus(this.periodoValidezHoras);
            return ultimaCondicionClimatica;
        }
        return ultimaCondicionClimatica;
    }

    private boolean expirado(LocalDateTime fechaHora) {
        return fechaHora.isAfter(LocalDateTime.now());
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
