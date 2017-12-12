package nl.openweb.hippo.vo;

import lombok.Value;

/**
 * Created by Senussi on 08/12/2017.
 */
@Value
public class ErrorVO {

    private final Integer status;
    private final String error;
    private final String message;



}
