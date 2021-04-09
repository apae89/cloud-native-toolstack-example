/*
 * HttpConstants.java
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
 * Http constants.
 *
 * @author mbb.tss@valtech.de
 */
public final class HttpConstants {

    private HttpConstants() {
        // private constructor to avoid instantiating
    }

    /**
     * The media type of the vehicle report
     */
    public static final String HTTP_MEDIA_TYPE_RVS_V1_0_0 = "application/vnd.vwg.mbb.rvs_v1_0_0+xml";

    /**
     * The media type of the vehicle report
     */
    public static final String HTTP_MEDIA_TYPE_RVS_RDK_V1_0_0 = "application/vnd.vwg.mbb.rvsRdk_v1_0_0+xml";

    /**
     * The media type of the vehicle report
     */
    public static final String HTTP_MEDIA_TYPE_RVS_RDK_V1_0_1 = "application/vnd.vwg.mbb.rvsRdk_v1_0_1+xml";

    /**
     * The media type of the vehicle report
     */
    public static final String HTTP_MEDIA_TYPE_RVS_RDK_V1_0_2 = "application/vnd.vwg.mbb.rvsRdk_v1_0_2+xml";

    /**
     * The media type of fleet configuration version 1_0_4 (compatible to v1_0_0, v1_0_1, v1_0_2 and v1_0_3)
     */
    public static final String HTTP_MEDIA_TYPE_FLEET_V1_0_4 = "application/vnd.vwg.mbb.fleet_v1_0_4+xml";

    /**
     * The media type of raw OBDC data from a business service.
     */
    public static final String HTTP_MEDIA_TYPE_TECHNICAL_USER = "application/vnd.vwg.mbb.technicalUser_v1_0_0+xml";

    /**
     * The media type of consumer version 1_0_0.
     */
    public static final String HTTP_MEDIA_TYPE_CONSUMER_V1_1_0 = "application/vnd.vwg.mbb.consumer_v1_1_0+xml";

    /**
     * The media type for sharedTelemetricReport_v1_0_0
     */
    public static final String HTTP_MEDIA_TYPE_SHARED_TELEMETRIC_REPORT_V1_0_0 = "application/vnd.vwg.mbb.sharedTelemetricReport_v1_0_0+xml";

    /**
     * The media type for sharedTelemetricReport_v1_0_1
     */
    public static final String HTTP_MEDIA_TYPE_SHARED_TELEMETRIC_REPORT_V1_0_1 = "application/vnd.vwg.mbb.sharedTelemetricReport_v1_0_1+xml";

    /**
     * The media type of raw OBDC data from a business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V1_0_0 = "application/vnd.vwg.mbb.telemetricSharedService_v1_0_0+xml";
    /**
     * The media type of data from a the OPR business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V1_0_1 = "application/vnd.vwg.mbb.telemetricSharedService_v1_0_1+xml";

    /**
     * The media type of data from a the OPR business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V1_0_2 = "application/vnd.vwg.mbb.telemetricSharedService_v1_0_2+xml";

    /**
     * The media type of data from a the OPR business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V1_0_3 = "application/vnd.vwg.mbb.telemetricSharedService_v1_0_3+xml";
    /**
     * The media type of raw OBDC data from a business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V2_0_0 = "application/vnd.vwg.mbb.telemetricSharedService_v2_0_0+xml";
    /**
     * The media type of raw OBDC data from a business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V2_0_1 = "application/vnd.vwg.mbb.telemetricSharedService_v2_0_1+xml";
    /**
     * The media type of raw OBDC data from a business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V3_0_0 = "application/vnd.vwg.mbb.telemetricSharedService_v3_0_0+xml";
    /**
     * The media type of raw OBDC data from a business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V3_0_1 = "application/vnd.vwg.mbb.telemetricSharedService_v3_0_1+xml";
    /**
     * The media type of raw OBDC data from a business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V3_0_2 = "application/vnd.vwg.mbb.telemetricSharedService_v3_0_2+xml";
    /**
     * The media type of raw OBDC data from a business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V3_0_3 = "application/vnd.vwg.mbb.telemetricSharedService_v3_0_3+xml";

    /**
     * The media type of raw OBDC data from a business service.
     */
    public static final String HTTP_MEDIA_TYPE_TELEMETRIC_SHARED_SERVICE_V3_0_4 = "application/vnd.vwg.mbb.telemetricSharedService_v3_0_4+xml";

    /**
     * The media type for a data configuration update
     */
    public static final String HTTP_MEDIA_TYPE_DATA_CONFIGURATION = "application/vnd.vwg.mbb.tssDataConfiguration_v1_0_0+xml";

    /**
     * The media type for a the tenant configuration
     */
    public static final String HTTP_MEDIA_TYPE_TENANT_CONFIGURATION = "application/vnd.vwg.mbb.tssConfiguration_v1_0_0+xml";

    /**
     * The media type for the service configuration keys
     */
    public static final String HTTP_MEDIA_TYPE_SERVICE_CONF_KEYS = "application/vnd.vwg.mbb.serviceConfigurationKeys_v1_0_1+xml";

    // /** The media type of raw OBDC data from a business service. */
    // public static final String VEHICLE_DATA_REQUEST_TYPE =
    // "application/vnd.vwg.mbb.telemetricSharedService_v1_0_0+xml";
    // /** The media type of vehicle data. */
    // public static final String VEHICLE_DATA_RESPONSE = "application/vnd.vwg.mbb.sharedTelemetricReport_v1_0_0+xml";
    // /** The media type of raw OBDC data from a business service. */
    // public static final String BS_RAW_VEHICLE_DATA_MEDIA_TYPE =
    // "application/vnd.vwg.mbb.telemetricSharedService_v1_0_0+xml";
    // /** The media type of raw OBDC data from a business service. */
    // public static final String RAW_VEHICLE_DATA_MEDIA_TYPE = "application/vnd.vwg.mbb.rvs_v1_0_0+xml";
    // /** The media type of {@link TSSVehicleDataRequestType}. */
    // public static final String VEHICLE_DATA_MEDIA_TYPE = "application/vnd.vwg.mbb.sharedTelemetricReport_v1_0_0+xml";
    // /** tracking context put TSS configuration. */
    // public static final String SERVICE_ID_POST_RAW_VEHICLE_DATA = "TSS:REST:postTelemetricVehicleData";

    /**
     * The name of the HTTP VIN header.
     */
    public static final String HTTP_HEADER_NAME_X_VIN = "X-VIN";

    /**
     * The name of the HTTP trace-ID header.
     */
    public static final String HTTP_HEADER_NAME_X_TRACE_ID = "X-TRACE-ID";

    /**
     * The name of the HTTP brand header.
     */
    public static final String HTTP_HEADER_NAME_X_BRAND = "X-BRAND";

    /**
     * The name of the HTTP country header.
     */
    public static final String HTTP_HEADER_NAME_X_COUNTRY = "X-COUNTRY";

    /**
     * The name of the HTTP accept-language header.
     */
    public static final String HTTP_HEADER_NAME_ACCEPT_LANGUAGE = "Accept-Language";

    /**
     * The name of the HTTP asserted identity header.
     */
    public static final String HTTP_HEADER_NAME_X_ASSERTED_IDENDITY = "X-AssertedIdentity";

    /**
     * The name of the HTTP channel header.
     */
    public static final String HTTP_HEADER_NAME_X_CHANNEL = "X-CHANNEL";

    /**
     * The name of the HTTP channel header.
     */
    public static final String HTTP_HEADER_NAME_X_SYSTEM_ID = "X-SYSTEMID";

    /**
     * The name of the HTTP brand header.
     */
    public static final String HTTP_HEADER_NAME_X_RELATED_JOBID = "X-RelatedJobId";

    /**
     * The name of the HTTP fleet header.
     */
    public static final String HTTP_HEADER_NAME_X_FLEETID = "X-FLEETID";

    /**
     * The name of the HTTP fleet provider id header.
     */
    public static final String HTTP_HEADER_NAME_X_FLEET_PROVIDER_ID = "X-FleetProviderId";

    /**
     * The name of the HTTP data callback enabled header.
     */
    public static final String HTTP_HEADER_NAME_X_US_DATA_CALLBACK_ENABLED = "X-USDataCallbackEnabled";

    /**
     * The name of the HTTP request actuation header.
     */
    public static final String HTTP_HEADER_NAME_X_REQUEST_ACTUATION = "X-RequestActuation";

    /**
     * The name of the HTTP trip data reason header.
     */
    public static final String HTTP_HEADER_NAME_X_TRIP_DATA_REASON = "X-TripDataReason";

    /**
     * constant for http status code 200.
     */
    private static final int HTTP_OK = 200;

    /**
     * constant for http status code 200.
     */
    private static final int HTTP_MULTIPLE_CHOICES = 300;

    /**
     * checks if the return code is in the 2xx range
     **/
    public static final boolean isSuccessfulCall(final int statusCode) {
        final boolean result = statusCode >= HTTP_OK && statusCode < HTTP_MULTIPLE_CHOICES;
        return result;
    }
}
