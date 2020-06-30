package convertors;

import java.time.LocalDateTime;

import org.apache.johnzon.mapper.Converter;

public class LocalDateTimeConverter implements Converter<LocalDateTime> {
	
	  @Override
	  public String toString(final LocalDateTime instance) {
	  return instance.toString();
	  }
	  @Override
	  public LocalDateTime fromString(final String text) {
	  return LocalDateTime.parse(text);
	  }
	}
