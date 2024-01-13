package kg.rakhim.classes.thechheim.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

public class Converter {
    private static final ModelMapper mapper = new ModelMapper();

    public static <T> Object convert(Object o1, Class<T> type){
        return mapper.map(o1, type);
    }
}
