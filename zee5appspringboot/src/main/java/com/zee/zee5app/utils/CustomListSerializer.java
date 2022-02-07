package com.zee.zee5app.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zee.zee5app.dto.Login;

public class CustomListSerializer extends StdSerializer<Login> {
	
	public CustomListSerializer()
	{
		this(null);
	}
	
	public CustomListSerializer(Class<Login> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(Login value, JsonGenerator gen, SerializerProvider provider) throws IOException
	{
		gen.writeObject(value);
	}
}
