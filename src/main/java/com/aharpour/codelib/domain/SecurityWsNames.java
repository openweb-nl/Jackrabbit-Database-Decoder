package com.aharpour.codelib.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.aharpour.codelib.Runner;

/**
 * @author Ebrahim Aharpour
 * @since 11/19/2017
 */
@Entity
@Table(name = Runner.SECURITY_WS_PREFIX + "NAMES")
public class SecurityWsNames extends Names {

}