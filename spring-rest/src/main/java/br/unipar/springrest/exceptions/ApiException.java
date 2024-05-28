package br.unipar.springrest.exceptions;

import java.util.Arrays;
import java.util.List;

public class ApiException {

    private List<String> errorList;

    public ApiException(String message) {
        errorList = Arrays.asList(message);
    }

    public ApiException(List<String> errorList) {
        this.errorList = errorList;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
