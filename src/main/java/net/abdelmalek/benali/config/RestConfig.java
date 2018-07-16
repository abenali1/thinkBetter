package net.abdelmalek.benali.config;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Configuration
public class RestConfig {
@Value("${resttemplate.useproxy}")
private boolean useProxy;
@Value("${resttemplate.host}")
private String proxyHost;
@Value("${resttemplate.port}")
private int proxyPort;

public RestTemplate getRestTemplate() {
	 RestTemplate restTemplate = null;
     if (useProxy) {
         SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
         requestFactory.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));
         restTemplate = new RestTemplate(requestFactory);
     } else {
         restTemplate = new RestTemplate();
     }
     
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    // Add the Jackson Message converter
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JodaModule());
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
    objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
    converter.setObjectMapper(objectMapper);
    // Note: here we are making this converter to process any kind of response,
    // not only application/*json, which is the default behaviour
    converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
    messageConverters.add(converter);
    restTemplate.setMessageConverters(messageConverters);
	return restTemplate;
	
	
}

	

}
