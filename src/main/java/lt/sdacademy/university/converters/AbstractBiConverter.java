package lt.sdacademy.university.converters;

import static java.util.stream.Collectors.toList;

import java.util.List;

public abstract class AbstractBiConverter<T, R> {

    public abstract R convert(T obj);

    public List<R> convert(List<T> items) {
        if (items == null) {
            return null;
        }

        return items.stream().map(this::convert).collect(toList());
    }

    public abstract T convertToEntity(R obj);

    public List<T> convertToEntity(List<R> items) {
        if (items == null) {
            return null;
        }

        return items.stream().map(this::convertToEntity).collect(toList());
    }
}
