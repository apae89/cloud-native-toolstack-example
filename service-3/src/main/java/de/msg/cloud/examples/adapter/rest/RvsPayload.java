/*
 * RvsPayload.java
 * 
 * (c) Copyright AUDI AG, 2017
 * All Rights reserved.
 * 
 * AUDI AG
 * 85057 Ingolstadt
 * Germany
 */
package de.msg.cloud.examples.adapter.rest;

/**
 * Container class storing the raw payload of an rvs request enhanced with meta information that can be used to store and extract the data.
 *
 * @author kruegerp - msg systems ag
 */
public class RvsPayload {

    /** The request payload represented as a String object */
    private String payload;
    /** ContentType of the request */
    private String contentType;

    /**
     * Constructor.
     *
     * @param aPayload the request payload as a String object, not null
     */
    public RvsPayload(final String aPayload) {
        this.payload = aPayload;
    }

    /**
     * @return the request xml payload as a string object
     */
    public String getPayload() {
        return this.payload;
    }

    /**
     * @return the contentType of the rquest payload (e.g. "application.vnd.vwg.mbb.rvs_v1_0_0+xml")
     */
    public String getContentType() {
        return this.contentType;
    }

    /**
     * Set the content type of the request payload
     * 
     * @param aContentType the content type, e.g. "application.vnd.vwg.mbb.rvs_v1_0_0+xml"
     */
    public void setContentType(final String aContentType) {
        this.contentType = aContentType;
    }

}
