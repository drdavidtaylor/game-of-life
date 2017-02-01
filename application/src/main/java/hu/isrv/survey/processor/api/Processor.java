package hu.isrv.survey.processor.api;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
public interface Processor <T> {

    public T execute(T t);
}
